import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;


/**
 * LeetCode 223. Rectangle Area
 * https://leetcode.com/problems/rectangle-area/
 */
public class RectangleArea {


    /**
     * Given the coordinates of two rectilinear rectangles in a 2D plane,
     * return the total area covered by the two rectangles.
     * 
     * Execution: O(1) - Space: O(1)
     * 
     * Runtime: 2 ms, faster than 100.00% of Java online submissions.
     * Memory Usage: 38.1 MB, less than 92.38% of Java online submissions.
     * 
     * 3080 / 3080 test cases passed.
     * Status: Accepted
     * Runtime: 2 ms
     * Memory Usage: 38.6 MB
     */
    static public int computeArea0(int ax1, int ay1, int ax2, int ay2, int bx1, int by1, int bx2, int by2) {
        
        // **** initialization ****
        int area1   = Math.abs(ax2 - ax1) * Math.abs(ay2 - ay1);
        int area2   = Math.abs(bx2 - bx1) * Math.abs(by2 - by1);
        int overlap = 0;

        // ???? ????
        System.out.println("<<< area1: " + area1);
        System.out.println("<<< area2: " + area2);

        // **** check if rectangles are one above the other (do NOT overlap) ****
        if (ay1 >= by2 || by1 >= ay2)
            return area1 + area2;

        // ***** check if rectangles are side by side (do NOT overlap) ****
        if (ax2 <= bx1 || bx2 <= ax1)
            return area1 + area2;

        // **** compute overlap ****
        overlap =   Math.max(Math.min(ax2, bx2) - Math.max(ax1, bx1), 0) *
                    Math.max(Math.min(ay2, by2) - Math.max(ay1, by1), 0);

        // ???? ????
        System.out.println("<<< overlap: " + overlap);

        // **** return area ****
        return area1 + area2 - overlap;
    }


    /**
     * Given the coordinates of two rectilinear rectangles in a 2D plane,
     * return the total area covered by the two rectangles.
     * 
     * Execution: O(1) - Space: O(1)
     * 
     * Runtime: 2 ms, faster than 100.00% of Java online submissions.
     * Memory Usage: 38.1 MB, less than 84.60% of Java online submissions.
     * 
     * 3080 / 3080 test cases passed.
     * Status: Accepted
     * Runtime: 2 ms
     * Memory Usage: 38.1 MB
     */
    static public int computeArea1(int ax1, int ay1, int ax2, int ay2, int bx1, int by1, int bx2, int by2) {
        
        // **** initialization ****        
        int area1   = (ax2 - ax1) * (ay2 - ay1);
        int area2   = (bx2 - bx1) * (by2 - by1);
        
        // **** rectangles do not overlap ****
        if ((ay1 >= by2 || by1 >= ay2) ||
            (ax2 <= bx1 || bx2 <= ax1))
            return area1 + area2;

        // **** rectangles overlap ****
        return area1 + area2 - 
                    Math.max(Math.min(ax2, bx2) - Math.max(ax1, bx1), 0) *
                    Math.max(Math.min(ay2, by2) - Math.max(ay1, by1), 0);
    }






    /**
     * Given the coordinates of two rectilinear rectangles in a 2D plane,
     * return the total area covered by the two rectangles.
     * 
     * Execution: O(1) - Space: O(1)
     * 
     */
    static public int computeArea(int ax1, int ay1, int ax2, int ay2, int bx1, int by1, int bx2, int by2) {
        
        // **** initialization ****        
        int area1   = (ax2 - ax1) * (ay2 - ay1);
        int area2   = (bx2 - bx1) * (by2 - by1);
        
        // **** rectangles do not overlap ****
        if ((ay1 >= by2 || by1 >= ay2) ||
            (ax2 <= bx1 || bx2 <= ax1))
            return area1 + area2;

        // **** rectangles overlap ****
        return area1 + area2 - 
                    max(min(ax2, bx2) - max(ax1, bx1), 0) *
                    max(min(ay2, by2) - max(ay1, by1), 0);
    }


    /**
     * Auxiliary function to compute max.
     */
    static private int max(int a, int b) {
        if (a >= b) return a;
        return b;
    }


    /**
     * Auxiliary function to compute min.
     */
    static private int min(int a, int b) {
        if (a <= b) return a;
        return b;
    }


    /**
     * Test scaffold.
     * !!! NOT PART OF SOLUTION !!!
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        
        // **** open buffered reader ****
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // **** read coordinates for first rectangle ****
        int[] r1 = Arrays.stream(br.readLine().trim().split(","))
                        .mapToInt(Integer::parseInt)
                        .toArray();

        // **** read coordinates for second rectangle ****
        int[] r2 = Arrays.stream(br.readLine().trim().split(","))
                        .mapToInt(Integer::parseInt)
                        .toArray();

        // **** close buffered reader ****
        br.close();

        // ???? ????
        System.out.println("main <<< r1: " + Arrays.toString(r1));
        System.out.println("main <<< r2: " + Arrays.toString(r2));

        // **** call function of interest and display result ****
        System.out.println("main <<< computeArea0: " + computeArea0(r1[0], r1[1], r1[2], r1[3], r2[0], r2[1], r2[2], r2[3]));

        // **** call function of interest and display result ****
        System.out.println("main <<< computeArea0: " + computeArea1(r1[0], r1[1], r1[2], r1[3], r2[0], r2[1], r2[2], r2[3]));

        // **** call function of interest and display result ****
        System.out.println("main <<<  computeArea: " + computeArea(r1[0], r1[1], r1[2], r1[3], r2[0], r2[1], r2[2], r2[3]));
    }

}