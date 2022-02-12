package LoginScreen;

import javax.swing.*;

import static LoginScreen.MainLoginScreen.mainPanel;


public class Fields {

    public static JTextField username_Field;
    public static JPasswordField password_Field;

    public static void addFields() {
        // Username field
        username_Field = new JTextField(15);
        username_Field.setBounds(90, 10, 160, 25);
        //usernameText.setText("Username");

        // Password field
        password_Field = new JPasswordField(15);
        password_Field.setBounds(90, 40, 160, 25);
    }

    public static void addToPanel() {

        // Add fields to the panel
        mainPanel.add(username_Field);
        mainPanel.add(password_Field);

    }
}
