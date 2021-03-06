# Android Logger

View the project's web site [here](http://michelzanini.github.io/android-logger).

It is hard to work with log levels when using <b>android.util.Log</b> class.   
The methods are short and not very readable, like Log.d, Log.e, etc... There aren`t many options to format the log.    
Also, there are a few bugs, like logging a null String will crash the app.    

This project is a simple wrapper above the <b>android.util.Log</b> class. It is similar to Apache Commons Logging, as many may be used to.
The log levels available are: verbose, debug, info, warn and error.

This is an example of how to obtain a Logger instance:

```java
//using a String as Log Tag
Logger logger = LoggerFactory.getLogger("LOG_TAG");

//using a class name as Log Tag
Logger logger = LoggerFactory.getLogger(getClass());
```

These are some of the log methods available:

```java
//logging a String message
logger.debug("String message");

//logging a String using arguments to format the string (message and params are used with String.format())
logger.info("String with params: Param 1 = %s, Param 2 = %s", "Param 1 Value", "Param 2 Value");

//logging a Exception
logger.error(e);

//logging a message and a Exception
logger.error("Message", e);
```

How to set the desired log level for logging (default is Level.INFO):

```java
//log level constant from code
LoggerFactory.setLevel(LoggerLevel.DEBUG);

//log level constant from strings.xml
LoggerFactory.setLevelFromStringResource(context, R.string.log_level);

/*
in the 'strings.xml' file
<string name="log_level">DEBUG</string>
*/
```

How to filter log messages that can impact performance:

```java
if (logger.isDebugEnabled()) {
   logger.debug("Message " + variable + " something else...");
}
```

## How to get it

[Download the bundle](http://michelzanini.github.io/android-logger/downloads/1.0.1/android-logger-1.0.1-dist.zip) or add it as a Maven dependency:

```xml
<dependency>
   <groupId>com.github.michelzanini</groupId>
   <artifactId>android-logger</artifactId>
   <version>1.0.1</version>
</dependency>
```


