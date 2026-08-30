import java.util.ArrayList; //Import to access the ArrayList Class
import java.util.Scanner; 
public class Products {
    //ArrayLists are mutable hence there are the best option for this inventory class
    //Scanner class may be used by most of the methods in this class
    private Scanner keyboard = new Scanner(System.in);
    private ArrayList<ReportData> products;

    //Constructing a constructor for the products location: array
    public  Products(){
        products = new ArrayList<>();
    }
    
    /*The following methods are managing how the products accessed or inserted 
      there is a topic of each method at the top of it*/
    
    //This method displays menu to the user
    public boolean display_menu(){
        //Some options need code name to call some methods
        String product_code ;
        System.out.println("Please select one of the following menu items:");
        System.out.println("(1) Capture a new product.");
        System.out.println("(2) Search for a product.");
        System.out.println("(3) Update a product.");
        System.out.println("(4) Delete a product.");
        System.out.println("(5) Print Report.");
        System.out.println("(6) Exit Application.");

        int option = keyboard.nextInt();
        keyboard.nextLine();
        //There are may options to choose from, if-else blocks do not look good
        switch (option) {
            case 1: //You are capturing a new product
                capture_product();
                break;
            case 2: //You are searching a product
                System.out.print("Enter the product code: ");
                product_code = keyboard.nextLine();
                display_product(product_code);
                break;
            case 3: //You are updating a product
                System.out.print("Enter the product code: ");
                product_code = keyboard.nextLine();
                update_product(product_code);
                break;
            case 4: //You are deleting a product
                System.out.print("Enter the product code: ");
                product_code = keyboard.nextLine();
                delete_product(product_code);
                break;
            case 5: //You are printing a report of products
                display_report();
                break;
            case 6: //You are closing the application
                return true;
            default://The choice is not in the option
                System.out.println("Invalid input.");
                break;
        }
        return false;
    }
    //This method captures a new product
    public void capture_product(){
        /*I need temporary variables to store to store data from the user
          so that they can be passed to the construct on the ReportData class*/
        String code;
        String name;
        String category = ""; //This needs to be initialized in-case the switch block fail to initialize it
        String supplier;
        String warranty;
        double price;
        int stock_level;
        int option;

        //Heading
        System.out.println("CAPTURE A NEW PRODUCT");
        System.out.println("*************************");

        System.out.print("Enter the product code: ");
        code = keyboard.nextLine();
        System.out.print("Enter the product name: ");
        name = keyboard.nextLine();
        System.out.println("Select the product category:");
        System.out.println("Desktop Computer - 1");
        System.out.println("Laptop - 2");
        System.out.println("Tablet - 3");
        System.out.println("Printer - 4");
        System.out.println("Gaming Console - 5");

        System.out.print("\nProduct Category >> ");
        option = keyboard.nextInt();
        //The user is required to insert the correct input hence there is a loop below
        while(option < 1 || option > 5){
            System.out.print("Invalid input \nProduct Category >> ");
            option = keyboard.nextInt();
        }
        keyboard.nextLine();
        switch (option) {
            case 1: category = "Desktop Computer";
                break;
            case 2: category = "Laptop";
                break;
            case 3: category = "Tablet";
                break;
            case 4: category = "Printer";
                break;
            case 5: category = "Gaming Console";
                break;
            default: // this block will never be executed but the statement is for formality
                System.out.println("Invalid Input");
                break;
        }

        System.out.print("Indicate the product warranty. Enter (1) for 6 months or any other key for 2 years. ");
        warranty = keyboard.nextLine();
        if(warranty.equals("1")){
            warranty = "6 months";
        }
        else{
            warranty = "2 years";
        }
        System.out.print("Enter the price for " + name + " >> ");
        price = keyboard.nextDouble();
        System.out.print("Enter the stock level for " + name + " >> ");
        stock_level = keyboard.nextInt();
        keyboard.nextLine();
        System.out.print("Enter the supplier for " + name + " >> ");
        supplier = keyboard.nextLine();

        //Instantiation of the object which is a product
        ReportData product = new ReportData(code, name, category, supplier, warranty, price, stock_level);
        save_product(product);
    }

    //This method will save the product to the ArrayList
    public void save_product(ReportData product){
        products.add(product);
        System.out.println("Products details has been saved successfully!!!");
    }

    //This method will help in finding a products and return it to a method that will need it(product)
    public ReportData search_product(String product_code){
        //The loop will search in the ArrayList if there is a code provided
        for(ReportData product: products){
            if(product.get_code().equals(product_code)){
                return product;
            }
        }
        return null;
    }

