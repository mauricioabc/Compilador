# Compilador
## ¿Qué es?
Compilador implementado en Java.

Este repositorio contiene el código fuente de un analizador léxico y sintáctico, así como ejemplos de pruebas de código y documentos que describen los fundamentos del lenguaje, el autómata y la gramática utilizados por el analizador.

## Instalación
- Verificar si la versión de Java es compatible con la máquina. En caso negativo, modificar el archivo pom.xml.
- Añadir la dependencia AbsoluteLayout-RELEASE65.jar.

## ¿Cómo usarlo?
Para utilizar el analizador, simplemente compile el código fuente, ejecútelo y seleccione el archivo de entrada que contiene el código a analizar. El analizador verificará el código fuente y generará una salida que indicará qué tokens se reconocieron, así como posibles errores y el árbol de derivación.

El directorio `documents` contiene documentos que describen los [fundamentos del lenguaje](https://github.com/mauricioabc/Compilador/blob/analisador-sintatico/documents/Express%C3%B5es%20regulares.pdf), así como el [autómata](https://github.com/mauricioabc/Compilador/blob/analisador-sintatico/documents/AFDCompleto.pdf) y la [gramática](https://github.com/mauricioabc/Compilador/blob/analisador-sintatico/documents/Gram%C3%A1tica%20LR(1).pdf) utilizados por el analizador léxico. Esta documentación puede ser útil para comprender cómo funciona el analizador y cómo reconoce los tokens en el código fuente.

## Ejemplo
Los directorios `exemplosLX` y `exemplosLR` contienen varios archivos de ejemplo con códigos que se pueden utilizar para probar el analizador.

## Contribuciones
¡Se aceptan contribuciones! Si tienes alguna sugerencia de mejora o corrección de errores, no dudes en abrir una solicitud de extracción (Pull Request).

## Referencias
- [ANTLR Website](https://www.antlr.org/)
- [ANTLR4 Repository](https://github.com/antlr/antlr4)