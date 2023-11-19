FROM openjdk:20
VOLUME /tmp
EXPOSE 8080
ARG JAR_FILE=target/tf_arquitectura_web-0.0.1-SNAPSHOT.jar
ADD ${JAR_FILE} tf_arquitectura_web.jar
ENTRYPOINT ["java","-jar","/tf_arquitectura_web.jar"]