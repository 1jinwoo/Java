import java.util.Random;

public class Deck {
	
	private Card[] cards;
	private int top=-1; // the index of the top of the deck
    private int count;
    private int t;//keep index for top of deck when dealing cards

	// add more instance variables if needed
	
	public Deck(){
		// make a 52 card deck here
		cards=new Card[52];
        for(int suit=1; suit<5; suit++){
            for(int rank=1; rank<14; rank++){
                cards[count]=new Card(suit, rank);
                count++;
            }
        }
	}
	
	public void shuffle(){
        Random random=new Random();
        random.nextInt();
        for(int i=0; i<cards.length; i++){
            int f=random.nextInt(52);
            Card temp=cards[i];
            cards[i]=cards[f];
            cards[f]=temp;
        }
        top=-1;
		// shuffle the deck here
	}
	
	public Card deal(){
        if(top==51){
            shuffle();
            top=-1;
        }
        top++;
        return cards[top];
		// deal the top card in the deck
	}
	
	// add more methods here if needed

}

