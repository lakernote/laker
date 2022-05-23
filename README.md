# laker

**Laker** is a Spring Boot-based collection of tools that includes the following features.

- Configuration Item Encryption

- Invokes time-consuming link printing

- Data desensitization

- Added traceId for log MDC

## Add dependency

```xml
<dependency>
    <groupId>io.github.lakernote</groupId>
    <artifactId>laker-spring-boot-starter</artifactId>
    <version>1.0.2</version>
</dependency>
```

## application.yml

```yaml
laker:
  password: enc:25d778c22331899a1f79eab82a1d930b9abc4633fb948387c764e5f1f9e5bd3f
```

The format is `enc :` + **ciphertext**

## The command line

Add parameters to the command line.

```shell
-Denc.key=A string of 16 characters
```

For example , `-Denc.key=1234567890123456`

## Start project testing

The decrypted configuration will be printed.

```
laker.password

laker11111111111111111
```

