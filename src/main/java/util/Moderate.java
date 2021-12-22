package util;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.IOException;
import java.util.List;

public class Moderate {
	private static List<String> forbiddenWords = readFile("forbiddenWords.txt");

	private static List<String> readFile(String file) {
		List<String> words = null;

		try {
			words = Files.readAllLines(Paths.get("util/" + file));
		} catch (IOException e) {
			System.out.println("Impossible de lire le fichier \"" + file + "\", vérifiez son existence et/ou son contenu");
		}

		if (words != null) {
			return words;
		}
		else {
			return null;
		}
	}

	public static String censor(String text) {
		for (String word:forbiddenWords) {
			String censoredWord = word.replaceAll(".", "*");
			text = text.replaceAll(word, censoredWord);  
		}

		return text;
	}	
}
