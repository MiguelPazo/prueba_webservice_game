# docker build -t webservice_game .
# docker run -dp 3032:3032 -t webservice_game

FROM gradle:jdk11

WORKDIR /app
COPY . /app
CMD ["./bootstrap.sh"]