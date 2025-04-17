import java.io.File;
import java.util.Scanner;

public class Store {
    private int b;
    private String keyGame[] = {"123", "321", "231"};

    Store() {
        this.b = Main.getBalance();
        start();
    }

    public void start() {
        Scanner in = new Scanner(System.in);

        info();
        String choise = in.nextLine();

        switch (choise) {
            case "1":
                if (!Main.getSellGeme(Main.fiftyFiftyF).equals(keyGame[0])) {
                    Main.setSellGeme(Main.fiftyFiftyF, keyGame[0]);
                    b -= 1000;
                    Main.setBalance(b);
                    System.out.println("Куплено");
                }
                break;
            case "2":
                if (!Main.getSellGeme(Main.wheelOfFortuneF).equals(keyGame[1])) {
                    Main.setSellGeme(Main.wheelOfFortuneF, keyGame[1]);
                    b -= 2500;
                    Main.setBalance(b);
                    System.out.println("Куплено");
                }
                break;
            case "3":
                if (!Main.getSellGeme(Main.crapsF).equals(keyGame[2])) {
                    Main.setSellGeme(Main.crapsF, keyGame[2]);
                    b -= 3500;
                    Main.setBalance(b);
                    System.out.println("Куплено");
                }
                break;
        }
    }

    private void info() {
        System.out.print("Магазин:\n\n" +
                "Купить игры казино:\n" +
                "1 - 50/50(цена - 1000)\n" +
                "2 - Колесо удачи(цена - 2500)\n" +
                "3 - Кости(цена - 3500)\n" +
                "Ввод: ");
    }
}
