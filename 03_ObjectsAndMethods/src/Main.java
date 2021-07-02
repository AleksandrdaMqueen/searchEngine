public class Main {

    public static void main(String[] args) {
        Basket basket = new Basket();
        basket.add("xleb", 2, 6);
        basket.add("maslo", 2, 3);
        basket.add("ky", 9,1);
        basket.add("ogurec", 5, 4);
        basket.add("oihl",8,1);
        Basket basket1 = new Basket();
        basket.add("opopo",1,5);
        System.out.println("Общее кол-во корзин: " + Basket.getCount());
        System.out.println("Сумма всех товаров: " + Basket.getTotalPriceOfProducts());
        System.out.println("Общее кол-во товаров: " + Basket.getTotalCountOfProducts());
        System.out.println("Средняя цена всех корзин:" + Basket.getAveragePriceOfProduct());
        System.out.println(Basket.getAveargePriceOfBasket());
    }
}
