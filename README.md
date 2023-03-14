# enigma-machine

The Enigma machine is one of the most famous and complex encryption machines ever created, and recreating its exact workings would be difficult and would require advanced knowledge of cryptography. However, it is possible to create a Java program that emulates some of the features of Enigma and allows you to encrypt and decrypt messages.

Here is a basic example of a program that encrypts and decrypts a message using a set of user-defined keys.

In this example, the program asks the user to enter a message and an encryption key. The message is then encrypted by applying the key to each character in the message. The key is repeated until it is the same length as the message. The end result is the encrypted message. The program also asks the user to enter the encrypted message they want to decrypt, along with the encryption key. The key is applied to each character of the encrypted message, similarly to the encryption process, but this time subtracting the key instead of adding it. The end result is the decrypted message.

This is just a basic example and lacks the sophistication of the real Enigma machine, but it can serve as a starting point for working with encryption algorithms.

**Obs:** This project uses Quarkus, the Supersonic Subatomic Java Framework. If you want to learn more about Quarkus, please visit its website: https://quarkus.io/ .

## Project premise
- Install jdk 11.0.17
- Install apache maven 3.8.3

## Running the application in dev mode

You can run your application in dev mode that enables live coding using:
```script
mvn compile quarkus:dev
```

> **_NOTE:_**  Quarkus now ships with a Dev UI, which is available in dev mode only at http://localhost:8080/q/dev/.

## Packaging and running the application

The application can be packaged using:
```script
mvn clean package -DskipTests
```
It produces the `quarkus-run.jar` file in the `target/quarkus-app/` directory.
Be aware that it’s not an _über-jar_ as the dependencies are copied into the `target/quarkus-app/lib/` directory.

The application is now runnable using `java -jar ./target/quarkus-app/quarkus-run.jar`.

If you want to build an _über-jar_, execute the following command:
```script
mvn clean package -Dquarkus.package.type=uber-jar -DskipTests
```
The application, packaged as an _über-jar_, is now runnable using `java -jar ./target/enigma-machine-1.0-runner.jar`.

## Access API specifications
After running enigma-machine go to the URL [http://localhost:8080/q/swagger-ui/](http://localhost:8080/q/swagger-ui/)