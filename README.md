## Build
```
cd MartianRobots
./gradlew clean build
```
## Run
JAR executable
```
java -jar build/libs/Martian-Robots-1.0.jar <inputFileDirectory>
```
e.g.
```
java -jar build/libs/Martian-Robots-1.0.jar ./src/main/resources/input_instructions_file.txt
```
or
```
java -jar build/libs/Martian-Robots-1.0.jar ./src/main/resources/input_instructions_file_exceed_coordinate_length.txt
```
or
```
java -jar build/libs/Martian-Robots-1.0.jar ./src/main/resources/input_instructions_file_exceed_instructions_length.txt
```

