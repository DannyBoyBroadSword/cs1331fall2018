public class DynamicBindingDemo {

  public static void main(String[] args){
    Object o = new GraduateStudent();

    Object o1 = new Object();

    if (o instanceof GraduateStudent){
      System.out.println("Never got Here");
      GraduateStudent gs = (GraduateStudent) o1;
    }

    m(o);
    m(new Student());
    m(new Person());
    m(new Object());


  }

  public static void m(Object x){
    System.out.println(x.toString());
  }

}

class GraduateStudent extends Student {

}

class Student extends Person {
  public String toString() {
    return "Student";
  }
}

class Person extends Object {
  public String toString() {
    return "Person";
  }

}
