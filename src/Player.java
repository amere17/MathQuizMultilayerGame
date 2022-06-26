public class Player {
    private String name;
    private double score;
    private double STARS =  5.75;
    public Player(String name) {
        this.name = name;
        this.score = 0;
    }
    Player (){
        this.score = 0;
    }
    public String getName() {
        return name;
    }
    public double getScore() {
        return score;
    }
    public void setName(String name) {
        this.name = name;
    }

    public void increaseScore(int time){
        score += STARS - (STARS*time/60);
        System.out.println(time);
    }
}
