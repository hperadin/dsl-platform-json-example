package com.dslplatform.example.kamon;

public final class Metric implements java.io.Serializable, com.dslplatform.client.json.JsonObject {
    public Metric(final String name, final long min, final long max, final long sum) {
        setName(name);
        setMin(min);
        setMax(max);
        setSum(sum);
    }

    public Metric() {
        this.name = "";
        this.min = 0L;
        this.max = 0L;
        this.sum = 0L;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + 1561116808;
        result = prime * result + (this.name.hashCode());
        result = prime * result + ((int) (this.min ^ (this.min >>> 32)));
        result = prime * result + ((int) (this.max ^ (this.max >>> 32)));
        result = prime * result + ((int) (this.sum ^ (this.sum >>> 32)));
        return result;
    }

    @Override
    public boolean equals(final Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;

        if (!(obj instanceof Metric)) return false;
        final Metric other = (Metric) obj;

        if (!(this.name.equals(other.name))) return false;
        if (!(this.min == other.min)) return false;
        if (!(this.max == other.max)) return false;
        if (!(this.sum == other.sum)) return false;

        return true;
    }

    @Override
    public String toString() {
        return "Metric(" + name + ',' + min + ',' + max + ',' + sum + ')';
    }

    private static final long serialVersionUID = 0x0097000a;

    private String name;

    public String getName() {
        return name;
    }

    public Metric setName(final String value) {
        if (value == null) throw new IllegalArgumentException("Property \"name\" cannot be null!");
        this.name = value;

        return this;
    }

    private long min;

    public long getMin() {
        return min;
    }

    public Metric setMin(final long value) {
        this.min = value;

        return this;
    }

    private long max;

    public long getMax() {
        return max;
    }

    public Metric setMax(final long value) {
        this.max = value;

        return this;
    }

    private long sum;

    public long getSum() {
        return sum;
    }

    public Metric setSum(final long value) {
        this.sum = value;

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
        if (!(this.name.length() == 0)) {
            hasWrittenProperty = true;
            sw.writeAscii("\"name\":", 7);
            com.dslplatform.client.json.StringConverter.serialize(this.name, sw);
        }

        if (this.min != 0L) {
            if (hasWrittenProperty) sw.writeByte(com.dslplatform.client.json.JsonWriter.COMMA);
            hasWrittenProperty = true;
            sw.writeAscii("\"min\":", 6);
            com.dslplatform.client.json.NumberConverter.serialize(this.min, sw);
        }

        if (this.max != 0L) {
            if (hasWrittenProperty) sw.writeByte(com.dslplatform.client.json.JsonWriter.COMMA);
            hasWrittenProperty = true;
            sw.writeAscii("\"max\":", 6);
            com.dslplatform.client.json.NumberConverter.serialize(this.max, sw);
        }

        if (this.sum != 0L) {
            if (hasWrittenProperty) sw.writeByte(com.dslplatform.client.json.JsonWriter.COMMA);
            hasWrittenProperty = true;
            sw.writeAscii("\"sum\":", 6);
            com.dslplatform.client.json.NumberConverter.serialize(this.sum, sw);
        }
    }

    void __serializeJsonObjectFull(com.dslplatform.client.json.JsonWriter sw, boolean hasWrittenProperty) {
        sw.writeAscii("\"name\":", 7);
        com.dslplatform.client.json.StringConverter.serialize(this.name, sw);

        sw.writeAscii(",\"min\":", 7);
        com.dslplatform.client.json.NumberConverter.serialize(this.min, sw);

        sw.writeAscii(",\"max\":", 7);
        com.dslplatform.client.json.NumberConverter.serialize(this.max, sw);

        sw.writeAscii(",\"sum\":", 7);
        com.dslplatform.client.json.NumberConverter.serialize(this.sum, sw);
    }

    public static com.dslplatform.client.json.JsonReader.ReadJsonObject<Metric> JSON_READER = new com.dslplatform.client.json.JsonReader.ReadJsonObject<Metric>() {
        @Override
        public Metric deserialize(final com.dslplatform.client.json.JsonReader reader, final com.dslplatform.patterns.ServiceLocator locator)
                throws java.io.IOException {
            return new com.dslplatform.example.kamon.Metric(reader, locator);
        }
    };

    private Metric(final com.dslplatform.client.json.JsonReader reader, final com.dslplatform.patterns.ServiceLocator _serviceLocator)
            throws java.io.IOException {
        String _name_ = "";
        long _min_ = 0L;
        long _max_ = 0L;
        long _sum_ = 0L;
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
                    case -1925595674:
                        _name_ = com.dslplatform.client.json.StringConverter.deserialize(reader);
                        nextToken = reader.getNextToken();
                        break;
                    case -913357481:
                        _min_ = com.dslplatform.client.json.NumberConverter.deserializeLong(reader);
                        nextToken = reader.getNextToken();
                        break;
                    case -677190887:
                        _max_ = com.dslplatform.client.json.NumberConverter.deserializeLong(reader);
                        nextToken = reader.getNextToken();
                        break;
                    case -582075736:
                        _sum_ = com.dslplatform.client.json.NumberConverter.deserializeLong(reader);
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
                    case -1925595674:
                        _name_ = com.dslplatform.client.json.StringConverter.deserialize(reader);
                        nextToken = reader.getNextToken();
                        break;
                    case -913357481:
                        _min_ = com.dslplatform.client.json.NumberConverter.deserializeLong(reader);
                        nextToken = reader.getNextToken();
                        break;
                    case -677190887:
                        _max_ = com.dslplatform.client.json.NumberConverter.deserializeLong(reader);
                        nextToken = reader.getNextToken();
                        break;
                    case -582075736:
                        _sum_ = com.dslplatform.client.json.NumberConverter.deserializeLong(reader);
                        nextToken = reader.getNextToken();
                        break;
                    default:
                        nextToken = reader.skip();
                        break;
                }
            }
            if (nextToken != '}') { throw new java.io.IOException("Expecting '}' at position " + reader.positionInStream() + ". Found " + (char) nextToken); }
        }

        this.name = _name_;
        this.min = _min_;
        this.max = _max_;
        this.sum = _sum_;
    }

    public static Object deserialize(final com.dslplatform.client.json.JsonReader reader, final com.dslplatform.patterns.ServiceLocator locator)
            throws java.io.IOException {
        switch (reader.getNextToken()) {
            case 'n':
                if (reader.wasNull()) return null;
                throw new java.io.IOException("Invalid null value found at: " + reader.positionInStream());
            case '{':
                reader.getNextToken();
                return new com.dslplatform.example.kamon.Metric(reader, locator);
            case '[':
                return reader.deserializeNullableCollection(JSON_READER);
            default:
                throw new java.io.IOException("Invalid char value found at: " + reader.positionInStream() + ". Expecting null, { or [. Found: "
                        + (char) reader.last());
        }
    }
}
