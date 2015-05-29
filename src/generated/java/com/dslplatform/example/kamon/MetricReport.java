package com.dslplatform.example.kamon;

public class MetricReport implements java.io.Serializable, com.dslplatform.patterns.AggregateRoot, com.dslplatform.client.json.JsonObject {
    public MetricReport() {
        URI = java.lang.Integer.toString(System.identityHashCode(this));
        this.ID = 0;
        this.metrics = new java.util.ArrayList<com.dslplatform.example.kamon.Metric>(4);
        this.from = org.joda.time.DateTime.now();
        this.to = org.joda.time.DateTime.now();
    }

    private transient com.dslplatform.patterns.ServiceLocator _serviceLocator;

    private String URI;

    public String getURI() {
        return this.URI;
    }

    @Override
    public int hashCode() {
        return URI.hashCode();
    }

    @Override
    public boolean equals(final Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;

        if (getClass() != obj.getClass()) return false;
        final MetricReport other = (MetricReport) obj;

        return URI.equals(other.URI);
    }

    public boolean equals(final MetricReport other) {
        if (this == other) return true;
        if (other == null) return false;
        if (!URI.equals(other.URI)) return false;

        if (!(this.ID == other.ID)) return false;
        if (!((this.metrics == other.metrics || this.metrics != null && this.metrics.equals(other.metrics)))) return false;
        if (!(this.from == other.from || this.from != null
                && other.from != null
                && this.from.getMillis() == other.from.getMillis()
                && (org.joda.time.field.FieldUtils.equals(this.from.getChronology(), other.from.getChronology()) || this.from.getChronology() != null
                        && other.from.getChronology() != null
                        && this.from.getChronology().getZone().getOffset(0) == other.from.getChronology().getZone().getOffset(0)))) return false;
        if (!(this.to == other.to || this.to != null
                && other.to != null
                && this.to.getMillis() == other.to.getMillis()
                && (org.joda.time.field.FieldUtils.equals(this.to.getChronology(), other.to.getChronology()) || this.to.getChronology() != null
                        && other.to.getChronology() != null
                        && this.to.getChronology().getZone().getOffset(0) == other.to.getChronology().getZone().getOffset(0)))) return false;

        return true;
    }

    @Override
    public String toString() {
        return "MetricReport(" + URI + ')';
    }

    private static final long serialVersionUID = 0x0097000a;

    private int ID;

    public int getID() {
        return ID;
    }

    private MetricReport setID(final int value) {
        this.ID = value;

        return this;
    }

    public static MetricReport find(final String uri) throws java.io.IOException {
        return find(uri, com.dslplatform.client.Bootstrap.getLocator());
    }

    public static MetricReport find(final String uri, final com.dslplatform.patterns.ServiceLocator locator) throws java.io.IOException {
        try {
            return (locator != null ? locator : com.dslplatform.client.Bootstrap.getLocator()).resolve(com.dslplatform.client.CrudProxy.class)
                    .read(MetricReport.class, uri).get();
        } catch (final InterruptedException e) {
            throw new java.io.IOException(e);
        } catch (final java.util.concurrent.ExecutionException e) {
            throw new java.io.IOException(e);
        }
    }

    public static java.util.List<MetricReport> find(final Iterable<String> uris) throws java.io.IOException {
        return find(uris, com.dslplatform.client.Bootstrap.getLocator());
    }

    public static java.util.List<MetricReport> find(final Iterable<String> uris, final com.dslplatform.patterns.ServiceLocator locator)
            throws java.io.IOException {
        try {
            return (locator != null ? locator : com.dslplatform.client.Bootstrap.getLocator()).resolve(com.dslplatform.client.DomainProxy.class)
                    .find(MetricReport.class, uris).get();
        } catch (final InterruptedException e) {
            throw new java.io.IOException(e);
        } catch (final java.util.concurrent.ExecutionException e) {
            throw new java.io.IOException(e);
        }
    }

    public static java.util.List<MetricReport> search() throws java.io.IOException {
        return search(null, null, com.dslplatform.client.Bootstrap.getLocator());
    }

    public static java.util.List<MetricReport> search(final com.dslplatform.patterns.ServiceLocator locator) throws java.io.IOException {
        return search(null, null, locator);
    }

    public static java.util.List<MetricReport> search(final Integer limit, final Integer offset) throws java.io.IOException {
        return search(limit, offset, com.dslplatform.client.Bootstrap.getLocator());
    }

