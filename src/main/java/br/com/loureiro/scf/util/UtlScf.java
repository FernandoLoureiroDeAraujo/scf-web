package br.com.loureiro.scf.util;

import java.lang.reflect.Field;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

import org.apache.log4j.Logger;

public class UtlScf {

	private static final Logger LOGGER = Logger.getLogger(UtlScf.class.getName());
	
	/**
	 * Retorna campos e valores de uma classe.
	 * @param classe
	 * @return Map<Integer, Object[]>
	 * @throws Exception
	 */
	public static Map<Integer, Object[]> getFieldNamesAndValues(final Object classe) throws Exception {

		Map<Integer, Object[]> fieldMap = new HashMap<>();
		
		Field[] fieldsSuper = classe.getClass().getSuperclass().getDeclaredFields();
		Field[] fieldsClass = classe.getClass().getDeclaredFields();

		Field[] fields = Stream.concat(Arrays.stream(fieldsSuper), Arrays.stream(fieldsClass)).toArray(Field[]::new);
		
		for (int i = 0; i < fields.length; i++) {

			fields[i].setAccessible(true);

			Object[] objects = new Object[2];
			objects[0] = fields[i].getName();
			objects[1] = fields[i].get(classe);

			fieldMap.put(i, objects);
		}
		
		return fieldMap;
	}
	
    public static String concatenar(Object... objects) {
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < objects.length; i++) {
            str.append(objects[i]);
        }
        return str.toString();
    }
    
    private static final String PATTERN = "dd/MM/yyyy";
    public static String formatarData(LocalDate data) {
    	
    	if(data == null) {
    		return null;
    	}
    	
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern(PATTERN);
		String strLocalDate = data.format(formatter);
    	return strLocalDate;
    }
	
}