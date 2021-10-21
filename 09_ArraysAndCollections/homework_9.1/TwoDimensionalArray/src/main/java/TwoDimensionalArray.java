public class TwoDimensionalArray {
    public static char[][] getTwoDimensionalArray(int size) {
        char[][] figure = new char[size][size];

        //TODO: Написать метод, который создаст двумерный массив char заданного размера.
        // массив должен содержать символ symbol по диагоналям, пример для size = 3
        // [X,  , X]
        // [ , X,  ]
        // [X,  , X]

        for (int x = 0; x < figure.length; x++) {
            for (int y = 0; y < figure.length; y++) {
                if (x == y) {
                    figure[x][y] = 'X';
                } else {
                    figure[x][y] = ' ';
                }
            }
        }
        for (int i = figure.length - 1; i > 0; i--) {
            for (int j = figure.length - 1; j > 0; j--) {
                if (i == j) {
                    figure[i][j] = 'X';
                } else {
                    figure[i][j] = ' ';
                }
            }
        }
        return figure;
    }
}
