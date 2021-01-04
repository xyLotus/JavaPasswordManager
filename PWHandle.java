package PasswordManager; // Package Name

import java.io.File; // General File Handling
import java.io.FileWriter; // Writing to file
import java.io.FileNotFoundException; // Error Catching / Handling
import java.io.IOException; // Error Catching / Handling
import java.util.Scanner; // User Input


public class PWHandle {
    static String _baseFileName = "master.txt"; // Standart File Name
    static String mPassword; // No Value Yet

    static int getFileLength() { // Getting Length -> for no master password overwriting
        String content = "";
        try {
            File fHandle = new File(_baseFileName);
            Scanner rHandle = new Scanner(fHandle);
            while (rHandle.hasNextLine()) {
                String currentLine = rHandle.nextLine();
                String cLineStr = "\n" + currentLine;
                content += cLineStr; // Adding the current line(str) to the full content(str) variable
            }
            rHandle.close(); // Closing ReadHande -> Scanner
            } catch (FileNotFoundException e) {
                System.out.println("    *** [ERROR]"); // Error Output Decorator
                e.printStackTrace(); // Error Output
            }
            return content.length(); // Returning Full Content
        }
    
    static void createMasterFile() {
        try { // Trying to create file
            File fHandle = new File(_baseFileName); // Creating file
            if (fHandle.createNewFile()) { // Output
                System.out.println("File Created With Name -> " + fHandle.getName());
            } // No output if file already exists -> File Set-up done
        } catch (IOException e) { // Error Catching
            System.out.println("    *** [ERROR]"); // Error Output Decorator
            e.printStackTrace(); // Error Ouput
        }
    }

    static void getMasterPassword() {
        try { // Trying to create Handle and get master password
            FileWriter fEditHandle = new FileWriter(_baseFileName); // File Editing Handle
            Scanner inHandle = new Scanner(System.in);
            System.out.println("<master-password>: ");
            
            String masterPassword = inHandle.nextLine();
            mPassword = masterPassword; // Seting Locally Global Variable to Master Password
            fEditHandle.write(mPassword); // writing master password in standart file
            
            fEditHandle.close(); // Closing file
            inHandle.close(); // Closing scanner
        } catch (IOException e) {
            System.out.println("    *** [ERROR]"); // Error Output Decorator
            e.printStackTrace(); // Error Ouput
        }
    }

    public static void main(String[] args) {
        if (getFileLength() <= 0) {
            createMasterFile();
            getMasterPassword();
        }
    }
}