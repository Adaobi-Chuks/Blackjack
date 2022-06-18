import java.util.Scanner;

public class Blackjack {

    public static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("\nWelcome to Java Casino!\n");
        System.out.println("Do you have a knack for Black Jack?");
        System.out.println("We shall see..\n");
        System.out.println("..Ready? Press anything to begin!");
        scan.nextLine();

        int unum1 = drawRandomCard();
        int unum2 = drawRandomCard();
        int total = Math.min(unum1, 10) + Math.min(unum2, 10);
        
        System.out.println("You get a \n" + cardString(unum1) + "\n and a \n" + cardString(unum2));
        System.out.println("your total is: " + (total));
        scan.nextLine();
        int cnum1 = drawRandomCard();
        int cnumb2 = drawRandomCard();
        int ctotal = Math.min(cnum1, 10) + Math.min(cnumb2, 10);

        System.out.println("The dealer shows \n" + cardString(cnum1) + "\nand has a card facing down \n" + faceDown());
        System.out.println("The dealer's total is hidden\n");
       
        String response = hitOrStay();
        while (response.equalsIgnoreCase("hit")) {
            int newNum = drawRandomCard();
            total += Math.min(newNum, 10);
            System.out.println("\nYou get a\n" + cardString(newNum));
            System.out.println("Your new total is " + total);
            if (total > 21) {
                System.out.println("Bust! Player loses.\n");
                System.exit(0);
            }
            response = hitOrStay();
            if (response.equals("stay")) {
                break;
            }
        }
        System.out.println("Dealer's turn");
        System.out.println("The dealer's cards are\n" + cardString(cnum1) + "\nand a \n" + cardString(cnumb2));
        System.out.println("\nThe dealer's total is:" + ctotal);
        scan.nextLine();
        while (ctotal < 17) {
            int cNewN = drawRandomCard();
            ctotal += Math.min(cNewN, 10);
            System.out.println("\nDealer gets a \n" + cardString(cNewN));
            System.out.println("Dealer's total is " + ctotal);
        }
        if (ctotal > 21) {
            System.out.println("Bust! Dealer loses.\n");
            System.exit(0);
        }
        if (total > ctotal) {
            System.out.println("Player wins!\n");
        } else if (total == ctotal) {
            System.out.println("It's a tie!\n");
        } else {
            System.out.println("Dealer wins\n");
        }
        scan.close();
    }

    public static int drawRandomCard() {
        double randomDouble = Math.random() * 13;
        randomDouble += 1;
        int randomInt = (int)randomDouble;
        return randomInt;
    }
    
    public static String cardString(int cardNumber) {
        switch (cardNumber) {
            case 1 : return "   _____\n"+
                            "  |A _  |\n"+ 
                            "  | ( ) |\n"+
                            "  |(_'_)|\n"+
                            "  |  |  |\n"+
                            "  |____V|\n"; 

            case 2 : return "   _____\n"+              
                            "  |2    |\n"+ 
                            "  |  o  |\n"+
                            "  |     |\n"+
                            "  |  o  |\n"+
                            "  |____Z|\n"; 

            case 3 : return "   _____\n" +
                            "  |3    |\n"+
                            "  | o o |\n"+
                            "  |     |\n"+
                            "  |  o  |\n"+
                            "  |____E|\n";

            case 4 : return "   _____\n" +
                            "  |4    |\n"+
                            "  | o o |\n"+
                            "  |     |\n"+
                            "  | o o |\n"+
                            "  |____h|\n";

            case 5 : return "   _____ \n" +
                            "  |5    |\n" +
                            "  | o o |\n" +
                            "  |  o  |\n" +
                            "  | o o |\n" +
                            "  |____S|\n";

            case 6 : return "   _____ \n" +
                            "  |6    |\n" +
                            "  | o o |\n" +
                            "  | o o |\n" +
                            "  | o o |\n" +
                            "  |____6|\n";

            case 7 : return "   _____ \n" +
                            "  |7    |\n" +
                            "  | o o |\n" +
                            "  |o o o|\n" +
                            "  | o o |\n" +
                            "  |____7|\n";

            case 8 : return "   _____ \n" +
                            "  |8    |\n" +
                            "  |o o o|\n" +
                            "  | o o |\n" +
                            "  |o o o|\n" +
                            "  |____8|\n";

            case 9 : return "   _____ \n" +
                            "  |9    |\n" +
                            "  |o o o|\n" +
                            "  |o o o|\n" +
                            "  |o o o|\n" +
                            "  |____9|\n";

            case 10 : return "   _____ \n" +
                            "  |10  o|\n" +
                            "  |o o o|\n" +
                            "  |o o o|\n" +
                            "  |o o o|\n" +
                            "  |___10|\n";

            case 11 : return "   _____\n" +
                            "  |J  ww|\n"+ 
                            "  | o {)|\n"+ 
                            "  |o o% |\n"+ 
                            "  | | % |\n"+ 
                            "  |__%%[|\n";

            case 12 : return "   _____\n" +
                            "  |Q  ww|\n"+ 
                            "  | o {(|\n"+ 
                            "  |o o%%|\n"+ 
                            "  | |%%%|\n"+ 
                            "  |_%%%O|\n";

            case 13 : return "   _____\n" +
                            "  |K  WW|\n"+ 
                            "  | o {)|\n"+ 
                            "  |o o%%|\n"+ 
                            "  | |%%%|\n"+ 
                            "  |_%%%>|\n";
            default: return "404";
        }
    }

    public static String faceDown() {
        return
        "   _____\n"+
        "  |     |\n"+ 
        "  |  J  |\n"+
        "  | JJJ |\n"+
        "  |  J  |\n"+
        "  |_____|\n";
    }
    
    public static String hitOrStay() {
        System.out.println("Would you like to hit or stay");
        String hitOrStay = scan.next();
        while (!hitOrStay.equalsIgnoreCase("hit") && !hitOrStay.equalsIgnoreCase
        ("stay")) {
            System.out.println("Please write 'hit' or 'stay'");
            hitOrStay = scan.next();
        }
        return hitOrStay;
    }
}