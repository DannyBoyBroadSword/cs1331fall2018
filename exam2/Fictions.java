public class Fictions extends Book {
  private String fname;
  private double fprice;
  private int fnumCopies;
	public Fictions(String name, double price, int numCopies){
	super(name, price);
}

@Override
public boolean equals(Object b){
	if(this == b){
    return true;
  }
  if(!(this instanceof Book)){
    return false;
  }
  if(this.fname == ((Fictions)b).fname && this.fprice == ((Fictions)b).fprice && this.fnumCopies == ((Fictions)b).fnumCopies){
    return true;
  } else {
    return false;
  }
}

public static void main(String[] args){
  Book flivverKing = new Fictions("Flivver King", 2.0,15);
  Book penisLover = new Fictions("Flivver King", 2.0,15);
  if(flivverKing.equals(penisLover)){
    System.out.println("GAY");
  }else{
    System.out.println("not equal");
  }
}

}
