import java.util.ArrayList;
import java.util.Scanner;

public class Inventory {
    public static void main(String[] args) {
        ArrayList<Items> items = new ArrayList<>();
        Scanner input = new Scanner(System.in);

        while (true) {

            System.out.println("What would you like to do? [1]Inventory List [2]Create New Item");
            String choice = input.nextLine();

            if (choice.equals("2")) {
                System.out.println("Enter item name:");
                String itemName = input.nextLine();
                itemName = itemName.substring(0, 1).toUpperCase() + itemName.substring(1);
                System.out.println("Enter amount of " + itemName + ":");
                String quantity = input.nextLine();

                Items newItem = new Items(itemName, quantity);
                items.add(newItem);
            } else if (choice.equals("1")) {
                if (items.isEmpty()) {

                } else {
                    System.out.println("Select an item to modify:");
                    int i = 1;
                    for (Items tempItem : items) {
                        System.out.println(i + ". " + tempItem.itemName + " - " + tempItem.quantity);
                        i++;
                    }

                    String text = input.nextLine();
                    int num = Integer.valueOf(text);
                    Items item = items.get(num - 1);
                    System.out.println("[1]Adjust Quantity");
                    System.out.println("[2]Remove");
                    System.out.println("[3]Go Back");
                    String newchoice = input.nextLine();
                    while (true) {
                        if (newchoice.equals("1")) {
                            System.out.println("Enter new amount:");
                            String newquantity = input.nextLine();
                            item.quantity = newquantity;
                            break;
                        } else if (newchoice.equals("2")) {
                            items.remove(item);
                            System.out.println("Successfully Removed");
                            break;
                        } else if (choice.equals("3")) {
                            break;
                        } else {
                            break;
                        }
                    }
                }
            } else {

            }
        }
    }
}