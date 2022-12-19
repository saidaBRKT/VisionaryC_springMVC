package com.visionaryCrofting.demo.Util;
import java.util.Random;

public class RandomRef {
   // public static void main(String[] args) {

        public static String generateRandomRef() {

            String Characters = "ABCDEFGHIJKLMNOPKRSTVWXYZ";
            String Numbers = "0123456789";
            String randomRef = "";
            int l1 = 3;
            int l2 = 5;
            Random random = new Random();
            char[] part1 = new char[l1];
            char[] part2 = new char[l2];

            for (int i = 0; i < l1; i++)
                part1[i] = Characters.charAt(random.nextInt(Characters.length()));

            for (int j = 0; j < l2; j++)
                part2[j] = Numbers.charAt(random.nextInt(Numbers.length()));

            for (int i = 0; i < l1; i++)
                randomRef += part1[i];

            for (int j = 0; j < l2; j++)
                randomRef += part2[j];

            System.out.println(randomRef);

            return randomRef;
        }
   // }
}
