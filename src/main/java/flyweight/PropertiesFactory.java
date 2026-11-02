package flyweight;

import java.util.HashMap;
import java.util.Map;

class PropertiesFactory {
    private static Map<String, CharacterProperties> pool =  new HashMap<>();

    public static CharacterProperties getCharacterProperties(String font, int size, String color) {
        String key = font + "|" + size + "|" + color;
        CharacterProperties charProps = pool.get(key);

        // If value not found for that key, insert new key-value pair
        if(charProps == null) {
            charProps = new CharacterProperties(font, size, color);
            pool.put(key, charProps);
        }

        return charProps;
    }

    public static int getPoolSize() {
        return pool.size();
    }
}