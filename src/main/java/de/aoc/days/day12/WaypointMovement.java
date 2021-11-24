package de.aoc.days.day12;

import java.util.Arrays;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Function;
import java.util.stream.Collectors;

enum WaypointMovement {
    NORTH(Ship2::moveNorth),
    EAST(Ship2::moveEast),
    SOUTH(Ship2::moveSouth),
    WEST(Ship2::moveWest),
    LEFT(Ship2::moveLeft),
    RIGHT(Ship2::moveRight),
    FORWARD(Ship2::moveForward);


    static WaypointMovement forShortHand(final char sh) {
        return fastMap.get(sh);
    }

    private static final Map<Character, WaypointMovement> fastMap = Arrays.stream(values())
            .collect(Collectors.toMap(d -> d.name().charAt(0), Function.identity()));

    private final BiConsumer<Ship2, Integer> mover;

    WaypointMovement(final BiConsumer<Ship2, Integer> mover) {
        this.mover = mover;
    }

    void move(final Ship2 ship, final int moves) {
        this.mover.accept(ship, moves);
    }
}
