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
        String encryptedMsg = "";
        String msg = message.substring(0);
        int endIndex = msg.length() - 1;
        System.out.println(endIndex);
        int space = numRows * numCols;

        if (message.length() == 0) {
            return "";
        } else if (msg.length() <= space) {
            fillBlock(msg);
            // encryptedMsg = encryptBlock();
        } else {
            while (endIndex != -1) {

            }
        }

        return encryptedMsg;
    }

    public static void main(String[] args) {
        String[][] letterBlock = new String[2][3];
        RouteCipher cipher = new RouteCipher(letterBlock);

        System.out.println(encryptMessage("andrew"));
    }
}