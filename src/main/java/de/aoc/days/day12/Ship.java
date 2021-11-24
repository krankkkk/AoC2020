package de.aoc.days.day12;

import de.aoc.utils.MathUtils;

class Ship {

    //direction in degrees
    private int direction = 90;
    private int xPos = 0;
    private int yPos = 0;

    int getxPos() {
        return xPos;
    }

    int getyPos() {
        return yPos;
    }

    void moveForward(final int steps) {
        ShipMovement.forDirection(this.direction)
                .move(this, steps);
    }

    void moveLeft(final int degrees) {
        this.direction = MathUtils.checkDegrees(this.direction - degrees);
    }

    void moveRight(final int degrees) {
        this.direction = MathUtils.checkDegrees(this.direction + degrees);
    }

    void moveNorth(final int steps) {
        this.yPos = yPos + steps;
    }

    void moveEast(final int steps) {
        this.xPos = xPos + steps;
    }

    void moveSouth(final int steps) {
        this.yPos = yPos - steps;
    }

    void moveWest(final int steps) {
        this.xPos = xPos - steps;
    }

    @Override
    public String toString() {
        return "Ship{" +
                "direction=" + direction +
                ", xPos=" + xPos +
                ", yPos=" + yPos +
                '}';
    }
}
