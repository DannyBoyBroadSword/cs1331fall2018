package edu.gatech.cs1331.collections;

public class myPerson implements Comparable<myPerson> {
  private int age;
  private String name;

  public myPerson(int age, String name){
    this.age = age;
    this.name = name;
  }

  public int compareTo(myPerson other){
    return this.age - other.age;
  }



}
