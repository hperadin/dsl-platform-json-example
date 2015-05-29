# DSL Platform - JSON example

A mini-example illustrating the use of DSL Platform's JSON (de)serialization.  
To build and run use `build-and-run-example.sh` (or `.bat` if on Windows).

Running the build script will perform the following:

* Compiling the DSL schema into the `src\generated\java` folder and package those into `target\model.jar`
* Compiling the main program, and package that into `target\dsl-platform-json-example.jar`
* Finally, it will run the jar (Main.java program) to show a working example

### Best practices for using JsonWriter:
	
* Reuse `JsonWriter` per thread, remember to `reset()` before use.
* Prefer `.toStream(OutputStream)` instead of `.toByteArray()`
* The `.toByteArray()` is a utility method, which performs an additional copy of the resulting byte array. You can avoid this by using the `.toBytes()` which gives you access to the result without copying the internal `JsonWriter` buffer.
