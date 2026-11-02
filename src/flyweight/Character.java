package flyweight;

// Character object holds extrinsic state (value)
// and reference to intrinsic state
// CharacterProperties object holds the intrinsic data
public class Character {
    private final char value; // extrinsic
    private CharacterProperties properties; // reference to shared flyweight

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

    public CharacterProperties getProperties() {
        return this.properties;
    }

    public void setProperties(CharacterProperties properties) {
        this.properties = properties;
    }
}