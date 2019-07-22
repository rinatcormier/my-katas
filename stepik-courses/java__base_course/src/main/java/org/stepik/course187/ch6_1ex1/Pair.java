package org.stepik.course187.ch6_1ex1;

class Pair<T, S> {

    private T first;
    private S second;

    private Pair(T first, S second) {
        this.first = first;
        this.second = second;
    }

    static <T, S> Pair<T, S> of(T first, S second) {
        return new Pair<>(first, second);
    }

    T getFirst() {
        return first;
    }

    S getSecond() {
        return second;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Pair<?, ?> pair = (Pair<?, ?>) o;
        return java.util.Objects.equals(first, pair.first) &&
                java.util.Objects.equals(second, pair.second);
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(first, second);
    }
}
