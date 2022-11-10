import java.io.*;

class main {
  public static void main(String[] args) {
    /*
     * Demo
     */
    // Create Variables & Objects
    Braille braille = new Braille();
    int status;

    /*
     * Print All Braille Alphabets
     */
    System.out.print(colors.RED + "\nPrint All Braille Alphabets" + colors.RESET);
    System.out.println(" ► Function: " + colors.CYAN + "printAllBrailleAlphabets();" + colors.RESET);
    braille.BrailleAlphabets();

    /*
     * Convert Braille To text
     */
    System.out.print(colors.RED + "\nConvert Braille To Text" + colors.RESET);
    System.out.println(" ► Function: " + colors.CYAN + "brailleToString(String brailleFormattedText);" + colors.RESET);
    System.out.println("Translated From Braille To Text: \t" + braille.brailleToString("⠞⠓⠑ ⠟⠥⠊⠉⠅ ⠃⠗⠕⠺⠝ ⠋⠕⠭ ⠚⠥⠍⠏⠑⠙ ⠕⠧⠑⠗ ⠞⠓⠑ ⠇⠁⠵⠽ ⠙⠕⠛"));

    /*
     * Convert Text To Braille
     */
    System.out.print(colors.RED + "\nConvert Text To Braille" + colors.RESET);
    System.out.println(" ► Function: " + colors.CYAN + "stringToBraille(String text);" + colors.RESET);
    System.out.println("Translated From Text To Braille: \t" + braille.stringToBraille("The quick brown fox jumped over the lazy dog"));

    /*
     * Convert String To Braille From Source File To Destination File
     */
    System.out.print(colors.RED + "\nConvert String To Braille From Source File To Destination File" + colors.RESET);
    System.out.println(" ► Function: " + colors.CYAN + "translateToBraille(String sourceFilePath, String destinationFilePath);" + colors.RESET);
    status = braille.translateToBraille("src/brailleRaw.txt", "src/brailleTranslated.txt");
    if (status == 0) {
      System.out.println("Result: " + colors.GREEN + "File Successfully Translated [✓]" + colors.RESET);
    } else {
      System.out.println(colors.RED + "Error [✗]" + colors.RESET);
    }

    /*
     * Convert Braille To String From Source File To Destination File
     */
    System.out.print(colors.RED + "\nConvert Braille To String From Source File To Destination File" + colors.RESET);
    System.out.println(" ► Function: " + colors.CYAN + "translateToText(String sourceFilePath, String destinationFilePath);" + colors.RESET);
    status = braille.translateToText("src/brailleTranslated.txt", "src/brailleRaw.txt");
    if (status == 0) {
      System.out.println("Result: " + colors.GREEN + "File Successfully Translated [✓]" + colors.RESET);
    } else {
      System.out.println(colors.RED + "Error [✗]" + colors.RESET);
    }
    System.out.println();
  }
}

class Braille {
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