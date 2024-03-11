
public class Program {

    public static void main(String[] args) {
        // Test your method here
        int[][] matrix = {
            {3, 2, 7, 6},
            {2, 4, 1, 0},
            {3, 2, 1, 0}
        };

        System.out.println(arrayAsString(matrix));
    }

    public static String arrayAsString(int[][] array) {
        StringBuilder numbers = new StringBuilder();
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                numbers.append(array[i][j]);
                
            }
            // Add a newline after each row except for the last one
            if (i < array.length - 1) {
                numbers.append("\n");
            }
        }
        return numbers.toString();
    }
}
