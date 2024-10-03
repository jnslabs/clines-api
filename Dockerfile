# Usar uma imagem base do OpenJDK 21
FROM openjdk:21-jdk-slim

# Instalar Maven
RUN apt-get update && apt-get install -y maven

# Definir o diretório de trabalho
WORKDIR /app

# Copiar o arquivo pom.xml e baixar as dependências
COPY pom.xml .
RUN mvn -B dependency:resolve dependency:resolve-plugins

# Copiar o código fonte e compilar a aplicação
COPY src ./src
RUN mvn -B package -DskipTests

# Ajustar permissões do arquivo JAR
RUN chmod 755 target/*.jar

# Expor a porta que a aplicação irá rodar
EXPOSE 8080

CMD java -XX:+UseContainerSupport -Xmx512m -jar target/*.jar