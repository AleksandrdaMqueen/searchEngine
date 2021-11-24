import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PhoneBook {
    private  final HashMap<String, String> phones = new HashMap<>();

    public void addContact(String phone, String name) {
        String regex4pone = "([0-9]{10,11})";

        Pattern pattern = Pattern.compile(regex4pone);
        Matcher matcher = pattern.matcher(phone);

        if (!matcher.matches()) {
            System.out.println("Невалидный  номер");
        } else {
            phones.put(name, phone);
        }
        // проверьте корректность формата имени и телефона (отдельные методы для проверки)
        // если такой номер уже есть в списке, то перезаписать имя абонента
    }

    public String getContactByPhone(String phone) {
        for (int i = 0; i < phones.size(); i++) {

            if (phones.containsValue(phone)) {
                return phones.get(phone);

            }
        }
        // формат одного контакта "Имя - Телефон"
        // если контакт не найдены - вернуть пустую строку
        return "";
    }

    public Set<String> getContactByName(String name) {
        if (phones.containsKey(name)) {
            return Collections.singleton(name + " - " + phones.get(name));

        }
        // формат одного контакта "Имя - Телефон"
        // если контакт не найден - вернуть пустой TreeSet
        return new TreeSet<>();
    }

    public Set<String> getAllContacts() {
        TreeSet<String> phoneList = new  TreeSet<>();
        if (!phones.isEmpty()) {
            for (int i = 0; i < phones.size(); i++) {
                phoneList.add(phones.get(i));
            }
            return phoneList;

        }
        // формат одного контакта "Имя - Телефон"
        // если контактов нет в телефонной книге - вернуть пустой TreeSet
        return new TreeSet<>();

    }

    // для обхода Map используйте получение пары ключ->значение Map.Entry<String,String>
    // это поможет вам найти все ключи (key) по значению (value)
    /*
        for (Map.Entry<String, String> entry : map.entrySet()){
            String key = entry.getKey(); // получения ключа
            String value = entry.getValue(); // получения ключа
        }
    */
}
