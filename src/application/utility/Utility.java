package application.utility;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

import java.security.SecureRandom;
import java.util.Optional;
import java.util.Random;

public class Utility {

    static final private String ALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
    static final private Random rng = new SecureRandom();

    public static char randomChar(){
        return ALPHABET.charAt(rng.nextInt(ALPHABET.length()));
    }

    public static String randomUUID(int length){
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            sb.append(randomChar());
        }
        return sb.toString();
    }

    public static boolean alert(String titel, String message) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle(titel);
        alert.setHeaderText(message);
        Optional<ButtonType> result = alert.showAndWait();
        return (result.isPresent()) && (result.get() == ButtonType.OK);
    }

    public static void message(String titel, String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(titel);
        alert.setHeaderText(message);
        alert.showAndWait();
    }
}
