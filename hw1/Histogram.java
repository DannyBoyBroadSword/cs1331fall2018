import java.util.Scanner;
import java.io.File;

//Figure out ranges

public class Histogram {

  public static void main(String[] args) throws Exception{
    try{
      //System.out.println(args[0]);
      Histogram.computeHistogram(Integer.parseInt(args[0]));
    } catch (Exception e) {
      //System.out.println(e);
      Histogram.computeHistogram(Histogram.askForBins());
    }
  }

  public static int askForBins(){
    Scanner reader = new Scanner(System.in);
    //System.out.printf("askForBins");
    System.out.println("How many bins would you like?");
    int n = reader.nextInt();
    reader.close();
    return n;
  }

  public static int[][] rangeArray(int bins){
    int[][] binRanges = new int[2][bins];

    for (int binIndex = 0;binIndex < bins; binIndex++){
      if (binIndex == bins-1){
        binRanges[0][binIndex] = 101-(1+binIndex*(101/bins));
        binRanges[1][binIndex] = 0;
      }else{
        binRanges[0][binIndex] = 101-(1+binIndex*(101/bins));
        binRanges[1][binIndex] = 101-((1+binIndex)*(101/bins));
      }

    }
    return binRanges;
  }

  public static int[] checkRange(int[][] myRangeArray, int bins) throws Exception{

    int[] myBins = new int[bins];

    File grades = new File("grades.csv");
    Scanner sc = new Scanner(grades);

    while (sc.hasNextLine()){
      String[] rawData = sc.nextLine().split(",");
      int formattedInt = Integer.parseInt(rawData[1].replaceAll("\\s+",""));
      for(int binIndex = 0; binIndex < bins ;binIndex++){
        if (formattedInt <= myRangeArray[0][binIndex] && formattedInt >= myRangeArray[1][binIndex]){
          myBins[binIndex]++;
        }else{
        }
      }
    }
    return myBins;
  }

  public static String bracketComposer(int numberOfBrackets){
    String output = "";

    for (int brackets = 0; brackets < numberOfBrackets; brackets++){
      output = output + "[]";
    }

    return output;
  }

  public static void computeHistogram(int bins) throws Exception{
    int[][] myRangeArray = rangeArray(bins);
    int[] myBinArray = checkRange(myRangeArray, bins);
    //String outputString = null;

    for (int rangeIndex = 0; rangeIndex < bins ; rangeIndex++){
      if (myRangeArray[0][rangeIndex] < 10){
        if (myRangeArray[1][rangeIndex] < 10){
          System.out.printf("  %d -   %d | %s%n",myRangeArray[0][rangeIndex],myRangeArray[1][rangeIndex],bracketComposer(myBinArray[rangeIndex]));
        }else if (myRangeArray[1][rangeIndex] < 100){
          System.out.printf("  %d -   %d | %s%n",myRangeArray[0][rangeIndex],myRangeArray[1][rangeIndex],bracketComposer(myBinArray[rangeIndex]));
        }else if (myRangeArray[1][rangeIndex] == 100){
          System.out.printf("  %d - %d | %s%n",myRangeArray[0][rangeIndex],myRangeArray[1][rangeIndex],bracketComposer(myBinArray[rangeIndex]));
        }

      }else if (myRangeArray[0][rangeIndex] < 100){
        if (myRangeArray[1][rangeIndex] < 10){
          System.out.printf(" %d -   %d | %s%n",myRangeArray[0][rangeIndex],myRangeArray[1][rangeIndex],bracketComposer(myBinArray[rangeIndex]));
        }else if (myRangeArray[1][rangeIndex] < 100){
          System.out.printf(" %d -  %d | %s%n",myRangeArray[0][rangeIndex],myRangeArray[1][rangeIndex],bracketComposer(myBinArray[rangeIndex]));
        }else if (myRangeArray[1][rangeIndex] == 100){
          System.out.printf("  %d - %d | %s%n",myRangeArray[0][rangeIndex],myRangeArray[1][rangeIndex],bracketComposer(myBinArray[rangeIndex]));
        }

      }else if (myRangeArray[0][rangeIndex] == 100){
        if (myRangeArray[1][rangeIndex] < 10){
          System.out.printf("%d -  %d | %s%n",myRangeArray[0][rangeIndex],myRangeArray[1][rangeIndex],bracketComposer(myBinArray[rangeIndex]));
        }else if (myRangeArray[1][rangeIndex] < 100){
          System.out.printf("%d -  %d | %s%n",myRangeArray[0][rangeIndex],myRangeArray[1][rangeIndex],bracketComposer(myBinArray[rangeIndex]));
        }else if (myRangeArray[1][rangeIndex] == 100){
          System.out.printf("%d - %d | %s%n",myRangeArray[0][rangeIndex],myRangeArray[1][rangeIndex],bracketComposer(myBinArray[rangeIndex]));
        }
      }
   }
}

}
