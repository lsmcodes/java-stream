package io.github.lsmcodes.stream.desafios;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;

public class NumeroNegativo {

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

                Predicate<Integer> numeroNegativo = numero -> numero < 0;

                boolean existeNumeroNegativo = numeros.stream()
                                .anyMatch(numeroNegativo);

                if (existeNumeroNegativo) {
                        System.out.println("Há ao menos um número negativo na lista.");
                } else {
                        System.out.println("Não existem números negativos na lista.");
                }
        }
}