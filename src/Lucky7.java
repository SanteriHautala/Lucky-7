import java.util.Random;
import java.util.Scanner;
public class Lucky7 {
    public static void main(String[] args) throws Exception {
        Random r = new Random();
        Scanner in = new Scanner (System.in);
        String playAgain;
        int balance = 25;

        int bet = 0;
        while (bet < 1 || bet > 5){
            System.out.print("Set your bet(1-5)");
            bet = in.nextInt();

            if (bet > balance){
                System.out.println("You don't have enough money for that bet! Your balance is "+ balance);
                bet = 0;
            }
        }
        in.nextLine();

        do{
            balance -= bet;

            System.out.println("balance: " + balance +(" Bet: " + bet));
            System.out.println("Good luck!");

            int num1 = r.nextInt(10) + 1;
            int num2 = r.nextInt(10) + 1;
            int num3 = r.nextInt(10) + 1;

            System.out.println(num1 + " " + num2 + " " + num3);

            int seiskat = 0;
            if(num1 == 7) seiskat++;
            if(num2 == 7) seiskat++;
            if(num3 == 7) seiskat++;

            if (seiskat == 0){
                int win = 0 * bet;
                System.out.println("unlucky..");
                balance +=win;
            }

            if (seiskat == 1){
                int win = 3 * bet;
                System.out.println("You won " + win + "!");
                balance +=win;
            } else if (seiskat == 2) {
                int win = 10 * bet;
                System.out.println("You won " + win + "!");
                balance += win;
            } else if (seiskat == 3) {
                int win = 30 * bet;
                System.out.println("You won " + win + "!");
                balance += win;
            } 

            if (balance < bet){
                System.out.println("You don't have enough balance for that bet. Your balance is: " + balance);
                break;
            }
            System.out.print("Spin again by pressing Enter (or type 'e' and press Enter to exit): ");
            playAgain = in.nextLine();

        } while (!playAgain.equalsIgnoreCase("e"));

        in.close();
    }
}