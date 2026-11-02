package flyweight;

// Intrinsic (shared) states
public class CharacterProperties {
    private final String font;
    private final int size;
    private final String color;

    public CharacterProperties(String font, int size, String color) {
        this.font = font;
        this.size = size;
        this.color = color;
    }

    public String getFont() {
        return this.font;
    }

    public int getSize() {
        return this.size;
    }

    public String getColor() {
        return this.color;
    }
}
