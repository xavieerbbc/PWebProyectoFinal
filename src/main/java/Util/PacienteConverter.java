package Util;


import javax.el.ValueExpression;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import Modelo.Paciente;
import Vista.GestionRecetaBean;


@FacesConverter(value = "pacienteConverter")
public class PacienteConverter implements Converter {

	    @Override
	    public Object getAsObject(FacesContext ctx, UIComponent uiComponent, String beerId) {
	        ValueExpression vex =
	                ctx.getApplication().getExpressionFactory()
	                        .createValueExpression(ctx.getELContext(),
	                                "#{gestionRecetaBean}", GestionRecetaBean.class);

	        GestionRecetaBean bean = (GestionRecetaBean)vex.getValue(ctx.getELContext());
	        for(Paciente m: bean.getPacientes()) {
	        	System.out.println(m);
	        	if(m.getCodigo() == Integer.valueOf(beerId)) {
	        		System.out.println("encontrado");
	        		return m;
	        	}
	        		
	        }
	        return null;
	    }

	    @Override
	    public String getAsString(FacesContext facesContext, UIComponent uiComponent, Object beer) {
	        return "" + ((Paciente)beer).getCodigo();
	    }

	}