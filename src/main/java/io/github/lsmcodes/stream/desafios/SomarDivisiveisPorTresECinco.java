package io.github.lsmcodes.stream.desafios;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;

public class SomarDivisiveisPorTresECinco {

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

                Predicate<Integer> divisivelPorTresECinco = numero -> {
                        if ((numero % 3 == 0) && (numero % 5 == 0)) {
                                return true;
                        }
                        return false;
                };

                int soma = numeros.stream()
                                .filter(divisivelPorTresECinco)
                                .mapToInt(Integer::intValue)
                                .sum();

                System.out.println("Soma dos números divisíveis por 3 e 5: " + soma);
        }

}