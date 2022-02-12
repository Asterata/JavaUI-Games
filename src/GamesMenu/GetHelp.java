package GamesMenu;

import java.net.URI;
import java.awt.Desktop;

public class GetHelp {

    public static void getHelp(String inputURL) {
        try {
            URI url= new URI(inputURL);
            Desktop.getDesktop()
                    .browse(url);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
