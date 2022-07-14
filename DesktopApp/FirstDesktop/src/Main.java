import javax.swing.*;
import javax.swing.text.MaskFormatter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.beans.PropertyChangeListener;
import java.text.ParseException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main extends JFrame {




    public static void main(String[] args) {
          String regex = "[a-zA-Zа-яА-Я]+";

        JFrame frame = new JFrame();

        JPanel panel = new JPanel();

        JTextField lastName = new JTextField();
        JTextField name = new JTextField();
        JTextField patronymic = new JTextField();


        JButton expand = new JButton();
        expand.setText("Expand");
        JButton collapse = new JButton();
        collapse.setText("Collapse");
        collapse.addActionListener(new Action() {
            @Override
            public Object getValue(String key) {
                return null;
            }

            @Override
            public void putValue(String key, Object value) {

            }

            @Override
            public void setEnabled(boolean b) {

            }

            @Override
            public boolean isEnabled() {
                return false;
            }

            @Override
            public void addPropertyChangeListener(PropertyChangeListener listener) {

            }

            @Override
            public void removePropertyChangeListener(PropertyChangeListener listener) {

            }

            @Override
            public void actionPerformed(ActionEvent e) {
//
                if (name.getText().isEmpty() || lastName.getText().isEmpty()){
                    JOptionPane.showMessageDialog(
                            panel, "Поле \"Имя\" или поле \"Фамилия\" не заполненны. Пожалуйста, заполните их.","Ошибка",JOptionPane.PLAIN_MESSAGE
                    );
                }
                else {
                    JOptionPane.showMessageDialog(panel,lastName.getText() + " "+ name.getText() + " "+ patronymic.getText(),"ФИО", JOptionPane.PLAIN_MESSAGE);

                    panel.remove(collapse);
                    panel.add(expand);

                }
            }
        });

        expand.addActionListener(new Action() {
            @Override
            public Object getValue(String key) {
                return null;
            }

            @Override
            public void putValue(String key, Object value) {

            }

            @Override
            public void setEnabled(boolean b) {

            }

            @Override
            public boolean isEnabled() {
                return false;
            }

            @Override
            public void addPropertyChangeListener(PropertyChangeListener listener) {

            }

            @Override
            public void removePropertyChangeListener(PropertyChangeListener listener) {

            }

            @Override
            public void actionPerformed(ActionEvent e) {
           Pattern pattern = Pattern.compile(regex);
          Matcher matcher = pattern.matcher(name.getText());
           if (!matcher.matches()){
               JOptionPane.showMessageDialog(panel,"Некорректное имя или фамилия");
          }else{
               JOptionPane.showMessageDialog(panel,lastName.getText() + " "+ name.getText() + " "+ patronymic.getText(),"ФИО", JOptionPane.PLAIN_MESSAGE);

           }
            }
        });

        patronymic.setColumns(19);
        name.setColumns(19);
        lastName.setColumns(19);
        panel.add(new JLabel("Фамилия"));
        panel.add(lastName);
        panel.add(new JLabel("Имя"));
        panel.add(name);
        panel.add(new JLabel("Отчество"));
        panel.add(patronymic);
        panel.add("Collapse",collapse);
        frame.setSize(600,400);
        frame.add(panel);



        frame.setVisible(true);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
}
