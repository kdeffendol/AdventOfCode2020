import java.util.*;
import java.io.File;
//import java.util.Scanner;
import java.lang.*;
import java.io.IOException;

public class Day2 {
    public static void main(String args[]) {
        try {
            File inputFile = new File("input.txt");
            Scanner sc = new Scanner(inputFile);
    
            ArrayList<String> input = createArrayList(sc, inputFile);
            ArrayList<PasswordInfo> passwordInfoList = makePasswordInfoObjects(input);

            printObjectArrayList(passwordInfoList);
            int validCounter = validityCounter(passwordInfoList);
            System.out.println(validCounter);


        }
        catch (IOException e) {
            System.out.println("An error occurred.");
        }
    }



    public static ArrayList<String> createArrayList(Scanner sc, File inputFile) {
        ArrayList<String> input = new ArrayList<String>();

        while (sc.hasNextLine()) {
            String line = sc.nextLine();
            input.add(line);
        }
        return input;
    }

    public static ArrayList<PasswordInfo> makePasswordInfoObjects(ArrayList<String> input) {
        ArrayList<PasswordInfo> passwordInfoList = new ArrayList<PasswordInfo>();
        for (String value : input) {
            PasswordInfo tempPassInfo = new PasswordInfo(value);
            passwordInfoList.add(tempPassInfo);
        }

        return passwordInfoList;
    }

    public static void printArrayList(ArrayList<String> list) {
        for (String value : list) {
            System.out.print(value + ", ");
        }
    }

    public static void printObjectArrayList(ArrayList<PasswordInfo> list) {
        for (PasswordInfo info : list) {
            info.printPasswordInfo();
        }
    }

    public static int validityCounter(ArrayList<PasswordInfo> list) {
        int isValidCount = 0;
        for (PasswordInfo info : list) {
            if (info.isPasswordValid() == true) {
                isValidCount++;
            }
        }

        return isValidCount;
    }
}