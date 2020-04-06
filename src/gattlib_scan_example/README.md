# Gattlib BLE scan example

## where to find what

In the build.grade are several definition found , including the dependency definition that a library (here called bluetooth)
should be compiled for linux

```gradle
linuxX64("linux"){
     compilations.main.cinterops {
         bluetooth
     }
}
```

the definition which headers sould be used is found in src/nativeInterop/cinterop/bluetooth.def

under the `---` is the corresponing c code located

In the src/commonMain/kotlin/sample/Sample.kt is the base defined. here an object named platfom that have to be in every
platform implementation.

the implementation is done in the src/commonMain/kotlin/sample/Sample.kt

## Notes

the code needs some free statements to clean up memory leaks