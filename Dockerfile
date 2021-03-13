FROM adoptopenjdk/openjdk11:latest

COPY ./target/client-api-leo-1.jar /usr/app/

WORKDIR /usr/app

RUN sh -c 'touch client-api-leo-1.jar'

ENTRYPOINT ["java","-jar","client-api-leo-1.jar"]