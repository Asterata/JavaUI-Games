package LoginScreen;

import javax.swing.*;

import static LoginScreen.MainLoginScreen.mainPanel;

public class Labels {

    public static JLabel username_Label;
    public static JLabel password_Label;
    public static JLabel status_Label;

    public static void addLabels() {
        // Username Label
        username_Label = new JLabel("Username:");
        username_Label.setBounds(15, 10, 80, 25);

        // Password Label
        password_Label = new JLabel("Password:");
        password_Label.setBounds(15, 40, 80, 25);

        // Status Label
        status_Label = new JLabel("");
        status_Label.setBounds(15, 70, 80, 25);
    }

    public static void addToPanel() {

        // Add Labels to the panel
        mainPanel.add(username_Label);
        mainPanel.add(password_Label);
        //MainLoginScreen.mainPanel.add(status_Label);

    }

}
