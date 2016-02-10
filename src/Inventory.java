import java.util.ArrayList;
import java.util.Scanner;

public class Inventory {

    static Items createItem(String name, int quantity, String category) {
        if (category.equals("Alcohol")) {
            Alcohol newAlcohol = new Alcohol(name, quantity);
            return newAlcohol;
        }
        if (category.equals("Desserts")) {
            return new Desserts(name, quantity);
        }
        if (category.equals("SodaJuice")) {
            return new SodaJuice(name, quantity);
        }
        if (category.equals("Food")) {
            return new Food(name, quantity);
        }
        if (category.equals("Seafood")) {
            return new Seafood(name, quantity);
        }
        return null;
    }

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
                System.out.printf("Enter amount of %s\n", itemName);
                int quantity = Integer.valueOf(input.nextLine());
                System.out.printf("What is the category of %s\n", itemName);
                String newCategory = input.nextLine();
               // Items newItem = new Items(itemName, quantity);
                Items newItem = createItem(itemName, quantity, newCategory);
                items.add(newItem);
            } else if (choice.equals("1")) {
                if (items.isEmpty()) {

                } else {
                    System.out.println("Select an item to modify:");
                    int i = 1;
                    for (Items tempItem : items) {
                        System.out.printf("%d. %s - %d : %s\n", i, tempItem.itemName, tempItem.quantity, tempItem.category);
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
                            int newquantity = Integer.valueOf(input.nextLine());
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