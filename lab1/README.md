# Lab01

## Crear e executar projeto Maven 

mvn archetype:generate -DgroupId=com.mycompany.app -DartifactId=my-app -DarchetypeArtifactId=maven-archetype-quickstart -DinteractiveMode=false

groupID = com.ua.pt
artifactID = "nome projeto"

mvn package
mvn exec:java -Dexec.mainClass="com.ua.pt.WeatherStarter" -Dexec.args=""

Extensoes sao colocadas no pom.xml
