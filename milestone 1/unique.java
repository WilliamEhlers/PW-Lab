// Source code is decompiled from a .class file using FernFlower decompiler.
package main;

import java.io.File;
import java.util.List;
import java.util.Scanner;

public class Main {
   public Main() {
   }

   public static void main(String[] var0) {
      String var1 = "C:\\Users\\billy\\OneDrive\\Documents\\PW-Lab-main\\main\\files project";
      String var2 = "C:\\Users\\billy\\OneDrive\\Documents\\PW-Lab-main\\main\\stopwords.txt";
      File var3 = new File(var1);
      if (var3.isDirectory()) {
         File[] var4 = var3.listFiles();
         if (var4 != null && var4.length > 0) {
            System.out.println("Which file do you want to read?");

            for(int var5 = 0; var5 < var4.length; ++var5) {
               if (var4[var5].isFile()) {
                  System.out.println(var5 + 1 + ": " + var4[var5].getName());
               }
            }

            Scanner var11 = new Scanner(System.in);
            System.out.print("Please select the number of the file that you want to use: ");
            int var6 = var11.nextInt();
            if (var6 > 0 && var6 <= var4.length && var4[var6 - 1].isFile()) {
               File var7 = var4[var6 - 1];
               System.out.println("You have selected: " + var7.getName());
               TextProcessor var8 = new TextProcessor(var2);
               List var9 = var8.processFileForUnique(var7);
               Statistics var10 = new Statistics(var9);
               var10.displayStatistics();
            } else {
               System.out.println("Invalid selection.");
            }

            var11.close();
         } else {
            System.out.println("There are no files in this folder.");
         }
      } else {
         System.out.println("That is not a valid directory.");
      }

   }
}

