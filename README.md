# Basic Text Analysis Application

## Project Overview
This project implements a basic text analysis tool to preprocess articles and analyze word frequencies. The application processes text files on a specific topic, removes stop words, calculates basic statistics, and ranks words by frequency.

## About Us:
**William Ehlers**: I am a sophomore at Fairfield University studying Computer Science and Finance. I am from Milford, Connecticut. 
**Viktor Nikolov**: Junior Student at Fairfield. Computer Science major. 
I am from Plovdiv, Bulgaria. 
**Chris Smith**: I am a sophomore at Fairfield University studying Computer Science. I am from Albany, New York.


## Milestone 1: Preprocessing Text Files

### Features:
- **Stop Words Removal**: Removes common words like "and", "but", etc.
- **Basic Statistics**: Calculates the number of words and sentences.
- **Word Frequency Ranking**: Ranks words based on how often they appear in the text.

### Setup:
1. **Articles**: Store articles on the same topic in a folder as `.txt` files.
2. **Stop Words**: Use a `stopwords.txt` file with a list of words to ignore during processing. [Example list](https://en.wikipedia.org/wiki/Stop_words).

### Usage:
1. **Run `Main.java`**: It will prompt you to choose a file from a directory.
2. **Preprocessing**: The selected file will be processed, displaying statistics and word rankings.

## Milestone 2: Possitive attitude or negative attitude? 

##Features:
- **Stop Words Removal**: Filters out common stop words (e.g., "and", "the") to focus on meaningful words within the text.
- **Tone Analysis**: Analyzes the text for tone by counting positive and negative words based on predefined lists, allowing for sentiment assessment.
- **Basic Statistics**: Calculates key statistics, including the total number of words, unique word count, and displays word frequency rankings.
- **Word Frequency Ranking**: Provides a ranked list of words based on frequency, helping identify prominent themes or keywords in the text.
- **Multi-File Comparison**: Allows for the selection of two articles, analyzes them individually, and compares their tone to determine which one expresses a more positive attitude.

##Setup:
- **Articles**: Place all articles for analysis within the same folder as .txt files.
- **Stop Words**: Include a stopwords.txt file containing common words to exclude during processing.
- **Positive and Negative Word Lists**: Add positive-words.txt and negative-words.txt files containing words to be used for tone analysis.

##Usage:
- **Run Main.java**: Upon execution, the program will prompt you to select two files for analysis.
- **Individual Analysis**: The program will display statistics for each file, including word frequency and positive and negative word counts.
- **Tone Comparison**: After individual analysis, the program compares the positivity levels of both files and identifies the one with a more positive tone.

##Output (Screenshots):


![1](https://github.com/user-attachments/assets/d42691ab-ad55-4151-ae64-a042558f37c2) 
Explanation: (Showing the positive and negative word count, and unique words of text 1)

![shows which text is more possitive](https://github.com/user-attachments/assets/6bb35960-662c-4b92-8dd0-5fa71e349dea)
Explanation: (Shows the positive and negative word count, and unique words from text 2 and tell you wich one has more positive attitude) 
