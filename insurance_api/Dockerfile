FROM jimschubert/8-jdk-alpine-mvn

RUN mkdir -p /usr/src/app
WORKDIR /usr/src/app

COPY . /usr/src/app

RUN mvn clean install

ENV JAVA_OPTS=""
ENTRYPOINT exec java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -jar /usr/src/app/target/insurance_api-0.0.1.jar