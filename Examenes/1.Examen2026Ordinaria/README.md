# Enunciado Examen 2026 Ordinaria
> **OJO:** Se recuerda que para realizar este examen se ha partido de un examen resuelto y se le pasó a gemini para que 
> pudiera hacer un enunciado lo más parecido al examen real. El código del que se partió está en la carpeta comprimida 
> ``Examen2026-Ordinaria-Gemini.zip``
---

Se desea desarrollar un editor de texto interactivo por consola que opere sobre un documento en memoria (Document). 
El sistema debe soportar inicialmente cuatro acciones básicas: abrir un fichero (open), insertar texto (insert), borrar 
la última palabra (delete) y reemplazar cadenas de texto (replace).

Recientemente, se ha solicitado añadir un sistema de Macros. Una macro es una secuencia de comandos grabados que se 
pueden almacenar bajo un nombre para ser reproducidos más tarde (play). El editor debe soportar tres modos de 
funcionamiento:
- **Modo Normal:** Las acciones se ejecutan inmediatamente sobre el documento. 
- **Modo Grabación (record):** Las acciones se ejecutan inmediatamente sobre el documento y además se guardan en la macro 
actual. No se permite abrir ficheros en este modo. 
- **Modo Definición (define):** Las acciones no se ejecutan sobre el documento; únicamente se guardan en la macro para su 
uso posterior. Si se abre un fichero, se guarda la macro y se vuelve al Modo Normal.

## El problema actual:
El código inicial suministrado (Editor) funciona, pero sufre de una explosión de condicionales basados en el 
modo de edición actual. El código está altamente duplicado, viola el principio Open/Closed (cada vez que se añade una 
acción o un modo hay que romper el switch principal) y las macros no se pueden anidar fácilmente.

> 💡 **Objetivo:** Refactorizar el sistema eliminando los flags de estado y abstrayendo las acciones utilizando los 
> patrones de diseño adecuados.

---
## Patrones utilizados:
- Patrón Command
- Patrón Composite
- Patrón State