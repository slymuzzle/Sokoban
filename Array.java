public class Array {
    public static  int[][] createDesktop(String value) {
    int row = 0;

    for(int i = 0; i < value.length(); i++) {

        char symbol = value.charAt(i);

        if(symbol == '\n') {

            row = row + 1;

        }

    }

    int[][] newDesktop = new int[row][];

    int columns = 0;
    int index = 0;

    for(int i = 0; i < value.length(); i++) {
        char symbol = value.charAt(i);
        if(symbol == '\n') {
            newDesktop[index] = new int[columns];
            columns = 0;
            index++;
            continue;
        }
        columns = columns + 1;
    }

    int x = 0;
    int y = 0;


    for(int i = 0; i < value.length(); i++) {
        char symbol = value.charAt(i);
        if(symbol == '\n') {
            y = y + 1;
            x = 0;

            continue;
        }

        int element = Integer.parseInt("" + symbol);
        newDesktop[y][x] = element;
        x = x + 1;
    }

    return newDesktop;
    }
}