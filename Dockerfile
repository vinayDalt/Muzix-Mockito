FROM openjdk:11.0-jdk

 ADD ./target/MuzixApp-0.0.1-SNAPSHOT.jar /muzix/app/MuzixApp-0.0.1-SNAPSHOT.jar

 WORKDIR muzix/app

 ENTRYPOINT ["java", "-jar", "MuzixApp-0.0.1-SNAPSHOT.jar"]