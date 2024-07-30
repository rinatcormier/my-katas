package my.rinat.problems;

import my.rinat.problems.TraverseNodes.Node;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class TraverseNodesTest {

    @Test
    public void testRecursion() {
        Node a = new Node("a");
        Node b = new Node("b");
        Node c = new Node("c");
        Node d = new Node("d");
        Node e = new Node("e");
        Node f = new Node("f");
        a.children.add(b);
        a.children.add(c);
        c.children.add(d);
        c.children.add(e);
        c.children.add(f);
        List<Node> result = TraverseNodes.toFlatListRecursion(a);
        assertThat(result)
                .containsExactlyInAnyOrder(a, b, c, d, e, f);
    }

    @Test
    public void testLoop() {
        Node a = new Node("a");
        Node b = new Node("b");
        Node c = new Node("c");
        Node d = new Node("d");
        Node e = new Node("e");
        Node f = new Node("f");
        a.children.add(b);
        a.children.add(c);
        c.children.add(d);
        c.children.add(e);
        c.children.add(f);
        List<Node> result = TraverseNodes.toFlatListLoop(a);
        assertThat(result)
                .containsExactlyInAnyOrder(a, b, c, d, e, f);
    }

    @Test
    public void testCycledRecursion() {
        Node a = new Node("a");
        Node b = new Node("b");
        Node c = new Node("c");
        Node d = new Node("d");
        Node e = new Node("e");
        Node f = new Node("f");
        a.children.add(b);
        a.children.add(c);
        c.children.add(d);
        c.children.add(e);
        c.children.add(f);
        f.children.add(a);
        f.children.add(b);
        List<Node> result = TraverseNodes.toFlatListCycledRecursion(a, new HashSet<>());
        assertThat(result)
                .containsExactlyInAnyOrder(a, b, c, d, e, f);
    }

    @Test
    public void testCycledLoop() {
        Node a = new Node("a");
        Node b = new Node("b");
        Node c = new Node("c");
        Node d = new Node("d");
        Node e = new Node("e");
        Node f = new Node("f");
        a.children.add(b);
        a.children.add(c);
        c.children.add(d);
        c.children.add(e);
        c.children.add(f);
        f.children.add(a);
        f.children.add(b);
        List<Node> result = TraverseNodes.toFlatListCycledLoop(a);
        assertThat(result)
                .containsExactlyInAnyOrder(a, b, c, d, e, f);
    }
}
