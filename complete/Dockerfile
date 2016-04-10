FROM anapsix/alpine-java

RUN mkdir -p /root/.gradle
ENV HOME /root
VOLUME /root/.gradle

RUN mkdir /app
ADD build.gradle settings.gradle gradlew /app/
WORKDIR /app
ADD gradle ./gradle
ADD src/main src/main
EXPOSE 8080
ENV GRADLE_OPTS -Dorg.gradle.native=false
ENTRYPOINT ["./gradlew", "bootRun"]
