import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static String firstPlayerName;
    static String secondPlayerName;
    static int ROUNDS = 2;


    public static void main(String[] args) {

        displayMenu();
        ArrayList<Player> arrPlayers = new ArrayList<Player>();
        Player p1 = new Player(firstPlayerName);
        Player p2 = new Player(secondPlayerName);
        arrPlayers.add(p1);
        arrPlayers.add(p2);
        startGame(arrPlayers);
        showWinner(findWinner(arrPlayers));
    }

    public static void runRound(Player player, int rounds) {
        System.out.println("######## " + player.getName() + " turn ########");
        Question que = new Question();
        System.out.print(que.toString(rounds));
        Date startDate = new Date();
        int answer = sc.nextInt();
        System.out.println("_____________________");
        if (answer == que.getResult()) {
            Date endDate = new Date();
            player.increaseScore((int) ((endDate.getTime() - startDate.getTime()) / 1000));
        }
    }
    public static void displayMenu(){

        System.out.println("----------------------------------------------------------");
        System.out.println("--------------- Arithmetic Operations Game ---------------");
        System.out.println("----------------------------------------------------------");
        System.out.println("Whats the name of the first player?");
        firstPlayerName = sc.next();
        System.out.println("Whats the name of the second player?");
        secondPlayerName = sc.next();
    }

    public static void startGame(ArrayList<Player> players){
        int round = 1;
        while (round <= ROUNDS) {

            for(Player p :players) {
                runRound(p, round);
                System.out.println(p.getName() + " Score: " + p.getScore());
                System.out.println('\n');
            }
            round++;
        }
    }

    public static Player findWinner(ArrayList<Player> arrPlayers){
        Player topPlayer = new Player();

        for (Player player:arrPlayers){
            if(player.getScore() > topPlayer.getScore())
                topPlayer = player;
        }
        return topPlayer;
    }

    public static void showWinner(Player winner){
        System.out.println("The Winnner is @"+winner.getName()+"@\nScore:"+winner.getScore()+"\n"+"Congratulation");
    }
}
