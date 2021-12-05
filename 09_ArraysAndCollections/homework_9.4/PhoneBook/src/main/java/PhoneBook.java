
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


        if (!matcher4phone.matches() || !matcher4name.matches()) {
            System.out.println("Невалидный  ввод");

        } else if (phones.containsValue(phone)) {
            for (Map.Entry<String, String> entry : phones.entrySet()) {
                String value = entry.getValue();
                phones.replace(value, name);
                break;

            }


        } else {
            phones.put(phone, name);
        }
        // проверьте корректность формата имени и телефона (отдельные методы для проверки)
        // если такой номер уже есть в списке, то перезаписать имя абонента
    }

    public String getContactByPhone(String phone) {
        StringBuilder name = new StringBuilder();

        if (phones.containsKey(phone)) {
            for (Map.Entry<String, String> entry : phones.entrySet()) {
                String key = entry.getKey(); // получения ключа
                String value = entry.getValue(); // получения ключа

                if (key.equals(phone)) {
                    name.append(value).append(" - ").append(key);
                }
            }

            return name.toString();
        } else {
            return "";
        }
        // формат одного контакта "Имя - Телефон"
        // если контакт не найдены - вернуть пустую строку

    }

    public Set<String> getContactByName(String name) {
        TreeSet<String> contactByName = new TreeSet<>();

        if (phones.containsValue(name)) {
            for (Map.Entry<String, String> entry : phones.entrySet()) {
                String key = entry.getKey(); // получения ключа
                String value = entry.getValue(); // получения ключа

                if (value.equals(name)) {
                    if(contactByName.isEmpty()){
                        contactByName.add(value + " - " + key);
                    }

                }
            }

            return contactByName;
        } else {
            return new TreeSet<>();
        }
        // формат одного контакта "Имя - Телефон"
        // если контакт не найден - вернуть пустой TreeSet

    }

    public Set<String> getAllContacts() {
        HashSet<String> phoneList = new HashSet<>();


        if (!phones.isEmpty()) {
            for (String value : phones.values()) {
                StringBuilder result = new StringBuilder(value + " - ");
                for (Map.Entry<String, String> entry : phones.entrySet()) {
                    if (value.equals(entry.getValue())) {
                        String key = entry.getKey();
                        result.append(key).append(", ");
                    }
                }
                phoneList.add(result.substring(0, result.length() - 2));
            }
            return phoneList;
        }
        return new TreeSet<>();


    }


    // формат одного контакта "Имя - Телефон"
    // если контактов нет в телефонной книге - вернуть пустой TreeSet

}
