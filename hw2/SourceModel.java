import java.util.Scanner;
import java.io.File;

public class SourceModel {

    private String name;
    private String fileName;
    private double sum;
    private double probability;
    private double[][] countList = new double[26][26];
    private double[][] transitionMatrix = new double[26][26];
    private String alphabet = "abcdefghijklmnopqrstuvwxyz";
    private char[] alphabetArray = "abcdefghijklmnopqrstuvwxyz".toCharArray();


    public static void main(String[] args) throws Exception {
        Double maximum = 0.0;
        String mostLikely = "";
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        double probabilitySum = 0;
        SourceModel[] trainingSets = new SourceModel[args.length - 1];
        for (int i = 0; i < args.length - 1; i++) {
            trainingSets[i] = new SourceModel(args[i].split("\\.")[0],
            args[i]);
        }
        System.out.printf("Analyzing: %s%n", args[args.length - 1]);

        String[] testStringBuffer = args[args.length - 1].
        replaceAll("[^a-zA-Z]", "").
        split("");
        for (int i = 0; i < testStringBuffer.length; i++) {
            testStringBuffer[i] = testStringBuffer[i].toLowerCase();
        }
        for (int k = 0; k < trainingSets.length; k++) {
            for (int i = 0; i < testStringBuffer.length - 1; i++) {
                trainingSets[k].probability = trainingSets[k].probability
                        * trainingSets[k].transitionMatrix[alphabet.
indexOf(testStringBuffer[i])][alphabet.indexOf(testStringBuffer[i + 1])];
            }
        }
        for (int k = 0; k < trainingSets.length; k++) {
            probabilitySum += trainingSets[k].probability;
        }

        for (int k = 0; k < trainingSets.length; k++) {
            if (trainingSets[k].probability / probabilitySum > maximum) {
                maximum = trainingSets[k].probability / probabilitySum;
                mostLikely = trainingSets[k].name;
            } else {
                Double x = 0.0;
            }
            System.out.printf("%s %10s: %.02f%n", "Probability that test st"
                + "ring is", trainingSets[k].name, trainingSets[k].probability
                     / probabilitySum);
        }
        System.out.printf("Test string is most likely %s.%n", mostLikely);


    }

    public String getName() {
        return this.name;
    }

    public String toString() {
        String outputString = "";
        outputString = outputString + String.format("Model: %s%n", this.name);
        outputString = outputString +  String.format("     a    b    c    d    "
+ "e    f    g    h    i    j    "
+ "k    l    m    n    o    p    q    r    s    t    u    v    "
+ "w    x    y    z%n");
        for (int i = 0; i < 26; i++) {
            outputString = outputString
                + String.format("%c ", this.alphabetArray[i]);
            for (int m = 0; m < 26; m++) {
                outputString = outputString + String.format("%.02f ",
this.transitionMatrix[i][m]);
            }
            outputString = outputString + String.format("%n");
        }
        return outputString;
    }

    public double probability(String testString) {
        this.probability = 1.0;
        String[] testStringBuffer = testString.replaceAll("[^a-zA-Z]", "").
split("");

        for (int i = 0; i < testStringBuffer.length; i++) {
            testStringBuffer[i] = testStringBuffer[i].toLowerCase();
        }

        for (int i = 0; i < testStringBuffer.length - 1; i++) {
            this.probability = this.probability
                * this.transitionMatrix[alphabet.indexOf(testStringBuffer[i])]
[alphabet.indexOf(testStringBuffer[i + 1])];
        }
        return this.probability;
    }

    SourceModel(String aName, String aFileName) throws Exception {
        this.name = aName;
        this.sum = sum;
        this.probability = probability;
        this.probability = 1;
        this.fileName = aFileName;
        this.transitionMatrix = transitionMatrix;
        this.countList = countList;
        System.out.printf("Training %s model", this.name);
        String[] formattedCorpus = new Scanner(new File(this.fileName)).
useDelimiter("\\Z").next().replaceAll("[^a-zA-Z]", "").split("");
    //System.out.println(Arrays.toString(formattedCorpus));
        for (int i = 0; i < formattedCorpus.length - 1; i++) {
            this.countList[alphabet.indexOf(formattedCorpus[i].toLowerCase())]
[alphabet.indexOf(formattedCorpus[i + 1].toLowerCase())]++;
        }
        System.out.print(" ... ");
        for (int i = 0; i < 26; i++) {
            this.sum = 0;
            for (int q = 0; q < 26; q++) {
                this.sum = this.sum + this.countList[i][q];
            }
            for (int m = 0; m < 26; m++) {
                this.transitionMatrix[i][m] = this.countList[i][m] / this.sum;
                if (this.sum == 0 || this.transitionMatrix[i][m] == 0) {
                    this.transitionMatrix[i][m] = 0.01;
                }
            }
        }
        System.out.printf("done.%n");
    }
}
