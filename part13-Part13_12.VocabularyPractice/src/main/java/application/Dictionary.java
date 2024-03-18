/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application;

/**
 *
 * @author ATS
 */
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Map;
import java.util.List;
import java.util.Random;

public class Dictionary {

    private Map<String, String> translations;
    private List<String> words;

    public Dictionary() {
        this.translations = new HashMap<>();
        this.words = new ArrayList<>();
       
    }

    public String getWord(String word) {
        return this.translations.get(word);
    }

    public void add(String word, String translation) {
        if (!this.translations.containsKey(word)) {
            this.words.add(word);
        }
        this.translations.put(word, translation);
    }

    public String getRandomWord() {
        if (this.words.isEmpty()) {
            return null;
        }

        Random random = new Random();
        return this.words.get(random.nextInt(this.words.size()));
    }

}
