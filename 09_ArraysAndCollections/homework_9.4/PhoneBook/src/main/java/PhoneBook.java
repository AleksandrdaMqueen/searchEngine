import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PhoneBook {
    private final HashMap<String, String> phones = new HashMap<>();
    private final String regex4name = "([А-я]+)";
    private final String regex4phone = "([0-9]{10,11})";

    private final Pattern pattern4name = Pattern.compile(regex4name);
    private final Pattern pattern4phone = Pattern.compile(regex4phone);


    public void addContact(String phone, String name) {


        Matcher matcher4name = pattern4name.matcher(name);
        Matcher matcher4phone = pattern4phone.matcher(phone);



        if (!matcher4phone.matches() || !matcher4name.matches()  ) {
            System.out.println("Невалидный  ввод");

        } else {
            phones.put(name, phone);
        }
        // проверьте корректность формата имени и телефона (отдельные методы для проверки)
        // если такой номер уже есть в списке, то перезаписать имя абонента
    }

    public String getContactByPhone(String phone) {
        String name = "";

        if (phones.containsValue(phone)) {
            for (String key : phones.keySet()) {
                name += key  + " - " + phones.get(key);
            }

            return name;
        }else {
            return "";
        }
        // формат одного контакта "Имя - Телефон"
        // если контакт не найдены - вернуть пустую строку

    }

    public Set<String> getContactByName(String name) {
        TreeSet<String> contactByName = new TreeSet<>();

        if (phones.containsKey(name)) {
            for (String key : phones.keySet()) {
                contactByName.add(key + " - " + phones.get(name));
            }

            return contactByName;
        }else {
            return new TreeSet<>();
        }
        // формат одного контакта "Имя - Телефон"
        // если контакт не найден - вернуть пустой TreeSet

    }

    public Set<String> getAllContacts() {
        TreeSet<String> phoneList = new TreeSet<>();
        if (phones != null) {
            for (Map.Entry<String, String> entry : phones.entrySet()) {
                String key = entry.getKey(); // получения ключа
                String value = entry.getValue(); // получения ключа
                phoneList.add(key + " - " + value);
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
