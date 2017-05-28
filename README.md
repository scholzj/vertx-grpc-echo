# gRPC Echo service

A simple echo server and client written using Vert.x and gRPC. I used this to play with gRPC and to test gRPC loadbalancing. The application can run as both *server* and *client*.

# Server

To run as server, set the environment variable `SERVICE_TYPE` to value `server`:
```bash
export SERVICE_TYPE=server
```

Optionally, you can also set `GRPC_HOSTNAME` and `GRPC_PORT` to the hostname and port on which the server should be listening. By default, these will be `0.0.0.0` and `8080`.

# Client

To run as client, set the environment variable `SERVICE_TYPE` to value `client`:
```bash
export SERVICE_TYPE=client
```

Optionally, you can also set `GRPC_HOSTNAME` and `GRPC_PORT` to the hostname and port where the server should try to connect. By default, these will be `localhost` and `8080`.


## Logging

Log level can be configured by setting the environment variable `LOG_LEVEL` to the desired log level (`INFO`, `DEBUG`, etc.).