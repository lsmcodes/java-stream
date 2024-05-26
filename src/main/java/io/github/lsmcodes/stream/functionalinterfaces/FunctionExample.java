package io.github.lsmcodes.stream.functionalinterfaces;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;

/**
 * <p>
 * Representa uma função que aceita um argumento de tipo <code>T</code> e produz
 * um resultado de tipo <code>R</code>.
 * </p>
 */
public class FunctionExample {

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

                // Usar Function com expressão lambda para imprimir o dobro dos números
                System.out.println("Dobro dos números:");
                Function<Integer, Integer> dobro = numero -> numero * 2;
                for (Integer numero : numeros) {
                        int dobroDoValor = dobro.apply(numero);
                        System.out.println(dobroDoValor);
                }

                // Usar Function implicitamente e Stream para imprimir o triplo dos números
                System.out.println("Triplo dos números:");
                List<Integer> triplo = numeros.stream()
                                .map(numero -> numero * 3)
                                .toList();
                triplo.stream().forEach(System.out::println);
        }

}