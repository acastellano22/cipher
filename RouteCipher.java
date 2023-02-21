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

        for (int i = 0; i < letterBlock.length; i++) {
            for (int j = 0; j < letterBlock[i].length; j++) {
                System.out.println(letterBlock[i][j]);
            }
        }
    }

    public static String encryptMessage(String message) {
        String phrase = message.substring(0, numRows * numCols);
        String[] arr = phrase.split("");
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
        return null;
    }

    public static void main(String[] args) {
        String[][] letterBlock = new String[3][5];
        RouteCipher cipher = new RouteCipher(letterBlock);
        encryptMessage("hola");
    }
}