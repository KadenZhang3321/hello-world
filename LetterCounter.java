import java.util.*;
import java.io.*;

public class LetterCounter {

    /**
     * 统计字符串中每个字母出现的次数
     * @param input 输入字符串
     * @return 包含字母频率的Map
     */
    public static Map<Character, Integer> countLetters(String input) {
        Map<Character, Integer> letterCount = new HashMap<>();

        if (input == null || input.isEmpty()) {
            return letterCount;
        }

        // 转换为小写以便统一统计
        String lowerInput = input.toLowerCase();

        for (char c : lowerInput.toCharArray()) {
            // 只统计字母
            if (Character.isLetter(c)) {
                letterCount.put(c, letterCount.getOrDefault(c, 0) + 1);
            }
        }

        return letterCount;
    }

    /**
     * 打印字母统计结果
     * @param letterCount 字母频率Map
     * @param originalInput 原始输入字符串
     */
    public static void printLetterCount(Map<Character, Integer> letterCount, String originalInput) {
        System.out.println("输入字符串: \"" + originalInput + "\"");
        System.out.println("字母统计结果:");
        System.out.println("====================");

        if (letterCount.isEmpty()) {
            System.out.println("没有找到任何字母");
            return;
        }

        // 按字母顺序排序显示
        letterCount.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .forEach(entry ->
                    System.out.printf("字母 '%c': %d 次%n",
                                    entry.getKey(), entry.getValue()));

        System.out.println("====================");
        System.out.println("总共统计了 " + letterCount.size() + " 种不同的字母");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== 字符串字母统计程序 ===");
        System.out.println("请输入一个字符串 (输入 'quit' 退出程序):");

        while (true) {
            System.out.print("> ");
            String input = scanner.nextLine().trim();

            if ("quit".equalsIgnoreCase(input)) {
                System.out.println("程序结束，再见！");
                break;
            }

            if (input.isEmpty()) {
                System.out.println("请输入非空字符串");
                continue;
            }

            Map<Character, Integer> result = countLetters(input);
            printLetterCount(result, input);
            System.out.println();
        }

        scanner.close();
    }
}