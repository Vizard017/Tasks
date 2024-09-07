
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Task2 {

    public static void main(String[] args) {
        int xCenter = 0;
        int yCenter = 0;
        int radius = 0;
        try {
            File circleFile = new File(args[0]);
            Scanner circleScanner = new Scanner(circleFile);

            if (circleScanner.hasNextInt()) {
                xCenter = circleScanner.nextInt();
            }
            if (circleScanner.hasNextInt()) {
                yCenter = circleScanner.nextInt();
            }
            if (circleScanner.hasNextInt()) {
                radius = circleScanner.nextInt();
            }
            circleScanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("Файл с окружностью не найден.");
            return;
        }

        try {
            File pointsFile = new File(args[1]);
            Scanner pointsScanner = new Scanner(pointsFile);

            while (pointsScanner.hasNextInt()) {
                double xPoint = 0;
                double yPoint = 0;

                if (pointsScanner.hasNextInt()) {
                    xPoint = pointsScanner.nextInt();
                }
                if (pointsScanner.hasNextInt()) {
                    yPoint = pointsScanner.nextDouble();
                }

                double distance = Math.sqrt((xPoint - xCenter) * (xPoint - xCenter) + (yPoint - yCenter) * (yPoint - yCenter));

                if (distance == radius) {
                    System.out.println(0);  // Точка лежит на окружности
                } else if (distance < radius) {
                    System.out.println(1);  // Точка внутри окружности
                } else {
                    System.out.println(2);  // Точка снаружи окружности
                }
            }
            pointsScanner.close();
        } catch (FileNotFoundException e) {
            System.out.println(" Файл с точками не найден.");
        }
    }
}
