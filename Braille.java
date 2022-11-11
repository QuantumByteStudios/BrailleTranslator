import java.io.*;

public class Braille {
  /*
   * Variables
   */
  static String Braille[] = {
      "⠁", "⠃", "⠉", "⠙", "⠑", "⠋", "⠛", "⠓", "⠊",
      "⠚", "⠅", "⠇", "⠍", "⠝", "⠕", "⠏", "⠟", "⠗",
      "⠎", "⠞", "⠥", "⠧", "⠺", "⠭", "⠽", "⠵"
  };

  /*
   * Basics
   */
  String stringToBraille(String text) {
    text = text.toLowerCase();
    String result = "";
    for (int i = 0; i < text.length(); i++) {
      int index = text.charAt(i) - 97;
      if (index < 0) {
        result += " ";
      } else {
        result += Braille[index];
      }
    }
    return result;
  }

  String brailleToString(String braille_text) {
    String result = "";
    for (int i = 0; i < braille_text.length(); i++) {
      char c = braille_text.charAt(i);
      for (int j = 0; j < Braille.length; j++) {
        if (c == ' ') {
          result += ' ';
          break;
        } else if (c == Braille[j].charAt(0)) {
          result += (char) (j + 97);
        }
      }
    }
    return result;
  }

  /*
   * Text To Braille
   */
  int translateToBraille(String Source) {
    // Console Output
    char[] array = new char[100];
    try {
      FileReader input = new FileReader(Source);
      input.read(array);
      System.out.println("Raw File:");
      System.out.println(array);
      System.out.println("Translated File:");
      String translatedData = CharToString(array);
      System.out.println(brailleToString(translatedData));
      input.close();
    } catch (Exception e) {
      e.getStackTrace();
    }
    return 0;
  }

  int translateToBraille(String Source, String Destination) {
    // Sourced Output
    char[] array = new char[100];
    try {
      FileReader input = new FileReader(Source);
      input.read(array);
      String Data = CharToString(array);
      input.close();
      String translatedData = brailleToString(Data);
      FileWriter output = new FileWriter(Destination);
      output.write(translatedData);
      output.close();
    } catch (Exception e) {
      e.getStackTrace();
    }
    return 0;
  }

  /*
   * Braille To Text
   */
  int translateToText(String Source) {
    // Console Output
    char[] array = new char[100];
    try {
      FileReader input = new FileReader(Source);
      input.read(array);
      System.out.println("Raw File:");
      System.out.println(array);
      System.out.println("Translated File:");
      String translatedData = CharToString(array);
      System.out.println(stringToBraille(translatedData));
      input.close();
    } catch (Exception e) {
      e.getStackTrace();
    }
    return 0;
  }

  int translateToText(String Source, String Destination) {
    // Sourced Output
    char[] array = new char[100];
    try {
      FileReader input = new FileReader(Source);
      input.read(array);
      String Data = CharToString(array);
      input.close();
      String translatedData = stringToBraille(Data);
      FileWriter output = new FileWriter(Destination);
      output.write(translatedData);
      output.close();
    } catch (Exception e) {
      e.getStackTrace();
    }
    return 0;
  }

  void BrailleAlphabets() {
    System.out.println("All Braille Alphabets");
    char a = 'a';
    for (int i = 0; i < Braille.length; i++) {
      System.out.print(a + " ");
      a++;
    }
    System.out.println();
    for (int i = 0; i < Braille.length; i++) {
      System.out.print(Braille[i] + " ");
      a++;
    }
    System.out.println();
  }

  /*
   * Others
   */
  String CharToString(char array[]) {
    String result = "";
    for (int i = 0; i < array.length; i++) {
      result += array[i];
    }
    return result;
  }

}
