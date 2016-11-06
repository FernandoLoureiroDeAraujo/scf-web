package br.com.loureiro.scf.util;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.FacesConverter;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import br.com.loureiro.scf.bean.BeanContasPagas;

@FacesConverter(value = ConvertStringToLocalDate.ID)
public class ConvertStringToLocalDate implements javax.faces.convert.Converter {

	private static final Logger LOGGER = LogManager.getLogger(BeanContasPagas.class);

	public static final String ID = "convertStringToLocalDate";
	private static final String PATTERN = "dd/MM/yyyy";
	
	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {		
		
		LocalDate localDate = null;
		
		try {
			if(value == null || value.equals("")) {
				return value;
			}
			
			 localDate = LocalDate.parse(value, DateTimeFormatter.ofPattern(PATTERN));
		} catch(Exception e) {
			LOGGER.error(e.getMessage(), e);
		}
		
		return localDate;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		
		String dateString = null;
		
		try {
			LocalDate dateValue = (LocalDate) value;
			dateString = dateValue.format(DateTimeFormatter.ofPattern(PATTERN));
		} catch (Exception e) {
			LOGGER.error(e.getMessage(), e);
		}
		
		return dateString;
	}
	
}