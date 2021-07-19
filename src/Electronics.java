public class Electronics extends Item{
    Electronics(String name, int quantity,double price){
        super(name,quantity,price);
    }

    @Override
    public String toString() {
        return "Type : Electronics"+
                "\tName : "+name+
                "\tQuantity : "+ quantity +
                "\tprice : "+price;
    }
}
