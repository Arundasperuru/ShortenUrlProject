# ShortenUrlProject

1) Postgres db should be up
2) configure your database username and password and port number in the applicatio.properties file
3) run the application
4) open postman
5) PostRequest 
    request : {localhost:8081/createShortUrl}
    header : contentType : applicationJson
    body : {
              "originalUrl" : "{give any url here}"
           }
           
6) you will get response of both original and shorten url
7) copy the shorten url and paste it in browser (or) press ctrl button and click the shoren link
