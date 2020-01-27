import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class BunnyHop {

    public static void main(String[] args) {
        int numberOfNode = 9;
        int[] parentNodes = new int[]{-1, 0, 0, 1, 1, 3, 3, 6, 2};
        int[] startPoint = new int[]{7, 8, 7, 4, 4, 5};
        int[] jumpLeg = new int[]{2, 1, 1, 1, 0, 2};
        int[] answer = new int[startPoint.length];

        Map<Integer, Node> nodesMap = new HashMap<>();

        for (int i = 0; i < numberOfNode; i++) {
            Node n = new Node(i, parentNodes[i]);
            nodesMap.put(i, n);
        }

        // loop on the start point array
        for (int i = 0; i < startPoint.length; i++) {
            Node n = nodesMap.get(startPoint[i]);
            // if node exist in the array
            if (n != null) {
                int lastParentIndex = n.getParentIndex();
                int lastNodeValue = n.getValue();
                int jumpLength = jumpLeg[i];
                int jumpTimes = 0;

                // if jump length is <1 then you shouldn't add anything to the answer
                if (jumpLength > 0) {
                    while (n.getParentIndex() != -1) {

                        //add  the first node value to the answer array
                        if (n.getValue() == lastNodeValue && n.getParentIndex() == lastParentIndex) {
                            answer[i] += n.getValue();
                        } else {

                            if (n.getValue() == lastParentIndex) {
                                jumpTimes += 1;
                                lastNodeValue = n.getValue();
                                lastParentIndex = n.getParentIndex();
                            }

                            //check if the jump times is equal to jump leg
                            if (jumpTimes == jumpLength) {
                                answer[i] += n.getValue();
                                jumpTimes = 0;
                            }
                        }

                        n = nodesMap.get(n.getValue() - 1);
                    }
                }
            }
        }

        //print answers
        System.out.println(Arrays.toString(answer));
    }
}
