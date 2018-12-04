public class Wee {
    static void bar() throws Exception {
        throw new Exception("Wee!");
}
    static void foo() throws Exception {
        bar();
        System.out.println("Foo!");
    }
    public static void main(String[] args) {
        try {
            foo();
            System.out.println("Got here");
        } catch (Exception t) {
            System.out.println(t.getMessage());
        }
        System.out.println("I’m still running.");
    }
}
