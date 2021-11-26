mport java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PhoneBook {
    private  final HashMap<String, String> phones = new HashMap<>();

    public void addContact(String phone, String name) {
        String regex4name = "([А-я]+)";
        String regex4phone = "([0-9]{10,11})";

        Pattern pattern4name = Pattern.compile(regex4name);
        Matcher matcher4name = pattern4name.matcher(phone);

        Pattern pattern4phone = Pattern.compile(regex4phone);
        Matcher matcher4phone = pattern4phone.matcher(phone);
        if (!matcher4phone.matches() || !matcher4name.matches() ) {
            System.out.println("Невалидный  ввод");
        } else {
            phones.put(phone, name);
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
        TreeSet<String> contactByName= new TreeSet<>();
        if (phones.containsValue(name)) {
            for(String key : phones.keySet()){
                if(Objects.equals(phones.get(key), name)){
                    contactByName.add(key);
                }
            }

            return contactByName;
        }
        return new TreeSet<>();
        // формат одного контакта "Имя - Телефон"
        // если контакт не найден - вернуть пустой TreeSet

    }

    public Set<String> getAllContacts() {
        TreeSet<String> phoneList = new  TreeSet<>();
        if (phones != null) {
            for (Map.Entry<String, String> entry : phones.entrySet()){
                String key = entry.getKey(); // получения ключа
                String value = entry.getValue(); // получения ключа
                phoneList.add(key + " - "+value);
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
