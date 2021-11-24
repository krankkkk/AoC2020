package de.aoc.utils;

public final class MathUtils {

    public static int checkDegrees(final int newDegree) {
        if (newDegree < 0) {
            return newDegree + 360;
        } else if (newDegree >= 360) {
            return newDegree - 360;
        }
        return newDegree;
    }


    private MathUtils() {
    }
}
