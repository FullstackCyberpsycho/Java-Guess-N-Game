import java.util.Random;
import java.util.Scanner;

public class RunLeve {
    private int count = 10, countGo = 1, javaNum, userNum;
    private final Random random = new Random();
    private final Scanner scanner = new Scanner(System.in);
    private int balance;

    public RunLeve(String leve) {
        this.balance = Main.getBalance();

        switch (leve) {
            case "1": leve(10); break;
            case "2": leve(30); break;
            case "3": leve(50); break;
            case "4": leve(); break;
            case "5": leve(""); break;
        }
    }

    private void leve(int javaNumR) {
        javaNum = random.nextInt(javaNumR);
            System.out.println("Кол-во попыток: " + count + ". Попытка: " + countGo);

        while (true) {
            count--;
            countGo++;
            System.out.print("Введите число: ");
            userNum = scanner.nextInt();

            if (userNum > javaNum) {
                System.out.println("Кол-во попыток: " + count + ". Попытка: " + countGo);
                System.out.println("Java: Меньше!");
            } else if (userNum < javaNum) {
                System.out.println("Кол-во попыток: " + count + ". Попытка: " + countGo);
                System.out.println("Java: Больше!");
            } else {
                int winAmount = 0;
                switch (countGo) {
                    case 2: winAmount = 100; break;
                    case 3: winAmount = 70; break;
                    case 4: winAmount = 50; break;
                    case 5: winAmount = 10; break;
                    case 6: winAmount = 5; break;
                    case 7: winAmount = 1; break;
                }

                balance += winAmount;
                Main.setBalance(balance);

                System.out.println("Вы угадали число (" + javaNum + ") c " + --countGo + "-ой попытки! Новый баланс: " + balance);
                break;
            }

            if (count == 1) {
                System.out.println("У вас осталась 1 попытка!");
            } else if (count <= 0) {
                System.out.println("Ваши попытки кончились. Вы проиграли.");
                break;
            }
        }
    }

    private void leve() {
        int[] ranges = {50, 100, 200, 300};
        int randomIndex = random.nextInt(ranges.length);
        int horizon = ranges[randomIndex];
        javaNum = random.nextInt(horizon);

        System.out.println("Диапазон: 0-" + horizon);
        System.out.println(javaNum + "Кол-во попыток: " + count + ". Попытка: " + countGo);

        while (true) {
            count--;
            countGo++;
            System.out.print("Введите число: ");
            userNum = scanner.nextInt();

            if (userNum > javaNum) {
                System.out.println("Кол-во попыток: " + count + ". Попытка: " + countGo);
                System.out.println("Java: Меньше!");
            } else if (userNum < javaNum) {
                System.out.println("Кол-во попыток: " + count + ". Попытка: " + countGo);
                System.out.println("Java: Больше!");
            } else {
                int winAmount = 0;
                switch (countGo) {
                    case 1: winAmount = 100; break;
                    case 2: winAmount = 70; break;
                    case 3: winAmount = 50; break;
                    case 4: winAmount = 10; break;
                    case 5: winAmount = 5; break;
                    case 6: winAmount = 1; break;
                }

                balance += winAmount;
                Main.setBalance(balance);
                System.out.println("Вы угадали число (" + javaNum + ") c " + --countGo + "-ой попытки! Новый баланс: " + balance);
                break;
            }

            if (count == 1) {
                System.out.println("Осталась 1 попытка!");
            } else if (count <= 0) {
                System.out.println("Вы проиграли.");
                break;
            }
        }
    }

    private void leve(String s) {
        System.out.print("В этом уровне баланс не прибавляется!\n");
        System.out.print("Введите максимальное число: ");
        int maxNumber = scanner.nextInt();
        System.out.print("Введите количество попыток: ");
        count = scanner.nextInt();

        javaNum = random.nextInt(maxNumber);
        System.out.println("Кол-во попыток: " + count + ". Попытка: " + countGo);

        while (true) {
            count--;
            countGo++;
            System.out.print("Введите число: ");
            userNum = scanner.nextInt();

            if (userNum > javaNum) {
                System.out.println("Кол-во попыток: " + count + ". Попытка: " + countGo);
                System.out.println("Java: Меньше!");
            } else if (userNum < javaNum) {
                System.out.println("Кол-во попыток: " + count + ". Попытка: " + countGo);
                System.out.println("Java: Больше!");
            } else {
                System.out.println("Вы угадали число (" + javaNum + ") c " + --countGo + "-ой попытки!");
                break;
            }

            if (count == 1) {
                System.out.println("Осталась 1 попытка!");
            } else if (count <= 0) {
                System.out.println("Вы проиграли.");
                break;
            }
        }
    }
}
