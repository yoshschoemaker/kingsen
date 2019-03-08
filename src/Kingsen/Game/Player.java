package Kingsen.Game;

public class Player {
    private int id;
    private String name;
    private int penaltyScore;

    public Player(String name) {
        this.name = name;
        penaltyScore = 0;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setPenaltyScore(int penaltyScore) {
        this.penaltyScore = penaltyScore;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public int getPenaltyScore() {
        return penaltyScore;
    }
}
