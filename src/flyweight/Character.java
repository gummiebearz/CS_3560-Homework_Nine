package flyweight;

// Character itself that holds both intrinsic and extrinsic states
public class Character {
    char value; // extrinsic
    CharacterProperties properties; // intrinsic

    public Character(char value, CharacterProperties properties) {
        this.value = value;
        this.properties = properties;
    }

    public char getValue() {
        return this.value;
    }

    public String getFont() {
        return this.properties.getFont();
    }

    public int getSize() {
        return this.properties.getSize();
    }

    public String getColor() {
        return this.properties.getColor();
    }
}