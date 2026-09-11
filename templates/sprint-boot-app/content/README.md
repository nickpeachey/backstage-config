# ${{ values.name }}

${{ values.description if values.description else "A Spring Boot 4 Web API scaffolded from a Backstage template." }}

## Getting started

Requires a [JDK 21](https://adoptium.net/). Gradle is provided via the wrapper,
so no local Gradle install is needed (the Kotlin DSL build lives in
[build.gradle.kts](./build.gradle.kts)).

```sh
./gradlew bootRun
```

The API listens on `http://localhost:8080`. Try the sample endpoint at
`http://localhost:8080/weatherforecast`, and the health probe at
`http://localhost:8080/actuator/health`.

## Docker

```sh
docker build -t ${{ values.name }} .
docker run -p 8080:8080 ${{ values.name }}
```

## Catalog

This service is registered in Backstage via [catalog-info.yaml](./catalog-info.yaml),
which defines the `${{ values.name }}` Component and the `${{ values.name }}-api`
API (OpenAPI spec in [openapi.yaml](./openapi.yaml)).
