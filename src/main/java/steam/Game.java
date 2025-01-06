package steam;

public class Game {
    protected String name;
    protected String description;
    protected String publisher;
    protected double price;

    protected int positiveReviews;
    protected int negativeReviews;

    public Game(String name, String descriprion, String publisher, double price){
        setName(name);
        setDescription(descriprion);
        setPrice(price);
        setPublisher(publisher);
        positiveReviews = 0;
        negativeReviews = 0;
    }

    public void setName(String name){
        this.name = name;
    }
    public String getName(){
        return name;
    }
    public void setDescription(String description){
        this.description = description;
    }
    public String getDescription(){
        return description;
    }
    public void setPrice(double price){
        this.price = price;
    }
    public double getPrice(){
        return price;
    }
    public void setPublisher(String publisher){
        this.publisher = publisher;
    }
    public String getPublisher(){
        return publisher;
    }

    public int reviewsRate(){
        return (positiveReviews/(positiveReviews+negativeReviews))*100;
    }
}