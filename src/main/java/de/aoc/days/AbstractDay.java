package de.aoc.days;

import java.io.IOException;
import java.io.UncheckedIOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Stream;

public abstract class AbstractDay implements Day {

    @Override
    public Stream<String> getDebugInput() {
        return getInput(0);
    }

    @Override
    public Stream<String> getActualInput() {
        return getInput(1);
    }

    @Override
    public long part1() {
        return part1(getActualInput());
    }


    @Override
    public long part2() {
        return part2(getActualInput());
    }

    private Stream<String> getInput(final int part) {
        try {
            final URI toSrc = getClass().getResource("/%s-%d.txt".formatted(getClass().getSimpleName(), part)).toURI();
            return Files.lines(Path.of(toSrc));
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        } catch (URISyntaxException e) {
            throw new IllegalStateException(e);
        }
    }
}