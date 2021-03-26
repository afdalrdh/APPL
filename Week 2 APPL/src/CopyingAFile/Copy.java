package CopyingAFile;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Copy {
     public static void main(String[] args){
        Scanner input_scanner;
        Scanner text_scanner;
        String file_name;
        File user_file;
        Boolean copied = false;
        
        while(!copied) {
            try {
                Scanner input = new Scanner(System.in);
                System.out.print("Your file name: ");
                file_name = input.nextLine();
                user_file = new File(file_name);
                if(user_file == null) {
                    throw new FileNotFoundException();
                } else {
                    text_scanner = new Scanner(user_file);
                    while(text_scanner.hasNextLine()) {
                        String data = text_scanner.nextLine();
                        System.out.print(data);
                    }
                    copied = true;
                }
            } catch(FileNotFoundException e) {
                System.out.print(e.getMessage() + "\n");
            }
        }
    }
}
