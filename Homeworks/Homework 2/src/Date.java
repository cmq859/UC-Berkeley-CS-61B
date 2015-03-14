/* Date.java */

import java.io.*;

class Date {

    /* Put your private data fields here. */
    private int month, day, year;

    /** Constructs a date with the given month, day and year.   If the date is
     *  not valid, the entire program will halt with an error message.
     *  @param month is a month, numbered in the range 1...12.
     *  @param day is between 1 and the number of days in the given month.
     *  @param year is the year in question, with no digits omitted.
     */
    public Date(int month, int day, int year) {
        if (isValidDate(month, day, year)) {
            this.month = month;
            this.day = day;
            this.year = year;
        }
    }

    /** Constructs a Date object corresponding to the given string.
     *  @param s should be a string of the form "month/day/year" where month must
     *  be one or two digits, day must be one or two digits, and year must be
     *  between 1 and 4 digits.  If s does not match these requirements or is not
     *  a valid date, the program halts with an error message.
     */
    public Date(String s) {
        int index = s.indexOf("/");
        month = Integer.parseInt(s.substring(0, index));
        day = Integer.parseInt(s.substring(index + 1, (index = s.indexOf("/", index + 1))));
        year = Integer.parseInt(s.substring(index + 1));
    }

    /** Checks whether the given year is a leap year.
     *  @return true if and only if the input year is a leap year.
     */
    public static boolean isLeapYear(int year) {
        //return true;                        // replace this line with your solution
        if (year % 4 == 0) {
            if (year % 100 == 0) {
                if (year % 400 == 0) {
                    return true;
                } else {
                    return false;
                }
            } else {
                return true;
            }
        } else {
            return false;
        }
    }

    /** Returns the number of days in a given month.
     *  @param month is a month, numbered in the range 1...12.
     *  @param year is the year in question, with no digits omitted.
     *  @return the number of days in the given month.
     */
    public static int daysInMonth(int month, int year) {
        //return 0;                           // replace this line with your solution
        if (isLeapYear(year) && month == 2) {
            return 29;
        } else {
            switch (month) {
                case 2:
                    return 28;
                case 1:
                case 3:
                case 5:
                case 7:
                case 8:
                case 10:
                case 12:
                    return 31;
                default:
                    return 30;
            }
        }
    }

    /** Checks whether the given date is valid.
     *  @return true if and only if month/day/year constitute a valid date.
     *
     *  Years prior to A.D. 1 are NOT valid.
     */
    public static boolean isValidDate(int month, int day, int year) {
        //return true;                        // replace this line with your solution
        if (month < 1 || month > 12) {
            System.out.println("Error: Month has to be between 1 and 12");
            System.exit(0);
        }
        if (day < 1 || day > daysInMonth(month, year)) {
            System.out.println("Error: Day is invalid");
            System.exit(0);
        }
        if (year < 1) {
            System.out.println("AD years only");
            System.exit(0);
        }
        return true;
    }

    /** Returns a string representation of this date in the form month/day/year.
     *  The month, day, and year are expressed in full as integers; for example,
     *  12/7/2006 or 3/21/407.
     *  @return a String representation of this date.
     */
    public String toString() {
        //return "stuff";                     // replace this line with your solution
        String date = month + "/" + day + "/" + year;
        return date;
    }

    /** Determines whether this Date is before the Date d.
     *  @return true if and only if this Date is before d.
     */
    public boolean isBefore(Date d) {
        //return true;                        // replace this line with your solution
        if (year < d.year) {
            return true;
        } else if (year > d.year) {
            return false;
        } else {
            if (month < d.month) {
                return true;
            } else if (month > d.month) {
                return false;
            } else {
                if (day < d.day) {
                    return true;
                } else {
                    return false;
                }
            }
        }
    }

    /** Determines whether this Date is after the Date d.
     *  @return true if and only if this Date is after d.
     */
    public boolean isAfter(Date d) {
        //return true;                        // replace this line with your solution
        if (day == d.day && month == d.month && year == d.year) {
            return false;
        }
        return !isBefore(d);
    }

