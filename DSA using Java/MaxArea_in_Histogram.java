import java.util.Stack;

public class MaxArea_in_Histogram {
    int[] barHeight = {2, 1, 5, 6, 2, 3};
    int[] leftSmallArr = new int[barHeight.length];
    int[] rightSmallArr = new int[barHeight.length];
    int[] maxAreaHistoArr = new int[barHeight.length];
    int max = Integer.MIN_VALUE;

    void leftSmaller() {
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        leftSmallArr[0] = -1;
        for (int i = 1; i < barHeight.length; i++) {
            while (!stack.isEmpty() && barHeight[stack.peek()] >= barHeight[i]) {
                stack.pop();
            }
            if (stack.isEmpty()) {
                leftSmallArr[i] = -1;
            } else {
                leftSmallArr[i] = stack.peek();
            }

            stack.push(i);
        }
    }

    void rightSmaller() {
        Stack<Integer> stack = new Stack<>();

        for (int i = barHeight.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && barHeight[i] <= barHeight[stack.peek()]) {
                stack.pop();
            }
            if (stack.isEmpty()) {
                rightSmallArr[i] = barHeight.length;
            } else {
                rightSmallArr[i] = stack.peek();
            }
            stack.push(i);
        }
    }

    void findHistogram() {
        for (int i = 0; i < barHeight.length; i++) {
            int areaOfHisto = (barHeight[i] * (rightSmallArr[i] - leftSmallArr[i] - 1));
            maxAreaHistoArr[i] = areaOfHisto;
            max = Math.max(max, areaOfHisto);
        }
    }

    static void main(String[] args) {
        MaxArea_in_Histogram obj = new MaxArea_in_Histogram();
        obj.leftSmaller();
        obj.rightSmaller();
        obj.findHistogram();

        System.out.println("Left Smaller");
        for (int i = 0; i < obj.leftSmallArr.length; i++) {
            System.out.print(obj.leftSmallArr[i] + " ");
        }

        System.out.println("\nRight smaller");
        for (int i = 0; i < obj.rightSmallArr.length; i++) {
            System.out.print(obj.rightSmallArr[i] + " ");
        }

        System.out.println("\nArea of Histogram");
        for (int i = 0; i < obj.maxAreaHistoArr.length; i++) {
            System.out.print(obj.maxAreaHistoArr[i] + " ");
        }
        System.out.println("\nMaxArea of Histogram = " + obj.max);

    }
}
