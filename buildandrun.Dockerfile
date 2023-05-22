FROM bellsoft/liberica-openjdk-alpine:11.0.16.1-1

COPY ./src/main/java ./src

RUN mkdir ./out

RUN javac -sourcepath ./src -d out ./src/ru/gb/homework/sem1/Main.java

CMD java -classpath ./out ru.gb.homework.sem1.Main