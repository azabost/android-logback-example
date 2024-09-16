# Don't obfuscate the names of classes containing a Logger.
-keepclasseswithmembernames class * {
    org.slf4j.Logger *;
}

# Don't obfuscate the names of enclosing classes when their companion objects contain a Logger.
-if class **$* {
    org.slf4j.Logger *;
}
-keepclasseswithmembernames class <1>
