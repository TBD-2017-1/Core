# Core
La libreria Core, provee de clases basicas para manejar tweets, usuarios y ubicaciones georaficas, ademas de proveer 
controladores basicos para interactuar con Mysql y MongoDB

Esta libreria es utilizada por las librerias [TextAPI](https://github.com/TBD-2017-1/TextApi.git) y proximamente en 
[GraphAPI](https://github.com/TBD-2017-1/GraphApi.git) y [GeoAPI](https://github.com/TBD-2017-1/GeoApi.git)

## Instalación
Para compilar el protecto se requiere:
- Gradle 3.5
- Maven 3.5
- Clomar este repositorio con `git clone https://github.com/TBD-2017-1/Core.git`

## Compilación y uso
Si se quiere compilar el proyecto, se debe escribir en la raiz de este repositorio y por terminal
```
gradle shadow
```

Para utilizar esta libreria se debe definir como dependencia, la forma mas facil en los proyectos de politweets es:
 - Copiar la libreria que generada en el proceso de compilacion, ubicada en la carpeta `lib/`
 - Pegar en la carpeta `lib/` del proyecto dependiente
 - Verificar que Gradle señala a la version correcta de la libreria como dependencia
