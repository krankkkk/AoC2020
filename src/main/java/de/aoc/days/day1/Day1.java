package de.aoc.days.day1;

import de.aoc.days.AbstractDay;
import de.aoc.utils.ArrayUtils;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

/**
 * # JMH version: 1.26
 * # VM version: JDK 15, OpenJDK 64-Bit Server VM, 15+36
 * <p>
 * Benchmark                    Mode  Cnt    Score    Error  Units
 * Day1.benchmarkDefaultSearch  avgt   50  611,385 ± 169,035  us/op <- all over the place from 600 to 20
 * Day1.benchmarkMapSearch      avgt    5  20,119 ± 0,475  us/op
 * Day1.benchmarkSortSearch     avgt    5   5,323 ± 0,027  us/op
 * Day1.benchmarkSortedSearch   avgt    5  38,586 ± 0,464  ns/op
 */
public class Day1 extends AbstractDay {
    private static long mapSearch(final Map<Long, String> input) {
        for (final long outer : input.keySet()) {
            for (final long middle : input.keySet()) {
                final long combo = outer + middle;
                if (combo > 2020) {
                    continue;
                }

                final long rest = 2020 - combo;

                if (input.get(rest) != null) {
                    return outer * middle * rest;
                }
            }
        }
        return -1;
    }

    private static long defaultSearch(final long[] input) {
        for (final long outer : input) {
            for (final long middle : input) {
                for (final long inner : input) {
                    if (outer + middle + inner == 2020) {
                        return outer * middle * inner;
                    }
                }
            }
        }
        return -1;
    }

    private static long sortSearch(final long[] sorted) {
        for (int i = 0; i < sorted.length; i++) {
            final long first = sorted[i];
            final long maxSecond = 2020 - first;
            final long location = Math.abs(Arrays.binarySearch(sorted, maxSecond));

            for (int j = i; j < location; j++) {
                final long second = sorted[j];

                final long rest = 2020 - first - second;
                final long locationLast = Math.abs(Arrays.binarySearch(sorted, rest));

                final long last = sorted[(int) locationLast];
                if (last == rest) {
                    return first * second * last;
                }
            }
        }
        return -1;
    }

    private static long miniSortSearch(long[] input) {
        for (final long aLong1 : input) {
            final long rest = 2020 - aLong1;
            final int index = Math.abs(Arrays.binarySearch(input, rest));
            if (input[index] == rest) {
                return rest * aLong1;
            }
        }
        return -1;
    }


    private static Map<Long, String> getMap(final List<String> input) {
        final Map<Long, String> temp = new HashMap<>(input.size());
        input.forEach(i -> temp.put(Long.parseLong(i), i));
        return temp;
    }

    private static long[] getArray(final List<String> input) {
        final int size = input.size();
        final long[] arr = new long[size];
        for (int i = 0; i < size; i++) {
            arr[i] = Long.parseLong(input.get(i));
        }
        return arr;
    }

    @Override
    public long part1(final Stream<String> stream) {
        final long[] array = stream.mapToLong(Long::parseLong).toArray();
        ArrayUtils.quickSort(array, 0, array.length - 1);
        return miniSortSearch(array);
    }

    @Override
    public long part2(Stream<String> stream) {
        final long[] array = stream.mapToLong(Long::parseLong).toArray();
        ArrayUtils.quickSort(array, 0, array.length - 1);
        return sortSearch(array);
    }
}
