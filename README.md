# Sample OpenTelemetry Tutorial

This repository contains a simple Java application to calculate the nth number (between 1-90) in the Fibonacci sequence.

The application in this exercise has been instrumented with OpenTelemetry. Follow the instructions below to run the app using Docker and view the data in New Relic One.

### To run the app:

1. Export your NR ingest key:
```shell
export NEW_RELIC_API_KEY=<your_license_key>
```

2. Build and run the app using Docker:
```shell
docker-compose up
```

3. To exercise, run the following command in a new shell:
```shell
./load-generator.sh
```

4. Head to your NR account to view the data.
