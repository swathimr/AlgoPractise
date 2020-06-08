package Array;

/**
 * time O(n) and space O(1)
 * two pointer
 * Move from left and right and calc max area
 * max area = max(maxarea, min(height[l], height[r])*(r-l))
 */
public class ContainerWithMostWater {

    public int maxArea(int[] height) {
        int maxArea = 0; int l = 0, r = height.length -1;
        while(l<r) {
            maxArea = Math.max(maxArea, Math.min(height[l], height[r])*(r-l));
            if(height[l] < height[r])
                l++;
            else
                r--;
        }
        return maxArea;
    }

}
