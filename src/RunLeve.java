import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

public class RunLeve {
    private int count = 10, countGo = 1, javaNum, userNum;
    private final Random random = new Random();
    private final Scanner scanner = new Scanner(System.in);
    private int balance;
    private GameStats stats = new GameStats();
    private static int gamesPlayed, gamesWon; //, totalWins;

    public RunLeve(String leve) throws IOException {
        gamesPlayed = stats.getGamesPlayed();
        gamesWon = stats.getGamesWon();
        this.balance = Main.getBalance();
        //totalWins = balance;

        switch (leve) {
            case "1": leve(10); break;
            case "2": leve(30); break;
            case "3": leve(50); break;
            case "4": leve(); break;
            case "5": leve(""); break;
        }
    }

    private void leve(int javaNumR) throws IOException {
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
                    case 2: winAmount = 100; /*totalWins = winAmount; stats.setTotalWins(totalWins);*/ break;
                    case 3: winAmount = 70; break;
                    case 4: winAmount = 50; break;
                    case 5: winAmount = 10; break;
                    case 6: winAmount = 5; break;
                    case 7: winAmount = 1; break;
                }

                balance += winAmount;
                Main.setBalance(balance);

                System.out.println("Вы угадали число (" + javaNum + ") c " + --countGo + "-ой попытки! Новый баланс: " + balance);
                gamesWon++;
                gamesPlayed++;
                stats.setGamesPlayed(gamesPlayed);
                stats.setGamesWon(gamesWon);

                System.out.println("Нажмите 'Enter' чтобы продолжить");
                System.in.read();
                break;
            }

            if (count == 1) {
                System.out.println("У вас осталась 1 попытка!");
            } else if (count <= 0) {
                System.out.println("Ваши попытки кончились. Вы проиграли.\nНажмите 'Enter' чтобы продолжить");
                gamesPlayed++;
                stats.setGamesPlayed(gamesPlayed);
                System.in.read();
                break;
            }
        }
    }

    private void leve() throws IOException {
        int[] ranges = {50, 100, 200, 300};
        int randomIndex = random.nextInt(ranges.length);
        int horizon = ranges[randomIndex];
        javaNum = random.nextInt(horizon);

        System.out.println("Диапазон: 0-" + horizon);
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
                gamesWon++;
                gamesPlayed++;
                stats.setGamesPlayed(gamesPlayed);
                stats.setGamesWon(gamesWon);

                System.out.println("Нажмите 'Enter' чтобы продолжить");
                System.in.read();
                break;
            }

            if (count == 1) {
                System.out.println("Осталась 1 попытка!");
            } else if (count <= 0) {
                System.out.println("Вы проиграли.\nНажмите 'Enter' чтобы продолжить");
                gamesPlayed++;
                stats.setGamesPlayed(gamesPlayed);
                System.in.read();
                break;
            }
        }
    }

    private void leve(String s) throws IOException {
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
                gamesWon++;
                gamesPlayed++;
                stats.setGamesPlayed(gamesPlayed);
                stats.setGamesWon(gamesWon);

                System.out.println("Нажмите 'Enter' чтобы продолжить");
                System.in.read();
                break;
            }

            if (count == 1) {
                System.out.println("Осталась 1 попытка!");
            } else if (count <= 0) {
                System.out.println("Вы проиграли.\nНажмите 'Enter' чтобы продолжить");
                gamesPlayed++;
                stats.setGamesPlayed(gamesPlayed);
                System.in.read();
                break;
            }
        }
    }
}
