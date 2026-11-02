package flyweight;

import java.util.ArrayList;
import java.util.List;

public class Document {
    private final List<TextCharacter> characters;

    public Document() {
        this.characters = new ArrayList<>();
    }

    public void addCharacter(char character, String font, int size, String color) {
        // Get flyweight (intrinsic data) from factory
        CharacterProperties characterProperties = PropertiesFactory.getCharacterProperties(font, size, color);

        // Add new character to the list
        this.characters.add(new TextCharacter(character, characterProperties));
    }

    // Style editing
    public void editCharacter(int index, String font, int size, String color) {
        // Get flyweight (intrinsic data) from factory
        CharacterProperties characterProperties = PropertiesFactory.getCharacterProperties(font, size, color);

        // Edit the character at given index
        this.characters.get(index).setProperties(characterProperties);
    }
}