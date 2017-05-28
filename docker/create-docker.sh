#!/usr/bin/env bash

DAVE_VERSION="1.0-SNAPSHOT"
DAVE_APPLICATION_NAME="dave-store-manager"
DAVE_CONFIG_FILE="${DAVE_APPLICATION_NAME}-${DAVE_VERSION}/etc/storemanager.conf"

# Copy the DAVe binaries
cp -r -v ./target/vertx-grpc-echo-1.0-SNAPSHOT/vertx-grpc-echo-1.0-SNAPSHOT ./docker/vertx-grpc-echo-1.0-SNAPSHOT

docker build -t scholzj/vertx-grpc-echo:latest ./docker/
docker tag -f scholzj/vertx-grpc-echo:latest docker.io/scholzj/vertx-grpc-echo:latest
docker push scholzj/vertx-grpc-echo:latest