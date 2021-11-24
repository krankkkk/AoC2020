package de.aoc.days.day12;

class Ship2 {

    final Waypoint waypoint = new Waypoint(10, 1);
    private double xPos = 0;
    private double yPos = 0;

    double getxPos() {
        return xPos;
    }

    double getyPos() {
        return yPos;
    }

    void moveForward(final int steps) {
        this.xPos = xPos + this.waypoint.getxPos() * steps;
        this.yPos = yPos + this.waypoint.getyPos() * steps;
    }

    void moveLeft(final int degrees) {
        final int turns = Math.abs(degrees / 90);

        for (int i = 0; i < turns; i++) {
            this.waypoint.turnLeft();
        }
    }

    void moveRight(final int degrees) {
        final int turns = degrees / 90;

        for (int i = 0; i < turns; i++) {
            this.waypoint.turnRight();
        }
    }

    void moveNorth(final int steps) {
        this.waypoint.setyPos(this.waypoint.getyPos() + steps);
    }

    void moveEast(final int steps) {
        this.waypoint.setxPos(this.waypoint.getxPos() + steps);
    }

    void moveSouth(final int steps) {
        this.waypoint.setyPos(this.waypoint.getyPos() - steps);
    }

    void moveWest(final int steps) {
        this.waypoint.setxPos((this.waypoint.getxPos() - steps));
    }

    @Override
    public String toString() {
        return "Ship2{" +
                "waypoint=" + waypoint +
                ", xPos=" + xPos +
                ", yPos=" + yPos +
                '}';
    }
}
