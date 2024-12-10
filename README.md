### Extended README for Milestone 3

# Basic Text Analysis Application

## Project Overview
This project implements a basic text analysis tool to preprocess articles and analyze word frequencies. The application processes text files on a specific topic, removes stop words, calculates basic statistics, analyzes sentiment, and ranks words by frequency. It further allows for comparison between articles to identify tone and vocabulary richness. The final milestone introduces a text-based user interface for improved interaction and functionality.

## About Us:
- **William Ehlers**: Sophomore at Fairfield University studying Computer Science and Finance. From Milford, Connecticut.
- **Viktor Nikolov**: Junior at Fairfield University majoring in Computer Science. From Plovdiv, Bulgaria.
- **Chris Smith**: Sophomore at Fairfield University studying Computer Science. From Albany, New York.

---

## Milestone 1: Preprocessing Text Files

### Features:
- **Stop Words Removal**: Removes common words like "and," "but," etc.
- **Basic Statistics**: Calculates word and sentence counts.
- **Word Frequency Ranking**: Ranks words by frequency in the text.

### Setup:
1. **Articles**: Store articles on the same topic in a folder as `.txt` files.
2. **Stop Words**: Use a `stopwords.txt` file with a list of words to ignore during processing.

### Usage:
1. **Run `Main.java`**: Prompts you to choose a file from a directory.
2. **Preprocessing**: Processes the selected file and displays statistics and word rankings.

---

## Milestone 2: Article Comparison and Sentiment Analysis

### Features:
- **Vocabulary Richness**: Determines which article uses the richest vocabulary.
- **Word Frequency Ranking**: Identifies and ranks the most repeated words in each article.
- **Tone Analysis**: Compares articles for positive and negative attitudes using predefined word lists (`positive-words.txt` and `negative-words.txt`).

### Setup:
- **Articles**: Store all articles in the same folder as `.txt` files.
- **Stop Words**: Include a `stopwords.txt` file to exclude common words.
- **Sentiment Lists**: Add `positive-words.txt` and `negative-words.txt` for sentiment analysis.

### Usage:
- **Run `Main.java`**: Select two articles for analysis.
- **Individual Analysis**: Displays statistics and word frequency for each file.
- **Tone Comparison**: Identifies which article has a more positive tone.

---

## Milestone 3: Interactive User Interface and Extended Features

### New Features:
- **Topic Selection**: Users can select a specific topic (directory of articles) from the library for analysis.
- **Interactive Analysis**: Allows users to run analysis for a selected topic, including:
  - Basic statistics for all articles within the topic.
  - Word frequency ranking.
  - Sentiment analysis.
  - Vocabulary richness.
- **Add New Articles**: Users can provide new articles (text files), which are added to the library and analyzed.
- **Refactoring**: Improved the application's structure for maintainability and scalability:
  - Consolidated and optimized classes for modular design.
  - Enhanced readability and efficiency of the codebase.

### Setup:
1. Organize articles in directories under the library folder. Each directory represents a topic.
2. Ensure `stopwords.txt`, `positive-words.txt`, and `negative-words.txt` are available in the same folder as the application.

### Usage:
1. **Run `Main.java`**:
   - Choose a topic from the list of directories.
   - Run analyses on the selected topic.
   - Add new articles to an existing or new topic.
2. **View Results**:
   - Output includes comprehensive statistics, sentiment scores, and vocabulary insights for the selected topic.

---

## Refactoring Summary:
### Proposed Classes:
- **TextProcessor**: Handles text preprocessing, including stop word removal and frequency calculation.
- **ArticleAnalyzer**: Manages individual article analysis, including sentiment scoring and vocabulary richness.
- **TopicManager**: Handles the selection and organization of topics (directories).
- **UserInterface**: Implements the text-based interaction with the user.

### Refactoring Motivation:
1. **TextProcessor**: Streamlined to separate preprocessing logic, reducing redundancy.
2. **ArticleAnalyzer**: Focuses on analysis-specific tasks for better separation of concerns.
3. **TopicManager**: Simplifies topic handling and article addition processes.
4. **UserInterface**: Centralized user interaction to make the application intuitive and maintainable.

---

## Deliverables:
![1](https://github.com/user-attachments/assets/d42691ab-ad55-4151-ae64-a042558f37c2) 
Explanation: (Showing the positive and negative word count, and unique words from text 1)

![shows which text is more possitive](https://github.com/user-attachments/assets/6bb35960-662c-4b92-8dd0-5fa71e349dea)
Explanation: (Shows the positive and negative word count, and unique words from text 2 and tell you wich one has more positive attitude) 

Mileston 3 output: 

![image](https://github.com/user-attachments/assets/9aefb7e4-7256-4c9f-8afd-d5de3da643e8)

(program ask you which type of document you want to select and if you want to add a new one, in this case the option is no, so it process with the files comparation.)

If yes, has to provide the path of the file that you want to implement. 
![image](https://github.com/user-attachments/assets/9ecea88e-1b72-4e16-9c6d-8973035dd020)



## UML Diagram: 
![uml_diagram](https://github.com/user-attachments/assets/651088f0-ef8c-469b-9710-c7e205cd4ded)
