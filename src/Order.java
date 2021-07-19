import java.util.ArrayList;

public class Order {
    public String customerName;
    public double orderTotal;
    ArrayList<Item> orderItems = new ArrayList<>();

    void addItem(Item item){
        orderTotal+=item.price*item.quantity;
        //if item already in the list find the item and increase tha qty
        boolean found=false;
        for (Item orderedItem : orderItems) {
            if (orderedItem.name.equals(item.name)) {
                orderedItem.quantity += item.quantity;
                found=true;
            }
        }
        if(!found){
            orderItems.add(item);
        }
    }
    void removeItem(Item item){

        for(int i=0;i<orderItems.size();i++){
            if (orderItems.get(i).name.equals(item.name)){
                orderItems.remove(i);
                orderTotal-=item.quantity* item.price;

            }
        }
    }

    @Override
    public String toString() {
        return
                "Customer Name: " + customerName + '\n' +
                "Order Total: " + orderTotal + '\n'+
                "Items:\n " + orderItems;
    }
}
