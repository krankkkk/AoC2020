package de.aoc.days.day12;

import de.aoc.days.AbstractDay;

import java.util.stream.Stream;

public class Day12 extends AbstractDay {

    /*
    636
     */
    @Override
    public long part1(final Stream<String> input) {
        final Ship ship = new Ship();

        input.forEach(line -> ShipMovement.forShortHand(line.charAt(0))
                .move(ship, Integer.parseInt(line.substring(1))));

        return Math.abs(ship.getxPos()) + Math.abs(ship.getyPos());
    }

    /*
    26841
     */
    @Override
    public long part2(final Stream<String> input) {
        final Ship2 ship = new Ship2();

        input.forEach(line -> WaypointMovement.forShortHand(line.charAt(0))
                .move(ship, Integer.parseInt(line.substring(1))));

        return (long) (Math.abs(ship.getxPos()) + Math.abs(ship.getyPos()));
    }
}
