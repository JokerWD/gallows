FROM openjdk:20
COPY . /usr/src/myapp
WORKDIR /usr/src/myapp/src
RUN javac Main.java Game/*.java
RUN jar cfm hangman.jar META-INF/MANIFEST.MF *.class Game/*.class
CMD ["java", "-jar", "hangman.jar"]