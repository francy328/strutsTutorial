package esempio;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
 
public class EsempioAction extends Action {
 
  public ActionForward execute(ActionMapping mapping, ActionForm form,
                               HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException 
  {
      String output = null;
       
      // controlliamo che il form non sia vuoto
      if (form != null) {
          // effetuiamo il cast dal form in ingresso
          EsempioForm actionForm = (EsempioForm) form;
          output = actionForm.getNome();
      }
       
      // giriamo risultato nella prossima request
      request.setAttribute("NOME", output);
      return (mapping.findForward("risultato"));
  }
}