    //This method will display the product that is search
    public void display_product(String product_code){
        //This temporary objects helps in not keep on searching the product each each I want to access its attribute
        ReportData product = search_product(product_code);
        if(product == null){
            System.out.println("The product cannot be located. Invalid Product");
            return;
        }
        System.out.println("*******************************************************");
        System.out.println("PRODUCT SEARCH RESULTS");
        System.out.println("*******************************************************");
        System.out.println("PRODUCT CODE:          " + product.get_code());
        System.out.println("PRODUCT NAME:          " + product.get_name());
        System.out.println("PRODUCT WARRANTY:      " + product.get_warranty());
        System.out.println("PRODUCT CATEGORY:      " + product.get_category());
        System.out.println("PRODUCT PRICE:         " + product.get_price());
        System.out.println("PRODUCT STOCK LEVEL:   " + product.get_stock_level());
        System.out.println("PRODUCT SUPPLIER:      " + product.get_supplier());
        System.out.println("*******************************************************");
    }

    //This method will display the full report 
    public void display_report(){
        if(products.size() == 0){
            System.out.println("Products cannot be found");
            return;
        }
        int product_numb = 1;
        int total_products = products.size();
        double total_product_value = 0;
        double average;
        System.out.println("PRODUCT REPORT");
        System.out.println("=============================================================");
        for(int i = 0; i < products.size(); i++){
            System.out.println("PRODUCT " + product_numb);
            System.out.println("-------------------------------------------------------------");
            System.out.println("PRODUCT CODE>>         " + products.get(i).get_code());
            System.out.println("PRODUCT NAME>>         " + products.get(i).get_name());
            System.out.println("PRODUCT WARRANTY>>     " + products.get(i).get_warranty());
            System.out.println("PRODUCT CATEGORY>>     " + products.get(i).get_category());
            System.out.println("PRODUCT PRICE>>        " + products.get(i).get_price());
            System.out.println("PRODUCT STOCK LEVEL>>  " + products.get(i).get_stock_level());
            System.out.println("PRODUCT SUPPLIER>>     " + products.get(i).get_supplier());
            System.out.println("-------------------------------------------------------------");
            product_numb++;
            total_product_value += (products.get(i).get_price() * products.get(i).get_stock_level());
        }
        average = total_product_value/total_products;
        System.out.println("=============================================================");
        System.out.println("TOTAL PRODUCT COUNT: " + total_products);
        System.out.println("TOTAL PRODUCT VALUE: " + total_product_value);
        System.out.println("AVERAGE PRODUCT VALUE: " + average);
    }

    //This method will update the product chosen
    public void update_product(String product_code){
        //Declaring local variables that may be updated in the product
        String warranty;
        double price;
        int stock_level;
        char option;
        boolean is_updated = false;
        ReportData product = search_product(product_code);
        if(product == null){
            System.out.println("The product cannot be located. Invalid Product");
            return;
        }
        System.out.print("Update the warranty? (y) Yes, (n) No ");
        option = keyboard.nextLine().toUpperCase().charAt(0);
        if(option == 'Y'){
            System.out.print("Indicate the new product warranty. Enter (1) for 6 months or any other key for 2 years. ");
            warranty = keyboard.nextLine();
            if(warranty.equals("1")){
                product.set_warranty("6 months");
            }
            else{
                product.set_warranty("2 years");
            }
            is_updated = true;
        }
        System.out.print("Update the product price? (y) Yes, (n) No ");
        option = keyboard.nextLine().toUpperCase().charAt(0);
        if(option == 'Y'){
            System.out.print("Enter the new price for " + product.get_name() + " >> ");
            price = keyboard.nextDouble();
            keyboard.nextLine();
            product.set_price(price);
            is_updated = true;
        }
        System.out.print("Update the stock level? (y) Yes, (n) No ");
        option = keyboard.nextLine().toUpperCase().charAt(0);
        if(option == 'Y'){
            System.out.print("Enter the new stock level for " + product.get_name() + " >> ");
            stock_level = keyboard.nextInt();
            keyboard.nextLine();
            product.set_stock_level(stock_level);
            is_updated = true;
        }
        if (is_updated){
            System.out.println("Product details has been updated successfully!!!");
        }
        else{
            System.out.println("Product details were not updated!!!");
        }
    }

    //This method will delete the product from the saved Arraylist
    public void delete_product(String product_code){
        ReportData product = search_product(product_code);
        if(product != null){
            products.remove(product);
            System.out.println("The products has been successfully deleted");
        }
        else{
            System.out.println("Product cannot be located. Invalid input");
        }
    }

    //This method starts and terminates the application
    public void exit_application(){
        String option;
        boolean exit;
       do{
            System.out.println("Enter (1) to launch menu or any other key to exit");
            option = keyboard.nextLine();
            if(option.equals("1")){
                exit = display_menu();
            }
            else{
                    break;
            }
       }while(!exit);
       keyboard.close();
    }
}
