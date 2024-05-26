package io.github.lsmcodes.stream.functionalinterfaces;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;

/**
 * </p>
 * Representa uma operação que aceita um único argumento de entrada de tipo
 * <code>T</code> e não retorna resultado.
 * </p>
 */
public class ConsumerExample {

        public static void main(String[] args) {
                Scanner scanner = new Scanner(System.in);
                boolean aguardarInput = true;

                List<Integer> numeros = new ArrayList<>();

                System.out.println("\nDigite um número por vez ou digite \"fim\" para sair:");
                while (aguardarInput) {
                        String opcao = scanner.nextLine();
                        if (opcao.equalsIgnoreCase("fim")) {
                                aguardarInput = false;
                        } else {
                                int numero = Integer.parseInt(opcao);
                                numeros.add(numero);
                        }
                }
                scanner.close();

                // Usar Consumer com expressão lambda para imprimir números pares
                System.out.println("Números pares:");
                Consumer<Integer> numerosPares = n -> {
                        if (n % 2 == 0) {
                                System.out.println(n);
                        }
                };
                for (Integer numero : numeros) {
                        numerosPares.accept(numero);
                }

                // Usar Consumer implícito com Stream para imprimir números ímpares
                System.out.println("Números ímpares:");
                numeros.stream()
                                .filter(n -> n % 2 != 0)
                                .forEach(System.out::println);
        }

}