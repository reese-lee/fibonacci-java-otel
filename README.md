
      
# Getting Started with OpenTelemetry 

This repository contains a simple Java application to calculate the nth number (between 1-90) in the Fibonacci sequence. 

Follow the steps below to instrument the app with OpenTelemetry and export the generated telemetry to your NR1 account. 

### To run the app:

1. Export the following environment variables:

* Your NR1 ingest key (replace `<your_license_key>` with your New Relic ingest license key):
```shell
export OTEL_EXPORTER_OTLP_HEADERS=api-key=<your_license_key>
```

* The endpoint the generated telemetry will be exported to:
```shell
export OTEL_EXPORTER_OTLP_ENDPOINT=https://otlp.nr-data.net:4317
```

2. Build and run the app:
```shell
gradle bootRun
```

3. Exercise the app by running the following command in a new terminal tab:
```shell
./load-generator.sh
```

4. Head to your NR1 account to view the data. 
