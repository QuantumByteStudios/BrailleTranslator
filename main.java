
class main {
  public static void main(String[] args) {
    Braille braille = new Braille();
    // braille.printAllBrailleAlphabets();
    System.out.println("Some Braille Text\t" + braille.toBraille("Hello World this is some text in braille"));
    System.out.println("Translate Braille\t" + braille.brailleToString("⠓⠑⠇⠇⠕ ⠺⠕⠗⠇⠙ ⠞⠓⠊⠎ ⠊⠎ ⠎⠕⠍⠑ ⠞⠑⠭⠞ ⠊⠝ ⠃⠗⠁⠊⠇⠇⠑"));
  }
}

class Braille {

  static String Braille[] = { "⠁", "⠃", "⠉", "⠙", "⠑", "⠋", "⠛", "⠓", "⠊", "⠚", "⠅", "⠇", "⠍", "⠝", "⠕", "⠏", "⠟", "⠗",
      "⠎",
      "⠞", "⠥", "⠧", "⠺", "⠭", "⠽", "⠵" };

  Braille() {
    // System.out.println("Braille Translator\n------------------");
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

  String toBraille(String rawText) {
    rawText = rawText.toLowerCase();
    String result = "";
    for (int i = 0; i < rawText.length(); i++) {
      int index = rawText.charAt(i) - 97;
      if (index < 0) {
        result += " ";
      } else {
        result += Braille[index];
      }
    }
    return result;
  }

  String brailleToString(String brailleText) {
    String result = "";
    for (int i = 0; i < brailleText.length(); i++) {
      char c = brailleText.charAt(i);
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

}