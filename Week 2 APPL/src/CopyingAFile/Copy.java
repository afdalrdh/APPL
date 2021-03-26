package CopyingAFile;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author afdalrdh
 */
public class Copy {
     public static void main(String[] args){
        Scanner input_scanner;
        Scanner text_scanner;
        String file_name;
        File user_file;
        Boolean copied = false;
        
        while(!copied) {
            try {
                input_scanner = new Scanner(System.in);
                System.out.print("Your file name: ");
                file_name = input_scanner.nextLine();
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
