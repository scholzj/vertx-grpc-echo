FROM openjdk:8-jre

RUN addgroup --system vertx && adduser --system --home /home/vertx --group vertx
COPY ./vertx-grpc-echo-1.0-SNAPSHOT /home/vertx

ENV DAVE_VERSION 1.0-SNAPSHOT

ENV JAVA_OPTS -Xmx512m

RUN chown -R vertx:vertx /home/vertx
WORKDIR /home/vertx

# Add entrypoint
COPY ./docker-entrypoint.sh /
ENTRYPOINT ["/docker-entrypoint.sh"]

USER vertx

# Expose port and run
EXPOSE 8080
CMD ["./bin/start.sh"]