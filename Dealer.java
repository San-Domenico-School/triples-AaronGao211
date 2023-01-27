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
        
    }
    
    protected void checkIfTriple(ArrayList<Card> cardsOnBoard, Card[]cardsSelected, ArrayList<Integer> selectedCardsIndex)
    {
        //To be implemented 
    }
    
    private void removeAndReplaceTriple()
    {
        
    }
    
    public Dealer(int numCardsInDeck)
    {
        deck = new Deck(numCardsInDeck);
        triplesRemaining = numCardsInDeck / 3;
        Scorekeeper.setDeckSize(numCardsInDeck);
    }
    
}
