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
sono classi particolari che contengono i dati inseriti in un form all interno di una pagina jsp.
Ha tre attributi principali: ClassName una classe se non si vuole usare il bean di configurazione di default. Il name del bean; il Type 
una classe java che estende l ActionForm di Struts.

3.action-mappings
per ogni action-mapping definiamo un action in cui è possibbile definire le proprietà (path name etc) ed i forward

4.message-resources
sono classi utili per gestire i messaggi in modo unificato, utili per applicazione multilingua

5.plug-in
classi aggiunte all applicazione


=========HELLO WORLD==============
i componenti principali dell app:
1.WEB-INF/web.xml
2.WEB-INF/struts-config.xml
3.index.jsp, pages/Welcome.jsp
4.WEB-INF/classes/message.properties
5. le api di struts WEB-INF/lib
6. il pom
7.la cartella META-INF che contiene il pom.
9.il file build.xml 



1. ci sono due tag <servlet> e <-mapping> ed il tag <welcome-file-list> in pratica
quando tomcat intercetta nell URL *.do chiama il metodo nella classe ActionServlet, che è stata
opportunatamente configurata dal file struts-config.xml

2.col tag <global-forwards> richieste Welcome.do sono associate ad un forward di nome welcome
col tag <action-mappings> mappiamo l action welcome.do.


FUNZIONAMENTO A GRANDI LINEE
org.apache.struts.action.ActionServlet è IL CONTROLLER DI QUESTA APPLICAZIONE
riceve una richiesta e istanzia un oggetto di una classe Action ossia si comporta 
da Action Factory.
Implementa come tutte le servlet i metodi doGet e doPost che chiamano il metodo process
ossia RequestProcessor.process(), una volta invocato questo metodo reperisce dal file struts.xml
l 'elemento action che corrisponde al path submitted (ossia il path specificato nella URL) della richiesta.
NEll esempio è Welcome.do contenuto nell URL
http://localhost:8080/ProvaStruts_1/Welcome.do
Il processor adesso, cerca nel file Strut-config.xml l action Welcome.so e trova
<action
            path="/Welcome"
            forward="/pages/Welcome.jsp"/>
quindi restituisce la pagina Welcome.jsp.

Esempio:
chiamo 
http://localhost:8080/ProvaStruts_1/Pippo.do
e
voglio visualizzare la pagina Pippo.jsp

Il controller istanzia oggetti della classe action, quindi nella classe action viene implentata la logica applicativa
Sono configurate nel file strut-config.xml il nome deve terminare in .do, in questo moto si indica che sara processata 
come action e non come servlet. Tramite le Action si possono ricevere le richieste dal Form elaborare i dati e lancia le view.
Per creare un action:
1. serve una classe che estende la classe org.apache.struts.action.Action
2.implementare il metodo execute in cui scriviamo la logica
3.aggiungere un elemento action nel file strut-config.xml


VEDIAMO I COMPONENTI NECESSARI A CREARE E GESTIRE UN FORM
Passi da compiere:
1.creo una view che contenga il form usando la taglib HTML e la vista result.jsp
2.Creo un oggetto actionForm che contiene i dati del form, la classe ActionForm mi permette di prendere 
  i dati dal form e trasferirli al controller
3.creo un Action che sara invocata invocata dal controller e gestira la richiesta
4.Modificare il file strut-config.xml 


FUNZIONAMETO IN BREVE:
chiamo :
http://localhost:8080/ProvaStruts_1/pages/esempio.jsp
e tomcat restituisce la pagina jsp, al click del bottone sul form 
che è un form costruito con i tag library di struts, in controller cerca nel file struts-config.xml
l action associata al form ed esegue il metodo execute, quidi esegue un forward all elemento indicato con la parola risultato
che è la vista risultato.jsp.






