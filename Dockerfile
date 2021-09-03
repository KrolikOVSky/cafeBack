FROM openjdk:11.0.11
WORKDIR /app
COPY /build/libs/cafeBack.jar .
EXPOSE 8081:8081
CMD ["java", "-jar", "cafeBack.jar"]