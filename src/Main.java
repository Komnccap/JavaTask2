import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;
import java.util.logging.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // Задание №2 - Реализуйте алгоритм сортировки пузырьком числового массива, результат после каждой итерации запишите в лог-файл.
        Logger logger = Logger.getLogger(Main.class.getName());
        ConsoleHandler conHan = new ConsoleHandler();
        FileHandler fh = new FileHandler("log.txt");
        logger.addHandler(conHan);
        logger.addHandler(fh);

        SimpleFormatter sFormat = new SimpleFormatter();
        //XMLFormatter xml = new XMLFormatter();
        conHan.setFormatter(sFormat);
        //fh.setFormatter(xml);

        int[] numSort = {11, 3, 14, 16, 7};
        boolean isSorted = false;
        int buf;
        while (!isSorted) {
            isSorted = true;
            for (int i = 0; i < numSort.length - 1; i++) {
                if (numSort[i] > numSort[i + 1]) {
                    isSorted = false;

                    buf = numSort[i];
                    numSort[i] = numSort[i + 1];
                    numSort[i + 1] = buf;
                    //logger.log(Level.WARNING,"Происходит сортировка массива");
                    logger.info("Происходит сортировка массива");

                }
            }
        }
        System.out.println(Arrays.toString(numSort));

        //Задание №4 - К калькулятору из предыдущего дз добавить логирование.

        Scanner scan = new Scanner(System.in);
        boolean done = false;
        while(done != true) {
            logger.info("Логирование калькулятора");
            System.out.println(" ");
            System.out.print("Введите перове число ");
            int firstNum = scan.nextInt();
            System.out.print("Введите опреацию(+ - * /) ");
            char ch;
            ch = (char) System.in.read();
            System.out.print("Введите второе число ");
            int secondNum = scan.nextInt();
            if (ch == '+') {
                System.out.println(firstNum + secondNum);
                done = true;
            } else if (ch == '-') {
                System.out.println(firstNum - secondNum);
                done = true;
            } else if (ch == '*') {
                System.out.println(firstNum * secondNum);
                done = true;
            } else if (ch == '/') {
                System.out.println(firstNum / secondNum);
                done = true;
            } else {
                System.out.print("ВВЕДЕНО НЕКОРРЕКТНОЕ ЗНАЧЕНИЕ!!!");
            }
        }
    }
}