package com.saeed.stream;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class UniqueEmailsByDomain {

    public static void main(String[] args) {
        List<String> emails = Arrays.asList(
                "Ali@GMAIL.com", "sara@yahoo.com", "mina@gmail.com", "john@outlook.com",
                "fake.email.com", "invalid@too@many.com", "Ali@GMAIL.com"
        );

        List<String> result = emails.stream()
                .filter(email -> email.split("@").length == 2)
                .map(String::toLowerCase)
                .distinct()
                .sorted(Comparator.comparing(
                        (String email) -> email.split("@")[1])
                        .thenComparing(email -> email.split("@")[0])
                )
                .toList();

        System.out.println(result);
    }
}
