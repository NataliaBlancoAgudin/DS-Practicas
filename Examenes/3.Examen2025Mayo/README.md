# Enunciado Examen 2025 MAYO
> **OJO:** Para la realización de este examen se ha partido tanto del enunciado del examen real como del código inicial.
> El único cambio que se ha hecho ha sido la traducción del enunciado a español. Se deja en la carpeta comprimida 
> ``Examen2025Mayo-inicial.zip`` el código de partida de este examen.
---

## Introducción
Para facilitar el desarrollo de aplicaciones web, nuestra empresa está creando un framework en el lado del servidor que
simplifica la especificación de cómo debe responder el servidor a las diferentes peticiones entrantes. En su forma más 
básica, un servidor web escucha las peticiones entrantes y, dependiendo de la URL solicitada, decide qué acción tomar y
proporciona la respuesta adecuada al cliente que realizó la petición.

Esta respuesta suele ser una página web (ya sea estática o dinámica, utilizando algún tipo de lenguaje de plantillas, 
aunque para este ejercicio las simularemos todas como simples fragmentos de texto plano). Sin embargo, también podría 
implicar el envío de un documento JSON tras consultar una base de datos, iniciar una transferencia de archivos al 
cliente que realizó la petición, etc.

## Código Inicial
Inicialmente, se te proporciona el prototipo de una versión muy rudimentaria del servidor web (junto con un cliente de
prueba que le envía peticiones).

## PRIMER PASO: ENTENDER QUÉ HACE EL CÓDIGO
El código consta de dos proyectos: el mencionado servidor (WebServer) y un cliente de prueba (Client).
Para ejecutarlos, siempre debes iniciar primero el servidor, seguido del cliente. Ambos proyectos incluyen sus propios 
archivos .bat, que puedes ejecutar desde la consola de Windows. Alternativamente, puedes ejecutar ambos en 
Eclipse/IntelliJ y cambiar entre ellos mediante la vista de consola para mostrar la traza de ejecución de cada uno 
(servidor y cliente).

Al ejecutar la versión inicial, verás (en la traza de salida del cliente) que las dos primeras páginas se devuelven 
correctamente, mientras que las siguientes aún no se han creado y muestran una página de error (404, no encontrado).

## SEGUNDO PASO: ENTENDER CÓMO LO HACE
### Cliente
No es necesario modificarlo, ni la clase TestClient (cambiar el protocolo de comunicación con el servidor no es el 
objetivo de este ejercicio) ni el Main. Si realizas algún cambio en este último porque deseas probar otras peticiones 
durante el examen, asegúrate de restaurarlo a su estado original antes de la entrega.

### Servidor
Se recomienda revisar las clases Main, Request, Response y Server en este orden (puedes ignorar el paquete util por 
ahora). El código debería ser lo suficientemente claro por sí mismo. Como puedes ver, el Main contiene varias llamadas 
a métodos privados que están comentadas. Durante el examen, deberás escribir el código necesario dentro de estos métodos 
para completar las tareas solicitadas a continuación, desescomentando y comentando las llamadas a medida que avances en 
cada sección.

## Qué se te pide que hagas
### ✅ REDISEÑAR EL SERVIDOR
Debe ser posible añadir nuevas páginas (o cualquier otra funcionalidad necesaria para gestionar cada petición entrante)
al servidor web. No solo para esta aplicación específica, sino que queremos poder utilizarlo para cualquier aplicación 
web futura que desarrollemos. Debes rediseñarlo para cumplir de la mejor manera posible estos objetivos, siguiendo los 
criterios estudiados en el curso.

La salida de la ejecución de runRedesigned con esta nueva versión debe ser la misma que en la versión original (la 
salida por pantalla será idéntica tanto en el cliente como en el servidor).
---
> El patrón que yo he usado para poder rediseñar el servidor ha sido el **Strategy**
---

## AMPLIACIONES (EXTENSIONS)
A continuación, se deben implementar los cambios enumerados abajo, en este orden estricto. Cada cambio se evaluará en 
función de cuánto código sea necesario modificar en comparación con el rediseño previo.

> (Nota: Las modificaciones realizadas en el método main para configurar los diferentes objetos no cuentan como cambios).

> Cada ampliación corresponde a la ejecución de un servidor diferente, por lo que debe lanzarse desde su método correspondiente run1(), run2(), etc.

### ✅ Ampliación 1
Se añaden dos nuevas páginas:
- **miCuenta:** Muestra la información de la cuenta del usuario que realiza la petición. Para simplificar, solo 
mostrará el nombre de usuario y, como contraseña, siempre 1111, incluso si el usuario es anónimo (aunque esto no sea 
realista).
- **ofertas:** Muestra los productos en venta.

Además, la página de error 404 debe personalizarse para incluir el nombre de la empresa:
`Error 404. Esta página no existe en Computers'R Us`

La salida del cliente debe ser similar al ejemplo mostrado en las trazas de los documentos.

````
[Log Cliente] Recibida página: index.html
        | Bienvenido a `Computers'R Us`
        
[Log Cliente] Recibida página: pedidos
        | Estos son los pedidos realizados por -> raul
        |   -5/19 Dell Inspiron
        |   -3/19 Monitor Acer
        
[Log Cliente] Recibida página: miCuenta
        | Su usuario es: cesar
        | Su contraseña es: 1111

[Log Cliente] Recibida página: miCuenta
        | Su usuario es: anonimo
        | Su contraseña es: 1111
        
[Log Cliente] Recibida página: ofertas
        | Las ofertas de esta semana son: Spectrum a 5€. MacBook a 2€. Dell a 3€

