import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class First {
    public static void main(String[] args) throws IOException {

        System.out.println(test());
    }

    private static int test() throws IOException {
        final int numberOfKeys;

        final int[] idArray;
        final int[] rowNumbers;

        final int numberOfLettersInText;

        final int[] lettersIDFromText;

        Map<Integer, Integer> keys = new HashMap<>();


        int output = 0;

        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
//получили число клавиш
            numberOfKeys = Integer.parseInt(bufferedReader.readLine());
//массив id клавиш
            idArray = new int[numberOfKeys];

            String[] stringIDs = bufferedReader.readLine().split(" ");
//получили все id
            for (int i = 0; i < numberOfKeys; i++) {
                idArray[i] = Integer.parseInt(stringIDs[i]);
            }

            rowNumbers = new int[numberOfKeys];

            String[] stringNumbers = bufferedReader.readLine().split(" ");
//заполнили номера рядов клавиш
            for (int i = 0; i < numberOfKeys; i++) {
                rowNumbers[i] = Integer.parseInt(stringNumbers[i]);
            }
//собираем мапу с ключами
            for (int i = 0; i < numberOfKeys; i++) {
                keys.put(idArray[i], rowNumbers[i]);
            }

//количество символов в тексте тестовом
            numberOfLettersInText = Integer.parseInt(bufferedReader.readLine());
//массив id букв из текста
            lettersIDFromText = new int[numberOfLettersInText];

            String[] stringIDsFromText = bufferedReader.readLine().split(" ");

            for (int i = 0; i < numberOfLettersInText; i++) {
                lettersIDFromText[i] = Integer.parseInt(stringIDsFromText[i]);
            }
        }

        int oldRowNumber = -1;

        for (int i = 0; i < numberOfLettersInText; i++) {

            if (oldRowNumber == -1) {
                oldRowNumber = keys.get(lettersIDFromText[i]);

            } else if (oldRowNumber == keys.get(lettersIDFromText[i])) {
                oldRowNumber = keys.get(lettersIDFromText[i]);

            } else {
                oldRowNumber = keys.get(lettersIDFromText[i]);
                output++;
            }
        }
        return output;
    }
}