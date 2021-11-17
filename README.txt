auth-services: 8080
common-services: 8081
mail-cron: 8082
mail-services: 8083
reservation-services: 8084
services-registry: 8761

## Run Reservation Service
docker run -it --net dev-network -e MYSQL_HOST=mysql8.0 faisalbegins/reservation-service

## Run Mail Service
docker run -it -e KAFKA_HOST_PORT='host.docker.internal:9092' -e KAFKA_TOPIC_GROUP='group_json' faisalbegins/mail-service