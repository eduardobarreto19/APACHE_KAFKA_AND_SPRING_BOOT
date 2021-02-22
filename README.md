# ¿Qué es Apache Kafka?
Apache Kafka es un sistema de transmisión de datos distribuido con capacidad de escalado horizontal y tolerante a fallos. Gracias a su alto rendimiento nos permite transmitir datos en tiempo real utilizando el patrón de mensajería publish/subscribe.


## Comandos para ejecutar apache kafka y zookeeper

- Iniciar zoopkeeper (una consola)
.\bin\windows\zookeeper-server-start.bat .\config\zookeeper.properties

- Iniciar apache kafka (en otra consola cmd)
.\bin\windows\kafka-server-start.bat .\config\server.properties

- Crear un topico (tercer consola CMD)
.\bin\windows\kafka-topics.bat –create –zookeeper localhost:2181 –replication-factor 1 –partitions 1 –topic topico-programacion-colombia

- Listar topicos  activos en apache Kafkazoopkeeper ( en la consola anterior)
.\bin\windows\kafka-topics.bat --list --zookeeper localhost:2181

- Crear productor de mensajes (misma consola anterior)
.\bin\windows\kafka-console-producer.bat –broker-list localhost:9092 –topic topico-programacion-colombia

- Crear consumidore (otra consola)
.\bin\windows\kafka-console-consumer.bat –bootstrap-server localhost:9092 --topic topico-programacion-colombia --from-beginning

- Detener apache kafka
.\bin\windows\kafka-server-stop.bat

- Detener zookeeeper
.\bin\windows\zookeeper-server-stop.bat


## Comandos para ejecutar el proyecto con Spring

Paso 1: Iniciar zoopkeeper (una consola)
.\bin\windows\zookeeper-server-start.bat .\config\zookeeper.properties

Paso 2:  Iniciar apache kafka (en otra consola cmd)
.\bin\windows\kafka-server-start.bat .\config\server.properties

Paso 3: Crear un topico (tercer consola CMD)
.\bin\windows\kafka-topics.bat –create –zookeeper localhost:2181 –replication-factor 1 –partitions 1 –topic topico

Paso 4: Listar topicos  activos en apache Kafkazoopkeeper ( en la consola anterior)
.\bin\windows\kafka-topics.bat --list --zookeeper localhost:2181

PASo 5:Crear consumidor
.\bin\windows\kafka-console-consumer.bat –bootstrap-server localhost:9092 --topic topico --from-beginning
