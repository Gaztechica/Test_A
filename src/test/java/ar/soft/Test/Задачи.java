package ar.soft.Test;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Задачи {

//1. Проверка на палиндром (без reverse)
//    java
    public static boolean isPalindrome(String text) {
        if (text == null) return false;
        String clean = text.replaceAll("[^a-zA-Z0-9]", "").toLowerCase(); // очистка от пробелов и регистра
        int left = 0;
        int right = clean.length() - 1;
        while (left < right) {
            if (clean.charAt(left) != clean.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }


    public static boolean isPalindromeSimpleStream(String text) {
        if (text == null) return false;

        String lower = text.toLowerCase();

        return IntStream.range(0, lower.length() / 2)
                .allMatch(i -> lower.charAt(i) == lower.charAt(lower.length() - 1 - i));
    }




//            2. Подсчет символов в строке
//    java

    public static Map<Character, Integer> countChars(String text) {
        Map<Character, Integer> map = new HashMap<>();
        if (text == null) return map;
        for (char c : text.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        return map;
    }
//                3. Поиск дубликатов в массиве (Оптимально: O(n) по времени)
//    java

    public static Set<Integer> findDuplicates(int[] numbers) {
        Set<Integer> duplicates = new HashSet<>();
        Set<Integer> unique = new HashSet<>();
        for (int num : numbers) {
            if (!unique.add(num)) { // add() вернет false, если элемент уже есть в Set
                duplicates.add(num);
            }
        }
        return duplicates;
    }

        public class CharCount {
            public static void main(String[] args) {
                countCharacters("автоматизация");
            }

            public static void countCharacters(String input) {
                Map<Character, Integer> charMap = new HashMap<>();

                // Перебираем строку посимвольно
                for (char c : input.toCharArray()) {
                    // Если символ уже есть, увеличиваем счетчик, если нет — ставим 1
                    charMap.put(c, charMap.getOrDefault(c, 0) + 1);
                }

                // Выводим результат
                for (Map.Entry<Character, Integer> entry : charMap.entrySet()) {
                    System.out.println("Буква '" + entry.getKey() + "' встречается: " + entry.getValue() + " раз(а)");
                }
            }
        }

//        Задача 4: Stream API (Современный подход в Java)
//
//        Условие: У вас есть список строк: ["тест", "автотест", "баг", "регресс", "лог"].
//        Используя Stream API, отфильтруйте этот список так, чтобы остались только слова, которые длиннее 4 символов,
//
//        переведите их в верхний регистр (UPPERCASE) и соберите результат в новый список.
//💡     решение       java


        public class StreamExample {
            public static void main(String[] args) {
                List<String> words = Arrays.asList("тест", "автотест", "баг", "регресс", "лог");

                List<String> result = words.stream()
                        .filter(word -> word.length() > 4)       // Фильтруем по длине
                        .map(String::toUpperCase)                // Преобразуем в верхний регистр
                        .collect(Collectors.toList());           // Собираем в новый список

                System.out.println(result); // Выведет: [АВТОТЕСТ, РЕГРЕСС]
            }
        }


    public static void main(String[] args) {
        List<String> listToEdit = Arrays.asList("num-1", "num-2", "num-3", "num-4");

        // Вызываем наш метод и сохраняем результат в новый список
        List<String> editedList = replaceHyphenWithSpace(listToEdit);

        // Выводим результат работы метода на экран
        System.out.println(editedList);
    }

    // Метод, который принимает список строк и возвращает измененный список
    public static List<String> replaceHyphenWithSpace(List<String> inputList) {
        return inputList.stream()
                // Метод replace("-", " ") заменяет все дефисы на пробелы в каждой строке
                .map(element -> element.replace("-", " "))
                // Собираем измененные элементы обратно в новый список
                .collect(Collectors.toList());
    }

// • .map(element -> element.replace("-", " ")) — метод map берет по очереди каждый элемент списка (например, "num-1"),
// временно помещает его в переменную element и применяет к нему стандартную функцию Java .replace("-", " ").
// На выходе получается "num 1", который летит дальше по конвейеру.






    public static void test() {

        /**
         * циклы
         * do while
         */

        int count = 10;
        while (count > 0) {
            count--;
            if (count == 4) {
                break;
            }
            System.out.println(count);
        }

        int row = 1;
        while (row < 4) {
            int cal = 1;
            while (cal <= 5) {
                System.out.print("#");
                cal++;
            }
            System.out.println();
            row++;
        }

        int rows = 1;
        do {
            System.out.println("gg " + rows);
            rows++;
        }
        while (false);
        while (rows < 4) ;


        int rows2 = 1;
        do {
            System.out.println("gg " + rows2);
            rows2++;
            if (rows2 == 5) {
                break;
            }
        } while (true);
//        while (rows < 4);


        for (int i = 0; i < 15; i++) {
            if (i % 3 == 0)
                continue;
            System.out.println("ee " + i);
        }


    }
}
