import java.io.File;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

public class Casino {
    private final Scanner scanner = new Scanner(System.in);
    private final Random random = new Random();
    private int balance, bet;
    private PrintInfo print = new PrintInfo();
    //GetGame getGame = new GetGame();
    //private File fiftyFiftyF = new File("src/resources/getFiftyFifty");
    //private String dateFiftyFiftyF;

    public Casino() throws IOException, InterruptedException {
        this.balance = Main.getBalance();
        start();
    }

    private void start() throws IOException, InterruptedException {
        String choice;
        while (true) {
            System.out.print("\nДобро пожаловать в казино! Ваш баланс: " + balance + "$\n" +
                    "Выберите игру:\n" +
                    "1 - 50/50 (x2 или 0)\n" +
                    "2 - Колесо удачи (x0, x0.5, x1, x2, x5, x-2, x-0.5, x-3, x-5) - beta\n" +
                    "3 - Кости (если сумма >7, ставка x2)\n" +
                    "0 - Выйти в меню\n" +
                    "Ввод: ");
            choice = scanner.nextLine();
            scanner.nextLine();
            switch (choice) {
                case "1": fiftyFifty(); break;
                case "2": wheelOfFortune(); break;
                case "3": craps(); break;
                case "0": Main.setBalance(balance); return;
                default: System.out.println("Неверный ввод, попробуйте снова."); break;
            }
        }
    }

    private void fiftyFifty() throws IOException {
        if (!Main.getSellGeme(Main.fiftyFiftyF).equals("123")) {
            System.out.println("Купите игру!");
            return;
        }

        System.out.print("Введите ставку(min: 100, max: 500): ");
        bet = scanner.nextInt();
        scanner.nextLine();

        if (bet > balance || bet <= 0) {
            System.out.println("Недостаточно средств!");
            return;
        } else if (bet < 100 || bet > 500) {
            System.out.println("Ставка слишком низкая или высокая");
        }

        boolean win = random.nextInt(100) < 35;
        if (win) {
            balance += bet;
            System.out.println("Вы выиграли! Ваш баланс: " + balance + "$");
        } else {
            balance -= bet;
            System.out.println("Вы проиграли... Ваш баланс: " + balance + "$");
        }
    }

    private void wheelOfFortune() {
        if (!Main.getSellGeme(Main.wheelOfFortuneF).equals("321")) {
            System.out.println("Купите игру!");
            return;
        }

        System.out.print("Введите ставку(min: 1000, max: 2500): ");
        bet = scanner.nextInt();
        scanner.nextLine();

        if (bet > balance || bet < 1000 || bet > 2500) {
            System.out.println("Ставка слишком низкая/высокая или недостаточно средств!");
            return;
        }

        double[] multipliers = {0, 0.5, 1, 2, 5, -2, -0.5, -3, -5};

        int count = random.nextInt(25);
        double multiplier = 0;
        for (int i = 0; i < count; i++) {
            multiplier = multipliers[random.nextInt(multipliers.length)];
            System.out.println(multiplier);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        int winnings = (int) (bet * multiplier);
        balance += winnings - bet;

        System.out.println("Колесо остановилось на x" + multiplier + "!");
        System.out.println("Ваш новый баланс: " + balance + "$");
        Main.setBalance(balance);
    }

    private void craps() throws IOException, InterruptedException {
        if (!Main.getSellGeme(Main.crapsF).equals("231")) {
            System.out.println("Купите игру!");
            return;
        }

        int craps1 = random.nextInt(6);
        int craps2 = random.nextInt(6);
        int sumCraps;

        System.out.print("Введите ставку(min: 1500, max: 3000): ");
        bet = scanner.nextInt();
        scanner.nextLine();

        if (bet > balance || bet <= 0 || bet < 1500 || bet > 3000) {
            System.out.println("Ставка слишком низкая/высокая или недостаточно средств!");
            return;
        }

        System.out.print("'Enter' - кинуть кубик ");
        System.in.read();
        try {
            Thread.sleep(750);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Выпало число: " + craps1);
        System.out.print("'Enter' - кинуть второй кубик ");
        System.in.read();
        Thread.sleep(750);

        System.out.println("Выпало число: " + craps2);
        sumCraps = craps1 + craps2;
        System.out.println("Сумма кубиков: " + sumCraps);
        if (sumCraps > 7) {
            balance += bet;
            System.out.println("Вы выиграли! Ваш баланс: " + balance + "$  +" + bet);
        } else {
            balance -= bet;
            System.out.println("Вы проиграли... Ваш баланс: " + balance + "$  -" + bet);
        }
        Main.setBalance(balance);
    }
}
