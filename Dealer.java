import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList; 
/**
 * Write a description of class Dealer here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Dealer extends Actor
{
    /**
     * Act - do whatever the Dealer wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private Deck deck; 
    private int triplesRemaining;
    
 
    public void addedToWorld(World world)
    {
        dealBoard();
    }
        
    protected void dealBoard()
    {
        for(int row = 0; row < 5; row++)
        {
            for(int column = 0; column < 3; column++)
            {
                getWorld().addObject(deck.getTopCard(),80 + column * 130,80 + row * 80);
            }
        }
               
    }
    
    private void setUI()
    {
        String cardsRemainingText = new Integer(triplesRemaining * 3).toString();
        String scoreText = new Integer(Scorekeeper.getScore()).toString();
        getWorld().showText(cardsRemainingText, 310, 470);
        getWorld().showText(scoreText, 310, 504); 
    } 
    
    protected void checkIfEndGame()
    {
        if(triplesRemaining == 0)
        {
            Greenfoot.stop();
        }
    }
    
    protected void checkIfTriple(ArrayList<Card> cardsOnBoard, Card[]cardsSelected, ArrayList<Integer> selectedCardsIndex)
    {
        int shapes = cardsSelected[0].getShape().ordinal() + cardsSelected[1].getShape().ordinal() + cardsSelected[2].getShape().ordinal();
        
        int shadings = cardsSelected[0].getShading() + cardsSelected[1].getShading() + cardsSelected[2].getShading();
        
        int colors = cardsSelected[0].getColor().ordinal() + cardsSelected[1].getNumberOfShapes() + cardsSelected[2].getNumberOfShapes();
        
        if(shapes % 3 == 0 && shadings % 3 == 0 && colors % 3 == 0)
        {
            removeAndReplaceTriple(cardsOnBoard, cardsSelected, selectedCardsIndex);
        }
        else
        {
            Animations.wobble(cardsSelected);
        }
    }
    
    private void removeAndReplaceTriple(ArrayList<Card> cardsOnBoard, Card[] cardsSelected, 
                                    ArrayList<Integer> selectedCardsIndex)
    {
       // Set position of triple cards by coordinate, 3 cards by 2 coordinates 
       int[][] cardsXYCoordinate = new int[3][2];  
       for(int card = 0; card < 3; card++)
       {
            cardsXYCoordinate[card][0] = cardsSelected[card].getX();
            cardsXYCoordinate[card][1] = cardsSelected[card].getY();
       }
       // Begin card animation off scene view     
       Animations.slideAndTurn(cardsSelected);      

       // Remove and replace triple cards
       for(int card = 0; card < 3; card++)
       { 
           getWorld().removeObject(cardsSelected[card]);
           if(deck.getNumCardsInDeck() > 0)
           {
               cardsOnBoard.set(selectedCardsIndex.get(card),deck.getTopCard());
               getWorld().addObject(cardsOnBoard.get(selectedCardsIndex.get(card)), 
                                                     cardsXYCoordinate[card][0], 
                                                     cardsXYCoordinate[card][1]);
           }
       }
       
       // UI Housekeeping
       triplesRemaining--;
       Scorekeeper.updateScore();
       setUI();
       checkIfEndGame(); 

    }
    
    public Dealer(int numCardsInDeck)
    {
        deck = new Deck(numCardsInDeck);
        triplesRemaining = numCardsInDeck / 3;
        Scorekeeper.setDeckSize(numCardsInDeck);
    }
    
}
