package flyweight;

public class Tester {
    public static void main(String[] args) {
        String text = "HelloWorldCS3560";

        Document document =  new Document();

        // Build document with 4 different styles
        for(int i = 0; i < text.length(); ++i) {
            char c = text.charAt(i);

            if (i < 5) {
                // Hello
                document.addCharacter(c, "Arial", 12, "Red");
            } else if (i < 10) {
                // World
                document.addCharacter(c, "Calibri", 14, "Blue");
            } else if (i < 12) {
                // CS
                document.addCharacter(c, "Verdana", 16, "Black");
            } else {
                // 3560
                document.addCharacter(c, "Arial", 16, "Blue");
            }
        }

        System.out.println("Original text: " + document.getText());
        document.display();
        System.out.println("Number of unique character properties: " + PropertiesFactory.getPoolSize());

        // Save to HelloWorldCS3560.txt
        document.save("./src/flyweight/" + text);

        // Load into a brand new document
        Document loaded = new Document();
        loaded.load("./src/flyweight/" + text);

        System.out.println();
        System.out.println("Loaded text: " + loaded.getText());
        loaded.display();
        System.out.println("Number of unique character properties after load: " + PropertiesFactory.getPoolSize());
        System.out.println("Texts match: " + document.getText().equals(loaded.getText()));
    }
}
