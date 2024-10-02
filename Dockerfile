FROM openjdk:21

WORKDIR /clines

COPY target/*.jar /clines/app.jar

ENV DB_URL=jdbc:postgresql://host.docker.internal:5432/clines
ENV DB_USER=postgres
ENV DB_PASSWORD=postgres

EXPOSE 8080

CMD java -XX:+UseContainerSupport -Xmx512m -jar app.jar