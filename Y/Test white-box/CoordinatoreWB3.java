import java.lang.Math;
import java.util.Date;

public class CoordinatoreWB3 {
	public static void main(String[] args) {
		try {
			
			String url1 = "http://localhost:8080/axis2/services/InterfacciaOffertaCasaCoinFlip";
			String url2 = "http://localhost:8080/axis2/services/InterfacciaRichiestaCasaCoinFlip";
			String url3 = "http://localhost:8080/axis2/services/InterfacciaAttrazioniCoinFlip";
			String url4 = "http://localhost:8080/axis2/services/InterfacciaServiziAccessoriCoinFlip";
			
			String ottieniRichiesteNonGestite = "<?xml version=\"1.0\" encoding=\"utf-8\" ?><soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:axis=\"http://ws.apache.org/axis2\"><soapenv:Header/><soapenv:Body><axis:ottieniRichiesteNonGestite></axis:ottieniRichiesteNonGestite></soapenv:Body></soapenv:Envelope>";
			
			String gestisciRichiesta = "<?xml version=\"1.0\" encoding=\"utf-8\" ?><soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:axis=\"http://ws.apache.org/axis2\"><soapenv:Header/><soapenv:Body><axis:gestisciRichiesta><axis:args0>richiesta</axis:args0></axis:gestisciRichiesta></soapenv:Body></soapenv:Envelope>";
			
			String ricercaOfferte = "<?xml version=\"1.0\" encoding=\"utf-8\" ?><soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:axis=\"http://ws.apache.org/axis2\"><soapenv:Header/><soapenv:Body><axis:ricercaOfferte> <axis:args0>indirizzo richiesta </axis:args0> <axis:args1>limitazioni richiesta </axis:args1> <axis:args2>trasporto richiesta </axis:args2> <axis:args3>descrizione richiesta </axis:args3> </axis:ricercaOfferte></soapenv:Body></soapenv:Envelope>";
			
			String ottieniListaAttrazioni = "<?xml version=\"1.0\" encoding=\"utf-8\" ?><soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:axis=\"http://ws.apache.org/axis2\"><soapenv:Header/><soapenv:Body><axis:ottieniListaAttrazioni> <axis:args0>indirizzo offerta</axis:args0>  </axis:ottieniListaAttrazioni></soapenv:Body></soapenv:Envelope>";
			
			String suggerisciListaPropostaAttivita = "<?xml version=\"1.0\" encoding=\"utf-8\" ?><soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:axis=\"http://ws.apache.org/axis2\"><soapenv:Header/><soapenv:Body><axis:suggerisciListaPropostaAttivita><axis:args0>Informazioni soggiorno</axis:args0><axis:args1>Classi</axis:args1></axis:suggerisciListaPropostaAttivita></soapenv:Body></soapenv:Envelope>";
			
			String ottieniRiferimentoServiziAccessori = "<?xml version=\"1.0\" encoding=\"utf-8\"?><soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:axis=\"http://ws.apache.org/axis2\"><soapenv:Header/><soapenv:Body><axis:ottieniRiferimentoServiziAccessori><axis:args0>indirizzoOfferta</axis:args0></axis:ottieniRiferimentoServiziAccessori></soapenv:Body></soapenv:Envelope>";
		
			String creaProposta = "<?xml version=\"1.0\" encoding=\"utf-8\"?><soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:axis=\"http://ws.apache.org/axis2\"><soapenv:Header/><soapenv:Body><axis:creaProposta><axis:args0>456hg3</axis:args0><axis:args1>indirizzo</axis:args1><axis:args2>2017-03-02</axis:args2><axis:args3>2018-02-01</axis:args3></axis:creaProposta></soapenv:Body></soapenv:Envelope>";
		
			String modificaProposta = "<?xml version=\"1.0\" encoding=\"utf-8\"?><soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:axis=\"http://ws.apache.org/axis2\"><soapenv:Header/><soapenv:Body><axis:modificaProposta><axis:args0>propostaCompilata</axis:args0></axis:modificaProposta></soapenv:Body></soapenv:Envelope>";
		
			String ottieniProposta = "<?xml version=\"1.0\" encoding=\"utf-8\"?><soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:axis=\"http://ws.apache.org/axis2\"><soapenv:Header/><soapenv:Body><axis:ottieniProposta><axis:args0>456hg3</axis:args0><axis:args1>indirizzo</axis:args1><axis:args2>2017-03-02</axis:args2><axis:args3>2018-02-01</axis:args3></axis:ottieniProposta></soapenv:Body></soapenv:Envelope>";
		
			String pubblicaPropostaScambio = "<?xml version=\"1.0\" encoding=\"utf-8\"?><soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:axis=\"http://ws.apache.org/axis2\"><soapenv:Header/><soapenv:Body><axis:pubblicaPropostaScambio><axis:args0>offerta</axis:args0><axis:args1>contattiRichiedente</axis:args1></axis:pubblicaPropostaScambio></soapenv:Body></soapenv:Envelope>";
			
			String visualizzaListaPropostaAttivita = "<?xml version=\"1.0\" encoding=\"utf-8\" ?><soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:axis=\"http://ws.apache.org/axis2\"><soapenv:Header/><soapenv:Body><axis:visualizzaListaPropostaAttivita><axis:args0>AKL32D11</axis:args0></axis:visualizzaListaPropostaAttivita></soapenv:Body></soapenv:Envelope>";
			
			String aggiungiAlternative = "<?xml version=\"1.0\" encoding=\"utf-8\" ?><soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:axis=\"http://ws.apache.org/axis2\"><soapenv:Header/><soapenv:Body><axis:aggiungiAlternative><axis:args0>Lista proposta attivita</axis:args0> <axis:args1>false</axis:args1> <axis:args1>false</axis:args1> <axis:args1>true</axis:args1> <axis:args1>false</axis:args1> </axis:aggiungiAlternative></soapenv:Body></soapenv:Envelope>";
			
			String rimuoviAlternative = "<?xml version=\"1.0\" encoding=\"utf-8\" ?><soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:axis=\"http://ws.apache.org/axis2\"><soapenv:Header/><soapenv:Body><axis:rimuoviAlternative> <axis:args0>Lista proposta attivita</axis:args0> <axis:args1>true</axis:args1> <axis:args1>false</axis:args1> <axis:args1>false</axis:args1> <axis:args1>false</axis:args1> <axis:args1>true</axis:args1> <axis:args1>false</axis:args1> <axis:args1>false</axis:args1> <axis:args1>false</axis:args1> </axis:rimuoviAlternative></soapenv:Body></soapenv:Envelope>";
			
			String creaPianificazione = "<?xml version=\"1.0\" encoding=\"utf-8\" ?><soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:axis=\"http://ws.apache.org/axis2\"><soapenv:Header/><soapenv:Body><axis:creaPianificazione><axis:args0>Fasce orarie</axis:args0> </axis:creaPianificazione></soapenv:Body></soapenv:Envelope>";
			
			int maxAttivita = 10;
			String richiesteNonGestite;
			String status;
			String esito;
			String richiesta, offerta, pianificazione;
			String proposta, propostaCompilata, propostaModificata;
			String indirizzoRichiesta, limitazioniRichiesta, trasportoRichiesta, descrizioneRichiesta;
			String classiAttrazioniRichiesta;
			String listaOfferte, listaOfferteOrdinata;
			String indirizzoOfferta;
			String listaAttrazioni, classeAttrazione;
			String riferimentoPropostaAttivita, riferimentoServiziAccessori;
			String infoSoggiorno;
			String richiedente, contattiRichiedente;
			Date inizioCondivisione, fineCondivisione;
			int statoProposta;
			String propostaID, listaPropostaAttivita, propostaAttivita;
			String fasceOrarie;
			
			richiesteNonGestite = SOAPClient.sendMess(url2, ottieniRichiesteNonGestite);
			int lunghezzaRichiesteNonGestite = 5;
	
			do{
				if(lunghezzaRichiesteNonGestite == 0)
				{
					System.out.println("Non ci sono richieste da gestire");
					return;
				}
				richiesta = estraiRichiesta(richiesteNonGestite);
				lunghezzaRichiesteNonGestite--;
				status = "false";
		
				for(int i=0; i<3; i++)
					if(status.contains("false")){
						status = SOAPClient.sendMess(url2, gestisciRichiesta);
					}
			}while(status.contains("false"));
		
			indirizzoRichiesta = estraiIndirizzoRichiesta(richiesta);
			limitazioniRichiesta = estraiLimitazioniRichiesta(richiesta);
			trasportoRichiesta = estraiTrasportoRichiesta(richiesta);
			descrizioneRichiesta = estraiDescrizioneRichiesta(richiesta);
	
			do {
				int lunghezzaOfferte;
				do{
					listaOfferte = SOAPClient.sendMess(url1, ricercaOfferte);
					lunghezzaOfferte = 5;
					if(lunghezzaOfferte == 0)
					{
						if(limitazioniRichiesta.equals(""))
						{
							System.out.println("Non ci sono più offerte da proporre");
							return;
						}
						limitazioniRichiesta = eliminaLimitazione(limitazioniRichiesta);
					}
				}while(lunghezzaOfferte == 0);
			
				classiAttrazioniRichiesta = estraiClassiAttrazioniRichiesta(richiesta);
				int lunghezzaClassiAttrazioni = estraiLunghezzaLista(classiAttrazioniRichiesta);
				float[] punteggi = new float[lunghezzaOfferte];
	
				for (int i=0; i<lunghezzaOfferte; i++) {
					offerta = ottieniOfferta(listaOfferte, i);
					indirizzoOfferta = estraiIndirizzoOfferta(offerta);
		
					listaAttrazioni = SOAPClient.sendMess(url3, ottieniListaAttrazioni);
					int lunghezzaListaAttrazioni = estraiLunghezzaLista(listaAttrazioni);
			
					int numeroClassi = 0;
					for (int j=0; j<lunghezzaClassiAttrazioni && lunghezzaListaAttrazioni != 0; j++) {
						classeAttrazione = ottieniClasseAttrazione(classiAttrazioniRichiesta, j);
						int numeroAttrazioni = contaAttrazioni(listaAttrazioni, classeAttrazione);
						if (numeroAttrazioni > 0)
							numeroClassi++;
					}
					punteggi[i] = assegnaPunteggio(numeroClassi);
				}
	
				listaOfferteOrdinata = ordinaLista(listaOfferte, punteggi);
	
				offerta = ottieniOfferta(listaOfferteOrdinata, 0);
				indirizzoOfferta = estraiIndirizzoOfferta(offerta);
				infoSoggiorno = estraiInfoSoggiorno(offerta, richiesta);
	
				riferimentoPropostaAttivita = SOAPClient.sendMess(url3, suggerisciListaPropostaAttivita);
  
				riferimentoServiziAccessori = SOAPClient.sendMess(url4, ottieniRiferimentoServiziAccessori);
				
				richiedente = estraiRichiedente(richiesta);
				inizioCondivisione = calcolaInizioCondivisione(offerta, richiesta);
				fineCondivisione = calcolaFineCondivisione(offerta, richiesta);

				proposta = SOAPClient.sendMess(url2,creaProposta);
				
				propostaCompilata = inserisciInfoProposta(proposta, offerta, riferimentoPropostaAttivita, riferimentoServiziAccessori);
				propostaModificata = SOAPClient.sendMess(url2, modificaProposta);
				
				int indice = 1;
				statoProposta = 0;
				while(indice < lunghezzaOfferte)
				{
					proposta = SOAPClient.sendMess(url2, ottieniProposta);
					
					if(indice == 1)
						statoProposta = 1;
					else
						statoProposta = 2;
					if(statoProposta == 1) 
					{
						offerta = ottieniOfferta(listaOfferteOrdinata, indice);
						indirizzoOfferta = estraiIndirizzoOfferta(offerta);
						inizioCondivisione = calcolaInizioCondivisione(offerta, richiesta);
						fineCondivisione = calcolaFineCondivisione(offerta, richiesta);
				
						riferimentoServiziAccessori = SOAPClient.sendMess(url4, ottieniRiferimentoServiziAccessori);
						
						propostaCompilata = inserisciInfoProposta(proposta, offerta, riferimentoPropostaAttivita, riferimentoServiziAccessori);
				
						propostaModificata = SOAPClient.sendMess(url2, modificaProposta);
						System.out.println("E' stata proposta una nuova offerta al richiedente");
						indice++;
					} 
					else if(statoProposta == 2)
						break;
				} 
		  
				if(statoProposta != 2)
					limitazioniRichiesta = eliminaLimitazione(limitazioniRichiesta);
		  
			} while(statoProposta != 2);

			contattiRichiedente = estraiContatti(proposta);
			esito = SOAPClient.sendMess(url1, pubblicaPropostaScambio);
			
			propostaID = estraiPropostaID(riferimentoPropostaAttivita);
			listaPropostaAttivita = SOAPClient.sendMess(url3, visualizzaListaPropostaAttivita);
			
			statoProposta = 2;
			while(statoProposta != 2) 
			{
				if(statoProposta == 1) 
				{
					int lunghezzaPropostaAttivita = estraiLunghezzaLista(listaPropostaAttivita);
					boolean[] fasceVuote = cercaFasceOrarieVuote(listaPropostaAttivita, lunghezzaPropostaAttivita);
					listaPropostaAttivita = SOAPClient.sendMess(url3, aggiungiAlternative);
					
					int lunghezzaAlternative = lunghezzaPropostaAttivita * maxAttivita;
					boolean[] daRimuovere = new boolean[lunghezzaAlternative];
					daRimuovere = selezionaAttivitaDaRimuovere(listaPropostaAttivita, classiAttrazioniRichiesta, lunghezzaAlternative);
					listaPropostaAttivita = SOAPClient.sendMess(url3, rimuoviAlternative);
					
					System.out.println("Aggiornata la lista delle proposte d'attività");
				}
				listaPropostaAttivita = SOAPClient.sendMess(url3, visualizzaListaPropostaAttivita);
				statoProposta = estraiStatoListaPropostaAttivita(listaPropostaAttivita);
			}

			fasceOrarie = estraiFasceOrarie(listaPropostaAttivita);
			pianificazione = SOAPClient.sendMess(url4, creaPianificazione);
			System.out.println("La condivisione è andata a buon fine");
			
		} catch(Exception e){System.out.println("Eccezione");}
	
	}
	
