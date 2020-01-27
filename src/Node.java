public class Node {

    private int value;
    private int parentIndex;

    public Node(int value, int parentIndex) {
        this.value = value;
        this.parentIndex = parentIndex;
    }

    public int getValue() {
        return value;
    }

    public int getParentIndex() {
        return parentIndex;
    }

    @Override
    public String toString() {
        return "node "+ value+ " Parent "+ parentIndex;
    }
}