    public static java.util.List<MetricReport> search(final Integer limit, final Integer offset, final com.dslplatform.patterns.ServiceLocator locator)
            throws java.io.IOException {
        try {
            return (locator != null ? locator : com.dslplatform.client.Bootstrap.getLocator()).resolve(com.dslplatform.client.DomainProxy.class)
                    .search(MetricReport.class, limit, offset, null).get();
        } catch (final InterruptedException e) {
            throw new java.io.IOException(e);
        } catch (final java.util.concurrent.ExecutionException e) {
            throw new java.io.IOException(e);
        }
    }

    public static java.util.List<MetricReport> search(final com.dslplatform.patterns.Specification<MetricReport> specification) throws java.io.IOException {
        return search(specification, null, null, com.dslplatform.client.Bootstrap.getLocator());
    }

    public static java.util.List<MetricReport> search(
            final com.dslplatform.patterns.Specification<MetricReport> specification,
            final com.dslplatform.patterns.ServiceLocator locator) throws java.io.IOException {
        return search(specification, null, null, locator);
    }

    public static java.util.List<MetricReport> search(
            final com.dslplatform.patterns.Specification<MetricReport> specification,
            final Integer limit,
            final Integer offset) throws java.io.IOException {
        return search(specification, limit, offset, com.dslplatform.client.Bootstrap.getLocator());
    }

    public static java.util.List<MetricReport> search(
            final com.dslplatform.patterns.Specification<MetricReport> specification,
            final Integer limit,
            final Integer offset,
            final com.dslplatform.patterns.ServiceLocator locator) throws java.io.IOException {
        try {
            return (locator != null ? locator : com.dslplatform.client.Bootstrap.getLocator()).resolve(com.dslplatform.client.DomainProxy.class)
                    .search(specification, limit, offset, null).get();
        } catch (final InterruptedException e) {
            throw new java.io.IOException(e);
        } catch (final java.util.concurrent.ExecutionException e) {
            throw new java.io.IOException(e);
        }
    }

    public static long count() throws java.io.IOException {
        return count(com.dslplatform.client.Bootstrap.getLocator());
    }

    public static long count(final com.dslplatform.patterns.ServiceLocator locator) throws java.io.IOException {
        try {
            return (locator != null ? locator : com.dslplatform.client.Bootstrap.getLocator()).resolve(com.dslplatform.client.DomainProxy.class)
                    .count(MetricReport.class).get();
        } catch (final InterruptedException e) {
            throw new java.io.IOException(e);
        } catch (final java.util.concurrent.ExecutionException e) {
            throw new java.io.IOException(e);
        }
    }

    public static long count(final com.dslplatform.patterns.Specification<MetricReport> specification) throws java.io.IOException {
        return count(specification, com.dslplatform.client.Bootstrap.getLocator());
    }

    public static long count(final com.dslplatform.patterns.Specification<MetricReport> specification, final com.dslplatform.patterns.ServiceLocator locator)
            throws java.io.IOException {
        try {
            return (locator != null ? locator : com.dslplatform.client.Bootstrap.getLocator()).resolve(com.dslplatform.client.DomainProxy.class)
                    .count(specification).get();
        } catch (final InterruptedException e) {
            throw new java.io.IOException(e);
        } catch (final java.util.concurrent.ExecutionException e) {
            throw new java.io.IOException(e);
        }
    }

    private java.util.List<com.dslplatform.example.kamon.Metric> metrics;

    public java.util.List<com.dslplatform.example.kamon.Metric> getMetrics() {
        return metrics;
    }

    public MetricReport setMetrics(final java.util.List<com.dslplatform.example.kamon.Metric> value) {
        if (value == null) throw new IllegalArgumentException("Property \"metrics\" cannot be null!");
        com.dslplatform.example.Guards.checkNulls(value);
        this.metrics = value;

        return this;
    }

    private org.joda.time.DateTime from;

    public org.joda.time.DateTime getFrom() {
        return from;
    }

    public MetricReport setFrom(final org.joda.time.DateTime value) {
        if (value == null) throw new IllegalArgumentException("Property \"from\" cannot be null!");
        this.from = value;

        return this;
    }

    private org.joda.time.DateTime to;

    public org.joda.time.DateTime getTo() {
        return to;
    }

    public MetricReport setTo(final org.joda.time.DateTime value) {
        if (value == null) throw new IllegalArgumentException("Property \"to\" cannot be null!");
        this.to = value;

        return this;
    }

    public void serialize(final com.dslplatform.client.json.JsonWriter sw, final boolean minimal) {
        sw.writeByte(com.dslplatform.client.json.JsonWriter.OBJECT_START);
        if (minimal) {
            __serializeJsonObjectMinimal(sw, false);
        } else {
            __serializeJsonObjectFull(sw, false);
        }
        sw.writeByte(com.dslplatform.client.json.JsonWriter.OBJECT_END);
    }

