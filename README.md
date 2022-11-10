<h1 align="center">⠃⠗⠁⠊⠇⠇⠑⠞⠗⠁⠝⠎⠇⠁⠞⠕⠗</h1>
<p align="center">Simple Java program that converts text to braille & braille to text</p>

Execute in linux terminal
  
    ./run.sh

# Methods List
| Return Type | Method | Parameters | Description |
| ------------- | ------------- | ------------- | ------------- |
| String |  stringToBraille()  | String `text` | Converts Normal Text `abc` To Braille Text `⠁⠃⠉`  |
| String |  brailleToString()  | String `braille_text` | Converts Braille Text `⠁⠃⠉` To Normal Text `abc`  |
| int |  translateToBraille()  | String `Source` | Converts Normal Text `abc` To Braille Text `⠁⠃⠉` From a File  |
| int |  translateToBraille()  | String `Source`, String `Destination` | Converts Normal Text `abc` To Braille Text `⠁⠃⠉` From a File  |
| int |  translateToText()  | String `Source` | Converts Braille Text `⠁⠃⠉` To Normal Text `abc` From a File  |
| int |  translateToText()  | String `Source`, String `Destination` | Converts Braille Text `⠁⠃⠉` To Normal Text `abc` From a File  |
| void |  BrailleAlphabets()  | `void` | Prints all the Braille & English Alphabets |