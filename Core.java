package PasswordManager;
// ^ C:\Users\Martin\Desktop\EVERYTHING\Java\PasswordManager\
// package Java.PasswordManager?

// File Imports (Package)
import PasswordManager.PWHandle;
import PasswordManager.UserInterface;

// Standart Libary Imports
import java.io.File;        // General File Handling
import java.io.FileWriter;  // Writing to files
import java.io.IOException; // Error Catching / Handling


interface UI {
    public void draw_menu();
}

class Core {
    static void out(String output) { // Simple Output Function, only String compatabel ( Non-Overloaded )
        System.out.println(output); 
    }

    private class Cache { // Logging & Cache
        String baseFileName = "cache.txt"; // Standart File Name
        
        public void createFile() {
            try { // Trying to create file
                File FileHandle = new File(baseFileName);
                if (FileHandle.createNewFile()) {
                    out("File Created As -> " + FileHandle.getName()); // Initialization
                } else {
                    out("File already exists...");
                }
            } catch (IOException e) { // FileError
                out("    *** [Error]"); // Error Output Decorator
                e.printStackTrace(); // Error Output Main
            }
        }

        public void writeToFile(String content) { // Main Docking -> FileHandle -> name = "Cache.txt" (Cache)
            try { // Trying to write to standart file
                FileWriter fEditHandle = new FileWriter(baseFileName, true); // Write Handle Initialization
                fEditHandle.write(content); // Writing to file
                System.out.println("Wrote Content -> " + content + " to file -> " + baseFileName); // Debug Output
                fEditHandle.close(); // Closing File - Mem Cleaning
            } catch (IOException e) { // @ error -> print error
                out("   *** [Error]"); // Error Output Decorator
                e.printStackTrace(); // Error Output
            }
        }
    }

    public static void main(String[] args) { // -> Main Calling <- 
        Core main_handle = new Core();

        Cache fHandle = main_handle.new Cache();
        fHandle.createFile();
        fHandle.writeToFile("TEST TEXT - SAMPLE PLACEHOLDER - SAMPLE TEXT WOOOHOOo");
    }
}
