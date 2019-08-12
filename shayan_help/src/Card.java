public class Card implements Comparable<Card>{
	
	private int suit; // use integers 1-4 to encode the suit
	private int rank; // use integers 1-13 to encode the rank
    private String ranks[]={"Ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", 
                            "Jack", "Queen", "King"};//array of ranks
    //array of suits
    private String suits[]={"Clubs", "Diamonds", "Hearts", "Spades"};
    
	public Card(int s, int r){
		//make a card with suit s and value v
		suit=s;
        rank=r;   
	}
    
	public int compareTo(Card c){
        // use this method to compare cards so they 
		// may be easily sorted
		int compareRank=c.getRank();
        int compareSuit=c.getSuit();
        if(compareRank>this.rank){
            return 1;
        }
        else if(compareRank<this.rank){
            return -1;
        }
        else if(compareRank==this.rank){
            if(compareSuit>this.suit){
                return 1;
            }
            else{
                return -1;
            }
        }
		return 0;
	}
	
	public String toString(){
		// use this method to easily print a Card object
		System.out.println("problematic index: " + (rank-1));
		System.out.println("problematic index: " + (suit-1));

		return ranks[rank-1] + " of " + suits[suit-1];
	}
    
    public int getRank(){
        return rank;
    }
    
    public int getSuit(){
        return suit;
    }

}

