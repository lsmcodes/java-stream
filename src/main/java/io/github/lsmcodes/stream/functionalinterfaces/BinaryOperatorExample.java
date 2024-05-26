package io.github.lsmcodes.stream.functionalinterfaces;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.function.BinaryOperator;

/**
 * <p>
 * Representa uma operação com dois operandos de um mesmo tipo <code>T</code> e
 * que produz um resultado com o mesmo tipo dos operandos.
 * </p>
 */
public class BinaryOperatorExample {

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

                // Usar BinaryOperator para multiplicar todos os números
                BinaryOperator<Integer> multiplicacao = (n1, n2) -> n1 * n2;
                int totalMultiplicacao = 1;
                for (Integer numero : numeros) {
                        totalMultiplicacao = multiplicacao.apply(totalMultiplicacao, numero);
                }
                System.out.println("Multiplicação de todos os números: " + totalMultiplicacao);

                // Usar BinaryOperator implicitamente com Stream para somar todos os números
                int soma = numeros.stream()
                                .reduce(0, Integer::sum);
                System.out.println("Soma de todos os números: " + soma);
        }

}