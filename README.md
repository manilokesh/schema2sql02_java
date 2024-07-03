# schema2sql02_java
schema 2 sql java works

## ⚙️ Set up a Java
The application uses OpenJDK17, you can use openJDK you use or you can download from  [https://adoptium.net/temurin/releases/?version=17] 

## ⚙️ Set up MVN
The application uses "apache-maven-3.9.6".

## ⚙️ Configure Java in Eclipse

eclipse --> window --> preference

![image](https://github.com/manilokesh/schema2sql02_java/assets/8210587/652a74ee-6f5a-4c93-8002-b49e93cb09ce)


## ⚙️ Configure MVN in Eclipse

![image](https://github.com/manilokesh/schema2sql02_java/assets/8210587/0ba90bd9-5914-417b-9398-76bccb12a297)

## ⚙️ Import Project

Eclipse --> File --> Import

![image](https://github.com/manilokesh/schema2sql02_java/assets/8210587/f45062b4-35d2-49eb-a618-bbf134d04469)

![image](https://github.com/manilokesh/schema2sql02_java/assets/8210587/cac57d6b-19e6-4e3e-8fbb-5db1ad7f016f)

## ⚙️ Build and Run in command prompt
open command prompt 
go to the project folder "git/schema2sql02_java/hims"

```bash
> mvn clean install
```

```bash
>java -jar -Dmysqldbuser=<user> -Dmysqldbpassword=<password> target\hims-0.0.1-SNAPSHOT.jar
```

