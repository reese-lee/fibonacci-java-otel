package com.example.demo;

import io.opentelemetry.api.trace.propagation.W3CTraceContextPropagator;
import io.opentelemetry.context.propagation.ContextPropagators;
import io.opentelemetry.sdk.resources.Resource;
import io.opentelemetry.sdk.trace.SpanLimits;
import io.opentelemetry.semconv.resource.attributes.ResourceAttributes;

import io.opentelemetry.sdk.OpenTelemetrySdk;
import io.opentelemetry.api.trace.Tracer;
import io.opentelemetry.sdk.trace.SdkTracerProvider;
import io.opentelemetry.api.GlobalOpenTelemetry;
import io.opentelemetry.instrumentation.spring.webmvc.SpringWebMvcTracing;
import io.opentelemetry.sdk.trace.export.SimpleSpanProcessor;
import io.opentelemetry.sdk.trace.export.BatchSpanProcessor;
import io.opentelemetry.sdk.trace.SpanLimits;
import io.opentelemetry.exporter.otlp.trace.OtlpGrpcSpanExporter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import javax.servlet.Filter;

@SpringBootApplication
public class Application {

  public static void main(String[] args) {
    OpenTelemetrySdk openTelemetrySdk =
        OpenTelemetrySdk.builder()
            .setTracerProvider(
                SdkTracerProvider.builder()
                    .build())
            .build();

    Tracer tracer = openTelemetrySdk.getTracer("ConfigureTraceExample");

    SdkTracerProvider sdkTracerProvider = SdkTracerProvider.builder()
      .addSpanProcessor(BatchSpanProcessor.builder(OtlpGrpcSpanExporter.builder().build()).build())
      .build();

    // SdkMeterProvider meterProvider = SdkMeterProvider.builder()
    //   .registerMetricReader(PeriodicMetricReader.builder(OtlpGrpcMetricExporter.builder().build()).build())
    //   .build();

    // OpenTelemetry openTelemetry = OpenTelemetrySdk.builder()
      // .setTracerProvider(sdkTracerProvider)
      // .setMeterProvider(sdkMeterProvider)
      // .setPropagators(ContextPropagators.create(W3CTraceContextPropagator.getInstance()))
      // .buildAndRegisterGlobal();

    SpringApplication.run(Application.class, args);
  }

  @Bean
  public Filter webMvcTracingFilter() {
    return SpringWebMvcTracing.create(GlobalOpenTelemetry.get()).newServletFilter();
  }

}
