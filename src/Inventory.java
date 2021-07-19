import java.util.ArrayList;

public class Inventory {
    ArrayList<Item> stock = new ArrayList<>();
    ArrayList<Order> orders = new ArrayList<>();

    public void addInventory(Item item){
        boolean found = false;
        //loop checks for the item being already in the list item if is in the list .. it increases the quantity
        for(Item i:stock){
            if (i.name.equals(item.name)){
                i.quantity+=item.quantity;
                i.price= item.price;
                found=true;
                break;
            }
        }
        //if item is not already in the list new item is added
        if(!found) stock.add(item);
    }



    public void getInventory(){
        for(int i=0;i<stock.size();i++){
            System.out.println(stock.get(i));
        }
    }

    public void addOrders(Order order){
        orders.add(order);
    }

    public void getOrders(){
        System.out.println("-----------Completed Orders-----------");

        orders.forEach(order->{
            System.out.print("\nCustomer Name: "+order.customerName+
                    "\nOrder Total: "+ order.orderTotal +" rupees\n"+"Items: \n"
            );
            order.orderItems.forEach(item-> System.out.println(item));
                });
    }

    @Override
    public String toString() {
        return "Inventory{" +
                "items=" + stock +
                '}';
    }
}
