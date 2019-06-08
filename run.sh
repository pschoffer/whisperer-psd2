#bash

git pull
./gradlew build
java -jar  build/libs/whisperer-0.0.1-SNAPSHOT.jar  -Dspring.profiles.active=local -Djava.net.preferIPv4Stack=true > /tmp/backend.log &
