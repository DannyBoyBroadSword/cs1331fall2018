public enum VendingItem {
    LAYS (1.50,"Lays"), DORITOS (1.50, "Doritos"), COKE (2.50, "Coke"),
    RAMBLIN_RECK_TOY (180.75, "Ramblin_Reck_Toy"),
    RUBIKS_CUBE (30.00, "Rubiks_Cube"),RAT_CAP (15.00, "Rat_Cap"), FASET_LANYARD (10.00, "Faset_Lanyard"),
    GRAPHING_CALCULATOR (120.00, "Graphing_Calculator"), UGA_DIPLOMA (0.10, "UGA_Diploma"),
    PIE (3.14, "Pie"), CLICKER (55.55, "Clicker"), CHEETOS (1.25, "Cheetos"), SPRITE (2.50, "Sprite"),
    RED_BULL (4.75, "Red_Bull"), RAMEN (3.15, "Ramen"), COLD_PIZZA (0.99, "Cold_Pizza");

    private final double price;
    private final String name;

    private VendingItem(final double price){
      this.price = price;
    }

    public double getPrice(){
      return price;
    }
    public String getName(){
      return name;
    }

    public String toString(){
      return String.format("(%s): $%.2f",name,price);
    }

}
