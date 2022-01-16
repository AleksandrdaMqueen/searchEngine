import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CustomerStorage {
    private final Map<String, Customer> storage;
    private final String regex4Phone = "[+][0-9]{11}";
    private final String regex4Email = "([A-z]+@[A-z]+\\.[a-z]+)";
    private final Pattern pattern1 = Pattern.compile(regex4Email);
    private final Pattern pattern = Pattern.compile(regex4Phone);

    public CustomerStorage() {
        storage = new HashMap<>();
    }

    public void addCustomer(String data) throws IllegalAccessException {
        final int INDEX_NAME = 0;
        final int INDEX_SURNAME = 1;
        final int INDEX_EMAIL = 2;
        final int INDEX_PHONE = 3;



            String[] components = data.split("\\s+");
            Matcher matcher = pattern.matcher(components[INDEX_PHONE]);
            Matcher matcher1 = pattern1.matcher(components[INDEX_EMAIL]);
            if (components.length != 4){
                throw new IllegalArgumentException();
            }else if(!matcher.matches()){
                throw new IllegalArgumentException();
            }else if(!matcher1.matches()){
                throw new IllegalArgumentException();
            }
            String name = components[INDEX_NAME] + " " + components[INDEX_SURNAME];
            storage.put(name, new Customer(name, components[INDEX_PHONE], components[INDEX_EMAIL]));

    }

    public void listCustomers() {
        storage.values().forEach(System.out::println);
    }

    public void removeCustomer(String name) {
        storage.remove(name);
    }

    public Customer getCustomer(String name) {
        return storage.get(name);
    }

    public int getCount() {
        return storage.size();
    }
}
