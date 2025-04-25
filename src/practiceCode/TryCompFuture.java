package practiceCode;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

public class TryCompFuture {

    void main() throws ExecutionException, InterruptedException {
        Worker worker = new Worker();
        ExecutorService executors = Executors.newFixedThreadPool(3);
        CompletableFuture<Void> compFuture= CompletableFuture.runAsync(worker, executors).thenRun(()-> System.out.println("worker task compeleted::executing another runnable which doesn't return any result by thread::"+Thread.currentThread().getName()));
//        compFuture.join();
        //supplyAsAsync takes supplier
        Supplier<Integer> supplier = ()->{
            int sum=0;
            for(int i=0;i<10;i++){
                sum=sum+i;
            }
            System.out.println("Task Running Asynchronously:: "+ Thread.currentThread().getName()+" sum::"+sum);
            return sum;
        };
        Supplier<Integer> supplier1 = ()->{
            int sum=0;
            for(int i=10;i<20;i++){
                sum=sum+i;
            }
            System.out.println("Task Running Asynchronously:: "+ Thread.currentThread().getName()+" sum::"+sum);
            return sum;
        };
        Function<Integer,Integer> function = (value1)->{
            System.out.println("In apply method of comp Future:: "+Thread.currentThread().getName());
            return value1*10;
        };

        Consumer<Integer> consumer =  (value)->{
            System.out.println("In accept method of comp future::"+Thread.currentThread().getName()+"\n"+"Printing output::"+value);
        };
        final CompletableFuture<Void> voidCompletableFuture = CompletableFuture.supplyAsync(supplier,executors).thenApplyAsync(function,executors).thenAccept(consumer);
        voidCompletableFuture.join();

        final CompletableFuture<Integer> completableFuture = CompletableFuture.supplyAsync(supplier);
        final CompletableFuture<Integer> completableFuture1 = CompletableFuture.supplyAsync(supplier1);
        final CompletableFuture<Integer> completableFuture2 = completableFuture.thenCombine(completableFuture1, (result1, result2) -> {
            System.out.println("combining result::"+Thread.currentThread().getName());
            return result1 + result2;
        });
        System.out.println("combined result:: "+completableFuture2.get());
        System.out.println("void completable future get::"+voidCompletableFuture.get());
        executors.shutdown();

    }
}

class Worker implements Runnable{
    @Override
    public void run() {
        System.out.println(
                "Running the task::by"+Thread.currentThread().getName()
        );
    }
}

