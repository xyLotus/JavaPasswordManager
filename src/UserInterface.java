package PasswordManager; // Package Name

// Standart Imports
import java.util.HashMap; // Dictionary Like Type

public class UserInterface { // using UIOrder Interface
    static void drawMenu(String[] args) { // Drawing Menu (UI)
        HashMap<String, String> dictionary = new HashMap<String, String>();
        dictionary.put("Hello", "Greeting");
        System.out.println(dictionary.get("Hello"));

    }

    public static void Core(String[] args) {
        String[] list = {"One", "Number"};
        drawMenu(list);     
    }

}
