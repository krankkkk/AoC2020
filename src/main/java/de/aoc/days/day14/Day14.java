package de.aoc.days.day14;

import de.aoc.days.AbstractDay;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Day14 extends AbstractDay {
    @Override
    public long part1(final Stream<String> stream) {
        final List<String> input = stream.toList();
        String mask = "";

        final Map<Long, Long> memory = new HashMap<>(input.size());
        for (final String line : input) {
            String[] split = line.split("=");

            if (line.startsWith("mask")) {
                mask = split[1].trim();
            } else {
                long rawNumber = Long.parseLong(split[1].trim());
                memory.put(getMemoryLocation(split[0]), applyMask(mask, rawNumber));
            }
        }
        return memory.values()
                .stream()
                .mapToLong(Long::longValue)
                .sum();
    }

    private long getMemoryLocation(String memStr) {
        final int startLoc = memStr.indexOf('[');
        final int endLoc = memStr.indexOf(']');

        return Long.parseLong(memStr.substring(startLoc + 1, endLoc));
    }


    private long applyMask(String mask, long parsed) {
        char[] chars = mask.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            final long bit = 1L << (chars.length - i - 1);//We only want to affect that single bit
            if (chars[i] == '1') {
                parsed |= bit;
            } else if (chars[i] == '0') {
                parsed &= ~bit;
            }
        }

        return parsed;
    }


    @Override
    public long part2(final Stream<String> stream) {
        final List<String> input = stream.toList();
        String mask = "";

        final Map<Long, Long> memory = new HashMap<>(input.size());
        for (final String line : input) {
            String[] split = line.split("=");

            if (line.startsWith("mask")) {
                mask = split[1].trim();
            } else {
                long rawNumber = Long.parseLong(split[1].trim());
                for (final long memLoc : applyAddressMask(mask, getMemoryLocation(split[0]))) {
                    memory.put(memLoc, rawNumber);
                }
            }
        }
        return memory.values()
                .stream()
                .mapToLong(Long::longValue)
                .sum();
    }

    private static Set<Long> applyAddressMask(final String mask, final long memoryLocation) {
        final char[] chars = mask.toCharArray();
        Set<Long> memAddresses = new HashSet<>();
        memAddresses.add(memoryLocation);
        for (int i = 0; i < chars.length; i++) {
            final long bit = 1L << (chars.length - i - 1);
            if (chars[i] != '0') {
                memAddresses = memAddresses.stream()
                        .map(memLoc -> memLoc | bit)
                        .collect(Collectors.toSet());

                if (chars[i] == 'X') {
                    memAddresses.addAll(memAddresses.stream()
                            .map(memLoc -> memLoc & ~bit)
                            .toList());
                }
            }
        }

        return memAddresses;
    }
}
