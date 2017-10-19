package labone;

/**
 * Java Doc.
 */
public final class GenerateNewText {
    /**
     * Java Doc.
     */
    private GenerateNewText() {
    }

    /**
     * Java Doc.
     *
     * @param inputText 1
     * @return 1
     */
    public static String newtext(final String inputText) {
        // 根据桥接词补充文本
        String newText = "";
        final int length = 1000;
        String[] textWord = new String[length];
        textWord = inputText.split(" ");

        newText += textWord[0];
        int textlen = textWord.length;

        for (int i = 0; i < textlen - 1; i++) {
            String word1 = textWord[i];
            String word2 = textWord[i + 1];

            String bridgeword = QueryBridgeWords.getBridgeWords(word1, word2);
            String[] firstword = QueryBridgeWords.getbridgeword(bridgeword);
            int randomnum = (int) (Math.random() * firstword.length);
            if (firstword[randomnum].length() == 0) {
                newText = newText + " " + word2;
            } else {
                newText = newText + " " + firstword[randomnum] + " " + word2;
            }
        }

        return newText;
    }

}
