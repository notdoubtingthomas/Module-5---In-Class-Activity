import java.util.Scanner;

/**
 * Part B: Mini-Project — Inventory Management System (Student Starter with TODOs)
 *
 * Requirements:
 * 1) Use a for loop to display product names and quantities.
 * 2) Use a while loop to allow continuous updates until exit.
 * 3) Use a do-while loop to validate quantity input (must be an int >= 0).
 */
public class InventorySystem{

    public static void main(String[] args) {
        String[] products = {"Laptop", "Smartphone", "Tablet", "Headphones", "Smartwatch"};
        int[] quantities = {10, 15, 8, 20, 12};

        Scanner scanner = new Scanner(System.in);

        // TODO: Print the initial inventory using a for loop
        // Example:
        // 1. Laptop - Qty: 10
        // 2. Smartphone - Qty: 15
        // ...
        for(int i = 0; i < products.length; i++){
            System.out.println((i+1) + ". " + products[i] + " - " + "Qty: " + quantities[i]);
        }

        boolean running = true;

        // TODO: Use a while loop to repeat a menu until user exits:
        // Menu options:
        // 1) Display Inventory
        // 2) Update Quantity
        // 0) Exit
        int choice;
        while(running){
            System.out.println("Enter choice (1 to display inventory, 2 to update quantity, 0 to exit): ");
            choice = scanner.nextInt();
            switch(choice){
                case 1:
                    for(int i = 0; i < products.length; i++){
                        System.out.println((i+1) + ". " + products[i] + " - " + "Qty: " + quantities[i]);
                    }
                    break;
                case 2:
                    System.out.println("Enter product number (1...N): ");
                    int product = scanner.nextInt();
                    if(product < 1 || product > products.length){
                        System.out.println("Invalid product number!");
                        break;
                    }
                    int newQuantity;
                    do {
                        System.out.println("Enter new quantity (greater than or equal to 0): ");
                        while(!scanner.hasNextInt()){
                            System.out.println("Invalid quantity!");
                            scanner.next();
                        }

                        newQuantity = scanner.nextInt();
                        if(newQuantity < 0 ){
                            System.out.println("Quantity must be greater than 0!");
                        }
                    } while(newQuantity < 0);
                    quantities[product-1] = newQuantity;
                    System.out.println("Quantity updated!");
                    break;
                case 0:
                    running = false;
                    break;
                default:
                    break;
            }
        }

        // Hints:
        // - Read choice as int
        // - Use if/switch to handle options
        // - For Update:
        //   - Ask which product number (1..N)
        //   - Validate product selection
        //   - Use do-while to validate new quantity:
        //       - must be integer (use scanner.hasNextInt())
        //       - must be >= 0
        //   - Update quantities[productIndex]

        System.out.println("Goodbye!");
        scanner.close();
    }
}
