FROM anapsix/alpine-java
VOLUME /tmp
ADD gs-spring-boot-docker.jar app.jar
RUN bash -c 'touch /app.jar'
EXPOSE 8080
ENTRYPOINT ["java", "-Djava.security.egd=file:/dev/./urandom", "-jar", "/app.jar"]