    void __serializeJsonObjectMinimal(com.dslplatform.client.json.JsonWriter sw, boolean hasWrittenProperty) {
        sw.writeAscii("\"URI\":");
        com.dslplatform.client.json.StringConverter.serializeShort(this.URI, sw);

        if (this.ID != 0) {
            sw.writeAscii(",\"ID\":", 6);
            com.dslplatform.client.json.NumberConverter.serialize(this.ID, sw);
        }

        if (this.metrics.size() != 0) {
            sw.writeAscii(",\"metrics\":[", 12);
            com.dslplatform.example.kamon.Metric item = this.metrics.get(0);
            sw.writeByte(com.dslplatform.client.json.JsonWriter.OBJECT_START);
            item.__serializeJsonObjectMinimal(sw, false);
            sw.writeByte(com.dslplatform.client.json.JsonWriter.OBJECT_END);
            for (int i = 1; i < this.metrics.size(); i++) {
                sw.writeByte(com.dslplatform.client.json.JsonWriter.COMMA);
                item = this.metrics.get(i);
                sw.writeByte(com.dslplatform.client.json.JsonWriter.OBJECT_START);
                item.__serializeJsonObjectMinimal(sw, false);
                sw.writeByte(com.dslplatform.client.json.JsonWriter.OBJECT_END);
            }
            sw.writeByte(com.dslplatform.client.json.JsonWriter.ARRAY_END);
        }

        if (this.from != org.joda.time.DateTime.now()) {
            sw.writeAscii(",\"from\":", 8);
            com.dslplatform.client.json.DateConverter.serialize(this.from, sw);
        }

        if (this.to != org.joda.time.DateTime.now()) {
            sw.writeAscii(",\"to\":", 6);
            com.dslplatform.client.json.DateConverter.serialize(this.to, sw);
        }
    }

    void __serializeJsonObjectFull(com.dslplatform.client.json.JsonWriter sw, boolean hasWrittenProperty) {
        sw.writeAscii("\"URI\":");
        com.dslplatform.client.json.StringConverter.serializeShort(this.URI, sw);

        sw.writeAscii(",\"ID\":", 6);
        com.dslplatform.client.json.NumberConverter.serialize(this.ID, sw);

        if (this.metrics.size() != 0) {
            sw.writeAscii(",\"metrics\":[", 12);
            com.dslplatform.example.kamon.Metric item = this.metrics.get(0);
            sw.writeByte(com.dslplatform.client.json.JsonWriter.OBJECT_START);
            item.__serializeJsonObjectFull(sw, false);
            sw.writeByte(com.dslplatform.client.json.JsonWriter.OBJECT_END);
            for (int i = 1; i < this.metrics.size(); i++) {
                sw.writeByte(com.dslplatform.client.json.JsonWriter.COMMA);
                item = this.metrics.get(i);
                sw.writeByte(com.dslplatform.client.json.JsonWriter.OBJECT_START);
                item.__serializeJsonObjectFull(sw, false);
                sw.writeByte(com.dslplatform.client.json.JsonWriter.OBJECT_END);
            }
            sw.writeByte(com.dslplatform.client.json.JsonWriter.ARRAY_END);
        } else sw.writeAscii(",\"metrics\":[]", 13);

        sw.writeAscii(",\"from\":", 8);
        com.dslplatform.client.json.DateConverter.serialize(this.from, sw);

        sw.writeAscii(",\"to\":", 6);
        com.dslplatform.client.json.DateConverter.serialize(this.to, sw);
    }

    public static com.dslplatform.client.json.JsonReader.ReadJsonObject<MetricReport> JSON_READER = new com.dslplatform.client.json.JsonReader.ReadJsonObject<MetricReport>() {
        @Override
        public MetricReport deserialize(final com.dslplatform.client.json.JsonReader reader, final com.dslplatform.patterns.ServiceLocator locator)
                throws java.io.IOException {
            return new com.dslplatform.example.kamon.MetricReport(reader, locator);
        }
    };

