package lab_1;

public class GenerateNewText {

    public static String newtext(String inputText) {
        // 根据桥接词补充文本
        String new_text = "";
        String text_word[] = new String[1000];
        text_word = inputText.split(" ");

        new_text += text_word[0];
        int textlen = text_word.length;

        for (int i = 0; i < textlen - 1; i++) {
            String word1 = text_word[i];
            String word2 = text_word[i + 1];

            String bridgeword = QueryBridgeWords.getBridgeWords(word1, word2);
            String firstword[] = QueryBridgeWords.getbridgeword(bridgeword);
            int randomnum = (int) (Math.random() * firstword.length);
            if (firstword[randomnum].length() == 0) {
                new_text = new_text + " " + word2;
            } else {
                new_text = new_text + " " + firstword[randomnum] + " " + word2;
            }
        }

        return new_text;
    }

}
