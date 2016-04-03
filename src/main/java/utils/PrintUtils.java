package utils;

import java.util.Stack;

/**
 * Created by dineshgurumurthy on 3/24/16.
 */
public class PrintUtils {

    public static void print(Iterable iterable) {
        for (Object obj : iterable) {
            System.out.println(obj);

        }
    }

    public static void print(Stack stack) {
        if (stack != null) {
            int size = stack.size();
            for (int x = 0; x < size; x++) {
                System.out.println(stack.pop());
            }
        }
    }

    public static void print(int[] ar) {
        for (int i = 0; i < ar.length; i++) {
            System.out.println(i + " -> " + ar[i]);
        }
    }

    public static void print(boolean[] ar) {
        for (int i = 0; i < ar.length; i++) {
            System.out.println(i + " -> " + ar[i]);
        }
    }

    public static void printLineBreak() {
        System.out.println("---------------------");
    }
}
