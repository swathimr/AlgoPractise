package Matrix;

// same as number of islands  O(m*n) and space O(1)
public class FloodFill {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int color = image[sr][sc];
        if(color!=newColor) {
            fill(image, sr, sc, color, newColor);
        }
        return image;
    }

    private void fill(int[][] image, int sr, int sc, int color, int newColor) {
        if(sr < 0 || sr >= image.length || sc <0 || sc >= image[0].length || image[sr][sc]!=color)
            return;

        image[sr][sc] = newColor;
        fill(image, sr-1, sc, color, newColor);
        fill(image, sr+1, sc, color, newColor);
        fill(image, sr, sc-1, color, newColor);
        fill(image, sr, sc+1, color, newColor);

    }
}
