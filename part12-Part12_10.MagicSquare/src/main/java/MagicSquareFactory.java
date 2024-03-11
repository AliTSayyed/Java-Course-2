
public class MagicSquareFactory {

    public MagicSquare createMagicSquare(int sideLength) {
         MagicSquare square = new MagicSquare(sideLength);
         
        if (sideLength % 2 == 0) {
            throw new IllegalArgumentException("Side length must be an odd integer.");
        }

        int[][] magicSquare = new int[sideLength][sideLength];

        int maxNum = sideLength * sideLength;
        int num = 1;
        int row = 0;
        int col = sideLength / 2;

        while (num <= maxNum) {
            magicSquare[row][col] = num;
            num++;

            int nextRow = (row - 1 + sideLength) % sideLength;
            int nextCol = (col + 1) % sideLength;

            if (magicSquare[nextRow][nextCol] != 0) {
                row = (row + 1) % sideLength;
            } else {
                row = nextRow;
                col = nextCol;
            }
        }

        square.setSquare(magicSquare);

        return square;
    }
}
