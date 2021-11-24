package de.aoc.days.day12;

class Waypoint {

    private double xPos;
    private double yPos;

    public Waypoint(final double xPos, final double yPos) {
        this.xPos = xPos;
        this.yPos = yPos;
    }

    public double getxPos() {
        return xPos;
    }

    public void setxPos(final double xPos) {
        this.xPos = xPos;
    }

    public double getyPos() {
        return yPos;
    }

    public void setyPos(final double yPos) {
        this.yPos = yPos;
    }


    void turnRight() {
        final double x = this.xPos;
        this.xPos = this.yPos;
        this.yPos = -x;
    }

    void turnLeft() {
        final double x = this.xPos;
        this.xPos = -this.yPos;
        this.yPos = x;
    }

    @Override
    public String toString() {
        return "Waypoint{" +
                "xPos=" + xPos +
                ", yPos=" + yPos +
                '}';
    }
}
