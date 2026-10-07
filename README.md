# Password Generator

A simple Java console application to generate secure, random passwords based on your preferences.

## Disclaimer

This is a practice project and should not be used outside test purposes.

Also the program does not store or remember any generated passwords.

Use responsibly.

## Features

- Choose password length
- Optionally include uppercase, lowercase, numbers, and special characters
- Ensures at least 2 numbers and 2 special characters if selected, increasing the minimum with password length when possible
- Regenerates passwords containing adjacent repeated characters before displaying them
- Uses `SecureRandom` for cryptographically secure password generation

## Usage

1. Compile the app:
   ```
   javac src/App.java
   ```
2. Run the app:
   ```
   java -cp src App
   ```
3. Follow the prompts to generate your password.