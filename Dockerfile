FROM java:8
VOLUME /tmp
ADD target/restaurant.jar app.jar
EXPOSE 8086
ENTRYPOINT ["java", "-jar", "app.jar"]