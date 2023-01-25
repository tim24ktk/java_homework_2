package java_homework_2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.File;


public class Program {
  public static void main(String[] args) throws IOException {
    int valueA = readFile("a", "input.txt");
    int valueB = readFile("b", "input.txt");

    if (valueA != 0 && valueB !=0) {
      int intPower = getPow(valueA, valueB);

      System.out.println("Число " + valueA + " в степени " + valueB + ": " + intPower);
      writeFile(intPower, "output.txt");

    } else {
      System.out.print("Не определено!");
    }
  }

  public static int readFile(String value, String fileName) throws IOException {
    BufferedReader br = null;
    Object result = null;

    try {
      br = new BufferedReader(new FileReader("input.txt"));
      String line;

      while ((line = br.readLine()) != null) {
        String[] words = line.strip().split("\\s+");

        if (words[0].equals(value) && words.length == 2 && words[1].matches("^\\d+(\\.\\d+)?")) {
          result = Integer.parseInt(words[1]);
        }
      }

    } catch(IOException ex){
        System.out.println(ex.getMessage());
    } finally {
      br.close();
    }

    return (int) result;
  }

  public static int getPow(int number, int pow) {
    return (int) Math.pow(number, pow);
  }

  public static void writeFile(int value, String fileName) {
    try {
      File file = new File(fileName);

      if (!file.exists()) {
        file.createNewFile();
      }

      PrintWriter pw = new PrintWriter(fileName);

      pw.print(value);
      pw.close();
      System.out.println("Число " + value + " записано в файл!");

    } catch (IOException ex){
      System.out.println(ex.getMessage());
    }
  }
}
