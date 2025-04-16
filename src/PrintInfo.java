import java.io.IOException;
import java.util.Scanner;

public class PrintInfo {
    public void rules() {
        System.out.println("Правила игры:\n" +
                "1. Java загадывает число, а user пытается его угадать.\n" +
                "2. Java может писать «больше» или «меньше», когда user вводит число.\n" +
                "3. Игра продолжается до тех пор, пока user не угадает число.\n" +
                "4. Если user угадал число, он выигрывает. Если он превысил количество" +
                " попыток, то выигрывает Java.\n" +
                "5. У вас есть баланс$ он нужен для того чтобы покупать разные бонусы!\n" +
                "что бы пополнять его вам нужно угадывать числа!" +
                "\n1 уровень:" +
                "\n100$ - угадал(а) с 1-ой попытки!" +
                "\n70$ - угадал(а) с 2-ой попытки!" +
                "\n50$ - угадал(а) с 3-ой попытки!" +
                "\n10$ - угадал(а) с 4-ой попытки!" +
                "\n5$ - угадал(а) с 5-ой попытки!" +
                "\n1$ - угадал(а) с 6-ой попытки!\n" +

                "\n2 уровень:" +
                "\n500$ - угадал(а) с 1-ой попытки!" +
                "\n250$ - угадал(а) с 2-ой попытки!" +
                "\n100$ - угадал(а) с 3-ой попытки!" +
                "\n50$ - угадал(а) с 4-ой попытки!" +
                "\n15$ - угадал(а) с 5-ой попытки!" +
                "\n5$ - угадал(а) с 6-ой попытки!\n" +

                "\n3 уровень:" +
                "\n700$ - угадал(а) с 1-ой попытки!" +
                "\n350$ - угадал(а) с 2-ой попытки!" +
                "\n200$ - угадал(а) с 3-ой попытки!" +
                "\n65$ - угадал(а) с 4-ой попытки!" +
                "\n20$ - угадал(а) с 5-ой попытки!" +
                "\n10$ - угадал(а) с 6-ой попытки!\n" +

                "6. Всего есть 6 уровня сложности: легкий(0-10), средний(0-30), сложный(0-50), случайный(0-???), Пользовательский(сами настраиваете...) + казино...(в разработке)\n" +
                "Казино:\n" +
                "1. 50/50 – игрок либо удваивает ставку, либо теряет всё.\n" +
                "2. Колесо удачи – выпадает случайный множитель (x0, x0.5, x1, x2, x5 ...).\n" +
                "3. Кости – кидаешь 2 кубика, если сумма выше 7 – выигрываешь x2.\n");

    }

    public void mainMenu() {
        System.out.print("beta 2.7\n" +
                "1 - Угадай число\n" +
                "2 - Казино\n" +
                "3 - Правила\n" +
                "4 - Статистика\n" +
                "5 - Магазин\n" +
                "Ввод: ");
    }

    public void level() {
        System.out.print("1 - легкий(0-10)\n" +
                "2 - средний(0-30)\n" +
                "3 - сложный(0-50)\n" +
                "4 - случайный(0-???)\n" +
                "5 - Пользовательский\n" +
                "Ввод: ");
    }

    public void statistics() {
        //int numGames;
        Scanner in = new Scanner(System.in);
        String reset;
        GameStats gameStats = new GameStats();

        System.out.println("Beta");
        gameStats.showStats();
        System.out.println("Баланс: " + Main.getBalance());
        System.out.print("'1' - сбросить\n" +
                "Ввод: ");
        reset = in.nextLine();
        if (reset.equals("1")) {
            gameStats.setGamesPlayed(0);
            gameStats.setGamesWon(0);
            gameStats.setTotalWins(0);
            gameStats.setTotalBets(0);
            Main.setBalance(0);
        }
    }

    /*public void casino() {

    }*/

}
