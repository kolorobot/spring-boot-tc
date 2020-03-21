# ./mvnw clean target
# docker build -t spring-boot-tc .
# docker run -it -p 8080:9000 spring-boot-tc
FROM openjdk:13-alpine
COPY target/spring-boot-tc-*.jar .
EXPOSE 8080

CMD java -jar spring-boot-tc-*.jar