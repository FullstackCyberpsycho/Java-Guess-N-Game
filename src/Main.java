import java.io.*;
import java.util.Scanner;

public class Main{
    private static int balance = 0;
    static File balanceF = new File("src/resources/balance.txt");
    static File fiftyFiftyF = new File("src/resources/getFiftyFifty.txt");
    static File wheelOfFortuneF = new File("src/resources/getWheelOfFortune.txt");
    static File crapsF = new File("src/resources/getCraps.txt");

    public static void main(String[] args) throws IOException, InterruptedException {
        start();
    }

    private static void start() throws IOException, InterruptedException {
        Scanner scanner = new Scanner(System.in);
        String numLevel, choice;
        PrintInfo print = new PrintInfo();

        while (true) {
            print.mainMenu();
            choice = scanner.nextLine();
            switch (choice) {
                case "1":
                    print.level();
                    numLevel = scanner.nextLine();
                    new RunLeve(numLevel);
                    break;
                case "2": new Casino(); break;
                case "3": print.rules(); break;
                case "4": print.statistics(); break;
                case "5": new Store(); break;
            }
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

    public static void setSellGeme(File gameF, String key) {
        try (FileWriter fileWriter = new FileWriter(gameF, false)) {
            fileWriter.write(key);
        } catch (IOException e) {
            System.out.println("Ошибка при записи баланса.");
        }
    }

    public static String getSellGeme(File gameF) {
        String date = "";
        try {
            Scanner myReader = new Scanner(gameF);
            if (myReader.hasNextLine()) {
                date = myReader.nextLine().trim();
            }
            myReader.close();
        } catch (IOException | NumberFormatException e) {
            System.out.println("Ошибка при чтении баланса.");
        }
        return date;
    }

}