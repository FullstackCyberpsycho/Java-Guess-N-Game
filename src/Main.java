import java.io.*;
import java.util.Scanner;

public class Main {
    private static int balance = 0;
    static File balanceF = new File("src/resources/balance.txt");

    public static void main(String[] args) throws IOException {
        start();
    }

    private static void printInfo() {
        System.out.println("(Beta 2.1)Правила игры:\n" +
                "1. Java загадывает число, а user пытается его угадать.\n" +
                "2. Java может писать «больше» или «меньше», когда user вводит число.\n" +
                "3. Игра продолжается до тех пор, пока user не угадает число.\n" +
                "4. Если user угадал число, он выигрывает. Если он превысил количество" +
                " попыток, то выигрывает Java.\n" +
                        "5. У вас есть баланс$ он нужен для того чтобы покупать разные бонусы!\n" +
                        "что бы пополнять его вам нужно угадывать числа!" +
                        "\n100$ - угадал(а) с 1-ой попытки!" +
                        "\n70$ - угадал(а) с 2-ой попытки!" +
                        "\n50$ - угадал(а) с 3-ой попытки!" +
                        "\n10$ - угадал(а) с 4-ой попытки!" +
                        "\n5$ - угадал(а) с 5-ой попытки!" +
                        "\n1$ - угадал(а) с 6-ой попытки!\n" +
                "6. Всего есть 6 уровня сложности: 1 - легкий(0-10), " +
                "2 - средний(0-30), 3 - сложный(0-50), 4 - случайный(0-???) + казино...(в разработке)");

        System.out.println("ВАШ БАЛАНС: " + getBalance());
        System.out.print("\nВыберите уровень сложности (1-5): ");
    }

    private static void start() throws IOException {
        Scanner scanner = new Scanner(System.in);
        String numLevel;

        while (true) {
            printInfo();
            numLevel = scanner.nextLine();
            new RunLeve(numLevel);
        }
    }

    public static int getBalance() {
        try {
            if (!balanceF.exists()) {
                balanceF.createNewFile();
                setBalance(0);
            }

            Scanner myReader = new Scanner(balanceF);
            if (myReader.hasNextLine()) {
                balance = Integer.parseInt(myReader.nextLine().trim());
            }
            myReader.close();
        } catch (IOException | NumberFormatException e) {
            System.out.println("Ошибка при чтении баланса. Установлен 0.");
            balance = 0;
        }
        return balance;
    }

    public static void setBalance(int newBalance) {
        try (FileWriter fileWriter = new FileWriter(balanceF, false)) {
            fileWriter.write(String.valueOf(newBalance));
            balance = newBalance;
        } catch (IOException e) {
            System.out.println("Ошибка при записи баланса.");
        }
    }
}
