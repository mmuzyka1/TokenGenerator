package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {

    private static final List<Integer> availableTokenLengths = List.of(5, 10, 15);
    private static final List<Integer> availableCharacters = new ArrayList<>();

    public static void main(String[] args) {
        populateAvailableCharactersList();
        System.out.println(tokenGenerator(getTokenLength()));
    }

    public static String tokenGenerator(int tokenLength) {
        Random random = new Random();
        StringBuilder token = new StringBuilder();
        for (int i = 0; i < tokenLength; i++) {
            token.append((char) availableCharacters.get(random.nextInt(availableCharacters.size())).intValue());
        }
        return token.toString();
    }

    public static int getTokenLength() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please, choose the length of your token: 5, 10 or 15 characters.");

        while (true) {
            try {
                int tokenLength = scanner.nextInt();
                if (!availableTokenLengths.contains(tokenLength)) {
                    System.out.println("This is not a valid token length. Please, choose 5, 10 or 15 characters.");
                    scanner.nextLine();
                } else {
                    return tokenLength;
                }
            } catch (Exception e) {
                System.out.println("This is not a number!");
                scanner.nextLine();
            }
        }
    }

    private static List<Integer> getNumbersList() {
        return IntStream.rangeClosed(48, 57).boxed().collect(Collectors.toList());
    }

    private static List<Integer> getLowercaseList() {
        return IntStream.rangeClosed(97, 122).boxed().collect(Collectors.toList());
    }

    private static List<Integer> getUppercaseList() {
        return IntStream.rangeClosed(65, 90).boxed().collect(Collectors.toList());
    }

    private static List<Integer> getSpecialCharactersList() {
        return List.of(33, 35, 36, 37, 38, 40, 41, 42, 64, 94);
    }

    private static void populateAvailableCharactersList() {
        availableCharacters.addAll(getNumbersList());
        availableCharacters.addAll(getLowercaseList());
        availableCharacters.addAll(getUppercaseList());
        availableCharacters.addAll(getSpecialCharactersList());
    }
}