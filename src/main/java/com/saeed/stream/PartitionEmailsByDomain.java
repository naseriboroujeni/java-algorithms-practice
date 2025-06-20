package com.saeed.stream;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class PartitionEmailsByDomain {

    public static void main(String[] args) {
        List<String> emails = Arrays.asList(
                "ali@gmail.com", "sara@yahoo.com", "mina@gmail.com", "john@outlook.com"
        );

        Map<Boolean, List<String>> result = emails.stream()
                .collect(Collectors.partitioningBy(
                        email -> email.endsWith("@gmail.com"),
                        Collectors.mapping(
                                email -> email.split("@")[0].toUpperCase(),
                                Collectors.toList()
                        )));

        System.out.println(result);
    }
}
