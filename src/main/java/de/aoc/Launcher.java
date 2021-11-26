package de.aoc;

import de.aoc.days.Day;
import de.aoc.days.day1.Day1;
import de.aoc.days.day10.Day10;
import de.aoc.days.day12.Day12;
import de.aoc.days.day13.Day13;
import de.aoc.days.day14.Day14;
import de.aoc.days.day2.Day2;
import de.aoc.days.day3.Day3;
import de.aoc.days.day4.Day4;
import de.aoc.days.day5.Day5;
import de.aoc.days.day6.Day6;
import de.aoc.days.day7.Day7;
import de.aoc.days.day8.Day8;
import de.aoc.days.day9.Day9;

import java.util.Collection;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public class Launcher {

    public static void main(String[] args) {

        final Collection<Day> days = List.of(new Day1(), new Day2(), new Day3(), new Day4(), new Day5(), new Day6(),
                new Day7(), new Day8(), new Day9(), new Day10(), new Day12(), new Day13(), new Day14());//11 missing

        for (Day day : days) {
            CompletableFuture.runAsync(() -> System.out.printf("%s - %d     -       %d%n", day.getClass().getSimpleName(), day.part1(), day.part2()));
        }


        final Day day = new Day14();
        System.out.printf("%d%n%d%n", day.part1(), day.part2());
    }
}
