package io.github.lsmcodes.stream.desafios;

import java.util.ArrayList;
import java.util.List;
import java.util.OptionalDouble;
import java.util.Scanner;
import java.util.function.Predicate;

public class MediaMaioresQueCinco {

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

                Predicate<Integer> maiorQueCinco = numero -> numero > 5;

                OptionalDouble mediaMaioresQueCinco = numeros.stream()
                                .filter(maiorQueCinco)
                                .mapToDouble(Integer::doubleValue)
                                .average();

                System.out.println("Média dos números maiores que cinco: " + mediaMaioresQueCinco.getAsDouble());
        }

}