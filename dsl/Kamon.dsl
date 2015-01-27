module kamon {
    aggregate MetricReport {
        List<Metric> metrics;
        Timestamp from;
        Timestamp to;
    }

    value Metric {
        String name;
        Long min;
        Long max;
        Long sum;
    }
}
