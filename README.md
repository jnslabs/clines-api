# clines-api [![Java CI with Maven](https://github.com/jnslabs/clines-api/actions/workflows/maven.yml/badge.svg)](https://github.com/jnslabs/clines-api/actions/workflows/maven.yml)
## [Initializer](https://start.spring.io/#!type=maven-project&language=java&platformVersion=3.3.4&packaging=jar&jvmVersion=21&groupId=com.jnsdev.clines-api&artifactId=clines-api&name=clines-api&description=Api%20exemplo%20para%20deploy%20na%20aws&packageName=com.jnsdev.clines-api&dependencies=web,lombok,data-jpa,postgresql,configuration-processor,flyway)

## Repositorio

[clines-api](https://github.com/jnslabs/clines-api)

## Tecnologias Utilizadas

* Spring-boot
* Spring-boot-jpa
* Postgres
* Bean Validacion
* Flayway Migrations
* Lombok
* Github Action
* AWS

## Gerar imagem container

### Docker com variaveis de ambientes
```Dockerfile
FROM openjdk:21

WORKDIR /clines

COPY target/*.jar /clines/app.jar

ENV DB_URL=jdbc:postgresql://host.docker.internal:5432/clines
ENV DB_USER=postgres
ENV DB_PASSWORD=postgres

EXPOSE 8080

CMD java -XX:+UseContainerSupport -Xmx512m -jar app.jar
```
> :exclamation: Nesse caso o container acessa banco de dados externo.

### Docker sem variaveis de ambientes
```Dockerfile
FROM openjdk:21

WORKDIR /clines

COPY target/*.jar /clines/app.jar

EXPOSE 8080

CMD java -XX:+UseContainerSupport -Xmx512m -jar app.jar
```
> :exclamation: Nesse caso as variaveis de ambiente tem ser passadas no docker compose ou usar `-e` pelo docker run

### Docker Build
```shell
docker build -t jnsousa/clines-api:1.0.0 .
```

## Gerar container
### run
```shell
docker run -p 8080:8080 --name clines -d jnsousa/clines-api:1.0.0
```

### docker compose
```shell
$\docker\api> docker compose up -d
```
