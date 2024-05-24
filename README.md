# DIO - Trilha POO Java
www.dio.me

## Autora dos Exercícios e Repositório Original
- [Camila Cavalcante](https://github.com/cami-la)
- [Stream API Java](https://github.com/digitalinnovationone/ganhando_produtividade_com_Stream_API_Java)

## Java Stream API
A `Stream API` é uma abstração disponibilizada no Java 8 para trabalhar com coleções. Trata-se de uma poderosa solução para processar coleções de maneira `declarativa`, ao invés da tradicional e burocrática forma `imperativa`.

## Exercícios
Este repositório contém exercícios que colocam em prática os seguintes temas:

- Interface Functional
- Optional

## Programação Imperativa
`Programação imperativa` consiste em conjuntos de instruções detalhadas que são fornecidas ao computador para serem executadas em uma determinada ordem.

No exemplo a seguir, para fazer uma simples soma foi necessário explicitamente iterar sobre `itemList`, calcular o preço total de cada item e acumular o valor em `valorTotal`.

```java
public class CarrinhoDeCompras {
  // Atributos
  private List<Item> itemList;
  // Construtor
  public CarrinhoDeCompras() {
    this.itemList = new ArrayList<>();
  }
  
  // Método para calcular valor total dos itens sem utilizar a Stream API
  public double calcularValorTotal() {
    double valorTotal = 0d;
    if (!itemList.isEmpty()) {
      for (Item item : itemList) {
        double valorItem = item.getPreco() * item.getQuantidade();
        valorTotal += valorItem;
      }
      return valorTotal;
    } else {
      throw new RuntimeException("A lista está vazia.");
    }
  }
}
```

## Programação Declarativa
`Programação declarativa` é o oposto direto da programação imperativa no sentido de que o desenvolvedor não dá instruções sobre como o computador deve executar a tarefa, mas sim spbre qual resultado é esperado.

No exemplo a seguir, para realizar a mesma soma que o exemplo anterior foi necessário apenas descrever o que deve ser feito: um stream de itens (`itemList.stream()`), transformar cada item em um valor double (`mapToDouble()`) e somar todos os valores (`sum()`).

```java
public class CarrinhoDeCompras {
  // Atributos
  private List<Item> itemList;
  // Construtor
  public CarrinhoDeCompras() {
    this.itemList = new ArrayList<>();
  }
  
  // Método para calcular valor total dos itens utilizando a Stream API
  public double calcularValorTotal() {
    if (itemList.isEmpty()) {
      throw new RuntimeException("A lista está vazia.");
    }
    return itemList.stream()
        .mapToDouble(item -> item.getPreco() * item.getQuant())
        .sum();
  }
}
```

## Lambda
`Expressões lambda` permitem que classes anônimas de implementação simples sejam escritas de forma mais simplificada e clara. Também permitem que tratemos funcionalidades como argumentos e código como dados.

A sintaxe de expressões lambda consiste em uma lista de parâmetros separados por vírgula entre parênteses, o operador de seta e um corpo que pode ser uma única expressão ou um bloco de instruções: `(parameters-list) -> expression-body`.

```java
public class OrdenacaoPessoa {
  // Atributo
  private List<Pessoa> pessoaList;

  // Construtor
  public OrdenacaoPessoa() {
    this.pessoaList = new ArrayList<>();
  }

  public List<Pessoa> ordenarPorAltura() {
    if (!pessoaList.isEmpty()) {
      List<Pessoa> pessoasPorAltura = new ArrayList<>(pessoaList);
      pessoasPorAltura.sort((p1, p2) -> Double.compare(p1.getAltura(), p2.getAltura()));
      return pessoasPorAltura;
    } else {
      throw new RuntimeException("A lista está vazia.");
    }
  }
}
```

## Method Reference
As expressões lambda são usadas para criar métodos anônimos. Porém, às vezes expressões lambda não fazem nada além de invocar um método já existente e nesses casos, é frequentemente mais claro se referir ao método pelo nome. `Method references` permitem isso.

Como há diferentes tipos de method references, as sintaxes variam. O tipo de method reference que se refere a um método de instância de um determinado objeto tem sua sintaxe composta pelo objeto que contém o método, o operador de referência de método e o nome do método de instância do objeto: `containingObject::instanceMethodName`.

```java
public class OrdenacaoPessoa {
  // Atributo
  private List<Pessoa> pessoaList;

  // Construtor
  public OrdenacaoPessoa() {
    this.pessoaList = new ArrayList<>();
  }

  public List<Pessoa> ordenarPorAltura() {
    if (!pessoaList.isEmpty()) {
      List<Pessoa> pessoasPorAltura = new ArrayList<>(pessoaList);
      pessoasPorAltura.sort(Comparator.comparingDouble(Pessoa::getAltura));
      return pessoasPorAltura;
    } else {
      throw new RuntimeException("A lista está vazia.");
    }
  }
}
```

## Referências
- Java Stream API - Oracle: https://www.oracle.com/br/technical-resources/articles/java-stream-api.html
- Programming Paradigms - FreeCodeCamp: https://www.geeksforgeeks.org/difference-between-imperative-and-declarative-programming/
- Lambda Expressions - Oracle: https://docs.oracle.com/javase/tutorial/java/javaOO/lambdaexpressions.html#syntax
- Method References - Oracle: https://docs.oracle.com/javase/tutorial/java/javaOO/methodreferences.html
