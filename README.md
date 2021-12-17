# Prueba tecnica

Desarrollo realizado para una prueba tecnica especificada por la empresa choucair

## 🛠️ Desarrollado en Java con:  

* [SerenityBDD](https://serenity-bdd.github.io/theserenitybook/latest/index.html) - Framework web usado
* [JDK 11](https://www.oracle.com/co/java/technologies/javase/jdk11-archive-downloads.html) - Herramienta de desarrollo
* [Maven](https://maven.apache.org/) - Manejador de dependencias
* [Screenplay](https://serenity-bdd.github.io/theserenitybook/latest/serenity-screenplay.html) - Patron  de diseño

<p align="center"><img src="https://serenity-bdd.github.io/theserenitybook/latest/_images/journey-actors.png"/></p> 



## ⚙️ Ejecucion por consola

Para ejecutar la prueba tecnica
```
mvn clean verify -Denvironment=demo -Dtest=CreateMeetingRunner
```


## ⚙️ Para su ejecucion local

- El proyecto tiene configurado el driver de Google Chrome version 96
- El ambiente tiene configurada por defecto la pagina [demo](https://serenity.is/demo/) de la prueba 

Otros comandos para su ejecucion local
```
mvn clean install  //Limpia y compila cada modulo desde cero

mvn serenity:aggregate //Para agregar los reportes al proyecto
```

## 📋 Para visualizar los reportes 
```
Completo: target/site/serenity/index.html

Resumen:  target/site/serenity/serenity-summary.html
```