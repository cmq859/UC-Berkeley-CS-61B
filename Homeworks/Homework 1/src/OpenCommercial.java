/* OpenCommercial.java */

import java.net.*;
import java.io.*;

/**  A class that provides a main function to read five lines of a commercial
 *   Web page and print them in reverse order, given the name of a company.
 */

class OpenCommercial {

    /** Prompts the user for the name X of a company (a single string), opens
     *  the Web site corresponding to www.X.com, and prints the first five lines
     *  of the Web page in reverse order.
     *  @param arg is not used.
     *  @exception Exception thrown if there are any problems parsing the
     *             user's input or opening the connection.
     */
    public static void main(String[] arg) throws Exception {

        BufferedReader keyboard;
        String inputLine;

        keyboard = new BufferedReader(new InputStreamReader(System.in));

        System.out.print("Please enter the name of a company (without spaces): ");
        System.out.flush();        /* Make sure the line is printed immediately. */
        inputLine = keyboard.readLine();

        /* Replace this comment with your solution.  */
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new URL("http://www." + inputLine + ".com").openStream()));
        String lineOne = bufferedReader.readLine();
        String lineTwo = bufferedReader.readLine();
        String lineThree = bufferedReader.readLine();
        String lineFour = bufferedReader.readLine();
        String lineFive = bufferedReader.readLine();            //Arrays had not been taught at this point
        System.out.println(lineFive);
        System.out.println(lineFour);
        System.out.println(lineThree);
        System.out.println(lineTwo);
        System.out.println(lineOne);

        //With Arrays
        /*
        String[] lines = new String[5];
        for (int i = 0; i < 5; i++) {
            lines[i] = bufferedReader.readLine();
        }
        for (int i = 4; i >= 0; i--) {
            System.out.println(lines[i]);
        }
        */

        System.out.println("Enter a word and have the second character removed: ");
        inputLine = keyboard.readLine();
        nuke2(inputLine);
    }

    private static void nuke2(String inputLine) {
        if (inputLine.length() < 2) {
            System.out.println("You entered a word less with less than 2 characters.");
            return;
        }
        System.out.println("To remove the second character of " + inputLine);
        System.out.println(inputLine.substring(0, 1) + inputLine.substring(2));
    }
}
