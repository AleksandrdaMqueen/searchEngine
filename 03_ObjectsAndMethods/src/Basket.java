public class Basket {

    private static int count = 0;
    private String items = "";
    private int totalPrice = 0;
    private int limit;
    private static int totalPriceOfProducts = 0;
    private static int totalCountOfProducts = 0 ;

    public static int getAveargePriceOfBasket(){
        return totalPriceOfProducts / count;
    }

    public static double getAveragePriceOfProduct(){
        return totalPriceOfProducts / totalCountOfProducts;
    }

    public void increaseTotalPriceOfProducts(int totalPriceOfProducts) {
        Basket.totalPriceOfProducts = Basket.totalPriceOfProducts + totalPriceOfProducts;
    }

    public void increaseTotalCountOfProducts(int totalCountOfProducts){
        Basket.totalCountOfProducts = Basket.totalCountOfProducts + totalCountOfProducts;
    }

    public static int getTotalPriceOfProducts() {
        return totalPriceOfProducts;
    }

    public static int getTotalCountOfProducts(){
        return totalCountOfProducts;
    }

    public Basket() {
        totalPriceOfProducts = totalPriceOfProducts + totalPrice;
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
        this.items = this.items + items;
        this.totalPrice = totalPrice;
    }

    public static int getCount() {
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
            System.out.println("Error occured :(");
            return;
        }

        items = items + "\n" + name + " - " +
                count + " шт. - " + price;
        totalPrice = totalPrice + count * price;
        totalPriceOfProducts = totalPriceOfProducts + price * count;
        totalCountOfProducts = totalCountOfProducts + count;
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