DB_PORT=5444
docker build -t doobie-postgres --no-cache . && docker run -p$DB_PORT:5432  doobie-postgres