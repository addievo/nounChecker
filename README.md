# Noun Extractor
 This Java program is designed to extract all the nouns from a given string. It uses the OpenNLP library to perform POS (Part of Speech) tagging. It then filters out all the nouns (both proper and common) from the tagged words. It also ensures that the output is in lowercase and duplicates are removed.
 ## Prerequisites
 1. Java Development Kit (JDK) 8 or above installed on your machine.
    
3. Apache Maven for dependency management.
4. OpenNLP library.
 ## Steps to Run
 1. Clone the repository to your local machine.
 2. Navigate to the project directory from the terminal.
 3. Run the program using the command  `java Noun` . 
 4. When prompted, enter the string from which you want to extract the nouns.
 5. The program will output all the distinct nouns found in the string.
 ## Code Breakdown
 The code consists of several methods, each performing a specific task:
 1.  `getString()` : This method prompts the user to input a string and returns it.
 2.  `typeAssigner(String al)` : This method takes a string as input and assigns POS tags to each word in the string. It uses the OpenNLP library for POS tagging.
 3.  `splitWords(String f)` : This method splits the tagged string into individual words and stores them in an ArrayList.
 4.  `nounPicker()` : This method iterates through the ArrayList of tagged words and selects the words tagged as nouns (NN or NNP).
 5.  `cleaner()` : This method cleans the selected words by removing the POS tags and any trailing punctuation marks.
 6.  `setLowercase()` : This method converts all the words in the ArrayList to lowercase.
 7.  `findDuplicate()` : This method removes any duplicates from the ArrayList.
 8.  `stringPrinter()` : This method prints out all the words in the ArrayList, which are the distinct nouns found in the original string.
 ## Note
 The program currently only supports English language. The POS tagging may not be accurate for other languages.
