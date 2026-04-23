# SIT305 Task 6.1D - LLM-Enhanced Learning Assistant App

## Overview
This project is developed for **SIT305 Task 6.1D**. The goal of this assignment is to build an Android application that improves the way students learn and supports teaching through **personalized learning experiences, adaptive assessment, and intelligent tutoring**.

This app is designed as an **LLM-Enhanced Learning Assistant App**. It uses a simple student setup flow, interest selection, generated learning tasks, and AI-supported study tools to create a more engaging learning experience.

The app is built with **Android Studio** and includes both normal Android development concepts and **LLM/API integration** as required in the task.

---

## Project Purpose
The main purpose of this app is to demonstrate how a mobile learning assistant can:
- support students with topic-based revision
- provide AI-assisted explanations
- generate learning materials from a selected topic
- show how LLM features can be integrated into an Android learning app

This project uses **dummy data** to simulate student learning content and generated tasks, which matches the task requirement.

---

## Main Features

### 1. User Login
The app provides a simple login screen where the user can enter a username and password to access the learning platform.

### 2. Account Registration
New users can create an account by entering:
- username
- email
- confirm email
- password
- confirm password
- phone number

### 3. Interest Selection
After registration, users can select learning interests such as:
- Algorithms
- Data Structures
- Web Development
- Testing
- Databases
- Mobile Development

These interests are used to simulate personalized task generation.

### 4. Home Screen
The home screen welcomes the student and displays generated learning tasks based on the selected interests.

### 5. Generated Task Screen
The task screen shows revision activities and learning questions for the selected topic.

### 6. Results Screen
The results screen displays AI-generated responses and learning outputs after interaction with the LLM-based utilities.

---

## LLM-Powered Learning Utilities
This app includes **two LLM-powered learning functions**, as required by the task.

### A. Explain Why an Answer is Correct/Incorrect
This feature helps students understand their answers better.  
Instead of only showing whether the answer is right or wrong, the app provides:
- a short explanation
- why the answer is correct or incorrect
- guidance for improvement

### B. Create 3 Flashcards from a Topic
This feature generates **three educational flashcards** from a selected topic.  
Each flashcard contains:
- a question
- an answer

This is useful for quick revision and active recall learning.

---

## Prompt and Response Display
To meet the assignment requirement, the app shows:
- the **prompt sent to the LLM**
- the **response returned by the LLM**

This allows the user to clearly see how the AI-generated learning content is produced.

---

## Loading and Failure Handling
The app also handles different request states:
- **Loading state** while waiting for the LLM response
- **Success state** when the response is returned
- **Failure state** when the request fails
- retry option for failed requests

This improves usability and makes the application more realistic and complete.

---

## UI and Navigation
The user interface is designed to follow the task expectations:
- readable text
- meaningful button labels
- simple and clear layout
- consistent page navigation
- no dead-end screens
- back navigation support

The app structure also follows the sample workflow shown in the task sheet:
- Login
- Registration
- Setup / Interests
- Home
- Generated Task
- Results

---

## Technologies Used
- **Kotlin**
- **Android Studio**
- **Jetpack Compose**
- **Navigation Compose**
- **Material 3**
- **Retrofit / API integration**
- **LLM backend support**
- **Dummy data for simulation**

---

## How the App Works
1. The user logs in or creates a new account.
2. The user selects personal learning interests.
3. The app displays generated learning tasks.
4. The user opens a task and interacts with the built-in AI learning tools.
5. The app sends a prompt to the LLM service.
6. The response is shown in the UI.
7. The user can review flashcards or answer explanations on the results screen.

---

## Example Learning Scenarios
### Flashcard Generation
A user selects **Web Development**.  
The app sends a prompt asking the LLM to create 3 educational flashcards for that topic.  
The response may include:
- What is HTML?
- What is CSS?
- What is JavaScript?

### Answer Explanation
A user submits an answer to a revision question.  
The app sends the question, the correct answer, and the user's answer to the LLM.  
The returned response explains why the answer is correct or incorrect.

---

## Dummy Data Use
This project uses dummy data for:
- user profiles
- learning interests
- generated tasks
- question content
- learning history

This is consistent with the task requirement, since no real marking rubric or full personalized learning engine is required for this assignment.

---

## Repository Contents
This repository contains the full Android Studio project, including:
- source code
- UI implementation
- navigation logic
- dummy learning data
- LLM interaction logic
- supporting project files

---

## Running the Project
1. Open the project in **Android Studio**
2. Sync Gradle files
3. Run the project on an emulator or Android device
4. Navigate through the app screens
5. Test the LLM learning utilities from the task screen

If a real API key is not configured, a mock/demo mode can be used for testing and presentation purposes.

---

## LLM Use Declaration
This project uses an LLM as part of the assignment requirements for educational functionality.  
The LLM-assisted parts of this project include:
- idea generation for app structure
- implementation support for learning utility logic
- prompt design for flashcard generation and answer explanation
- code assistance for integrating LLM-based features

All code was reviewed, adjusted, and tested as part of the final project development process.

---

## Submission Notes
This repository is part of the submission for **SIT305 Task 6.1D**.

The final submission document includes:
- LLM declaration statement
- YouTube demonstration video link
- GitHub repository link
- LLM conversation link (if applicable)

---

## Author
**Name:** RUNQI LIU  
**Unit:** SIT305  
**Task:** 6.1D  
**Project Title:** LLM-Enhanced Learning Assistant App
