# strutsTutorial
Questo esempio userà il framework struts 1;

Nel file web.xml indica all apllication server quali componenti caricare all avvio della applicazione;


=====WEB.XML==============
1. configurazione controller, ossia la servlet  ActionServlet a questa servlet associamo il file struts-config.xml che sarà 
letto all'avvio.
2. configuriamo la chiamata alla servlet con gli URL che hano un suffisso uguale a .do (mapping della servlet).
3.configuriamo la pagina di benevenuto,usando il tag welcome-file-list.



======STRUTS-CONFIG.XML========
questo file ci permette di definire il comportamento del framework senza agire direttamente nel codice.
in questo file ci sono 5 sezioni:
1.global-forwards
possiamo creare delle associazioni tra un nome (che è una azione del controller) ed una vista.
ha tre attributi: il nome dell action; path è l URI verso cui dovrebbe avvenire il forward, comincia con /; classname serve per dichiarare l istanza che estende il bean di configurazione e mantiene tutte le info di forward; di default è org.apache.struts.action.ForwardConfig

2.form-beans
sono classi particolari che contengono i dati inseriti uin un form all interno di una pagina jsp.
Ha tre attributi principali: ClassName una classe se non si vuole usare il bean di configurazione di default. Il name del bean; il Type 
una classe java che estende l ActionForm di Struts.

3.action-mappings
per ogni action-mapping definiamo un action in cui è possibbile definire le proprietà (path name etc) ed i forward

4.message-resources
sono classi utili per gestire i messaggi in modo unificato, utili per applicazione multilingua

5.plug-in
classi aggiunte all applicazione

in breve




