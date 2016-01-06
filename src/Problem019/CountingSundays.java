package Problem019;

import java.util.HashMap;

/**
 * Problem 19:
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
    public static void main(String[] args) {
        HashMap<Integer, Integer> daysEachMonth = new HashMap<>();
        daysEachMonth.put(1, 31);
        daysEachMonth.put(2, 28);
        daysEachMonth.put(3, 31);
        daysEachMonth.put(4, 30);
        daysEachMonth.put(5, 31);
        daysEachMonth.put(6, 30);
        daysEachMonth.put(7, 31);
        daysEachMonth.put(8, 31);
        daysEachMonth.put(9, 30);
        daysEachMonth.put(10, 31);
        daysEachMonth.put(11, 30);
        daysEachMonth.put(12, 31);

        int year = 1901;
        int month = 1;
        int date = 1;
        int day = 1;

        int sum = 0;

        while (year < 2001) {
            int datesThisMonth = daysEachMonth.get(month);
            if (month == 2 && isLeapYear(year)) datesThisMonth++;
            while (date <= datesThisMonth) {
                day++;
                if (day == 7 && date == 1) sum++;
                if (day == 8) day = 1;
                date++;
            }
            date = 1;
            month++;
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
