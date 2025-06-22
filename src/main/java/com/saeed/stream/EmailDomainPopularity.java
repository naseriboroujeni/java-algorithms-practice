package com.saeed.stream;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class EmailDomainPopularity {

    public static void main(String[] args) {
        List<String> emails = Arrays.asList(
                "Ali@GMAIL.com", "sara@yahoo.com", "mina@gmail.com", "john@outlook.com",
                "ali@GMAIL.com", "sina@yahoo.com", "fake.email.com", "nina@outlook.com"
        );

        List<String> validEmails = emails.stream()
                .map(String::toLowerCase)
                .filter(email -> email.split("@").length == 2)
                .distinct()
                .toList();

        Map<String, Long> domainCount = validEmails.stream()
                .collect(Collectors.groupingBy(
                        email -> email.split("@")[1],
                        Collectors.counting()
                ));

        List<String> result = validEmails.stream()
                .sorted(Comparator.comparing(
                                (String email) -> domainCount.get(email.split("@")[1])
                        )
                        .reversed()
                        .thenComparing(String::compareTo)
                )
                .map(email -> String.join(
                        "",
                        email,
                        "(",
                        domainCount.get(email.split("@")[1]).toString(),
                        ")"
                ))
                .toList();

        System.out.println(result);
    }
}
