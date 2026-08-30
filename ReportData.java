public class ReportData{
    //Declaring final fields because I don't want them to change
    private String code;
    private String name;
    private String category;
    private String supplier;
    //Declaring fields that can be updated
    private String warranty;
    private double price;
    private int stock_level;

    //Constructing a constructor which will help in initializing these fields
    public ReportData(String code, String name, String category, String supplier, 
                      String warranty, double price, int stock_level){
        this.code = code;
        this.name = name;
        this.category = category;
        this.supplier = supplier;
        this.warranty = warranty;
        this.price = price;
        this.stock_level = stock_level;
    }

    /*Construct setter methods to access the data attribute
      these following setter methods will allow only three attributes to be modified*/
    public void set_warranty(String warranty){
        this.warranty = warranty;
    }
    public void set_price(double price){
        this.price = price;
    }
    public void set_stock_level(int stock_level ){
        this.stock_level = stock_level;
    }

    /*Constructing getter methods to called the fields
      All field will may be called hence they all need getter methods
      They are returning information  */
    public String get_code(){
        return code;
    }
    public String get_name(){
        return name;
    }
    public String get_category(){
        return category;
    }
    public String get_supplier(){
        return supplier;
    }
    public String get_warranty(){
        return warranty;
    }
    public double get_price(){
        return price;
    }
    public int get_stock_level(){
        return stock_level;
    }
    
}