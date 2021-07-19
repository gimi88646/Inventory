
import java.util.Scanner;

public class InventoryDriver {
    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {

        Inventory inv = new Inventory();

        while (true){
            int choice;
            System.out.print("*************  WELCOME TO ABC INVENTORY  *************\n"+
                    "Please enter your choice\n"+
                    "1. Add inventory\n"+
                    "2. Add order\n"+
                    "3. Show inventory\n"+
                    "4. Show orders\n"+
                    "5. Show all details\n"+
                    "6. Exit system\n\n"+
                    "Your choice: "
            );
            choice= input.nextInt();
            switch (choice){
                case 1:{
                    int choice1;
                    while (true){
                        System.out.print("Please select item type\n"+
                                "1. Electronics\n" +
                                "2. Cosmetics\n" +
                                "3. Clothes\n\n" +
                                "Your choice: "
                        );
                        choice1=input.nextInt();
                        switch (choice1){
                            /** CASE ELECTRONICS*/

                            case 1: {
                                System.out.print("^^^^^^^ ELECTRONICS ^^^^^^^\n"+
                                        "Enter name: "
                                );
                                String name = input.next();

                                System.out.print("Enter quantity: ");
                                int quantity = input.nextInt();

                                System.out.print("Enter price: ");
                                double price = input.nextDouble();
                                inv.addInventory(new Electronics(name,quantity,price));
                                break;


                            }
                            /** CASE COSMETICS*/

                            case 2: {
                                System.out.print("^^^^^^^ COSMETICS ^^^^^^^\n"+
                                        "Enter name: "
                                );
                                String name = input.next();

                                System.out.print("Enter quantity: ");
                                int quantity = input.nextInt();

                                System.out.print("Enter price: ");
                                double price = input.nextDouble();
                                inv.addInventory(new Cosmetics(name,quantity,price));
                                break;
                            }

                            /** CASE CLOTHES*/
                            case 3: {
                                System.out.print("^^^^^^^ CLOTHES ^^^^^^^\n"+
                                        "Enter name: "
                                );
                                String name = input.next();

                                System.out.print("Enter quantity: ");
                                int quantity = input.nextInt();

                                System.out.print("Enter price (per piece): ");
                                double price = input.nextDouble();
                                inv.addInventory(new Clothes(name,quantity,price));
                                break;
                            }
                        }

                        int choiceD;
                        System.out.print("Do you want to add more items?\n"+
                                "1. yes\n"+
                                "2. no\n\n"+
                                "your choice: "
                        );
                        choiceD=input.nextInt();
                        if(choiceD==1)continue;
                        else if(choiceD==2)break;

                    }
                    break;

                } //case completed    add inventory
                case 2:{
                    /**
                     * if quantity of an item in an order is greater than the quantity of available items in the inventory the order should not execute
                     * every order has an an item in it
                     * when placing two attributes are required that is name of an item and its quantity
                     */
                    String customerName;
                    String product;
                    int quantity;
                    int choiceInsideOrder;

                    System.out.print("Enter Customer name: ");
                    customerName= input.next();
                    Order order = new Order();
                    order.customerName=customerName;

                    while(true){
                        System.out.print("\nYour can add items from the following list\n\n");
//                        when adding items to the order... it should display the inventory items
                        inv.getInventory();

                        System.out.print("Enter product name: ");
                        product = input.next();
                        System.out.print("Enter quantity: ");
                        quantity= input.nextInt();

                        //checks for the availability of item if available and demanded quantity is valid ,
                        // then it initializes the item and adds to items-list in Order object
                        boolean found = false;
                        for (Item item:inv.stock){
//
                            if (item.name.equals(product) && item.quantity>=quantity) {
                                if (item instanceof Clothes) {
                                    order.addItem(new Clothes(product, quantity, item.price));
                                }
                                else if(item instanceof Cosmetics){
                                    order.addItem(new Cosmetics(product,quantity,item.price));
                                }
                                else if (item instanceof Electronics){
                                    order.addItem(new Electronics(product,quantity,item.price));
                                }
                                item.quantity-=quantity;
                                found=true;
                            }
                            else if(item.name.equals(product) && item.quantity<quantity){
                                System.out.println("Sorry only "+item.quantity+" number of "+product+" items are available");
                                found=true;
                            }
                        }
                        if (!found) System.out.println("Sorry, the item is not available!");
                        System.out.println(" ----------------------------\n"+
                                           "|       ORDER DETAILS       |\n"+
                                           " ----------------------------"
                                );

                        //print total of the item and ordered items
                        System.out.println("Total Amount: "+order.orderTotal+"\nItems: ");
                        order.orderItems.forEach(item -> System.out.println(item));

                        System.out.print("1. Add more items"+
                                "\n2. Complete order\n"+
                                "Your choice: "
                                );
                        choiceInsideOrder = input.nextInt();
                        if(choiceInsideOrder==1) {continue;}
                        else{
                            inv.addOrders(order);
                            break;}
                    }
                    break;

                }
                // case show inventory
                case 3:{
                    int choiceInsideShowInventory;
                    inv.getInventory();
                    System.out.print("Enter 1 to go back: ");
                    while(input.nextInt()!=1) ;
                    break;
                } //completed show inventory
                case 4:{
                    inv.getOrders();
                    System.out.print("Enter 1 to go back: ");
                    while(input.nextInt()!=1) ;
                    break;
                }//show orders
                case 5:{
                    System.out.println("-----------Inventory Items-----------");
                    inv.getInventory();
                    System.out.println();
                    inv.getOrders();
                    System.out.print("Enter 1 to go back: ");
                    while(input.nextInt()!=1) ;
                    break;
                }//completed show inventory and orders
                case 6:{
                    System.out.println("\nHope to see you again..\n\n    bye bye!!!");
                    System.exit(0);}

            }
        }
    }

}
