FROM openjdk:8 
ADD target/mentor-on-demand-0.0.1-SNAPSHOT.jar mentor-on-demand-0.0.1-SNAPSHOT.jar 
EXPOSE 8082
ENTRYPOINT ["java", "-jar", "mentor-on-demand-0.0.1-SNAPSHOT.jar"]