import java.util.*;
import java.io.File;
//import java.util.Scanner;
import java.lang.*;
import java.io.IOException;

public class PasswordInfo {
    private String passwordLine;
    private String password;
    private char letter;
    private int minRange;
    private int maxRange;

    private String rangeLetter;
    private String range;

    public PasswordInfo(String line) {
        passwordLine = line;
        this.setPassword();
        this.setRangeLetter();
        this.setRangeAndLetter();
        this.setRanges();

        this.isPasswordValid();
    }

    public String getPasswordLine() {
        return passwordLine;
    }

    public void setPassword() {
        String[] tempPass = passwordLine.split(":", 2);
        password = tempPass[1].trim();
    }

    public String getPassword() {
        return password;
    }

    private void setRangeLetter() {
        String[] tempRangeLetter = passwordLine.split(":", 2);
        rangeLetter = tempRangeLetter[0].trim();
    }

    private void setRangeAndLetter() {
        String[] tempRangeLetter = rangeLetter.split(" ", 2);
        range = tempRangeLetter[0];
        letter = tempRangeLetter[1].charAt(0);
    }

    private void setRanges() {
        String[] tempRange = range.split("-", 2);
        minRange = Integer.parseInt(tempRange[0]);
        maxRange = Integer.parseInt(tempRange[1]);
    }

    public int getMinRange() {
        return minRange;
    }

    public int getMaxRange() {
        return maxRange;
    }

    public char getLetter() {
        return letter;
    }

    public boolean isPasswordValid() {
        boolean isValid = false;
        int charCount = 0;
        
        //find character count
        for (int c = 0; c < password.length(); c++) {
            if (password.charAt(c) == letter) {
                charCount++;
            }
        }

        //check range
        if (charCount >= minRange && charCount <= maxRange) {
            isValid = true;
        }


        return isValid;
    }

    public void printPasswordInfo() {
        System.out.println("Password line: " + this.getPasswordLine() +
        "\nPassword: " + this.getPassword() +
        "\nMin Range: " + this.getMinRange() +
        "\nMax Range: " + this.getMaxRange() +
        "\nLetter: " + this.getLetter());
    }


}