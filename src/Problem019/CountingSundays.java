package Problem019;

import java.util.HashMap;

/**
 * You are given the following information, but you may prefer to do some research for yourself.
 * <p>
 * 1 Jan 1900 was a Monday.
 * Thirty days has September,
 * April, June and November.
 * All the rest have thirty-one,
 * Saving February alone,
 * Which has twenty-eight, rain or shine.
 * And on leap years, twenty-nine.
 * A leap year occurs on any year evenly divisible by 4, but not on a century unless it is divisible by 400.
 * <p>
 * How many Sundays fell on the first of the month during the twentieth century (1 Jan 1901 to 31 Dec 2000)?
 */

public class CountingSundays {
    //convert each month to days count
    private static HashMap<Integer, Integer> daysEachMonth = new HashMap<Integer, Integer>() {{
        this.put(1,31);
        this.put(2,28);
        this.put(3,31);
        this.put(4,30);
        this.put(5,31);
        this.put(6,30);
        this.put(7,31);
        this.put(8,31);
        this.put(9,30);
        this.put(10,31);
        this.put(11,30);
        this.put(12,31);
    }};
    public static void main(String[] args) {
        //initial condition
        int year = 1901;
        int month = 1;
        int date = 1;
        int day = 1;

        int sum = 0;

        //main loop
        while (year < 2001) {
            int datesThisMonth = daysEachMonth.get(month);
            if (month == 2 && isLeapYear(year)) datesThisMonth++;
            //date+1
            while (date <= datesThisMonth) {
                day++;
                if (day == 7 && date == 1) sum++;
                if (day == 8) day = 1;
                date++;
            }
            date = 1;
            month++;
            //year+1
            if (month == 13) {
                month = 1;
                year++;
            }
        }

        System.out.println("Sundays: " + sum);
    }

    private static boolean isLeapYear(int year) {
        if (year % 4 != 0) return false;
        if (year % 100 == 0) return year % 400 == 0;
        return true;
    }
}