    /** Returns the number of this Date in the year.
     *  @return a number n in the range 1...366, inclusive, such that this Date
     *  is the nth day of its year.  (366 is used only for December 31 in a leap
     *  year.)
     */
    public int dayInYear() {
        //return 0;                           // replace this line with your solution
        if (isLeapYear(year)) {
            return 366;
        }
        return 365;
    }

    /** Determines the difference in days between d and this Date.  For example,
     *  if this Date is 12/15/2012 and d is 12/14/2012, the difference is 1.
     *  If this Date occurs before d, the result is negative.
     *  @return the difference in days between d and this date.
     */
    public int difference(Date d) {
        //return 0;                           // replace this line with your solution
        int numDays = 0;
        if (isAfter(d)) {
            Date temp = new Date(month, day, year);
            return -d.difference(temp);
        }
        Date date = new Date(month, day, year);
        while (date.day != d.day || date.month != d.month || date.year != d.year) {
            date.day++;
            if (date.day > daysInMonth(date.month, date.year)) {
                date.day = 1;
                date.month++;
            }
            if (date.month > 12) {
                date.month = 1;
                date.year++;
            }
            numDays++;
        }
        return -numDays;
    }

    public static void main(String[] argv) {
        System.out.println("\nTesting constructors.");
        Date d1 = new Date(1, 1, 1);
        System.out.println("Date should be 1/1/1: " + d1);
        d1 = new Date("2/4/2");
        System.out.println("Date should be 2/4/2: " + d1);
        d1 = new Date("2/29/2000");
        System.out.println("Date should be 2/29/2000: " + d1);
        d1 = new Date("2/29/1904");
        System.out.println("Date should be 2/29/1904: " + d1);

        d1 = new Date(12, 31, 1975);
        System.out.println("Date should be 12/31/1975: " + d1);
        Date d2 = new Date("1/1/1976");
        System.out.println("Date should be 1/1/1976: " + d2);
        Date d3 = new Date("1/2/1976");
        System.out.println("Date should be 1/2/1976: " + d3);

        Date d4 = new Date("2/27/1977");
        Date d5 = new Date("8/31/2110");
        System.out.println("Date should be 2/27/1997: " + d4);
        System.out.println("Date should be 8/31/2110: " + d5);

        /* I recommend you write code to test the isLeapYear function! */
        System.out.println("\n1800 as a Leap Year should be false: " + isLeapYear(1800));
        System.out.println("1900 as a Leap Year should be false: " + isLeapYear(1900));
        System.out.println("1600 as a Leap Year should be true: " + isLeapYear(1600));
        System.out.println("2000 as a Leap Year should be true: " + isLeapYear(2000));

        System.out.println("\nTesting before and after.");
        System.out.println(d2 + " after " + d1 + " should be true: " +
                d2.isAfter(d1));
        System.out.println(d3 + " after " + d2 + " should be true: " +
                d3.isAfter(d2));
        System.out.println(d1 + " after " + d1 + " should be false: " +
                d1.isAfter(d1));
        System.out.println(d1 + " after " + d2 + " should be false: " +
                d1.isAfter(d2));
        System.out.println(d2 + " after " + d3 + " should be false: " +
                d2.isAfter(d3));

        System.out.println(d1 + " before " + d2 + " should be true: " +
                d1.isBefore(d2));
        System.out.println(d2 + " before " + d3 + " should be true: " +
                d2.isBefore(d3));
        System.out.println(d1 + " before " + d1 + " should be false: " +
                d1.isBefore(d1));
        System.out.println(d2 + " before " + d1 + " should be false: " +
                d2.isBefore(d1));
        System.out.println(d3 + " before " + d2 + " should be false: " +
                d3.isBefore(d2));

        System.out.println("\nTesting difference.");
        System.out.println(d1 + " - " + d1  + " should be 0: " +
                d1.difference(d1));
        System.out.println(d2 + " - " + d1  + " should be 1: " +
                d2.difference(d1));
        System.out.println(d3 + " - " + d1  + " should be 2: " +
                d3.difference(d1));
        System.out.println(d3 + " - " + d4  + " should be -422: " +
                d3.difference(d4));
        System.out.println(d5 + " - " + d4  + " should be 48762: " +
                d5.difference(d4));
    }
}
