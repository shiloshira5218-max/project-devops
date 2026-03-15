FROM eclipse-temurin:11-jre
COPY target/project-devops*.jar /usr/src/project-devops.jar
COPY src/main/resources/application.properties /opt/conf/application.properties
CMD ["java", "-jar", "/usr/src/project-devops.jar", "--spring.config.location=file:/opt/conf/application.properties"]