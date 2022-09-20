FROM openjdk:17
EXPOSE 9089
ADD target/HospitalManagement-0.0.1-SNAPSHOT.jar HospitalManagement-0.0.1-SNAPSHOT.jar
CMD ["java", "-jar", "HospitalManagement-0.0.1-SNAPSHOT.jar"]


