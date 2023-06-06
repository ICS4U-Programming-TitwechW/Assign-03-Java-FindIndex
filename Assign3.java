import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
* This program will read a list of strings
* then reverse the string and print it.
*
*
* @author Titwech Wal
* @version 1.0
* @since   2023-06-01
*/

public final class Assign3 {

    /**
    * This is a private constructor used to satisfy the
    * style checker.
    *
    * @exception IllegalStateException Utility class.
    * @see IllegalStateException
    */
    private Assign3() {
        throw new IllegalStateException("Utility class");
    }

    /**
    * This is the main method.
    *
    * @param args Unused.
    */
    public static void main(String[] args) {

        // Pass path to file as parameter.
        // And display it on the file.
        final File input = new File("input.txt");
        final File output = new File("output.txt");

        // Declare lists.
        final List<String> listOfChar =
                new ArrayList<String>();

        // Declare variable.
        final String charList;

        try {
            // Create FileWriter object to write to file.
            final FileWriter fW = new FileWriter(output);
            // Create Scanner object to read from file.
            final Scanner sc = new Scanner(input);
            // Create PrintWriter object to write to file.
            final PrintWriter write = new PrintWriter(fW);

            while (sc.hasNextLine()) {

                // Read line as string.
                final String str = sc.nextLine();
                final char numToFind = sc.nextLine().charAt(0);
                // final String strLine = str;

                // Convert from list to array.
                final char[] array = str.toCharArray();

                // Call the function.
                final int index = FindIndex(array, numToFind, 0);

                // Displays result to console
                System.out.println("The index of the first");
                System.out.print("occurrence is: " + index);

                // Displays result to output file
                write.println("The index of the first");
                write.print("occurrence is: " + index);
            }

            // Closes scanner & writer.
            write.close();
            sc.close();

        } catch (IOException error) {
            System.out.println("An error occurred: "
                    + error.getMessage());
        }

    }

    /**
     * This function returns findIndex.
     * param the string to search for the character and
     * the character to search for in the string.
     *
     * @param someString
     * @param aChar
     * @param place
     *
     * @return findIndex
     *
     */
    public static int findIndex(char[] someString, char aChar, int place) {

        // See if the line is empty.
        // If it is return the line.
        if (someString[place] == aChar) {
            return place;

        } else {
            // If the character is found return substring(1).
            // Means to return the 1 letter.
            return findIndex(someString, aChar, place + 1);
        }
    }
}
