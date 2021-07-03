public class Main {


    public static void main(String[] args) {
        Basket basket = new Basket();
        basket.add("xleb", 2, 6);
        basket.add("maslo", 2, 3);
        basket.add("ky", 9,1);
        basket.add("ogurec", 5, 4);
        basket.add("oil",8,1);
        Basket basket1 = new Basket();
        basket1.add("Pomidor",1,5);
        System.out.println("Общее кол-во корзин: " + Basket.count);
        System.out.println("Сумма всех товаров: " + Basket.totalPriceOfProducts);
        System.out.println("Общее кол-во товаров: " + Basket.totalCountOfProducts);
        System.out.println("Средняя цена всех корзин:" + Basket.getAveragePriceOfProducts());
        System.out.println("Среднее значение корзины: " + Basket.getAveargePriceOfBasket());
    }
}