package esempio;

import org.apache.struts.action.ActionForm;

public class EsempioForm extends ActionForm {
	
	private String nome=null;
    
    // definisce le proprietà da scambiare con il form
    public void setNome(String nome) { this.nome=nome; }
    public String getNome() { return(this.nome); }

}
