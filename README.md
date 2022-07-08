# Sample OpenTelemetry Tutorial
This repository contains a simple Java application to calculate the nth number (between 1-90) in the Fibonacci sequence. The application in this exercise has been instrumented with OpenTelemetry. 

Build and run the app by following the steps below to export the generated data to your New Relic account. 

Note: This is the non-dockerized version, which only requires you to have Java installed on your machine. To use the dockerized version in which you only need Docker installed on your machine, switch to the main branch.

## To run the app:

1. Export the following environmental variables:

* Your New Relic license key (replace the value with your ingest key):
```shell
export EXPORTER_OTLP_HEADERS=<your_license_key>
```

* The traces endpoint:
```shell
export OTEL_EXPORTER_OTLP_ENDPOINT=https://otlp.nr-data.net:4317
```

* The service name:
```shell
export OTEL_SERVICE_NAME=fibonacci-java-otel
```

2. Build and run the app:
```shell
gradle bootRun
```

3. To exercise, run the following command in a new shell tab:
```shell
./load-generator.sh
```

4. Head to your New Relic account to view and explore the data!