import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class GameStats {
    private int gamesPlayed;
    private int gamesWon;
    private int totalBets;
    private int totalWins;
    private File gamesPlayedF = new File("src/resources/gamesPlayed.txt");
    private File gamesWonF = new File("src/resources/gamesWon.txt");
    private File totalWinsF = new File("src/resources/totalWins.txt");

    public GameStats(int gamesPlayed, int gamesWon, int totalBets, int totalWins) {
        this.gamesPlayed = gamesPlayed;
        this.gamesWon = gamesWon;
        this.totalBets = totalBets;
        this.totalWins = totalWins;
    }

    public GameStats() {}

    public int getGamesPlayed() {
        try {
            if (!gamesPlayedF.exists()) {
                gamesPlayedF.createNewFile();
                setGamesPlayed(0);
            }
            Scanner myReader = new Scanner(gamesPlayedF);
            if (myReader.hasNextLine()) {
                gamesPlayed = Integer.parseInt(myReader.nextLine().trim());
            }
            myReader.close();
        } catch (IOException | NumberFormatException e) {
            System.out.println("Error. Установлен 0.");
        }
        return gamesPlayed;
    }

    public void setGamesPlayed(int gamesPlayed) {
        try (FileWriter fileWriter = new FileWriter(gamesPlayedF, false)) {
            fileWriter.write(String.valueOf(this.gamesPlayed = gamesPlayed));
        } catch (IOException e) {
            System.out.println("Error...");
        }
    }

    public int getGamesWon() {
        try {
            if (!gamesWonF.exists()) {
                gamesWonF.createNewFile();
                setGamesPlayed(0);
            }
            Scanner myReader = new Scanner(gamesWonF);
            if (myReader.hasNextLine()) {
                gamesWon = Integer.parseInt(myReader.nextLine().trim());
            }
            myReader.close();
        } catch (IOException | NumberFormatException e) {
            System.out.println("Error. Установлен 0.");
        }
        return gamesWon;
    }

    public void setGamesWon(int gamesWon) {
        try (FileWriter fileWriter = new FileWriter(gamesWonF, false)) {
            fileWriter.write(String.valueOf(this.gamesWon = gamesWon));
        } catch (IOException e) {
            System.out.println("Error...");
        }
    }

    public int getTotalBets() {
        return totalBets;
    }

    public void setTotalBets(int totalBets) {
        this.totalBets = totalBets;
    }

    public int getTotalWins() {
        try {
            if (!totalWinsF.exists()) {
                totalWinsF.createNewFile();
                setGamesPlayed(0);
            }
            Scanner myReader = new Scanner(totalWinsF);
            if (myReader.hasNextLine()) {
                totalWins = Integer.parseInt(myReader.nextLine().trim());
            }
            myReader.close();
        } catch (IOException | NumberFormatException e) {
            System.out.println("Error. Установлен 0.");
        }
        return totalWins;
    }

    public void setTotalWins(int totalWins) {
        try (FileWriter fileWriter = new FileWriter(totalWinsF, false)) {
            fileWriter.write(String.valueOf(this.totalWins = totalWins));
        } catch (IOException e) {
            System.out.println("Error...");
        }
    }

    public void showStats() {
        System.out.println("\nСтатистика(Угадай число):");

        //System.out.println("Угадай число:");
        System.out.println("Игр сыграно: " + getGamesPlayed());
        System.out.println("Побед: " + getGamesWon());
        System.out.println("Процент побед: " + (getGamesPlayed() > 0 ? (getGamesWon() * 100 / getGamesPlayed()) + "%" : "0%"));
        /*System.out.println("Всего выиграно: " + getTotalWins() + "$");

        System.out.println("\nКазино:");
        System.out.println("Игр сыграно: " );
        System.out.println("Побед: " );
        System.out.println("Процент побед: " );
        System.out.println("Всего поставлено: " + "$");
        System.out.println("Всего выиграно: " + "$");*/
    }
}

