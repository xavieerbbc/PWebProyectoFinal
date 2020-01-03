package Util;


import javax.el.ValueExpression;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import Modelo.Medico;
import Vista.GestionIndexPacienteBean;


@FacesConverter(value = "medicoConverter")
public class MedicoConverter implements Converter {

	    @Override
	    public Object getAsObject(FacesContext ctx, UIComponent uiComponent, String beerId) {
	        ValueExpression vex =
	                ctx.getApplication().getExpressionFactory()
	                        .createValueExpression(ctx.getELContext(),
	                                "#{gestionIndexPacienteBean}", GestionIndexPacienteBean.class);

	        GestionIndexPacienteBean bean = (GestionIndexPacienteBean)vex.getValue(ctx.getELContext());
	        for(Medico m: bean.getMedicos()) {
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
	        return "" + ((Medico)beer).getCodigo();
	    }

	}