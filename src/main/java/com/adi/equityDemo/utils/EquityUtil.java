package com.adi.equityDemo.utils;

import java.util.Collection;
import java.util.function.Predicate;

public class EquityUtil {
	public static <T> T findByProperty(Collection<T> collection, Predicate<T> predicate) {
		return collection.stream().filter(predicate).findFirst().orElse(null);
	}
}
