# DSL Platform - JSON example

A mini-example illustrating the use of DSL Platform's JSON (de)serialization.  
To build and run use `build-and-run-example.sh` (or `.bat` if on Windows).

Running the build script will perform the following:

 * Compiling the DSL schema into the `src\generated\java` folder and package those into `target\model.jar`
 * Compiling the main program, and package that into `target\dsl-platform-json-example.jar`
 * Finally, it will run the jar (Main.java program) to show a working example

### Best practices for using JsonWriter:

 * Reuse `JsonWriter` whenever possible, remember to `reset()` before reuse. For per thread reuse, use something like `ThreadLocal<JsonWriter>` 
 * Prefer `.toStream(OutputStream)` instead of `.toByteArray()`
 * The `.toByteArray()` is a utility method, which performs an additional copy of the resulting byte array. You can avoid this by using the `.toBytes()` which gives you access to the result without copying the internal `JsonWriter` buffer.
 * non-nullable collections can be serialized using `serialize(array or collection)` method.

### Best practices for using JsonReader:

 * Prefer constructor for reusing `byte[]`: `JsonReader(byte[], int, ServiceLocator)`
 * and even `char[]`: `JsonReader(byte[], int, ServiceLocator, char[])`

### FAQ

 Q: What should I provide for `ServiceLocator` dependency?
 
 A: If you only use JSON part of the library, just provide null for `ServiceLocator` 

 Q: How do I register my custom object for JSON?
 
 A: Serialization can be done for any type implementing `com.dslplatform.client.json.JsonObject` signature. For deserialization `JSON_READER` convention should be followed. Each object which needs to be deserialized should have `public static com.dslplatform.client.json.JsonReader.ReadJsonObject<Metric> JSON_READER;`  

 Q: How do I register external types (which don't register `com.dslplatform.client.json.JsonObject`)?
 
 A: `com.dslplatform.client.json.DslJsonSerialization` contains `registerReader` and `registerWriter` methods for custom primitives (this can be used for custom objects too).

 Q: Why is DSL JSON faster than others?
 
 A: Almost zero allocations. Works on byte level. Better algorithms for conversion from `byte[]` -> type and vice-versa. Minimized unexpected branching.
