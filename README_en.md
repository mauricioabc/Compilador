# Compiler
## What is it?
Compiler implemented in Java.

This repository contains the source code for a lexical and syntactic analyzer, as well as code test examples and documents describing the language fundamentals, the automaton, and the grammar used by the analyzer.

## Installation
- Check if the Java version is compatible with your machine. If not, modify it in the pom.xml file.
- Add the AbsoluteLayout-RELEASE65.jar dependency.

## How to Use?
To use the analyzer, simply compile the source code, run it, and select the input file containing the code to be analyzed. The analyzer will then check the source code and generate an output indicating which tokens were recognized, as well as possible errors and the derivation tree.

The `documents` directory contains documents describing the [language fundamentals](https://github.com/stephaniemarcolino/Compilador/blob/analisador-sintatico/documents/Express%C3%B5es%20regulares.pdf), as well as the [automaton](https://github.com/stephaniemarcolino/Compilador/blob/analisador-sintatico/documents/AFDCompleto.pdf) and the [grammar](https://github.com/stephaniemarcolino/Compilador/blob/analisador-sintatico/documents/Gram%C3%A1tica%20LR(1).pdf) used by the lexical analyzer. This documentation can be useful to understand how the analyzer works and how it recognizes tokens in the source code.

## Example

The `exemplosLX` and `exemplosLR` directories contain various example files with codes that can be used to test the analyzer.

## Contributions

Contributions are welcome! If you have any suggestions for improvement or bug fixes, feel free to open a Pull Request.

## References
- [ANTLR Website](https://www.antlr.org/)
- [ANTLR4 Repository](https://github.com/antlr/antlr4)