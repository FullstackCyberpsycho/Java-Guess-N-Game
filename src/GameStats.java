public class GameStats {
    private int gamesPlayed;
    private int gamesWon;
    private int totalBets;
    private int totalWins;

    public GameStats(int gamesPlayed, int gamesWon, int totalBets, int totalWins) {
        this.gamesPlayed = gamesPlayed;
        this.gamesWon = gamesWon;
        this.totalBets = totalBets;
        this.totalWins = totalWins;
    }

    public GameStats() {}

    public int getGamesPlayed() {
        return gamesPlayed;
    }

    public void setGamesPlayed(int gamesPlayed) {
        this.gamesPlayed = gamesPlayed;
    }

    public int getGamesWon() {
        return gamesWon;
    }

    public void setGamesWon(int gamesWon) {
        this.gamesWon = gamesWon;
    }

    public int getTotalBets() {
        return totalBets;
    }

    public void setTotalBets(int totalBets) {
        this.totalBets = totalBets;
    }

    public int getTotalWins() {
        return totalWins;
    }

    public void setTotalWins(int totalWins) {
        this.totalWins = totalWins;
    }

    public void showStats() {
        System.out.println("\nСтатистика:");
        System.out.println("Игр сыграно: " + gamesPlayed);
        System.out.println("Побед: " + gamesWon);
        System.out.println("Процент побед: " + (gamesPlayed > 0 ? (gamesWon * 100 / gamesPlayed) + "%" : "0%"));
        System.out.println("Всего поставлено: " + totalBets + "$");
        System.out.println("Всего выиграно: " + totalWins + "$");
    }
}

