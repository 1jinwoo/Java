
public class PokerTest{
    
    //this class must remain unchanged
    //your code must work with this test class
    public static void main(String[] args){
        /*if (args.length<1){
            Game g = new Game();
            g.play();
        }
        else{*/
    	String[] testHand = {"pokerTest", "s1", "s2", "s3", "s4", "s5"};
            Game g = new Game(testHand);
            g.play();
       /* }
    }*/

}
}