package com.dslplatform.example.kamon.repositories;

public class MetricReportRepository extends com.dslplatform.client.ClientPersistableRepository<com.dslplatform.example.kamon.MetricReport> {
    public MetricReportRepository(final com.dslplatform.patterns.ServiceLocator locator) {
        super(com.dslplatform.example.kamon.MetricReport.class, locator);
    }
}
