FROM anapsix/alpine-java

RUN mkdir -p /root/.gradle
ENV HOME /root
VOLUME /root/.gradle

RUN mkdir /app
ADD . /app
VOLUME /app

EXPOSE 8080
ENV GRADLE_OPTS -Dorg.gradle.native=false
WORKDIR /app
ENTRYPOINT ["./gradlew", "bootRun"]
