# Trade Mediator API

![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&labelColor=black&logo=openjdk&logoColor=ED8B00)
![Spring](https://img.shields.io/badge/Spring-6DB33F?style=for-the-badge&labelColor=black&logo=spring&logoColor=6DB33F)
![PostgreSQL](https://img.shields.io/badge/PostgreSQL-4169E1?style=for-the-badge&labelColor=black&logo=postgresql&logoColor=4169E1)

A REST API for a simple platform that supports importers and exporters to communicate with each other, using a bank as
intermediary.

## Relevant Links

[Data Model](https://app.diagrams.net/#G19Jiycc_v9KolPfTiTQ08G6SXK9qh4hBU#%7B%22pageId%22%3A%22R2lEEEUBdFMjLlhIrx00%22%7D)

[API GitHub Repository]()

[Angular Client GitHub Repository]()

## Getting started

### Prerequisites

[JDK 17+](http://www.oracle.com/technetwork/java/javase/downloads/index.html)

[Gradle](http://www.gradle.org/downloads)

[PostgreSQL 15.3](https://www.postgresql.org/download/)

### Running the application locally

1. Create a PostgreSQL database
2. Copy the contents of `.env.example` file to a `.env` file and update the necessary fields with your configuration.

`To insert mock data in the database, set the INSERT_MOCK_DATA variable to true`

3. Build & Run the application
4. Access the application using http://localhost:8080/ *
5. OpenApi Documentation is available at http://localhost:8080/swagger-ui.html *

- `* Replace 8080 with your updated port if you're not using the default one`