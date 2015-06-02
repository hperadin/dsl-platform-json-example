package com.dslplatform.example;

import com.dslplatform.example.kamon.Metric;
import com.dslplatform.example.kamon.MetricReport;

import java.util.Random;

import com.dslplatform.patterns.Bytes;
import org.joda.time.DateTime;

import com.dslplatform.client.json.JsonReader;
import com.dslplatform.client.json.JsonWriter;

public class Main {
    private static Random rnd = new Random();

    public static void main(final String[] args) throws Exception {
        final MetricReport mr = randomMetricReport();

        // Serialization
        System.out.println("\n==================");
        System.out.println("The source object:");
        System.out.println("==================\n");
        out(mr);

        final JsonWriter sw = new JsonWriter();
        mr.serialize(sw, true);

        // Bytes has a reference to internal byte[] used during serialization
        final Bytes serialized = sw.toBytes();

        // Bytes also has few useful utility methods
        System.out.println("\n===================================");
        System.out.println("Serialized object as a JSON string:");
        System.out.println("===================================\n");
        System.out.println(serialized.toUtf8());

        // Deserialization
        final JsonReader jr = new JsonReader(serialized.content, serialized.length, null);

        // deserialize can return null, object instance or array list
        final MetricReport deserializedObject = (MetricReport) MetricReport.deserialize(jr, null);
        System.out.println("\n====================");
        System.out.println("Deserialized object:");
        System.out.println("====================\n");
        out(deserializedObject);
    }

    private static void out(final MetricReport mr) {
        System.out.println(mr.toString());
        System.out.println("From: " + mr.getFrom());
        System.out.println("To: " + mr.getTo());
        System.out.println();
        for (final Metric m : mr.getMetrics()) {
            out(m);
        }
    }

    private static void out(final Metric m) {
        System.out.println(m.toString());
    }

    private static MetricReport randomMetricReport() {
        final MetricReport mr = new MetricReport();
        mr.setFrom(DateTime.now().minusDays(10));
        mr.setTo(DateTime.now());
        for (int i = 0; i < 10; i++) {
            mr.getMetrics().add(randomMetric());
        }
        return mr;
    }

    private static Metric randomMetric() {
        final Metric m = new Metric();
        m.setName("A random nonsensical metric (" + rnd.nextLong() + ")");
        m.setMin(rnd.nextLong());
        m.setMax(rnd.nextLong());
        m.setSum(rnd.nextLong());
        return m;
    }
}
