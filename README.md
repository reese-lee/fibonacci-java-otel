# SKO OTel Session

This repo holds the Java app being used for the OpenTelemetry session for SKO '22. It has been instrumented with OpenTelemetry. 

All that is required for you to run the app is Docker. 

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
