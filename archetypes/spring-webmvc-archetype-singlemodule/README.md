# spring-rest-api-archetype
Maven archetype for Spring native REST API with webmvc, data-jpa, security (OpenID) and OpenAPI.

It is intended to be extended with one maven module per Spring `@RestController`: an higher number of micro-service applications allows great control over overall scallability and availability.

# Sample usage
If not already set you must define following env variables: `SERVER_SSL_KEY_STORE`, `SERVER_SSL_KEY_STORE_PASSWORD` and `SERVER_SSL_KEY_PASSWORD`. Please refer to [this tutorial](https://github.com/ch4mpy/self-signed-certificate-generation) if you do not already have self-signed SSL certificate.

``` bash
# generate a new project using the archetype
mvn archetype:generate \
  -DarchetypeCatalog=remote \
  -DarchetypeGroupId=com.c4-soft.springaddons \
  -DarchetypeArtifactId=spring-webmvc-archetype-singlemodule \
  -DarchetypeVersion=4.2.0 \
  -DgroupId=com.c4-soft \
  -DartifactId=bao-loc \
  -Dversion=1.0.0-SNAPSHOT \
  -Dapi-artifactId=solutions-api \
  -Dapi-path=solutions

cd bao-loc

# generate OpenAPI spec
mvn clean install -Popenapi -DskipTests

# run
mvn spring-boot:run -pl sample-api

# generate regular (JVM) docker image
mvn clean package -Pbuild-image

# generate native docker image
mvn clean package -Pbuild-native-image -DskipTests
docker run --rm -p 8080:8080 -t sample-api:1.0.0-SNAPSHOT
```

If you ever wanted to use a snapshot, clone this repo, edit the archetype and then run:
``` bash
# install the archetype
cd spring-webmvc-archetype-singlemodule
mvn install
cd ..

# generate a new project using the local SNAPSHOT
```bash
mvn archetype:generate \
  -DarchetypeCatalog=local \
  -DarchetypeGroupId=com.c4-soft.springaddons \
  -DarchetypeArtifactId=spring-webmvc-archetype-singlemodule \
  -DarchetypeVersion=4.2.1-SNAPSHOT \
  -DgroupId=com.c4-soft \
  -DartifactId=bao-loc \
  -Dversion=1.0.0-SNAPSHOT
```