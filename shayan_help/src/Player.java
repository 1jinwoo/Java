import java.util.ArrayList;
import java.util.*;

public class Player {
	
	private ArrayList<Card> hand; // the player's cards
	private double bankroll=100;
    private double bet;

	// you may choose to use more instance variables
		
	public Player(){		
	    // create a player here
	    hand=new ArrayList<Card>(5);
	}

	public void addCard(Card c){
	    // add the card c to the player's hand
	    hand.add(c);
	}

	public void removeCard(Card c){
	    // remove the card c from the player's hand
	    hand.remove(c);
    }
    
    public void setCard(int i, Card c){
        hand.set(i, c);
    }
		
   public void bets(double amt){
        // player makes a bet
        bet=amt;
        bankroll-=bet;
        
   }

   public void winnings(double odds){
       // adjust bankroll if player wins
       double win=odds*bet;
       bankroll+=win;
   }

   public double getBankroll(){
        // return current balance of bankroll
        return bankroll;
   }
    
   public boolean onePair(){
       int c=0;
       for(int i=1; i<5; i++){
           if(hand.get(i-1).getRank()==hand.get(i).getRank()){
               c++;
           }
       }
       if(c==1){
           return true;
       }
       return false;
   }
    
   public boolean twoPairs(){
       int c=0;
       for(int i=1; i<5; i++){
           if(hand.get(i-1).getRank()==hand.get(i).getRank()){
               c++;
           }
       }
       if(c==2){
           return true;
       }
       return false;   
   }
    
   public boolean threeOfaKind(){
       int c=0;
       for(int i=1; i<5; i++){
           if(hand.get(i-1).getRank()==hand.get(i).getRank()){
               c++;
           }
       }
       if(c==3){
           return true;
       }
       return false;   
   }
    
   public boolean straight(){
       for(int i=1; i<5; i++){
           if(hand.get(i-1).getRank() != (hand.get(i).getRank()-1)){
               return false;
           }
       }
       return true;
   }
    
   public boolean flush(){
       int c=0;
       for(int i=1; i<5; i++){
           if(hand.get(i-1).getSuit()==hand.get(i).getSuit()){
               c++;
           }
       }
       if(c==5){
           return true;
       }
       return false;   
   }
    
   public boolean fullHouse(){
       if(threeOfaKind()&&onePair()){
           return true;
       }
       return false;
   }
    
   public boolean fourOfaKind(){
       int c=0;
       for(int i=1; i<5; i++){
           if(hand.get(i-1).getRank()==hand.get(i).getRank()){
               c++;
           }
       }
       if(c==4){
           return true;
       }
       return false;
   }
    
   public boolean straightFlush(){
       if(straight()&&flush()){
           return true;
       }
       return false;
   }
    
   public boolean royalFlush(){
	   System.out.println(hand);
       if(hand.get(0).getRank()==13&&hand.get(1).getRank()==12&&
         hand.get(2).getRank()==11&&hand.get(3).getRank()==10
         &&hand.get(4).getRank()==1){
           return true;
       }
       return false;
   }
    
   public ArrayList<Card> getHand(){
       return hand;
   }
   
   public String score(){
       if(royalFlush()){
           winnings(250);
           return "Royal Flush";
       }
       else if(straightFlush()){
           winnings(50);
           return "Straight Flush";
       }
       else if(fourOfaKind()){
           winnings(25);
           return "Four of a Kind";
       }
       else if(fullHouse()){
           winnings(6);
           return "Full House";
       }
       else if(flush()){
           winnings(5);
           return "Flush";
       }
       else if(straight()){
           winnings(4);
           return "Straight";
       }
       else if(threeOfaKind()){
           winnings(3);
           return "Three of a Kind";
       }
       else if(twoPairs()){
           winnings(2);
           return "Two Pairs";
       }
       else if(onePair()){
           winnings(1);
           return "One Pair";
       }
       else{
           winnings(0);
           return "No Pairs";
       }
   }
       
}



