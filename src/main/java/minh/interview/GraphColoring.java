package minh.interview;

import java.util.*;

public class GraphColoring {

    public static void main(String[] args) {
        GraphColoring gc = new GraphColoring();
        gc.test();
    }

    public void test() {
        GraphNode a = new GraphNode("a");
        GraphNode b = new GraphNode("b");
        GraphNode c = new GraphNode("c");

        a.addNeighbor(b);
        b.addNeighbor(a);
        b.addNeighbor(c);
        c.addNeighbor(b);

        List<GraphNode> graph = Arrays.asList(a, b, c);

        Set<String> colors = new HashSet<>();
        colors.add("blue");
        colors.add("yellow");
        colors.add("red");

        coloring(graph, colors);
    }

    private void coloring(List<GraphNode> graph, Set<String> colors) {
        graph.forEach(node -> {
            Set<String> illegalColors = new HashSet<>();
            System.out.print("node " + node.getLabel());

            // get color of neighbors
            node.getNeighbors().forEach(nb -> {
                if (nb.color.isPresent()) {
                    illegalColors.add(nb.getColor());
                }
            });

            // set color for this node
            for (String color : colors) {
                if (!illegalColors.contains(color)) {
                    node.setColor(color);
                    break;
                }
            }
            System.out.println(" color " + node.getColor());
        });
    }

    public class GraphNode {
        private String label;
        private Set<GraphNode> neighbors;
        private Optional<String> color;

        public GraphNode(String label) {
            this.label = label;
            neighbors = new HashSet<GraphNode>();
            color = Optional.empty();
        }

        public String getLabel() {
            return label;
        }

        public Set<GraphNode> getNeighbors() {
            return Collections.unmodifiableSet(neighbors);
        }

        public void addNeighbor(GraphNode neighbor) {
            neighbors.add(neighbor);
        }

        public boolean hasColor() {
            return color.isPresent();
        }

        public String getColor() {
            return color.get();
        }

        public void setColor(String color) {
            this.color = Optional.ofNullable(color);
        }
    }
}
