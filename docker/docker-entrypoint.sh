#!/bin/bash
set -e

# if command starts with an option, prepend the start script
if [ "${1:0:1}" = '-' ]; then
  set -- ./bin/start.sh "$@"
fi

# else default to run whatever the user wanted like "bash"
exec "$@"