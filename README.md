# Verifica Números Primos

Este projeto em Java verifica se os números fornecidos como argumentos na linha de comando são primos ou não. Ele utiliza múltiplas threads para realizar a verificação simultaneamente, melhorando a eficiência em comparação com uma abordagem sequencial.

## Funcionalidades

- Verifica se os números fornecidos são primos.
- Utiliza threading para verificar múltiplos números simultaneamente.

## Estrutura do Projeto

/seu-projeto<br>
├── src<br>
│ ├── VerificaNumerosPrimos.java<br>
│ └── VerificadorPrimo.java<br>
└── README.md<br>


## Como Compilar e Executar

### Pré-requisitos

- [Java Development Kit (JDK)](https://www.oracle.com/java/technologies/javase-downloads.html) instalado.

### Compilação

1. Navegue até o diretório `src` do projeto:
   ```bash
   cd src

2. Compile os arquivos java:
   javac VerificaNumerosPrimos.java VerificadorPrimo.java
   
Execução
1. Após a compilação, execute o programa passando os números que deseja verificar como argumentos:
   java VerificaNumerosPrimos 5 12 17 23 42
   
3. A saída será semelhante a:
   5 é primo
   12 não é primo
   17 é primo
   23 é primo
   42 não é primo

Explicação do Código
Main Class (VerificaNumerosPrimos):

Cria uma lista de threads, números e resultados.
Para cada argumento fornecido, cria um thread que executa a classe VerificadorPrimo.
Aguarda a conclusão de todas as threads e imprime se cada número é primo ou não.

Inner Class (VerificadorPrimo):

Implementa a interface Runnable e verifica se um número é primo.
Atualiza a lista de resultados com o resultado da verificação.
Notas
Certifique-se de que todos os números fornecidos como argumentos são inteiros válidos.
O método verificarPrimo implementa uma otimização simples para verificar se um número é primo.
Contribuições
Contribuições são bem-vindas! Sinta-se à vontade para abrir issues ou enviar pull requests para melhorias ou correções.

Licença<br>
Este projeto está licenciado sob a MIT License.<br><br>

Autor<br>
Demosthens Cavalcanti<br>
https://www.linkedin.com/in/demosthens-cavalcanti-4a0b9627b/ | demosthenscf@gmail.com
