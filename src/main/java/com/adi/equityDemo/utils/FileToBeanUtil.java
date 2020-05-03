package com.adi.equityDemo.utils;

import java.io.FileReader;
import java.util.List;

import com.opencsv.bean.ColumnPositionMappingStrategy;
import com.opencsv.bean.CsvToBeanBuilder;

public class FileToBeanUtil {
	public static <T> List<T> readCSVToObjects(Class<T> type, String filePath) throws Exception {
		try {
			ColumnPositionMappingStrategy<T> strategy = new ColumnPositionMappingStrategy<>();
			strategy.setType(type);
			return new CsvToBeanBuilder<T>(new FileReader(filePath)).withType(type).build().parse();
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
}
