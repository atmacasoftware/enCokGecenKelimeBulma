import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        HashMap<String, Integer> textHash = new HashMap<String, Integer>();

        Scanner input = new Scanner(System.in);

        System.out.println("Metin giriniz : ");
        String text = input.nextLine();

        System.out.println("Girilen Metin : " + text);

        if (!text.isEmpty()) {

            String[] arr = new String[text.split("[ .,]+").length];

            System.arraycopy(text.split("[ .,]+"), 0, arr, 0, text.split(" ").length);
            System.out.println(arr.length);
            for (int i = 0; i < arr.length; i++) {
                int count = 1;
                for (int j = 0; j < arr.length; j++) {
                    if ((i != j) && (arr[i].equalsIgnoreCase(arr[j]))) {
                        textHash.put(arr[i], count++);
                    } else {
                        textHash.put(arr[i], count);
                    }
                }

            }
            int max = 1;
            String maxWord = null;

            for (String i : textHash.keySet()) {
                System.out.println("Kelime: " + i + " - Tekrar Sayısı: " + textHash.get(i));

                if(textHash.get(i) > max){
                    max = textHash.get(i);
                    maxWord = i;
                }

            }

            System.out.println("---------------------------------------------------");

            System.out.println("En çok geçen kelime : " + maxWord);
            System.out.println("Sayısı : " + max);
        }

    }
}