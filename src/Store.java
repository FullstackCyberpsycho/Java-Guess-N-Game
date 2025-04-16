import java.io.File;
import java.util.Scanner;

public class Store {
    private int b;

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
                if (!Main.getSellGeme(Main.fiftyFiftyF).equals("123")) {
                    Main.setSellGeme(Main.fiftyFiftyF, "123");
                    b -= 1000;
                    Main.setBalance(b);
                    System.out.println("Куплено");
                }
                break;
            case "2":
                if (!Main.getSellGeme(Main.wheelOfFortuneF).equals("321")) {
                    Main.setSellGeme(Main.wheelOfFortuneF, "321");
                    b -= 2500;
                    Main.setBalance(b);
                    System.out.println("Куплено");
                }
                break;
            case "3":
                if (!Main.getSellGeme(Main.crapsF).equals("231")) {
                    Main.setSellGeme(Main.crapsF, "231");
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
                "1 - 50/50 (цена - 1000)\n" +
                "2 - Колесо удачи(цена - 2500)\n" +
                "3 - Кости(цена - 3500)\n" +
                "Ввод: ");
    }
}