    private MetricReport(final com.dslplatform.client.json.JsonReader reader, final com.dslplatform.patterns.ServiceLocator _serviceLocator)
            throws java.io.IOException {
        this._serviceLocator = _serviceLocator;
        String _URI_ = "";
        int _ID_ = 0;
        java.util.List<com.dslplatform.example.kamon.Metric> _metrics_ = new java.util.ArrayList<com.dslplatform.example.kamon.Metric>(4);
        org.joda.time.DateTime _from_ = com.dslplatform.client.json.DateConverter.MIN_DATE_TIME;
        org.joda.time.DateTime _to_ = com.dslplatform.client.json.DateConverter.MIN_DATE_TIME;
        byte nextToken = reader.last();
        if (nextToken != '}') {
            int nameHash = reader.fillName();
            nextToken = reader.getNextToken();
            if (nextToken == 'n') {
                if (reader.wasNull()) {
                    nextToken = reader.getNextToken();
                } else {
                    throw new java.io.IOException("Expecting 'u' (as null) at position " + reader.positionInStream() + ". Found " + (char) nextToken);
                }
            } else {
                switch (nameHash) {
                    case 2053729053:
                        _URI_ = reader.readString();
                        nextToken = reader.getNextToken();
                        break;
                    case 1458105184:
                        _ID_ = com.dslplatform.client.json.NumberConverter.deserializeInt(reader);
                        nextToken = reader.getNextToken();
                        break;
                    case -253285258:

                        if (nextToken == '[') {
                            nextToken = reader.getNextToken();
                            if (nextToken != ']') {
                                reader.deserializeCollection(com.dslplatform.example.kamon.Metric.JSON_READER, _metrics_);
                            }
                            nextToken = reader.getNextToken();
                        } else throw new java.io.IOException("Expecting '[' at position " + reader.positionInStream() + ". Found " + (char) nextToken);
                        break;
                    case -1781694347:
                        _from_ = com.dslplatform.client.json.DateConverter.deserializeDateTime(reader);
                        nextToken = reader.getNextToken();
                        break;
                    case 1111836708:
                        _to_ = com.dslplatform.client.json.DateConverter.deserializeDateTime(reader);
                        nextToken = reader.getNextToken();
                        break;
                    default:
                        nextToken = reader.skip();
                        break;
                }
            }
            while (nextToken == ',') {
                nextToken = reader.getNextToken();
                nameHash = reader.fillName();
                nextToken = reader.getNextToken();
                if (nextToken == 'n') {
                    if (reader.wasNull()) {
                        nextToken = reader.getNextToken();
                        continue;
                    } else {
                        throw new java.io.IOException("Expecting 'u' (as null) at position " + reader.positionInStream() + ". Found " + (char) nextToken);
                    }
                }
                switch (nameHash) {
                    case 2053729053:
                        _URI_ = reader.readString();
                        nextToken = reader.getNextToken();
                        break;
                    case 1458105184:
                        _ID_ = com.dslplatform.client.json.NumberConverter.deserializeInt(reader);
                        nextToken = reader.getNextToken();
                        break;
                    case -253285258:

                        if (nextToken == '[') {
                            nextToken = reader.getNextToken();
                            if (nextToken != ']') {
                                reader.deserializeCollection(com.dslplatform.example.kamon.Metric.JSON_READER, _metrics_);
                            }
                            nextToken = reader.getNextToken();
                        } else throw new java.io.IOException("Expecting '[' at position " + reader.positionInStream() + ". Found " + (char) nextToken);
                        break;
                    case -1781694347:
                        _from_ = com.dslplatform.client.json.DateConverter.deserializeDateTime(reader);
                        nextToken = reader.getNextToken();
                        break;
                    case 1111836708:
                        _to_ = com.dslplatform.client.json.DateConverter.deserializeDateTime(reader);
                        nextToken = reader.getNextToken();
                        break;
                    default:
                        nextToken = reader.skip();
                        break;
                }
            }
            if (nextToken != '}') { throw new java.io.IOException("Expecting '}' at position " + reader.positionInStream() + ". Found " + (char) nextToken); }
        }

        this.URI = _URI_;
        this.ID = _ID_;
        this.metrics = _metrics_;
        this.from = _from_;
        this.to = _to_;
    }

    public static Object deserialize(final com.dslplatform.client.json.JsonReader reader, final com.dslplatform.patterns.ServiceLocator locator)
            throws java.io.IOException {
        switch (reader.getNextToken()) {
            case 'n':
                if (reader.wasNull()) return null;
                throw new java.io.IOException("Invalid null value found at: " + reader.positionInStream());
            case '{':
                reader.getNextToken();
                return new com.dslplatform.example.kamon.MetricReport(reader, locator);
            case '[':
                return reader.deserializeNullableCollection(JSON_READER);
            default:
                throw new java.io.IOException("Invalid char value found at: " + reader.positionInStream() + ". Expecting null, { or [. Found: "
                        + (char) reader.last());
        }
    }

    public MetricReport(final java.util.List<com.dslplatform.example.kamon.Metric> metrics, final org.joda.time.DateTime from, final org.joda.time.DateTime to) {
        setMetrics(metrics);
        setFrom(from);
        setTo(to);
    }
}