[Log Cliente] Recibida página: ofertas
        | Las ofertas de esta semana son: Spectrum a 5€. MacBook a 2€. Dell a 3€
````

### ✅ Ampliación 2
Queremos realizar un seguimiento de cuántas veces visitan los usuarios la página de ofertas (para evaluar su utilidad). 
Para lograrlo, el servidor debe mostrar un mensaje cada vez que se acceda a la página, indicando el número total de 
veces que ha sido visitada hasta el momento.

Por otro lado, hemos recibido quejas sobre el tiempo de respuesta de la página miCuenta. Por lo tanto, queremos que el 
servidor registre cuánto tiempo tarda en servirse cada petición a esa página. Puedes utilizar, por ejemplo, 
`System.nanoTime()` para medir el tiempo transcurrido entre el inicio y el final del procesamiento de la página.

La página de inicio (index.html) debe ser monitorizada de ambas formas: debe informar tanto del número de visitas como 
del tiempo de respuesta de cada petición.

La página de pedidos (pedidos) permanecerá inalterada.

Tras aplicar estos cambios, la salida del servidor debe reflejar los contadores (Counter) y temporizadores (Timer) 
correspondientes.

````
[Log Server] Peticion recibida: Request [clientIP=Soto/192.168.0.13,pageURL=index.html, user=anonimo]
    (Counter:Indice) Value=1
    (Timer:Indice) Time=233000
    
[Log Server] Peticion recibida: Request [clientIP=Soto/192.168.0.13,pageURL=pedidos, user=raul]

[Log Server] Peticion recibida: Request [clientIP=Soto/192.168.0.13,pageURL=miCuenta, user=cesar]
    (Timer:MiCuenta) Time=120800
    
[Log Server] Peticion recibida: Request [clientIP=Soto/192.168.0.13,pageURL=miCuenta, user=anonimo]
    (Timer:MiCuenta) Time=70800
    
[Log Server] Peticion recibida: Request [clientIP=Soto/192.168.0.13,pageURL=ofertas, user=anonimo]
    (Counter:Indice) Value=1
    
[Log Server] Peticion recibida: Request [clientIP=Soto/192.168.0.13,pageURL=ofertas, user=aquilino]
    (Counter:Indice) Value=2
````

---
> El patrón que yo he usado para poder hacer esta ampliación ha sido el **Decorator**.
---
### ✅ Ampliación 3
Ahora queremos poder añadir control de acceso a ciertos recursos, ya sea basado en el usuario, la dirección IP o 
cualquier otra condición que requiera una aplicación específica. Si se cumple la condición, el recurso se sirve 
normalmente. De lo contrario, la petición debe redirigirse a una página de error.

Para implementar esta ampliación, ahora debes echar un vistazo a las clases del paquete util (UserAuthentication y 
DateUtil). Estas clases simulan un sistema de gestión de usuarios y operaciones de fecha. No necesitarás modificarlas.

Específicamente, se requiere lo siguiente:
- Todas las páginas vuelven a su versión original del rediseño (los contadores y monitores de tiempo de la Ampliación 2 
deben ser eliminados). 
- El acceso a la página de la cuenta (miCuenta) con un usuario inválido debe devolver una nueva página de error 401 no 
autorizado (`Error 401. El usuario no está autorizado: <usuario>`). Si el usuario es válido, se devuelve la página normal. 
- El acceso a la página de pedidos (pedidos) sin un usuario válido debe devolver la página de error 404 no encontrado 
(como si la página no existiera). Si el usuario es válido, se devuelve la página normal.
- Las ofertas (ofertas) solo deben estar disponibles los fines de semana. Si se accede a ellas durante la semana, el 
servidor debe devolver una página explicando que las ofertas solo están disponibles los fines de semana (Espere al 
fin de semana para ver nuestras ofertas).

````
[Log Cliente] Recibida página: index.html
        | Bienvenido a `Computers'R Us`
        
[Log Cliente] Recibida página: pedidos
        | Estos son los pedidos realizados por -> raul
        |   -5/19 Dell Inspiron
        |   -3/19 Monitor Acer
        
[Log Cliente] Recibida página: miCuenta
        | Su usuario es: cesar
        | Su contraseña es: 1111

[Log Cliente] Recibida página: miCuenta
        | Error 401. El usuario no está autorizado: anonimo
        
[Log Cliente] Recibida página: ofertas
        | Espere al fin de semana para ver nuestras ofertas

[Log Cliente] Recibida página: ofertas
        | Las ofertas de esta semana son: Spectrum a 5€. MacBook a 2€. Dell a 3€
````

---
> El patrón que yo he usado para poder hacer esta ampliación ha sido el **Decorator**.
---

### ✅ Ampliación 4
Se ha observado que la página de pedidos (pedidos) tarda más de lo esperado en servirse. Para ayudar a reducir la causa, 
queremos que el servidor registre cuánto tiempo tarda en total (tanto para validar al usuario como para enviar la página),
así como cuánto tiempo tarda únicamente en enviar la página.

Ha habido numerosos accesos a la página de "mi cuenta". Para ayudar a supervisar si todo funciona correctamente o si hay
intentos de acceso automatizados, queremos realizar un seguimiento de cuántas peticiones a miCuenta son válidas (es 
decir, realizadas por usuarios válidos y que dan como resultado el servicio de la página real) y cuántas son rechazadas 
con un error 401 no autorizado.

---
> Para esta ampliación no se ha añadido ninguna clase nueva, simplemente se ha usado las clases ya creadas.
---