import java.io.*;
import java.io.FileReader;

class main {
  public static void main(String[] args) {
    Braille braille = new Braille();
    // braille.printAllBrailleAlphabets();
    // System.out.println("Some Braille Text\t" + braille.stringToBraille("Hello
    // World this is some text in braille"));
    // System.out.println("Translate Braille\t" + braille.brailleToString("⠓⠑⠇⠇⠕
    // ⠺⠕⠗⠇⠙ ⠞⠓⠊⠎ ⠊⠎ ⠎⠕⠍⠑ ⠞⠑⠭⠞ ⠊⠝ ⠃⠗⠁⠊⠇⠇⠑"));
    braille.sourceFileToBraille("src/brailleRaw.txt");
    braille.sourceFileToBraille("src/brailleRaw.txt", "src/brailleTranslated.txt");
  }
}

class Braille {

  static String Braille[] = {
      "⠁", "⠃", "⠉", "⠙", "⠑", "⠋", "⠛", "⠓", "⠊",
      "⠚", "⠅", "⠇", "⠍", "⠝", "⠕", "⠏", "⠟", "⠗",
      "⠎", "⠞", "⠥", "⠧", "⠺", "⠭", "⠽", "⠵"
  };

  Braille() {
    // System.out.println("Braille Translator\n------------------");
  }

  void sourceFileToBraille(String Source) {
    // Console Output
    char[] array = new char[100];
    try {
      FileReader input = new FileReader(Source);
      input.read(array);
      System.out.println("Raw File:");
      System.out.println(array);
      System.out.println("Translated File:");
      String translatedData = sumCharToString(array);
      System.out.println(brailleToString(translatedData));
      input.close();
    } catch (Exception e) {
      e.getStackTrace();
    }
  }

  void sourceFileToBraille(String Source, String Destination) {
    // Sourced Output
    char[] array = new char[100];
    try {
      FileReader input = new FileReader(Source);
      input.read(array);
      String translatedData = sumCharToString(array);
      input.close();
      FileWriter output = new FileWriter(Destination);
      output.write(translatedData);
      output.close();
    } catch (Exception e) {
      e.getStackTrace();
    }
  }

  void printAllBrailleAlphabets() {
    System.out.println("All Braille Alphabets");
    char a = 'a';
    for (int i = 0; i < Braille.length; i++) {
      System.out.print(a + " = " + Braille[i] + "\n");
      a++;
    }
    System.out.println();
  }

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

  String sumCharToString(char array[]) {
    String result = "";
    for (int i = 0; i < array.length; i++) {
      result += array[i];
    }
    return result;
  }

}