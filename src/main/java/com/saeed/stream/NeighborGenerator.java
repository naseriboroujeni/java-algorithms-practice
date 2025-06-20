package com.saeed.stream;

import java.util.List;

@FunctionalInterface
public interface NeighborGenerator {

    List<Integer> generateNeighbor(int a);
}
