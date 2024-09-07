import java.util.Scanner;

public class Task1 {
    public static void main(String[] args) {

                Scanner scanner = new Scanner(System.in);

                System.out.print("введите аргумент n: ");
                int n = scanner.nextInt();
                System.out.print("введите аргумент m: ");
                int m = scanner.nextInt();
                scanner.close();
                StringBuilder path = new StringBuilder();

                // Заполнение массива
                int[] circularArray = new int[n];
                for (int i = 0; i < n; i++) {
                    circularArray[i] = i + 1;
                }
                int currentIndex = 0;
                do {
                    path.append(circularArray[currentIndex]);

                    currentIndex = (currentIndex + m - 1) % n;
                } while (currentIndex != 0);
                System.out.println(path.toString());
            }

        }




