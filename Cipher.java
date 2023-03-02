public class Cipher {
    private String[][] letterBlock;
    private int numRows;
    private int numCols; 

    public Cipher (String[][] letterBlock) {
        this.letterBlock = letterBlock;
        this.numRows = letterBlock.length;
        this.numCols = letterBlock[0].length;
    }

    private void fillBlock(String str) {
        if (str.length() == 0) {
            for (int i = 0; i < this.letterBlock.length; i++) {
                for (int j = 0; j < this.letterBlock[i].length; j++) {
                    this.letterBlock[i][j] = "A";
                }
            }
        } else {
            String[] phrase = str.split("");
            int counter = 0;
            for (int i = 0; i < this.letterBlock.length; i++) {
                for (int j = 0; j < this.letterBlock[i].length; j++) {
                    if (counter < phrase.length) {
                        this.letterBlock[i][j] = phrase[counter];
                        counter++;
                    } else {
                        this.letterBlock[i][j] = "A";
                    }
                }
            }
        }
    }

    public String encryptMessage(String message) {
        String finalMsg = "";
        int space = this.numRows * this.numCols;
        if (message.length() == 0) {
            return "";
        } else if (message.length() <= space) {
            fillBlock(message);
            finalMsg = encryptBlock();
        } else {
            String msg = message;
            while (msg.length() != 0) {
                fillBlock(msg);
                finalMsg += encryptBlock();
                if (msg.length() < space) {
                    space = msg.length();
                }
                msg = msg.substring(space);
            }
        }

        return finalMsg;
    }

    public static void main(String[] args) {
        String[][] block = new String[2][2];
        Cipher message = new Cipher(block);
        message.fillBlock("hello");
    }
}