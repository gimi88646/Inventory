public class Clothes extends Item {
    Clothes(String name, int quantity,double price){
        super(name,quantity,price);
    }

    @Override
    public String toString() {
        return "Type : Clothes"+
                "\tName : "+name+
                "\tQuantity : "+ quantity +
                "\tprice : "+price;
    }
}
