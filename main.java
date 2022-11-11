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
    System.out.println("Translated From Braille To Text: \t"
        + braille.brailleToString("⠞⠓⠑ ⠟⠥⠊⠉⠅ ⠃⠗⠕⠺⠝ ⠋⠕⠭ ⠚⠥⠍⠏⠑⠙ ⠕⠧⠑⠗ ⠞⠓⠑ ⠇⠁⠵⠽ ⠙⠕⠛"));

    /*
     * Convert Text To Braille
     */
    System.out.print(colors.RED + "\nConvert Text To Braille" + colors.RESET);
    System.out.println(" ► Function: " + colors.CYAN + "stringToBraille(String text);" + colors.RESET);
    System.out.println("Translated From Text To Braille: \t"
        + braille.stringToBraille("The quick brown fox jumped over the lazy dog"));

    /*
     * Convert String To Braille From Source File To Destination File
     */
    System.out.print(colors.RED + "\nConvert String To Braille From Source File To Destination File" + colors.RESET);
    System.out.println(" ► Function: " + colors.CYAN
        + "translateToBraille(String sourceFilePath, String destinationFilePath);" + colors.RESET);
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
    System.out.println(" ► Function: " + colors.CYAN
        + "translateToText(String sourceFilePath, String destinationFilePath);" + colors.RESET);
    status = braille.translateToText("src/brailleTranslated.txt", "src/brailleRaw.txt");
    if (status == 0) {
      System.out.println("Result: " + colors.GREEN + "File Successfully Translated [✓]" + colors.RESET);
    } else {
      System.out.println(colors.RED + "Error [✗]" + colors.RESET);
    }
    System.out.println();
  }
}