package com.iglaz.astonbase.lesson5.homework;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class PuttingIntoPractice {

    public static void main(String... args) {

        Trader raoul = new Trader("Raoul", "Cambridge");
        Trader mario = new Trader("Mario", "Milan");
        Trader alan = new Trader("Alan", "Cambridge");
        Trader brian = new Trader("Brian", "Cambridge");
        List<Trader> traders = new ArrayList<>();
        traders.add(raoul);
        traders.add(mario);
        traders.add(alan);
        traders.add(brian);

        List<Transaction> transactions = Arrays.asList(
                new Transaction(brian, 2011, 300),
                new Transaction(raoul, 2012, 1000),
                new Transaction(raoul, 2011, 400),
                new Transaction(mario, 2012, 710),
                new Transaction(mario, 2012, 700),
                new Transaction(alan, 2012, 950)
        );

        /*1. Найти все транзакции за 2011 год и отсортировать их по сумме (от меньшей
        к большей).*/

        transactions.stream()
                .filter(transaction -> transaction.getYear() == 2011)
                .sorted(Comparator.comparing(Transaction::getValue))
                .forEach(System.out::println);

        /*2. Вывести список неповторяющихся городов, в которых работают трейдеры.*/

       traders.stream()
               .map(Trader::getCity)
               .distinct()
               .forEach(System.out::println);

      /*  3. Найти всех трейдеров из Кембриджа и отсортировать их по именам.*/

        traders.stream()
                .filter(trader -> trader.getCity().equals("Cambridge"))
                .map(Trader::getName)
                .sorted()
                .forEach(System.out::println);

        /*4. Вернуть строку со всеми именами трейдеров, отсортированными в алфавитном
        порядке.*/

        List<String> trader= traders.stream()
                    .map(Trader::getName)
                    .sorted()
                    .collect(Collectors.toList());
        System.out.println(trader);

       /* 5. Выяснить, существует ли хоть один трейдер из Милана.*/

        boolean anyMatch = traders.stream()
                .anyMatch(trader -> trader.getCity().equals("Milan"));
        System.out.println(anyMatch);

       /* 6. Вывести суммы всех транзакций трейдеров из Кембриджа.*/

     int sum = transactions.stream()
              .filter(transaction -> transaction.getTrader()
                      .getCity().equals("Cambridge"))
             .mapToInt(Transaction::getValue)
             .sum();
        System.out.println(sum);

      /*  7. Какова максимальная сумма среди всех транзакций?*/

        int max = transactions.stream()
                .mapToInt(Transaction::getValue)
                .max().getAsInt();
        System.out.println(max);

       /* 8. Найти транзакцию с минимальной суммой.*/

        int min = transactions.stream()
                .mapToInt(Transaction::getValue)
                .min().getAsInt();
        System.out.println(min);
    }
}
