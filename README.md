# Bienvenido a TestPT
## Descripción del Proyecto
Se debe implementar la creación de objetos de animales que tengan la funcionalidad de emitir onomatopeyas según el tipo o especie del animal. Además, cada animal deberá tener un método que indique si es terrestre, volador o acuático.
## Requisitos
- Java 17
- Maven
## Funciones
- Creación de Objetos: Los objetos de tipo Animal deben ser creados con los siguientes atributos:
    - Nombre: El nombre del animal.
    - Tipo: Especifica si el animal es terrestre, volador o acuático.
    - Onomatopeya: El sonido que hace el animal.
- Método para Determinar el Tipo: Los animales deben tener un método que indique su tipo: terrestre, volador o acuático.
- Entrada de Datos: La entrada de datos se proporcionará a través de los argumentos del método main (Necesario Eliminar el Animales.txt), usando cadenas de texto en el siguiente formato: 
> nombre|tipo|onomatopeya

o utilizando el archivo animales.txt presente en el repositorio.
## Pasos
- Ejecuta el siguiente comando en la terminal dentro del proyecto: mvn clean install
- Aparecerá una carpeta llamada Target
- Dentro de Target habrán 2 JAR (SNAPSHOP[DEFAULT] Y SNAPSHOP-jar-with-dependencies)
- Ahora puedes Regresar a la ruta general del proyecto y Ejecutar el Runner.bat que ejecutara el proyecto utilizando como prioridad el archivo animales.txt
- Otra opción tambien para probarlo por medio de los args es Eliminar el Animals.txt y Ejecutar el comando con el siguiente formato:
> java -jar target/PruebaTecnica-1.0-SNAPSHOT-jar-with-dependencies.jar "gato|terrestre|miau" "pescao|Acuatico|psss" "..." "...."  
