package de.aoc.days.day6;

import de.aoc.days.AbstractDay;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

public class Day6 extends AbstractDay {
    @Override
    public long part1(final Stream<String> stream) {
        final List<List<String>> groups = getGroups(stream);

        long sum = 0L;
        for (final List<String> group : groups) {
            final Map<Character, Boolean> answers = new HashMap<>();
            for (final String line : group) {
                for (char c : line.toCharArray()) {
                    answers.putIfAbsent(c, Boolean.TRUE);
                }
            }
            sum += answers.size();
        }


        return sum;
    }

    @Override
    public long part2(final Stream<String> stream) {
        final List<List<String>> groups = getGroups(stream);

        long sum = 0L;
        for (final List<String> group : groups) {
            List<Character> answers = null;
            for (final String line : group) {
                if (!line.isBlank()) {
                    final List<Character> chars = new ArrayList<>();
                    for (char c : line.toCharArray()) {
                        chars.add(c);
                    }

                    if (answers == null) {
                        answers = chars;
                    } else {
                        answers.retainAll(chars);
                    }
                }

            }
            sum += answers.size();
        }

        return sum;
    }

    private List<List<String>> getGroups(final Stream<String> stream) {
        final List<String> input = stream.toList();
        input.add(" ");

        final List<List<String>> groups = new ArrayList<>();

        int lastBlank = 0;
        for (int i = 0; i < input.size(); i++) {
            final String line = input.get(i);
            if (line.isBlank()) {
                List<String> group = new ArrayList<>();
                for (int j = lastBlank; j < i; j++) {
                    group.add(input.get(j));
                }
                groups.add(group);
                lastBlank = i;
            }
        }
        return groups;
    }
}
