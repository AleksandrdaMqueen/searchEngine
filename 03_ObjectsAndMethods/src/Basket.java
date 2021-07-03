public class Basket {

    public static int count = 0;
    private String items = "";
    private static int totalPrice = 0;
    private int limit;
    public static int totalPriceOfProducts = 0;
    public static int totalCountOfProducts = 0 ;

    public static int getAveargePriceOfBasket(){
        return totalPriceOfProducts / count;
    }

    public static double getAveragePriceOfProducts(){
        return  totalPriceOfProducts/ totalCountOfProducts ;
    }

    public static void increaseTotalPriceOfProducts(int totalPriceOfProducts) {
        Basket.totalPriceOfProducts = Basket.totalPriceOfProducts + totalPriceOfProducts;
    }

    public static void increaseTotalCountOfProducts(int totalCountOfProducts){
        Basket.totalCountOfProducts = Basket.totalCountOfProducts + totalCountOfProducts;
    }

    public  int getTotalPriceOfProducts() {
        return totalPriceOfProducts;
    }

    public  int getTotalCountOfProducts(){
        return totalCountOfProducts;
    }

    public Basket() {
        increaseTotalPriceOfProducts(0);
        increaseTotalCountOfProducts(0);
        increaseCount(1);
        items = "Список товаров:";
        this.limit = 1000000;
    }

    public Basket(int limit) {
        this();
        this.limit = limit;
    }

    public Basket(String items, int totalPrice) {
        this();
        totalPriceOfProducts = totalPriceOfProducts + totalPrice;
        this.items = this.items + items;
        this.totalPrice = totalPrice;
    }

    public  int getCount() {
        return count;
    }

    public static void increaseCount(int count) {
        Basket.count = Basket.count + count;
    }


    public void add(String name, int price) {
        add(name, price, 1);
    }

    public void add(String name, int price, int count) {
        boolean error = false;
        if (contains(name)) {
            error = true;
        }

        if (totalPrice + count * price >= limit) {
            error = true;
        }

        if (error) {
            System.out.println("Error occurred :(");
            return;
        }

        items = items + "\n" + name + " - " +
                count + " шт. - " + price;
        totalPrice = totalPrice + count * price;
        increaseTotalPriceOfProducts(count* price);
        increaseTotalCountOfProducts(count);
    }

    public void clear() {
        items = "";
        totalPrice = 0;
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public boolean contains(String name) {
        return items.contains(name);
    }

    public void print(String title) {
        System.out.println(title);
        if (items.isEmpty()) {
            System.out.println("Корзина пуста");
        } else {
            System.out.println(items);
        }
    }
}

