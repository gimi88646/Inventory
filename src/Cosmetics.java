public class Cosmetics extends Item {
    Cosmetics(String name, int quantity,double price){
        super(name,quantity,price);
    }

    @Override
    public String toString() {
        return "Type : Cosmetics"+
                "\tName : "+name+
                "\tQuantity : "+ quantity +
                "\tprice : "+price;
    }



}