	public static String estraiRichiesta(String listaRichieste) {
		return "Prima richiesta";
	}
	
	public static String estraiIndirizzoRichiesta(String richiesta) {
		return "Indirizzo estratto da richiesta";
	}
	
	public static String estraiLimitazioniRichiesta(String richiesta) {
		return "Limitazioni estratte da richiesta";
	}
	
	public static String estraiTrasportoRichiesta(String richiesta) {
		return "Trasporto estratto da richiesta";
	}
	
	public static String estraiDescrizioneRichiesta(String richiesta) {
		return "Descrizione estratta da richiesta";
	}
	
	public static int estraiLunghezzaLista(String lista){
		
		if(lista.contains("Lista di attrazioni ordinata per distanza"))
			return (int)(Math.random()*10);
		if(lista.contains("Lista di offerte pertinenti con i parametri di ricerca."))
			return (int)(Math.random()*20);
		if(lista.contains("Richieste non gestite"))
			return (int)(Math.random()*20);
		if(lista.contains("Lista proposta attivita"))
			return (int)(Math.random()*100);
			
		return (int)(Math.random()*10);
	}
	
	public static String estraiClassiAttrazioniRichiesta(String richiesta) {
		return "Lista classi attrazioni estratte da richiesta";
	}
	
		public static String ottieniOfferta(String lista, int indice) {
		return "Offerta all'indice "+indice;
	}
	
