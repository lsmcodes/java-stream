package io.github.lsmcodes.stream.desafios;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;

public class ParesEImpares {

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

                Predicate<Integer> par = numero -> numero % 2 == 0;

                List<Integer> numerosPares = numeros.stream()
                                .distinct()
                                .filter(par)
                                .toList();

                Predicate<Integer> impar = numero -> numero % 2 != 0;

                List<Integer> numerosImpares = numeros.stream()
                                .distinct()
                                .filter(impar)
                                .toList();

                System.out.println("Números pares: " + numerosPares + ", números ímpares: " + numerosImpares);
        }

}