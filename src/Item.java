public abstract class Item{
    public String name;
    public double price;
    public int quantity;

    Item(){}
    Item(String name,int quantity,double price){
        this.name=name;
        this.price=price;
        this.quantity = quantity;

    }


    public void setQuantity(int quantity) {
        this.quantity = quantity;

    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public abstract String toString();



}
