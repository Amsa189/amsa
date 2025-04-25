package practiceCode;

final public class ImmutableClass {

    private final String name;

    ImmutableClass(String name){
        this.name = name;
    }

    public String getName(){
        return this.name;
    }
}

class TestIm{
    void main(){
        ImmutableClass obj = new ImmutableClass("amsa");
        System.out.println(obj.getName());

    }
}

