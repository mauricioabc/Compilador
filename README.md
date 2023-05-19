# Compilador
## O que é?
Compilador sendo implementado em Java.

Este repositório contém o código fonte de um analisador léxico e sintático, bem como exemplos de testes de código e documentos que descrevem os fundamentos da linguagem, o autômato e a gramática utilizados pelo analisador.

## Instalação
- Verificar se a versão do java é compatível com a máquina, caso negativo modificar no arquivo pom.xml;
- Adicionar a dependência AbsoluteLayout-RELEASE65.jar.

## Como usar?
Para utilizar o analisador, basta compilar o código fonte, executá-lo e selecionar o arquivo de entrada contendo o código a ser analisado. O analisador irá então verificar o código fonte e gerar uma saída indicando quais tokens foram reconhecidos, bem como possíveis erros e a árvore de derivação.

O diretório `documents` contém documentos que descrevem os [fundamentos da linguagem](https://github.com/stephaniemarcolino/Compilador/blob/analisador-sintatico/documents/Express%C3%B5es%20regulares.pdf), bem como o [autômato](https://github.com/stephaniemarcolino/Compilador/blob/analisador-sintatico/documents/AFDCompleto.pdf) e a [gramática](https://github.com/stephaniemarcolino/Compilador/blob/analisador-sintatico/documents/Gram%C3%A1tica%20LR(1).pdf) utilizados pelo analisador léxico. Essa documentação pode ser útil para entender como o analisador funciona e como ele reconhece os tokens no código fonte.

## Exemplo

Os diretórios `exemplosLX` e `exemplosLR` contém diversos arquivos de exemplo com códigos que podem ser utilizados para testar o analisador.

## Contribuições

Contribuições são bem-vindas! Se você tiver alguma sugestão de melhoria ou correção de bugs, sinta-se à vontade para abrir um Pull Request.

## Referências
- [ANTLR Website](https://www.antlr.org/)
- [ANTLR4 Repository](https://github.com/antlr/antlr4)
