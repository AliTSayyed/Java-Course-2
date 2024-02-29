/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dictionary;

import java.util.HashMap;
import java.util.Scanner;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.FileWriter;
import java.util.ArrayList;
/**
 *
 * @author ATS
 */
public class SaveableDictionary {

    private HashMap<String, String> translations;
    private String file;

    public SaveableDictionary() {
        this.translations = new HashMap<>();
    }

    public SaveableDictionary(String file) {
        this.translations = new HashMap<>();
        this.file = file;
    }

    public void add(String words, String translation) {
        if (!this.translations.containsKey(words)) {
            this.translations.put(words, translation);
            this.translations.put(translation, words);
        }
    }

    public String translate(String word) {
        if (this.translations.containsKey(word)) {
            return this.translations.get(word);
        } else {
            return null;
        }
    }

    public void delete(String word) {
        String translation = this.translations.get(word);
        if (this.translations.containsKey(translation)) {
            this.translations.remove(translation);
        }

        if (this.translations.containsKey(word)) {
            this.translations.remove(word);
        }
    }

    public boolean load() {
        try ( Scanner scanner = new Scanner(new File(this.file))) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] parts = line.split(":");
                if (parts.length >= 2) {
                    String word = parts[0];
                    String translation = parts[1];
                    this.translations.put(word, translation);
                    this.translations.put(translation, word);
                }
            }
            return true;
        } catch (IOException e) {
            System.err.println("Error loading dictionary from file: " + this.file);
            return false;
        }
    }

    public boolean save() {
        ArrayList<String> wordsWritten = new ArrayList<>();

        try (PrintWriter writer = new PrintWriter(new FileWriter(this.file))) {
            for (String words : this.translations.keySet()) {
                String word = words;
                String translation = this.translations.get(words);

                // Check if the word or translation has already been written to the file
                if (!wordsWritten.contains(word) && !wordsWritten.contains(translation)) {
                    writer.println(word + ":" + translation);
                    wordsWritten.add(word);
                }
            }
            return true;
        } catch (IOException e) {
            System.err.println("Error saving dictionary to file: " + this.file);
            return false;
        }

    }

}
