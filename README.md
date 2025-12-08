# Proyecto Java Maven - Sistema de gestion de pedidos

Este proyecto es una plantilla base para comenzar a trabajar con aplicaciones Java
utilizando Maven. Asegúrate de seguir las instrucciones para configurar tu entorno
correctamente y entender cómo contribuir al proyecto.

## Tabla de Contenidos

- [Introducción](#introducción)
- [Requisitos](#requisitos)
- [Configuración del Entorno](#configuración-del-entorno)
- [Estructura del Proyecto](#estructura-del-proyecto)
- [Compilación y Ejecución](#compilación-y-ejecución)
- [Conversión de EUR a USD](#conversión-de-EUR-a-USD)
- [Dónde se aplica el intercambio](#dónde-se-aplica-el-intercambio)
- [Contribución](#contribución)
- [Licencia](#licencia)

---

## Introducción

Este es un proyecto base para aprender sobre el uso de **Java** y **Maven**. El
objetivo familiarizarse con las buenas prácticas de desarrollo y gestionar
dependencias utilizando Maven.

## Requisitos

Antes de comenzar, asegúrate de tener instalado lo siguiente en tu sistema:

- **Java 8+** (JDK) - Puedes descargarlo desde
  [Oracle](https://www.oracle.com/java/technologies/javase-jdk11-downloads.html) o
  [OpenJDK](https://openjdk.java.net/)
- **Maven** - Puedes instalar Maven siguiendo las instrucciones en su sitio
  oficial:
  [https://maven.apache.org/install.html](https://maven.apache.org/install.html)
- **IDE recomendada:** Visual Studio Code o cualquier editor de tu preferencia con
  soporte para Java.

## Configuración del Entorno

### 1. Instalar Java

Asegúrate de que tienes **Java 8** o una versión superior instalada. Puedes
verificarlo con el siguiente comando:

```bash
java -version
```

### 2. Instalar Maven

Una vez que tengas Java instalado, puedes proceder con la instalación de Maven.
Para verificar que Maven esté instalado correctamente, ejecuta el siguiente
comando:
mvn -version

### 3. Configurar el IDE

Para trabajar con este proyecto, puedes usar cualquier IDE que soporte Java, como
Visual Studio Code, IntelliJ IDEA, Eclipse, etc. Si estás usando Visual Studio
Code, asegúrate de instalar las siguientes extensiones:
Java Extension Pack (de Microsoft)
Maven for Java

## Estructura del proyecto

```plaintext
GuillermoRodríguez-UniversidadEuropea/GuillermoRodríguezM22
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/
│   │   │       └── example/
│   │   │           ├── Controller/
│   │   │           │   └── OrderController.java
│   │   │           ├── model/
│   │   │           │   ├── Order.java
│   │   │           │   ├── Article.java
│   │   │           │   ├── Calculator.java
│   │   │           │   ├── Searcher.java
│   │   │           │   └── ExchangeRate.java
│   │   │           |── View/
│   │   │           |    └── OrderView.java
|   |   |           ├── Main.java
│   │   └── resources/
|   |       ├── plantuml
│   │       │      ├── casos_uso.puml
│   │       │      ├── model.puml
│   │       │      └── secuencia_pedido.puml
│   │       ├── orders.json
│   │       ├── app.png
│   │       └── logback.xml
│   └── test/
|       ├── Test_Model
│       |       ├── ArticleTest.java
│       |       └── OrderTest.java
|       └── Test_Unitarios
│               ├── CalculatorTestCase.java
│               └── SearcherTestCase.java
├── pom.xml
├── .gitignore
├── target/
└── README.md

```

## Compilación y ejecución

Para compilar y ejecutar el proyecto, sigue estos pasos:
Abre una terminal en la raíz del proyecto.
Ejecuta el siguiente comando para compilar el proyecto:

```bash
mvn clean install
```

Para ejecutar la aplicación, usa el siguiente comando:

```bash
mvn exec:java
```


## Conversión de EUR a USD

En esta versión he añadido que el programa pueda mostrar el total del pedido en euros y también en dólares.

Para hacer el Intercambio:

He creado una clase llamada Intercambio (en model) que:
Llama a una página web que devuelve el cambio de euro a dólar.
Lee ese número y lo devuelve con un método: public double obtenerEurUsd()

https://api.frankfurter.dev/v1/latest?base=EUR&symbols=USD

## Dónde se aplica el intercambio

En OrderController, cuando encuentro un pedido: saco el total en euros (getGrossTotal()), llamo a intercambio.obtenerEurUsd(), calculo el total en dólares y se lo mando a la vista.

En OrderView, he añadido un método displayOrder(order, tipoCambio) que: muestra el pedido, el total en EUR, el total en USD y el cambio usado (1 EUR = X USD).

## Contribución

Si deseas contribuir a este proyecto, por favor sigue estos pasos:

- Haz un fork del repositorio.
- Crea una nueva rama (git checkout -b feature-nueva-funcionalidad).
- Realiza tus cambios y haz commit (git commit -am 'Agregué nueva funcionalidad').
- Empuja los cambios a tu fork (git push origin feature-nueva-funcionalidad).
- Crea un pull request.

## Licencia

Este proyecto está bajo la Licencia MIT - consulta el archivo LICENSE para más
detalles.
