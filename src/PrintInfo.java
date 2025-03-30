import java.io.IOException;
import java.util.Scanner;

public class PrintInfo {
    public void rules() {
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
                "6. Всего есть 6 уровня сложности: легкий(0-10), средний(0-30), сложный(0-50), случайный(0-???), Пользовательский(сами настраиваете...) + казино...(в разработке)\n");
    }

    public void mainMenu() {
        System.out.print("beta 2.2\n" +
                "1 - Играть\n" +
                "2 - Правила\n" +
                "3 - Статистика\n" +
                "Ввод: ");
    }

    public void level() {
        System.out.print("1 - легкий(0-10)\n" +
                "2 - средний(0-30)\n" +
                "3 - сложный(0-50)\n" +
                "4 - случайный(0-???)\n" +
                "5 - Пользовательский\n" +
                "6 - казино(beta)\n" +
                "Ввод: ");
    }

    public void statistics() {
        int balance = 0;
        System.out.println("Beta");
        try {
            if (!Main.balanceF.exists()) {
                Main.balanceF.createNewFile();
                Main.setBalance(0);
            }

            Scanner myReader = new Scanner(Main.balanceF);
            if (myReader.hasNextLine()) {
                balance = Integer.parseInt(myReader.nextLine().trim());
            }
            myReader.close();
        } catch (IOException | NumberFormatException e) {
            System.out.println("Ошибка при чтении баланса. Установлен 0.");
            balance = 0;
        }
        System.out.println("Баланс: " + balance + "\n");
    }
}
