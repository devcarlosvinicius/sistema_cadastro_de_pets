 Sistema de Cadastro de Pets
A console-based pet registration system built in Java, developed as a practical challenge to consolidate core Java concepts including OOP, Exceptions, Regex, IO, and date/time manipulation.

Features

✅ Register a new pet with full validation
✅ List all registered pets
✅ Search pet by name
✅ Persist data in .txt files (one file per pet)
🔄 Edit pet data (in progress)
🔄 Delete pet record (in progress)


Validations

Weight must be between 0.5kg and 60kg
Age must not exceed 20 years
Age under 1 year (entered in months) is automatically converted to decimal format (e.g. 0.6)
Breed field does not accept numbers or special characters
Required fields cannot be left blank


Data Persistence
Each registered pet is saved as a .txt file inside the petsCadastrados/ folder at the project root.
File naming format:
yyyyMMdd'T'HHmm-FULLNAMEINUPPERCASE.TXT
Example:
20231101T1234-FLORZINHADASILVA.TXT
File content (one answer per line, no questions):
1 - Florzinha da Silva
2 - Cat
3 - Female
...

Technologies

Java 8+
OOP (encapsulation, separation of domain/test)
Custom Exceptions
Regex (Pattern & Matcher)
Java IO (FileWriter, BufferedWriter, FileReader)
java.time (LocalDateTime for file naming)


Project Structure
src/
└── maratonajava/
    └── javacore/
        └── [module]/
            ├── dominio/   → business logic
            └── test/      → entry point (main)
petsCadastrados/           → generated pet files

Author
Carlos Vinícius — @devcarlosvinicius
1st semester Computer Science student — IFMA Imperatriz-MA
Studying backend Java development
