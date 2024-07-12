public class Result {

    public static String encodeText(String text) {
        // Step 1: Reverse each word along with trailing and succeeding special characters
        String[] words = text.split(" ");
        StringBuilder reversedSentence = new StringBuilder();
        for (String word : words) {
            reversedSentence.append(new StringBuilder(word).reverse().toString()).append(" ");
        }
        reversedSentence.setLength(reversedSentence.length() - 1);  // Remove trailing space

        // Step 2, 3, and 4: Process the sentence according to character positions
        StringBuilder encodedSentence = new StringBuilder();
        for (int i = 0; i < reversedSentence.length(); i++) {
            char charAtI = reversedSentence.charAt(i);
            
            if (charAtI == ' ') {
                // Replace whitespaces with "#" if in even position, "*" if in odd position
                if (i % 2 == 0) {
                    encodedSentence.append('#');
                } else {
                    encodedSentence.append('*');
                }
            } else {
                // Convert character to uppercase if in even position, lowercase if in odd position
                if (i % 2 == 0) {
                    charAtI = Character.toUpperCase(charAtI);
                } else {
                    charAtI = Character.toLowerCase(charAtI);
                }
                
                // Step 4: Replace character with "@" if in even position, ":" if in odd position
                if (i % 2 == 0) {
                    encodedSentence.append('@');
                } else {
                    encodedSentence.append(':');
                }
            }
        }

        return encodedSentence.toString();
    }

    public static void main(String[] args) {
        String input = "The mangy, scrawny stray dog hurriedly gobbled down the grain-free, organic dog food.";
        System.out.println(encodeText(input));
    }
}
