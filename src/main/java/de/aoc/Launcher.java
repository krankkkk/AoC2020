package de.aoc;

import de.aoc.days.Day;
import de.aoc.days.day14.Day14;

public class Launcher {

    public static void main(String[] args) {
        final Day day12 = new Day14();
        //
        System.out.printf("%d%n%d%n", day12.part1(), day12.part2());
    }
}
