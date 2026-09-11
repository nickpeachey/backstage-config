# ${{ values.name }}

${{ values.description if values.description else "A .NET 10 minimal Web API scaffolded from a Backstage template." }}

## Getting started

Requires the [.NET 10 SDK](https://dotnet.microsoft.com/download/dotnet/10.0).

```sh
dotnet run --project src
```

The API listens on `http://localhost:5000`. The generated OpenAPI document is
available in development at `http://localhost:5000/openapi/v1.json`, and the
sample endpoint at `http://localhost:5000/weatherforecast`.

## Docker

```sh
docker build -t ${{ values.name }} .
docker run -p 8080:8080 ${{ values.name }}
```

## Catalog

This service is registered in Backstage via [catalog-info.yaml](./catalog-info.yaml),
which defines the `${{ values.name }}` Component and the `${{ values.name }}-api`
API (OpenAPI spec in [openapi.yaml](./openapi.yaml)).