	public static String estraiIndirizzoOfferta(String offerta) {
		return "Indirizzo estatto da offerta";
	}
	
	public static String ottieniClasseAttrazione(String classiAttrazioniRichiesta, int indice) {
		return "Classe d'attrazione all'indice "+indice;
	}
	
	public static int contaAttrazioni(String listaAttrazioni, String classe) {
		return (int)(Math.random()*5);
	}
	
	public static float assegnaPunteggio(int numeroClassi) {
		return numeroClassi * (float)Math.random() * 10;
	}
	
	public static String ordinaLista(String listaDaOrdinare, float[] punteggio) {
		return "Lista offerte ordinata per punteggio decrescente";
	}
	
	public static String estraiInfoSoggiorno(String offerta, String richiesta) { 
		return "Informazioni soggiorno";
	}
	
	public static String estraiRichiedente(String richiesta){  
		return "Richiedente"; 
	}
	
	public static Date calcolaInizioCondivisione(String offerta, String richiesta){
		return new Date(2017, (int)(Math.random()*12), (int)(Math.random()*27+1));
	}
	
	public static Date calcolaFineCondivisione(String offerta, String richiesta){
		return new Date(2018, (int)(Math.random()*12), (int)(Math.random()*27+1));
	}
	
	public static String inserisciInfoProposta(String proposta, String offerta, String riferimentoPropostaAttivita, String riferimentoServiziAccessori){
		return "Proposta compilata";
	}
	
