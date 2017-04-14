import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Main class calculate BMI of user
 * @author Roman
 * @version 1.0
 * @since 10.04.2017
 */
public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        /**
         * Verification of weight
         * by regular expressions(Pattern and Matcher classes)
         */
        System.out.println("Enter your weight, kg:");
        String weightString = sc.nextLine();
        Pattern patternWeight = Pattern.compile("0*[4-9]\\d|0*1\\d\\d|0*200");
        Matcher matcherWeight = patternWeight.matcher(weightString);

        while (! matcherWeight.matches()){
            System.out.println("Usage: 40 - 200");
            weightString = sc.nextLine();
            matcherWeight = patternWeight.matcher(weightString);
        }

        System.out.println("Enter your height, cm:");
        String heightString = sc.nextLine();
        Pattern patternHeight = Pattern.compile("0*[12]\\d\\d|300");
        Matcher matcherHeight = patternHeight.matcher(heightString);

        while (! matcherHeight.matches()){
            System.out.println("Usage: 100 - 300");
            heightString = sc.nextLine();
            matcherHeight = patternWeight.matcher(heightString);
        }

        /**
         * Calculating BMI and
         * printing a message
         */
        int bmi = (int) Math.round(Double.parseDouble(weightString) * 10000 /
                (Double.parseDouble(heightString) * Double.parseDouble(heightString)));

//        System.out.println(Math.round(Double.parseDouble(weightString) * 10000 /
//                (Double.parseDouble(heightString) * Double.parseDouble(heightString))));
//        System.out.println(bmi);

        /**
         * get value {@link Main#bmi} and print it and suitable message
         */
        switch (bmi){

            case 13: case 14: case 15 :
                System.out.println("BMI: " + bmi + " - Severe thinness");
                break;

            case 16: case 17: case 18 :
                System.out.println("BMI: " + bmi + " - Underweight");
                break;

            case 19: case 20: case 21: case 22: case 23: case 24: case 25:
                System.out.println("BMI: " + bmi + " - Normal (healthy weight)");
                break;

            case 26: case 27: case 28: case 29: case 30:
                System.out.println("BMI: " + bmi + " - Overweight");
                break;

            case 31: case 32: case 33: case 34: case 35:
                System.out.println("BMI: " + bmi + " - Obese Class I (Moderately obese)");
                break;

            case 36: case 37: case 38: case 39: case 40:
                System.out.println("BMI: " + bmi + " - Obese Class II (Severely obese)");
                break;

            default:
                System.out.println("BMI: " + bmi + " - To hospital!");
                break;
        }

        //сделать слайд с формулой и кейсом
    }
}
