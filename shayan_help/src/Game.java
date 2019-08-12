import java.util.*;
import java.util.ArrayList;

public class Game {
	
	private Player p;
	private Deck cards;
    private String playerHand="";
    private Card test;

	public Game(String[] testHand){
		// This constructor is to help test your code
		// use the contents of testHand to
		// make a hand for the player
		// use the following encoding for cards
		// c = clubs
		// d = diamonds
		// h = hearts
		// s = spades
		// 1-13 correspond to ace - king
		// example: s1 = ace of spades
		// example: testhand = {s1, s13, s12, s11, s10} = royal flush
		p=new Player();
        p.bets(1);
        for(int i = 0; i < testHand.length; i++) {
        	System.out.println(testHand[i]);
        }
        System.out.println("suit = " + testHand[1].charAt(0));
        System.out.println("number = " + Integer.parseInt(testHand[1].valueOf(1)));
        Card card1 = new Card(testHand[1].charAt(0), Integer.parseInt(testHand[1].substring(1,2)));
        p.addCard(card1);
        Card card2 = new Card(testHand[2].charAt(0), Integer.parseInt(testHand[2].substring(1,2)));
        p.addCard(card2);
        Card card3 = new Card(testHand[3].charAt(0), Integer.parseInt(testHand[3].substring(1,2)));
        p.addCard(card3);
        Card card4 = new Card(testHand[4].charAt(0), Integer.parseInt(testHand[4].substring(1,2)));
        p.addCard(card4);
        Card card5 = new Card(testHand[5].charAt(0), Integer.parseInt(testHand[5].substring(1,2)));
        p.addCard(card5);
        /*for(int i=0; i<5; i++){
            if(testHand[i].valueOf(0)=="c"){
                test=new Card(1, (Integer.parseInt(testHand[i].substring(1))));
                p.addCard(test);
            }
            else if(testHand[i].valueOf(0)=="d"){
                test=new Card(2, (Integer.parseInt(testHand[i].substring(1))));
                p.addCard(test);
            }
            else if(testHand[i].valueOf(0)=="h"){
                test=new Card(3, (Integer.parseInt(testHand[i].substring(1))));
                p.addCard(test);
            }
            else if(testHand[i].valueOf(0)=="s"){
                test=new Card(4, (Integer.parseInt(testHand[i].substring(1))));
                p.addCard(test);
            }                  
        }*/
        checkHand(p.getHand());
        //p.score();
        System.out.println(p.score());
	}
	
	public Game(){
		// This no-argument constructor is to actually play a normal game
		p=new Player();
        cards=new Deck();
	}
	
	public void play(){
		// this method should play the game	
		cards.shuffle();
        dealHand();
        System.out.println("Welcome! Here is your hand: ");
        checkHand(p.getHand());
        System.out.println(playerHand);
        Scanner input=new Scanner(System.in);
        System.out.println("Bet between 1 and 5 tokens.");
        int b=input.nextInt();
        while(b<1||b>5){
            System.out.println("Bet between 1 and 5 tokens only.");
            b=input.nextInt();
        }
        p.bets(b);
        System.out.println("How many cards would you like to replace?");
		int r=input.nextInt(); 
        while(r<0||r>5){
            System.out.println("Please enter a number between 0 and 5 only.");
            r=input.nextInt();
        }
        if(r==5){
            for(int i=0; i<5; i++){
                changeHand(i);
            }
        }
        else if(r!=0){
            for(int j=r; j>0; j--){
                System.out.println("Enter position of card to change (1-5)");
                int c=input.nextInt()-1;
                while(c<0||c>4){
                    System.out.println("Re-enter number. Must be from 1 to 5.");
                    c=input.nextInt()-1;
                }
                changeHand(c);
            }
        }
        playerHand="";
        checkHand(p.getHand());
        p.score();
        System.out.println(p.score());
        System.out.println("Here's your final hand:"+playerHand);
        System.out.println("Enter 1 to finish the game or 2 to play again!");
        int a=input.nextInt();
        while(!(a==1 || a==2)){
            System.out.println("Please enter 1 to finish or 2 to play again!");
            a=input.nextInt();
        }
        playAgain(a);
        //playagain method?
        //print the checkHand and you are done
        //need to account for bad input (does not input 1-5)
        
	}
    
	
	public String checkHand(ArrayList<Card> hand){
		// this method should take an ArrayList of cards
		// as input and then determine what evaluates to and
		// return that as a String
        Collections.sort(p.getHand());
        for(int z=0; z<hand.size(); z++){
            playerHand+=hand.get(z).toString()+"  ";
        }
        
        return playerHand;
	}
    
    public void dealHand(){
        for(int i=0; i<5; i++){
            p.addCard(cards.deal());
        }
    }
    
    public void changeHand(int n){
        p.setCard(n, cards.deal());
    }
    
    public void playAgain(int a){
        if(a==1){
            System.out.println("End of game! Final Score: "+p.getBankroll());
        }
        if(a==2){
            //make sure hand cards not replayed
            while(p.getHand().size()>0){
                p.removeCard(p.getHand().get(0));
            }
            playerHand="";
            play();
        }
    }

	// you will likely want many more methods here
	// per discussion in class
}

