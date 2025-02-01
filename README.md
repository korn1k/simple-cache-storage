# Simple Cache Storage

A distributed key-value storage system implemented using gRPC and Java.

## Features

- In-memory key-value storage
- TTL support for cached entries 
- gRPC client-server communication
- Interactive CLI client
- Concurrent access support

## Prerequisites

- JDK 23
- Gradle 8.x
- Protocol Buffers compiler

## Building

```bash
./gradlew clean generateProto build
```

## Running Instructions
Start the server:
```bash
./gradlew run
```
In a separate terminal, start the client:
```bash
./gradlew runClient --console=plain --no-daemon
```

## Usage

The client supports the following commands:
```
put <key> <value> [ttl] - Store a value with optional TTL in milliseconds
get <key> - Retrieve a value
has <key> - Check if key exists
delete <key> - Remove a key-value pair
help - Show available commands
exit - Close the client
```

## Architecture

- Protocol: gRPC with Protocol Buffers
- Server: Single-threaded in-memory storage with TTL support
- Client: Interactive CLI with persistent connection
- Data Model: Key-value pairs with optional expiration

## Example

```bash
> put name John 5000
Value stored successfully
> get name
Value is John
# After 5 seconds...
> get name
Key is not found in Store
```