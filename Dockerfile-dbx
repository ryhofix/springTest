FROM tomcat:8.0.20-jre8

COPY target/springTest-0.0.1-SNAPSHOT.war /usr/local/tomcat/webapps/spring.war
ENV JAVA_OPTS="-Dspring.profiles.active=docker"

EXPOSE 8080