	public static int estraiStatoProposta(String richiesta){
		return (int)(Math.random()*3);
	}
	
	public static String  eliminaLimitazione(String limitazioniRichiesta){
		return "Limitazioni ridotte";
	}
	
	public static String estraiContatti(String proposta){
		return "Contatti del richiedente";
	}
	
	public static String estraiPropostaID(String riferimentoPropostaAttivita) {
		return "ID della proposta";
	}
	
	public static int estraiStatoListaPropostaAttivita(String listaPropostaAttivita){
		return (int)(Math.random()*3);
	}
		
	public static boolean[] cercaFasceOrarieVuote(String listaPropostaAttivita, int lunghezza){
		boolean[] temp = new boolean[lunghezza];
		for(int i = 0; i < lunghezza; i++ )
			temp[i] = (Math.random() < 0.3)? true : false;
		return temp;
	}
	
	public static boolean[] selezionaAttivitaDaRimuovere(String listaPropostaAttivita, String classiAttrazioni, int lunghezza){
		boolean[] temp = new boolean[lunghezza];
		for(int i = 0; i < lunghezza; i++ )
			temp[i] = (Math.random() < 0.2)? true : false;
		return temp;
	}
	
	public static String estraiFasceOrarie(String listaPropostaAttivita){
		return "Fasce orarie estratte";
	}
}