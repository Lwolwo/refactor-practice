package com.twu.refactoring;

import java.util.*;

public class Direction {
    private final char direction;

    private static final Map<Character, List<Direction>> turnMap = new HashMap<Character, List<Direction>>() {{
        put('N', Arrays.asList(new Direction('W'), new Direction('E')));
        put('S', Arrays.asList(new Direction('E'), new Direction('W')));
        put('E', Arrays.asList(new Direction('N'), new Direction('S')));
        put('W', Arrays.asList(new Direction('S'), new Direction('N')));
    }};


    public Direction(char direction) {
        this.direction = direction;
    }

    public Direction turnRight() {
        if (!turnMap.containsKey(direction))
            throw new IllegalArgumentException();

        return turnMap.get(direction).get(1);
    }

    public Direction turnLeft() {
        if (!turnMap.containsKey(direction))
            throw new IllegalArgumentException();

        return turnMap.get(direction).get(0);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Direction direction1 = (Direction) o;

        if (direction != direction1.direction) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return (int) direction;
    }

    @Override
    public String toString() {
        return "Direction{direction=" + direction + '}';
    }
}
