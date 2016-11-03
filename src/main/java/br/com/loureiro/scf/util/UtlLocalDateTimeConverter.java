package br.com.loureiro.scf.util;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.FacesConverter;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import br.com.loureiro.scf.bean.BeanContasPagas;

@FacesConverter(value = UtlLocalDateTimeConverter.ID)
public class UtlLocalDateTimeConverter implements javax.faces.convert.Converter {

	private static final Logger logger = LogManager.getLogger(BeanContasPagas.class);

	public static final String ID = "localDateTimeConverter";
    
	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {		
		
		LocalDate localDate = null;
		
		try {
			if(value == null || value.equals("")) {
				return value;
			}
			
			 localDate = LocalDate.parse(value, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
		} catch(Exception e) {
			logger.error(e.getMessage(), e);
		}
		
		return localDate;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		
		String dateString = null;
		
		try {
			LocalDate dateValue = (LocalDate) value;
			dateString = dateValue.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
		
		return dateString;
	}
	
}