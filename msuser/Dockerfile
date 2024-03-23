# docker build -f Dockerfile -t techshop-local .
# docker run -p 5432:5432 -v $(pwd):/techshop/ techshop-local

FROM postgres:latest

ENV POSTGRES_DB techshop
ENV POSTGRES_USER postgres
ENV POSTGRES_PASSWORD postgres

COPY init.sql /docker-entrypoint-initdb.d/

EXPOSE 5432