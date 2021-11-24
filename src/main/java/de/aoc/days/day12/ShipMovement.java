package de.aoc.days.day12;

import java.util.Arrays;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Function;
import java.util.stream.Collectors;

enum ShipMovement {
    NORTH(Ship::moveNorth),
    EAST(Ship::moveEast),
    SOUTH(Ship::moveSouth),
    WEST(Ship::moveWest),
    LEFT(Ship::moveLeft),
    RIGHT(Ship::moveRight),
    FORWARD(Ship::moveForward);

    static ShipMovement forDirection(final int dir) {
        if (dir == 0) {
            return NORTH;
        } else if (dir == 90) {
            return EAST;
        } else if (dir == 180) {
            return SOUTH;
        } else if (dir == 270) {
            return WEST;
        }

        throw new IllegalArgumentException("Shit, doesn't line up " + dir);
    }


    static ShipMovement forShortHand(final char sh) {
        return fastMap.get(sh);
    }

    private static final Map<Character, ShipMovement> fastMap = Arrays.stream(values())
            .collect(Collectors.toMap(d -> d.name().charAt(0), Function.identity()));

    private final BiConsumer<Ship, Integer> mover;

    ShipMovement(final BiConsumer<Ship, Integer> mover) {
        this.mover = mover;
    }

    void move(final Ship ship, final int moves) {
        this.mover.accept(ship, moves);
    }
}
