import java.util.Random;

/**
 * Class representing a Vending Machine with associated methods to use it.
 *
 * @author ahennessy6
 * @version 1
 */
public class VendingMachine {
    private static double totalSales = 0;
    private int luckyChance = 0;
    private double machineValue = 0.0;
    private int machineItems = 0;
    private static final int MACHINEROW = 6;
    private static final int MACHINECOL = 3;
    private static final int MACHINEDEPTH = 5;

    private Random rand = new Random();

    private int row;
    private int col;
    private char[] coords;
    private VendingItem[][][] shelf;
    private VendingItem[] itemBuffer;

    /**
     * Constructor for VendingMachine
     */
    public VendingMachine() {
        this.luckyChance = luckyChance;
        this.machineValue = machineValue;
        this.shelf = new VendingItem[MACHINEROW][MACHINECOL][MACHINEDEPTH];
        this.machineItems = machineItems;
        this.rand = rand;
        this.itemBuffer = itemBuffer;
        restock();
    }

    /**
     * helper method to identify where letter is in alphabet.
     *
     * @param c to be evaluated
     * @return position
     */
    public int alphabetPosition(char c) {
        int temp = (int) c;
        int upperInteger = 65; // for lower case
        int lowerInteger = 97;

        if (temp <= 90 & temp >= 65) {
            return (temp - upperInteger);
        } else if (temp <= 122 & temp >= 97) {
            return (-1);

        } else if (temp <= 57 & temp > 48) {
            return (-1);
        } else {
            return 0;
        }
    }

    /**
     * Constructor for vendingItem
     *
     * @param code two character string passed in from VendingWorld that
     *             corresponds to slot on vending machine.
     * @return returns a VendingItem that is returned to Vending World as a
     *         product.
     */
    public VendingItem vend(String code) {
        try {
            coords = code.toCharArray();
            row = alphabetPosition(coords[0]);
            col = coords[1] - '1';
            if ((row == 0 || row == 1 || row == 2 || row == 3 || row == 4
                    || row == 5) && (col == 0 || col == 1 || col == 2)
                    && coords.length == 2) {
                // VendingItem picked = this.shelf[row][col][0];
                VendingItem picked = this.shelf[row][col][0];
                VendingItem[] holder = new VendingItem[1];
                holder[0] = picked;
                // System.out.println(Arrays.toString(this.shelf[row][col]));
                // System.out.println(String.valueOf(this.getLuckyChance()));

                if (free()) {
                    for (int i = 1; i < MACHINEDEPTH; i++) {
                        this.shelf[row][col][i - 1] = this.shelf[row][col][i];
                    }
                    this.shelf[row][col][MACHINEDEPTH - 1] = null;
                } else {
                    for (int i = 1; i < MACHINEDEPTH; i++) {
                        this.shelf[row][col][i - 1] = this.shelf[row][col][i];
                    }
                    this.shelf[row][col][MACHINEDEPTH - 1] = null;
                    totalSales = totalSales + holder[0].getPrice();
                }

                return holder[0];
            } else {
                System.out.println("Invalid Code not Exception");
                return null;
            }

        } catch (NullPointerException e) {
            System.out.println("Empty");
            this.luckyChance--;
            return null;
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Invalid code and/or Exception");
            return null;
        } finally {
            //System.out.println(this.getLuckyChance());
        }

    }

    /**
     * Private helper method to determine if the user should receive item for
     * free
     *
     * @return boolean true or false if user should get free item.
     */
    private boolean free() {
        try {
            if ((this.rand.nextInt(101 - this.luckyChance) == 0)
                    && this.luckyChance != 0) { // start at 100 decrement
                                                // by 1 every time
                this.luckyChance = 0;
                // System.out.println("True 1");
                return true;
            } else if (this.luckyChance == 0) {
                this.luckyChance++;
                // System.out.println("False 2");
                return false;
            } else if (this.luckyChance == 100) {
                this.luckyChance = 0;
                // System.out.println("True 3");
                return true;
            } else {
                this.luckyChance++;
                // System.out.println("False 4");
                return false;
            }
        } catch (Exception e) {
            this.luckyChance++;
            // System.out.println("False 2");
            return false;
        }
    }

    /**
     * Method that fill each empty spot in vending machine with random items.
     *
     */
    public void restock() {
        for (int i = 0; i < MACHINEROW; i++) {
            for (int j = 0; j < MACHINECOL; j++) {
                for (int k = 0; k < MACHINEDEPTH; k++) {
                    if (this.shelf[i][j][k] == null) {
                        this.shelf[i][j][k] = VendingItem.values()[this.rand
                                .nextInt(VendingItem.values().length)];
                    } else {
                        assert true;
                    }
                }
            }
        }
    }

    /**
     * Constructor for vendingItem
     *
     * @return total amount of sales from all machines
     */
    public static double getTotalSales() {
        return totalSales;
    }

    /**
     * gets the Total number of items in a machine
     *
     * @return number of items in a machine.
     */
    public int getNumberOfItems() {
        this.machineItems = 0;
        for (int i = 0; i < MACHINEROW; i++) {
            for (int j = 0; j < MACHINECOL; j++) {
                for (int k = 0; k < MACHINEDEPTH; k++) {
                    if (this.shelf[i][j][k] == null) {
                        assert true;
                    } else {
                        this.machineItems = this.machineItems + 1;
                    }
                }
            }
        }
        return this.machineItems;
    }

    /**
     * Method that returns combined total value of all the vending item sin the
     * machine.
     * @return number representing value of all items in vending machine.
     */
    public double getTotalValue() {
        this.machineValue = 0.0;
        try {
            for (int i = 0; i < MACHINEROW; ++i) {
                for (int j = 0; j < MACHINECOL; ++j) {
                    for (int k = 0; k < MACHINEDEPTH; ++k) {
                        if (this.shelf[i][j][k] == null) {
                            assert true;
                        } else {
                            this.machineValue = this.machineValue
                                    + this.shelf[i][j][k].getPrice();
                        }
                    }
                }
            }
            return this.machineValue;
        } catch (Exception e) {
            //System.out.println(e);
            return 0.0;
        }
    }

    /**
     * This method should return the current value of luckyChance.
     *
     * @return the current value of luckyChance.
     */
    public int getLuckyChance() {
        return this.luckyChance;
    }

    /**
     * To make it easier, this method has been provided for you below.
     * @return string that looks like vending machine.
     */
    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append("----------------------------------------------------------"
                + "------------\n");
        s.append("                            VendaTron 9000                "
                + "            \n");
        for (int i = 0; i < shelf.length; i++) {
            s.append("------------------------------------------------------"
                    + "----------------\n");
            for (int j = 0; j < shelf[0].length; j++) {
                VendingItem item = shelf[i][j][0];
                String str = String.format("| %-20s ",
                        (item == null ? "(empty)" : item.name()));
                s.append(str);
            }
            s.append("|\n");
        }
        s.append("----------------------------------------------------------"
                + "------------\n");
        s.append(String.format(
                "There are %d items with a total " + "value of $%.2f.%n",
                getNumberOfItems(), getTotalValue()));
        s.append(String.format(
                "Total sales across vending machines " + "is now: $%.2f.%n",
                getTotalSales()));
        return s.toString();
    }

}
