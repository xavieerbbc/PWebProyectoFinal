package Util;


import javax.el.ValueExpression;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import Modelo.Especialidad;
import Vista.GestionMedicoBean;


@FacesConverter(value = "especialidadConverter")
public class EspecialidadConverter implements Converter {

	    @Override
	    public Object getAsObject(FacesContext ctx, UIComponent uiComponent, String beerId) {
	        ValueExpression vex =
	                ctx.getApplication().getExpressionFactory()
	                        .createValueExpression(ctx.getELContext(),
	                                "#{gestionMedicoBean}", GestionMedicoBean.class);

	        GestionMedicoBean bean = (GestionMedicoBean)vex.getValue(ctx.getELContext());
	        for(Especialidad m: bean.getEspecialidades()) {
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
	        return "" + ((Especialidad)beer).getCodigo();
	    }

	}