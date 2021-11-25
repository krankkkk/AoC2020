package de.aoc.days.day5;

import de.aoc.days.AbstractDay;
import de.aoc.utils.ArrayUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

/**
 * Benchmark             Mode  Cnt   Score   Error  Units
 * Day5.benchmarkPart2   avgt   15  53,164 ± 3,317  us/op
 * Day5.benchmarkPart22  avgt   15  68,392 ± 1,662  us/op
 */
public class Day5 extends AbstractDay {

    @Override
    public long part1(final Stream<String> stream) {
        return part1(stream.toList());
    }

    private static long part1(List<String> input) {
        long max = 0;

        for (final String line : input) {
            final long id = getId(line);

            if (id > max) {
                max = id;
            }
        }

        return max;
    }

    @Override
    public long part2(final Stream<String> stream) {
        return part2(stream.toList());
    }

    private static long part2(List<String> input) {
        final Map<Long, Boolean> seats = new HashMap<>(input.size());

        for (final String line : input) {
            seats.put(getId(line), Boolean.TRUE);
        }

        for (final Long lower : seats.keySet()) {
            if (seats.get(lower + 1) == null && seats.get(lower + 2) != null) {
                return lower + 1;
            }
        }

        return -1L;
    }

    public static Long part22(final List<String> input) {
        final long[] arr = new long[input.size()];
        for (int i = 0; i < input.size(); i++) {
            arr[i] = getId(input.get(i));
        }
        ArrayUtils.quickSort(arr, 0, arr.length - 1);

        for (int i = 0; i < arr.length - 1; i++) {
            final long current = arr[i];
            final long next = arr[i + 1];

            if (current + 2 == next) {
                return current + 1;
            }
        }

        return -1L;
    }

    private static long getId(String line) {
        final char[] chars = line.toCharArray();

        for (int i = 0; i < 10; i++) {
            switch (chars[i]) {
                case 'F', 'L' -> chars[i] = '0';
                case 'B', 'R' -> chars[i] = '1';
            }
        }
        return Integer.parseInt(new String(chars), 2);
    }

}
