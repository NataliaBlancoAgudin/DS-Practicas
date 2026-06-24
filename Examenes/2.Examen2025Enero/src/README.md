# Enunciado Examen 2025 ENERO
> **OJO:** Se recuerda que para realizar este examen se ha partido del código inicial del examen real pero con un 
> enunciado que ha generado Gemini. En este caso se partió del código real del examen: está en la carpeta comprimida 
> ``Enero2025-inicial.zip``
---

Se desea desarrollar una aplicación de escritorio mediante interfaz gráfica (Swing) que actúe como un visor de 
documentos de texto plano (Document). 
El sistema procesa el texto dividiéndolo en líneas (Line) y palabras, y es capaz de renderizar el contenido en un área 
de dibujo (Canvas) adaptándose dinámicamente al ancho de la ventana cuando esta cambia de tamaño.

Actualmente, el sistema soporta dos tipos de alineación de texto:

- **Alineación a la Izquierda (Left):** Pinta el contenido original de la línea tal cual. 
- **Alineación Justificada (Justified):** Reparte de manera equitativa los espacios en blanco sobrantes entre los
huecos de las palabras para ocupar todo el ancho disponible de la línea (lineWidth).

## 🛑 El Problema de Diseño Actual:
El código suministrado funciona, pero sufre de problemas severos de cohesión y acoplamiento. La clase Canvas, que
estructuralmente es un componente puramente visual (JTextArea), se está encargando de implementar la lógica 
algorítmica compleja de formateo de texto (createJustifiedLine).

Además, la selección del algoritmo de alineación está fuertemente acoplada a los botones de la interfaz gráfica 
(leftButton.isSelected()) mediante estructuras condicionales if-else dentro del método de dibujo. Si el día de mañana 
se quisieran reutilizar estos algoritmos de alineación en un entorno sin interfaz gráfica (por ejemplo, para exportar 
el Quijote formateado a un fichero de texto de consola), sería totalmente imposible sin duplicar el código.

## 🚀 Nuevos Requisitos:
El departamento de producto ha solicitado que el visor sea extensible. En la próxima versión se requerirá introducir 
nuevos tipos de maquetación de línea, tales como Alineación a la Derecha (Right) y Alineación Centrada (Center).

El sistema actual viola el principio Open/Closed, ya que añadir estas alineaciones obligaría a:

- Modificar la clase Canvas añadiendo nuevas variables para los botones. 
- Engordar el método drawDocument con más bloques if-else.

## 🎯 Tareas a realizar:
- **Separación de responsabilidades:** Libera a la clase Canvas de cualquier lógica de formateo o cálculo de espacios.
- **Eliminación de condicionales:** Elimina los bloques if-else del método drawDocument que comprueban qué botón de la 
interfaz está seleccionado. 
- **Extensibilidad:** Diseña una estructura que permita al Canvas delegar el formateo de las líneas en componentes
intercambiables, de modo que añadir la alineación "A la Derecha" o "Centrada" en el futuro sea tan simple como crear una 
nueva clase, sin tocar una sola línea de código del componente visual.

---
## Patrón utilizado: Strategy
### Participantes

1) **Context** → `Canvas`  
   Métodos:
   - void adjustWidth(int width)
   - void drawDocument()
   - void setAlineacion(Alineacion alineacion)
2) **Strategy** → `Alineacion`  
   Métodos:
   - String alinear(Line line, int lineWidth)
3) **ConcreteStrategy** → `AlineaciónJustificada`, `AlineaciónIzquierda`  
   Métodos:
   - String alinear(Line line, int lineWidth)