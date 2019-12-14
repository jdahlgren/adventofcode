package se.johannesdahlgren.adventofcode.util;

import java.io.IOException;

@FunctionalInterface
public interface CheckedFunction<T, R> {

  R apply(T t) throws IOException;
}
