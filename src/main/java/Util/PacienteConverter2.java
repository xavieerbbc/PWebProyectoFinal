package Util;


import javax.el.ValueExpression;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import Modelo.Paciente;
import Vista.GestionHistorialBean;


@FacesConverter(value = "pacienteConverter2")
public class PacienteConverter2 implements Converter {

	    @Override
	    public Object getAsObject(FacesContext ctx, UIComponent uiComponent, String beerId) {
	        ValueExpression vex =
	                ctx.getApplication().getExpressionFactory()
	                        .createValueExpression(ctx.getELContext(),
	                                "#{gestionHistorialBean}", GestionHistorialBean.class);

	        GestionHistorialBean bean = (GestionHistorialBean)vex.getValue(ctx.getELContext());
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