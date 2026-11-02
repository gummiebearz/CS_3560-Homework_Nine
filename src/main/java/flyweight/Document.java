package flyweight;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Document {
    private final List<TextCharacter> characters;

    public Document() {
        this.characters = new ArrayList<>();
    }

    public void addCharacter(char character, String font, int size, String color) {
        // Get main.flyweight (intrinsic data) from factory
        CharacterProperties characterProperties = PropertiesFactory.getCharacterProperties(font, size, color);

        // Add new character to the list
        this.characters.add(new TextCharacter(character, characterProperties));
    }

    // Style editing
    public void editCharacter(int index, String font, int size, String color) {
        // Get main.flyweight (intrinsic data) from factory
        CharacterProperties characterProperties = PropertiesFactory.getCharacterProperties(font, size, color);

        // Edit the character at given index
        this.characters.get(index).setProperties(characterProperties);
    }

    // Value and style editing
    public void editCharacter(int index, char character, String font, int size, String color) {
        // Get main.flyweight (intrinsic data) from factory
        CharacterProperties characterProperties = PropertiesFactory.getCharacterProperties(font, size, color);

        this.characters.set(index, new TextCharacter(character, characterProperties));
    }

    public void display() {
        for (TextCharacter character : this.characters) {
            System.out.println(character.getValue() + " [" + character.getFont() + ", " + character.getSize() + ", " + character.getColor() + "]");
        }
    }

    public String getText() {
        StringBuilder text = new StringBuilder();
        for (TextCharacter character : this.characters) {
            text.append(character.getValue());
        }

        return text.toString();
    }

    public void save(String filename) {
        try (FileWriter fileWriter = new FileWriter(filename + ".txt")) {
            for (TextCharacter c : characters) {
                fileWriter.write((int) c.getValue() + "|" + c.getFont() + "|" + c.getSize() + "|" + c.getColor() + "\n");
            }
        } catch(IOException e) {
            System.err.println("Error writing to file " + filename + ".txt");
            e.printStackTrace();
        }
    }

    public void load(String filename) {
        try (BufferedReader fileReader = new BufferedReader(new FileReader(filename + ".txt"))) {
            this.characters.clear();

            String line = fileReader.readLine();
            while(line != null) {
                String[] tokens = line.split("\\|");
                if(tokens.length != 4) {
                    throw new Exception("Error parsing token: invalid number of tokens");
                }

                char value = (char)Integer.parseInt(tokens[0]);
                String font = tokens[1];
                int size = Integer.parseInt(tokens[2]);
                String color = tokens[3];

                // Use of main.flyweight from PropertiesFactory
                this.characters.add(new TextCharacter(value, PropertiesFactory.getCharacterProperties(font, size, color)));

                line = fileReader.readLine();
            }
        } catch(IOException e) {
            System.err.println("Error reading file " + filename + ".txt");
            e.printStackTrace();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
}