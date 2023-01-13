import greenfoot.*; 

/**
 * Game Board for Triples
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

public class Card extends Actor
{
   /**
     * Act - do whatever the Cards wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    public enum Shape
    {
        TRIANGLE, SQUARE, CIRCLE, NO_SHAPE
    }
    
    public enum Color
    {
        RED, GREEN, BLUE, NO_COLOR
    }
    
    private Shape shape;
    private Color color;
    private boolean isSelected;
    private GreenfootImage image, selectedImage;
    private int numberOfShapes, shading;  
    
    public Card(Shape shape, Color color, int numberOfShapes, int shading,
    GreenfootImage cardImage, GreenfootImage selectedCardImage)
    {
        this.shape = shape;
        this.color = color;
        this.numberOfShapes = numberOfShapes;
        this.shading = shading;
        image = cardImage;
        this.selectedImage = selectedCardImage; 
        setImage(image);
    }
    
    public boolean getIsSelected()
    {
        return isSelected;
    }
    
    public Shape getShape()
    {
        return shape;
    }
       
    public Color getColor()
    {
        return color;
    }
    
    public int getNumberOfShapes()
    {
        return numberOfShapes; 
    }
    
    public int getShading()
    {
        return shading;
    }
    
    public GreenfootImage getCardImage() 
    {
        return image;
    }
    
    public GreenfootImage getSelectedCardImage()
    {
        return selectedImage;
    }
    
    public void setNumberOfShapes(int num)
    {
        numberOfShapes = num; 
    }
    
    public void setShape(Shape shape)
    {
        this.shape = shape;
    }
       
    public void setColor(Color color)
    {
        this.color = color;
    }
    
    public void setShading(int num)
    {
        this.shading = num;
    }
    
    public void setCardImage(GreenfootImage image) 
    {
        this.image = image; 
    }
    
    public void setSelectedCardImage(GreenfootImage image)
    {
        selectedImage = image;
    }
    
    public void setIsSelected(boolean isSelected)
    {
        this.isSelected = isSelected;
    }
    
}

