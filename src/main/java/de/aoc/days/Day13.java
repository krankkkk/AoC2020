package de.aoc.days;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;
import java.util.function.Predicate;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class Day13 extends AbstractDay {

    @Override
    public long part1(Stream<String> stream) {
        final List<String> input = stream.toList();
        final double startTime = Double.parseDouble(input.get(0));

        Optional<Integer> first = Arrays.stream(input.get(1).split(","))
                .filter(Predicate.not("x"::equals))
                .map(Integer::parseInt)
                .min((o1, o2) -> (int) (getTimeLeft(startTime, o1) - getTimeLeft(startTime, o2)));


        int id = first.orElseThrow();
        return (long) (getTimeLeft(startTime, id) * id);
    }

    private double getTimeLeft(double startTime, Integer o1) {
        return (Math.floor(startTime / o1) + 1) * o1 - startTime;
    }

    @Override
    public long part2(Stream<String> stream) {
        String input = stream.skip(1)
                .findFirst()
                .orElseThrow();

        String[] split = input.split(",");
        final List<Bus> busses = IntStream.range(0, split.length)
                .filter(i -> !"x".equals(split[i]))
                .mapToObj(i -> new Bus(Integer.parseInt(split[i]), i))
                .toList();

        Bus first = busses.get(0);

        long startpoint = 100000000000000L; //actual Input
        //long startpoint = 0L; //debug Input
        AtomicLong aLong = new AtomicLong((long) Math.ceil(startpoint % first.id));
        return LongStream.iterate(aLong.getAndIncrement() * first.id, i -> aLong.getAndIncrement() * first.id)
                .parallel()
                .filter(i -> isCorrectTime(busses, i))
                .findFirst()
                .orElseThrow();
    }

    private boolean isCorrectTime(final Collection<Bus> busses, final long timestamp) {
        return busses.stream()
                .skip(1)
                .allMatch(b -> (timestamp + b.index) % b.id == 0);
    }

    private record Bus(int id, int index) {
    }
}
