package io.github.lsmcodes.stream.functionalinterfaces;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;

/**
 * <p>
 * Representa um predicado (função que retorna um valor booleano) de um
 * argumento do tipo <code>T</code>.
 * </p>
 */
public class PredicateExample {

        public static void main(String[] args) {
                Scanner scanner = new Scanner(System.in);
                boolean aguardarInput = true;

                List<String> palavras = new ArrayList<>();

                System.out.println("\nDigite uma palavra por vez ou digite \"0\" para sair:");
                while (aguardarInput) {
                        String opcao = scanner.nextLine();
                        if (opcao.equals("0")) {
                                aguardarInput = false;
                        } else {
                                palavras.add(opcao);
                        }
                }
                scanner.close();

                // Usar Predicate para verificar se uma palavra tem mais de cinco caracteres
                Predicate<String> maisDeCincoCaracteres = palavra -> palavra.length() > 5;

                // Usar Stream para filtrar palavras com mais de cinco caracteres e imprimí-las
                System.out.println("Palavras com mais de cinco caracteres:");
                palavras.stream()
                                .filter(maisDeCincoCaracteres)
                                .forEach(System.out::println);
        }

}