# Functional Interfaces
`Interfaces funcionais` fornecem tipos de destino para expressões lambda e method references. Cada interface funcional contém um único método abstrato ao qual os parâmetros e tipos de retorno da expressão lambda são correspondentes ou adaptados.

## Interface Consumer
`Consumer<T>` representa uma operação que aceita um único argumento de entrada de tipo `T` e não retorna resultado.

```java
public class ConsumerExample {
        public static void main(String[] args) {
                // Criar uma lista de números inteiros
                List<Integer> numeros = Arrays.asList(1, 2, 3, 4, 5);

                // Usar o Consumer com expressão lambda para imprimir números pares
                Consumer<Integer> imprimirNumeroPar = numero -> {
                        if (numero % 2 == 0) {
                                System.out.println(numero);
                        }
                };

                // Usar o Consumer para imprimir números pares no Stream
                numeros.stream_api().forEach(imprimirNumeroPar);
        }
}
```

## Interface Supplier
`Supplier<T>` representa um fornecedor de resultados de tipo `T`. Não há exigências de que um resultado novo ou distinto seja retornado a cada invocação de Supplier.

```java
public class SupplierExample {
        public static void main(String[] args) {
                // Usar o Supplier com expressão lambda para fornecer uma saudação personalizada
                Supplier<String> saudacao = () -> "Olá, seja bem-vindo(a)!";

                // Usar o Supplier para obter uma lista com 5 saudações
                List<String> listaSaudacoes = Stream.generate(saudacao)
                                .limit(5)
                                .collect(Collectors.toList());

                // Imprimir as saudações geradas
                listaSaudacoes.forEach(System.out::println);
        }
}
```

## Interface Function
`Function<T,R>` representa uma função que aceita um argumento de tipo `T` e produz um resultado de tipo `R`.

```java
public class FunctionExample {
        public static void main(String[] args) {
                // Criar uma lista de números inteiros
                List<Integer> numeros = Arrays.asList(1, 2, 3, 4, 5);

                // Usar a Function com expressão lambda para dobrar todos os números
                Function<Integer, Integer> dobrar = numero -> numero * 2;

                // Usar a função para dobrar todos os números no Stream e armazená-los em outra
                // lista
                List<Integer> numerosDobrados = numeros.stream_api()
                                .map(dobrar)
                                .collect(Collectors.toList());

                // Imprimir a lista de números dobrados
                numerosDobrados.forEach(System.out::println);
        }
}
```

## Interface Predicate
`Predicate<T>` representa um predicado (função que retorna um valor boolean) de um argumento do tipo `T`.

```java
public class PredicateExample {
        public static void main(String[] args) {
                // Criar uma lista de números inteiros
                List<Integer> numeros = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

                // Usar o Predicate com expressão lambda para filtrar números pares
                Predicate<Integer> isPar = numero -> numero % 2 == 0;

                // Usar o predicado para filtrar números pares no Stream e armazená-los em outra
                // lista
                List<Integer> numerosPares = numeros.stream_api()
                                .filter(isPar)
                                .collect(Collectors.toList());

                // Imprimir a lista de números pares
                numerosPares.forEach(System.out::println);
        }
}
```

## Interface BinaryOperator
`BinaryOperator<T>` representa uma operação com dois operandos de um mesmo tipo `T` e que produz um resultado com o mesmo tipo dos operandos.

```java
public class BinaryOperatorExample {
        public static void main(String[] args) {
                // Criar uma lista de números inteiros
                List<Integer> numeros = Arrays.asList(1, 2, 3, 4, 5);

                // Usar o BinaryOperator com expressão lambda para somar dois números inteiros
                BinaryOperator<Integer> somar = (num1, num2) -> num1 + num2;

                // Usar o BinaryOperator para somar todos os números no Stream
                int resultado = numeros.stream_api()
                                .reduce(0, somar);

                // Imprimir o resultado da soma
                System.out.println("A soma dos números é: " + resultado);
        }
}
```

## Referências
- Interface Consumer - Oracle: https://docs.oracle.com/javase/8/docs/api/java/util/function/Consumer.html
- Interface Supplier - Oracle: https://docs.oracle.com/javase/8/docs/api/java/util/function/Supplier.html
- Interface Function - Oracle: https://docs.oracle.com/javase/8/docs/api/java/util/function/Function.html
- Interface Predicate - Oracle: https://docs.oracle.com/javase/8/docs/api/java/util/function/Predicate.html
- Interface BinaryOperator - Oracle: https://docs.oracle.com/javase/8/docs/api/java/util/function/BinaryOperator.html