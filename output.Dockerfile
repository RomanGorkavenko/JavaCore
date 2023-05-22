FROM bellsoft/liberica-openjdk-alpine:11.0.16.1-1 AS BuildProject
WORKDIR /app
COPY ./src/main/java ./src
RUN mkdir ./out
RUN javac -sourcepath ./src -d out ./src/ru/gb/homework/sem1/Main.java

FROM scratch AS OutputFile
COPY --from=BuildProject /app/out /out