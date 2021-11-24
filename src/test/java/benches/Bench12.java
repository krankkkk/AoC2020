package benches;

import de.aoc.days.Day;
import de.aoc.days.day12.Day12;
import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.infra.Blackhole;

import java.util.List;
import java.util.concurrent.TimeUnit;

@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.NANOSECONDS)
@State(Scope.Benchmark)
public class Bench12 {

    private final Day day = new Day12();
    private final List<String> input = day.getActualInput().toList();

    @Benchmark
    @Warmup(iterations = 1)
    @Fork(0)
    public void benchmarkPart1(Blackhole blackhole) {
        blackhole.consume(day.part1(input.stream()));
    }

    @Benchmark
    @Warmup(iterations = 1)
    @Fork(0)
    public void benchmarkPart2(Blackhole blackhole) {
        blackhole.consume(day.part2(input.stream()));
    }
}
