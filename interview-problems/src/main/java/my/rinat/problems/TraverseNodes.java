package my.rinat.problems;

import java.util.*;

public class TraverseNodes {

    public static class Node {

        private final String name;
        public List<Node> children = new ArrayList<>();

        public Node(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return name;
        }
    }

    public static List<Node> toFlatListRecursion(Node root) {
        List<Node> result = new ArrayList<>();
        for (Node child : root.children) {
            result.addAll(toFlatListRecursion(child));
        }
        result.add(root);
        return result;
    }

    public static List<Node> toFlatListLoop(Node root) {
        final var result = new ArrayList<Node>();
        final var stack = new ArrayDeque<Node>();
        stack.push(root);
        while (!stack.isEmpty()) {
            final var current = stack.pop();
            for (Node child : current.children) {
                stack.push(child);
            }
            result.add(current);
        }
        return result;
    }

    public static List<Node> toFlatListCycledRecursion(Node root, Set<Node> visited) {
        final var result = new ArrayList<Node>();
        visited.add(root);
        result.add(root);
        for (Node child : root.children) {
            if (!visited.contains(child)) {
                result.addAll(toFlatListCycledRecursion(child, visited));
            }
        }
        return result;
    }

    public static List<Node> toFlatListCycledLoop(Node root) {
        final var result = new ArrayList<Node>();
        final var visited = new HashSet<Node>();
        final var stack = new ArrayDeque<Node>();
        stack.push(root);
        while (!stack.isEmpty()) {
            final var current = stack.pop();
            if (!visited.contains(current)) {
                result.add(current);
                visited.add(current);
            }
            for (Node child : current.children) {
                if (!visited.contains(child)) {
                    stack.push(child);
                }
            }
        }
        return result;
    }
}
