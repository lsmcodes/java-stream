package io.github.lsmcodes.stream.desafios;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;
import java.util.function.Predicate;

public class MaiorNumeroPrimo {

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

                Predicate<Integer> primo = numero -> {
                        List<Integer> divisiveis = new ArrayList<>();

                        for (int i = 1; i <= numero; i++) {
                                int resto = numero % i;
                                if (resto == 0) {
                                        divisiveis.add(i);
                                }
                        }

                        if ((divisiveis.size() == 2) && (divisiveis.contains(1)) && (divisiveis.contains(numero))) {
                                return true;
                        }
                        return false;
                };

                List<Integer> numerosPrimos = numeros.stream()
                                .distinct()
                                .filter(primo)
                                .toList();

                Optional<Integer> maiorNumeroPrimo = numerosPrimos.stream()
                                .sorted()
                                .max(Comparator.naturalOrder());

                System.out.println("O maior número primo da lista é: " + maiorNumeroPrimo.get());
        }

}