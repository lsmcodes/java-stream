package io.github.lsmcodes.stream.desafios;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class SegundoMaiorNumero {

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

                Optional<Integer> segundoMaiorNumeroOptional = numeros.stream()
                                .sorted()
                                .limit(numeros.size() - 1)
                                .distinct()
                                .max(Comparator.naturalOrder());

                int segundoMaiorNumero = segundoMaiorNumeroOptional.get();
                System.out.println("O segundo maior número da lista é: " + segundoMaiorNumero);
        }

}