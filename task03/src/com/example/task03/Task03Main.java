package com.example.task03;

import java.io.*;
import java.nio.charset.Charset;
import java.util.*;
import java.util.stream.Collectors;

public class Task03Main {

    public static void main(String[] args) throws IOException {

        List<Set<String>> anagrams = findAnagrams(new FileInputStream("task03/resources/singular.txt"), Charset.forName("windows-1251"));
        for (Set<String> anagram : anagrams) {
            System.out.println(anagram);
        }

    }

    public static List<Set<String>> findAnagrams(InputStream inputStream, Charset charset) {
        Map<String, Set<String>> result = new TreeMap<>();
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, charset))) {
            List<String> words = bufferedReader.lines()
                    .map(String::toLowerCase)
                    .filter(x -> x.length() >= 3)
                    .filter(x -> x.matches("[а-яё]+"))
                    .collect(Collectors.toList());
            for (String word : words) {
                char[] chars = word.toCharArray();
                Arrays.sort(chars);
                String key = new String(chars);
                result.computeIfAbsent(key, x -> new TreeSet<>()).add(word);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return  result.values().stream().filter(x -> x.size() >= 2).collect(Collectors.toList());
    }
}
