package br.com.loureiro.scf.util;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.FacesConverter;

@FacesConverter(value = UtlLocalDateTimeConverter.ID)
public class UtlLocalDateTimeConverter implements javax.faces.convert.Converter {

    public static final String ID = "localDateTimeConverter";
	
	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		if(value == null || value.equals("")) {
			return value;
		}
		
		return LocalDate.parse(value, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		LocalDate dateValue = (LocalDate) value;
		return dateValue.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
	}

}
