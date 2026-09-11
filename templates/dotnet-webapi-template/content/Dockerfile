FROM mcr.microsoft.com/dotnet/sdk:10.0 AS build
WORKDIR /src
COPY src/*.csproj ./src/
RUN dotnet restore ./src/${{ values.name }}.csproj
COPY . .
RUN dotnet publish ./src/${{ values.name }}.csproj -c Release -o /app/publish

FROM mcr.microsoft.com/dotnet/aspnet:10.0 AS runtime
WORKDIR /app
COPY --from=build /app/publish .
EXPOSE 8080
ENV ASPNETCORE_URLS=http://+:8080
ENTRYPOINT ["dotnet", "${{ values.name }}.dll"]