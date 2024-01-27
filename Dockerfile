
## Используйте официальный образ Java 17
#FROM openjdk:17-alpine
#
## Устанавливаем рабочую директорию внутри контейнера
#WORKDIR /app
#
## Копируем JAR файл внутрь контейнера
#COPY target/Sport-0.0.1-SNAPSHOT.jar app.jar
#
## Открываем порт, который приложение будет слушать
#EXPOSE 8111
#
## Запускаем приложение при старте контейнера
#CMD ["java", "-jar", "app.jar"]

FROM openjdk:17
VOLUME /tmp
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar
RUN bash -c "touch /app.jar"
EXPOSE 8111
ENTRYPOINT ["java", "-jar", "app.jar"]