package br.com.loureiro.scf.util;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.FacesConverter;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import br.com.loureiro.scf.bean.BeanContasPagas;

@FacesConverter(value = ConvertStringToDouble.ID)
public class ConvertStringToDouble implements javax.faces.convert.Converter {

	private static final Logger logger = LogManager.getLogger(BeanContasPagas.class);

	public static final String ID = "convertStringToDouble";
    
	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {		
		
		Double valor = null;
		
		try {
			if(value == null || value.equals("")) {
				return value;
			}
			
	    	String parseStringToDouble = value.replace(".", "");
	    	parseStringToDouble = parseStringToDouble.replace(",", ".");
	    	valor = Double.valueOf(parseStringToDouble);	
		} catch(Exception e) {
			logger.error(e.getMessage(), e);
		}
		
		return valor;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		return String.valueOf(value);
	}
	
}