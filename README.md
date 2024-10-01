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

```shell
docker build -t jnsousa/clines-api:1.0.0 .
```

## Gerar container
```shell
$\docker\api> docker compose up -d
```
