public class RouteCipher {
    private static String[][] letterBlock;
    private static int numRows;
    private static int numCols; 

    public RouteCipher (String[][] letterBlock) {
        this.letterBlock = letterBlock;
        this.numRows = letterBlock.length;
        this.numCols = letterBlock[0].length;
    }

    private static void fillBlock(String str) {
        String[] phrase = str.split("");
        int counter = 0;
        for (int i = 0; i < letterBlock.length; i++) {
            for (int j = 0; j < letterBlock[i].length; j++) {
                if (counter < phrase.length) {
                    letterBlock[i][j] = phrase[counter];
                    counter++;
                } else {
                    letterBlock[i][j] = "A";
                }
            }
        }
    }

    public static String encryptMessage(String message) {
        int counter = 0;
        String concatString = "";
        while (counter < message.length()) {
            String[][] block = new String[numRows][numCols];
            for (int i = 0; i < block.length; i++) {
                for (int j = 0; j < block[i].length; j++) {
                    if (counter < message.length()) {
                        block[i][j] = message.substring(counter, counter + 1);
                        counter++;
                    } else {
                        block[i][j] = "A";
                    }
                }
            }

            for (int i = 0; i < block.length; i++) {
                for (int j = 0; j < block[i].length; j++) {
                    concatString += block[i][j];
                }
            }
        }
        return concatString;
    }

    public static void main(String[] args) {
        String[][] letterBlock = new String[2][3];
        RouteCipher cipher = new RouteCipher(letterBlock);

        System.out.println(encryptMessage("hello world"));
    }
}