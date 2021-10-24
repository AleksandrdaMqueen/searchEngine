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

            for (int i = figure.length - 1; i >= 0; i--) {
                for (int j = 0; j < figure.length; j++) {
                    if (i == figure.length - j - 1) {
                        figure[i][j] = 'X';
                    }
                }
            }
        }
        return figure;
    }
}
