#!/bin/bash

WHEREAMI=`dirname "${0}"`
if [ -z "${SERVICE_ROOT}" ]; then
    export SERVICE_ROOT=`cd "${WHEREAMI}/../" && pwd`
fi

if [ -z "${LOG_LEVEL}" ]; then
    export LOG_LEVEL="info"
fi

SERVICE_LIB=${SERVICE_ROOT}/lib
SERVICE_ETC=${SERVICE_ROOT}/etc
export SERVICE_LOG=${SERVICE_ROOT}/log

java -Dvertx.logger-delegate-factory-class-name=io.vertx.core.logging.SLF4JLogDelegateFactory \
     -Dlogback.configurationFile=${SERVICE_ETC}/logback.xml \
     -jar ${SERVICE_LIB}/vertx-grpc-echo-1.0-SNAPSHOT-fat.jar