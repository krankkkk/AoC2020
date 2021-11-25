package de.aoc.days.day2;

import de.aoc.days.AbstractDay;

import java.util.stream.Stream;

public class Day2 extends AbstractDay {
    private static boolean isValidPart1(final String line) {
        final String[] s = line.split(" ");
        final String[] count = s[0].split("-");
        final char letter = s[1].charAt(0);
        int counter = 0;
        for (char c : s[2].toCharArray()) {
            if (c == letter) {
                counter++;
            }
        }

        final int min = Integer.parseInt(count[0]);
        final int max = Integer.parseInt(count[1]);
        return min <= counter && max >= counter;
    }

    private static boolean isValidPart2(final String line) {
        final String[] s = line.split(" ");
        final String[] place = s[0].split("-");
        final char letter = s[1].charAt(0);

        final int firstCharIndex = Integer.parseInt(place[0]) - 1;
        final int secondCharIndex = Integer.parseInt(place[1]) - 1;
        return s[2].charAt(firstCharIndex) == letter ^ s[2].charAt(secondCharIndex) == letter;
    }

    @Override
    public long part1(final Stream<String> stream) {
        return stream.filter(Day2::isValidPart1).count();
    }

    @Override
    public long part2(final Stream<String> stream) {
        return stream.filter(Day2::isValidPart2).count();
    }
}
