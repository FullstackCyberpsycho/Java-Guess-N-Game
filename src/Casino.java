import java.util.Random;
import java.util.Scanner;

public class Casino {
    private final Scanner scanner = new Scanner(System.in);
    private final Random random = new Random();
    private int balance, bet;
    private PrintInfo print = new PrintInfo();

    public Casino() {
        this.balance = Main.getBalance();
        start();
    }

    private void start() {
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

    private void fiftyFifty() {
        System.out.print("Введите ставку: ");
        bet = scanner.nextInt();
        scanner.nextLine();

        if (bet > balance || bet <= 0) {
            System.out.println("Недостаточно средств!");
            return;
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
        System.out.print("Введите ставку(минимум 1000): ");
        bet = scanner.nextInt();
        scanner.nextLine();

        if (bet > balance || bet < 1000) {
            System.out.println("Ставка слишком низкая или недостаточно средств!");
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
        //Main.setBalance(balance);
    }

    private void craps() {
        System.out.println("Пока недоступно!");
    }


}
