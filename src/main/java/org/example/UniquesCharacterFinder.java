package org.example;

import java.util.HashMap;
import java.util.Map;

public class UniquesCharacterFinder {
    public static String createNewTextWithCommonCharacters(String[] texts) {
    Map<Character, Integer> charCountMap = new HashMap<>();
    String textWithDuplicates = "";

    // Metinler dizisindeki metinleri dolaşarak tekrarlı karakterlerin bulunduğu metni belirle
        for (String text : texts) {
        for (char c : text.toCharArray()) {
            if (charCountMap.containsKey(c)) {
                // Karakter zaten varsa, tekrarlı karakterler içeren metni belirle
                textWithDuplicates = text;
                break;
            }
            charCountMap.put(c, 1);
        }
        if (!textWithDuplicates.isEmpty()) {
            break;
        }
        charCountMap.clear(); // Sonraki metinler için temizle
    }

    // İki metinde de tekrar eden karakterler bulunamadıysa, boş bir metin döndür
        if (textWithDuplicates.isEmpty()) {
        return "";
    }

    // İki metinde de tekrar eden karakterleri içeren yeni bir metin oluştur
    StringBuilder newTextBuilder = new StringBuilder();
        for (char c : textWithDuplicates.toCharArray()) {
        if (charCountMap.containsKey(c)) {
            newTextBuilder.append(c);
        }
    }
        return newTextBuilder.toString();
}

public static void main(String[] args) {
    String[] texts = {"hello", "world", "stackoverflow", "example", "word"};
    String newtext = createNewTextWithCommonCharacters(texts);

    if (!newtext.isEmpty()) {
        System.out.println("New text with common characters: " + newtext);
    } else {
        System.out.println("No two texts with duplicate characters found.");
    }
}
}
