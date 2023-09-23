# Lab01

## Crear e executar projeto Maven 

mvn archetype:generate -DgroupId=com.mycompany.app -DartifactId=my-app -DarchetypeArtifactId=maven-archetype-quickstart -DinteractiveMode=false

groupID = com.ua.pt

artifactID = "nome projeto"

mvn package

mvn exec:java -Dexec.mainClass="com.ua.pt.WeatherStarter" -Dexec.args=""

Extensoes sao colocadas no pom.xml

mvn clean - limpa target

mvn clean package - limpa binarios faz package

mvn install - coloca no repositorio local como dependencia

## Docker 

docker ps - mostrar todos containers a correr -a 

docker run -dp 127.0.0.1:3000:3000 getting-started - create container

docker build -t getting-started . -create image

## run anycityforecast

docker build -t anycityforecast .

docker run anycityforecast



