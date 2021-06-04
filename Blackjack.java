import java.util.Scanner;

public class Blackjack {

    public static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("\nWelcome to Tamara's Casino!");
        System.out.println("Do you have a knack for Black Jack?");
        System.out.println("---I dunno why I ask :)");
        System.out.println("Are you Ready? Press anything to begin!");

        //Wait for the user 
        scan.nextLine();

        //Two random cards
        int card1=drawRandomCard();
        int card2= drawRandomCard();
        System.out.println("\nYou get a \n" + cardString(card1) + "\n and a \n" + cardString(card2));

        // Math.min so if any card is bigger than 10 the value of those cards will be 10. Jack, Queen or King (10points each instead of 11,12,13) 
        int cardSum1= Math.min(card1,10) + Math.min(card2,10);  
        System.out.println("\nYour total is: \n" + cardSum1);
        System.out.println("Pres Enter to continue");
        scan.nextLine();

        int card3=drawRandomCard();
        int card4= drawRandomCard();
        System.out.println("The dealer gets \n" + cardString(card3) + "\nand has a card facing down \n" + faceDown());
        int cardSum2=Math.min(card3,10) + Math.min(card4,10); 
        System.out.println("Dealer's total is hidden");

        //Player1's Turn
        while(true){
            String option= hitStay();

            if(option.equalsIgnoreCase("STAY")){
                break;
            }
            int cardExtra=drawRandomCard();
            System.out.println("\n You get a: \n" + cardString(cardExtra));
            cardSum1 += Math.min(cardExtra,10);
            System.out.println("\n Your New Total is: \n" + cardSum1);

            if(cardSum1>21){
                System.out.println("Bust! You lose");
                System.exit(0);
            }
        }
        //Dealer's Turn
        System.out.println("Dealer's turn");
        System.out.println("The dealer's cards are \n"+ cardString(card3) +"\n and a \n"+ cardString(card4));
        while(cardSum2 < 17){
            int cardExDealer=drawRandomCard();
            System.out.println("\n Dealer gets a: \n" + cardString(cardExDealer));
            cardSum2 += Math.min(cardExDealer,10);
            System.out.println("\n Dealer's New Total is: \n" + cardSum2);
        }
        if(cardSum2 > 21){
            System.out.println("Bust! Dealer loses");
                System.exit(0);
        }
        if (cardSum1 > cardSum2 || cardSum1 == cardSum2){
            System.out.println("Player wins!");
        } else {
            System.out.println("Dealer wins!");
        }


         scan.close();

    }

    public static int drawRandomCard(){
        double randomNum =Math.random()*13;
        randomNum +=1;
        return (int)randomNum;

    }

    public static String cardString(int cardNumber){
        switch (cardNumber) {
            case 1: return 

                    "   _____\n"+
                    "  |A _  |\n"+ 
                    "  | ( ) |\n"+
                    "  |(_'_)|\n"+
                    "  |  |  |\n"+
                    "  |____V|\n" ;
            case 2:return
                    "   _____\n"+
                    "  |2    |\n"+
                    "  |  o  |\n"+
                    "  |     |\n"+
                    "  |  o  |\n"+
                    "  |____Z|\n";

            case 3:return
                    "   _____\n" +
                    "  |3    |\n"+
                    "  | o o |\n"+
                    "  |     |\n"+
                    "  |  o  |\n"+
                    "  |____E|\n";
            case 4:return
                    "   _____\n" +
                    "  |4    |\n"+
                    "  | o o |\n"+
                    "  |     |\n"+
                    "  | o o |\n"+
                    "  |____h|\n";

            case 5:return
                    "   _____ \n" +
                    "  |5    |\n" +
                    "  | o o |\n" +
                    "  |  o  |\n" +
                    "  | o o |\n" +
                    "  |____S|\n";
            case 6:return
                    "   _____ \n" +
                    "  |6    |\n" +
                    "  | o o |\n" +
                    "  | o o |\n" +
                    "  | o o |\n" +
                    "  |____6|\n";
            case 7:return
                    "   _____ \n" +
                    "  |7    |\n" +
                    "  | o o |\n" +
                    "  |o o o|\n" +
                    "  | o o |\n" +
                    "  |____7|\n";
            case 8:return
                    "   _____ \n" +
                    "  |8    |\n" +
                    "  |o o o|\n" +
                    "  | o o |\n" +
                    "  |o o o|\n" +
                    "  |____8|\n";
            case 9:return
                    "   _____ \n" +
                    "  |9    |\n" +
                    "  |o o o|\n" +
                    "  |o o o|\n" +
                    "  |o o o|\n" +
                    "  |____9|\n";
            case 10:return
                    "   _____ \n" +
                    "  |10  o|\n" +
                    "  |o o o|\n" +
                    "  |o o o|\n" +
                    "  |o o o|\n" +
                    "  |___10|\n";
            case 11:return
                    "   _____\n" +
                    "  |J  ww|\n"+
                    "  | o {)|\n"+
                    "  |o o% |\n"+
                    "  | | % |\n"+
                    "  |__%%[|\n";
            case 12:return
                        "   _____\n" +
                        "  |Q  ww|\n"+
                        "  | o {(|\n"+
                        "  |o o%%|\n"+
                        "  | |%%%|\n"+
                        "  |_%%%O|\n";
            case 13:return
                        "   _____\n" +
                        "  |K  WW|\n"+
                        "  | o {)|\n"+
                        "  |o o%%|\n"+
                        "  | |%%%|\n"+
                        "  |_%%%>|\n";

            default: return "no found";

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
    

    public static String hitStay(){
        System.out.println("Decide if 'HIT' or 'STAY'?");
        String decision=scan.nextLine();

        while(!(decision.equalsIgnoreCase("hit") || decision.equalsIgnoreCase("stay"))){
            System.out.println("Please, make sure you write either 'HIT' or 'STAY'.");
            decision=scan.nextLine();
        }
        return decision;
    }
}

