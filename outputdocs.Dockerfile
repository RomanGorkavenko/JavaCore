FROM bellsoft/liberica-openjdk-alpine:11.0.16.1-1 AS BuildProject
WORKDIR /app
COPY ./src/main/java ./src
COPY ./src/main/java/ru/gb/homework/sem1/out ./out
RUN mkdir ./docs
RUN javadoc -encoding utf-8 -d docs -sourcepath ./src -cp out -subpackages ru

FROM scratch AS OutputFile
COPY --from=BuildProject /app/docs /docs