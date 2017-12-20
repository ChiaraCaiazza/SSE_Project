import java.lang.Math;
import java.util.Date;

public class Coordinatore {
	
	public static void main(String[] args) {
		InterfacciaOffertaCasa offertaCasa = new InterfacciaOffertaCasa();
		InterfacciaRichiestaCasa richiestaCasa = new InterfacciaRichiestaCasa();
		InterfacciaAttrazioni attrazioni = new InterfacciaAttrazioni();
		InterfacciaServiziAccessori serviziAccessori = new InterfacciaServiziAccessori();
		
		int maxAttivita = 10;
		String richiesteNonGestite;
		boolean status = false;
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
		
		richiesteNonGestite = richiestaCasa.ottieniRichiesteNonGestite();
		int lunghezzaRichiesteNonGestite = estraiLunghezzaLista(richiesteNonGestite);
		
		do{
			if(lunghezzaRichiesteNonGestite == 0)
				return;
				
			richiesta = estraiRichiesta(richiesteNonGestite);
			lunghezzaRichiesteNonGestite--;
			for(int i=0; i<3 || (!status); i++)
				status = richiestaCasa.gestisciRichiesta(richiesta);
		}while(!status);
		
		indirizzoRichiesta = estraiIndirizzoRichiesta(richiesta);
		limitazioniRichiesta = estraiLimitazioniRichiesta(richiesta);
		trasportoRichiesta = estraiTrasportoRichiesta(richiesta);
		descrizioneRichiesta = estraiDescrizioneRichiesta(richiesta);
		
		do{
		    int lunghezzaOfferte;
			do{
				listaOfferte = offertaCasa.ricercaOfferte(indirizzoRichiesta, limitazioniRichiesta, trasportoRichiesta, descrizioneRichiesta);
				lunghezzaOfferte = estraiLunghezzaLista(listaOfferte);
				if(lunghezzaOfferte == 0) {
					if(limitazioniRichiesta.equals(""))
						return;
					limitazioniRichiesta = eliminaLimitazione(limitazioniRichiesta);
				}
			}while(lunghezzaOfferte == 0);
			
			classiAttrazioniRichiesta = estraiClassiAttrazioniRichiesta(richiesta);
			int lunghezzaClassiAttrazioni = estraiLunghezzaLista(classiAttrazioniRichiesta);
			float[] punteggi = new float[lunghezzaOfferte];
		
			for (int i=0; i<lunghezzaOfferte; i++) {
				offerta = ottieniOfferta(listaOfferte, i);
				indirizzoOfferta = estraiIndirizzoOfferta(offerta);
			
				listaAttrazioni = attrazioni.ottieniListaAttrazioni(indirizzoOfferta);
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
		
			riferimentoPropostaAttivita = attrazioni.suggerisciListaPropostaAttivita(infoSoggiorno, classiAttrazioniRichiesta);
			riferimentoServiziAccessori = serviziAccessori.ottieniRiferimentoServiziAccessori(indirizzoOfferta);
		
			richiedente = estraiRichiedente(richiesta);
			inizioCondivisione = calcolaInizioCondivisione(offerta, richiesta);
			fineCondivisione = calcolaFineCondivisione(offerta, richiesta);
		
			proposta = richiestaCasa.creaProposta(richiedente, indirizzoOfferta, inizioCondivisione, fineCondivisione);
			propostaCompilata = inserisciInfoProposta(proposta, offerta, riferimentoPropostaAttivita, riferimentoServiziAccessori);
			propostaModificata = richiestaCasa.modificaProposta(propostaCompilata);
		
			int indice = 1;
			statoProposta = 0;
			while(indice < lunghezzaOfferte) {
				proposta = richiestaCasa.ottieniProposta(richiedente, indirizzoOfferta, inizioCondivisione, fineCondivisione);
				statoProposta = estraiStatoProposta(proposta);
				if(statoProposta == 1) {
					offerta = ottieniOfferta(listaOfferteOrdinata, indice);
					indirizzoOfferta = estraiIndirizzoOfferta(offerta);
					inizioCondivisione = calcolaInizioCondivisione(offerta, richiesta);
					fineCondivisione = calcolaFineCondivisione(offerta, richiesta);
					riferimentoServiziAccessori = serviziAccessori.ottieniRiferimentoServiziAccessori(indirizzoOfferta);
					propostaCompilata = inserisciInfoProposta(proposta, offerta, riferimentoPropostaAttivita, riferimentoServiziAccessori);
					propostaModificata = richiestaCasa.modificaProposta(propostaCompilata);
					indice++;
				}
				else if(statoProposta == 2)
					break;
			}
			
			if(statoProposta != 2)
				limitazioniRichiesta = eliminaLimitazione(limitazioniRichiesta);
			
		}while(statoProposta != 2);
		
		contattiRichiedente = estraiContatti(proposta);
		esito = offertaCasa.pubblicaPropostaScambio(offerta, contattiRichiedente);
		
		propostaID = estraiPropostaID(riferimentoPropostaAttivita);
		listaPropostaAttivita = attrazioni.visualizzaListaPropostaAttivita(propostaID);
		statoProposta = estraiStatoListaPropostaAttivita(listaPropostaAttivita);
		while(statoProposta != 2) {
			if(statoProposta == 1) {
				int lunghezzaPropostaAttivita = estraiLunghezzaLista(listaPropostaAttivita);
				boolean[] fasceVuote = cercaFasceOrarieVuote(listaPropostaAttivita, lunghezzaPropostaAttivita);
				listaPropostaAttivita = attrazioni.aggiungiAlternative(listaPropostaAttivita, fasceVuote);
				
				int lunghezzaAlternative = lunghezzaPropostaAttivita * maxAttivita;
				boolean[] daRimuovere = new boolean[lunghezzaAlternative];
				daRimuovere = selezionaAttivitaDaRimuovere(listaPropostaAttivita, classiAttrazioniRichiesta, lunghezzaAlternative);
				listaPropostaAttivita = attrazioni.rimuoviAlternative(listaPropostaAttivita, daRimuovere);	
			}
			listaPropostaAttivita = attrazioni.visualizzaListaPropostaAttivita(propostaID);
			statoProposta = estraiStatoListaPropostaAttivita(listaPropostaAttivita);
		}
		
		fasceOrarie = estraiFasceOrarie(listaPropostaAttivita);
		pianificazione = serviziAccessori.creaPianificazione(fasceOrarie);	
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
		if(lista.equals("Lista di attrazioni ordinata per distanza"))
			return (int)(Math.random()*10);
		if(lista.equals("Lista di offerte pertinenti con i parametri di ricerca."))
			return (int)(Math.random()*20);
		if(lista.equals("Richieste non gestite"))
			return (int)(Math.random()*20);
		if(lista.equals("Lista proposta attivita"))
			return (int)(Math.random()*100);
			
		return (int)(Math.random()*10);
	}
	
	public static String estraiClassiAttrazioniRichiesta(String richiesta) {
		return "Lista classi attrazioni estratte da richiesta";
	}
	
	public static String ottieniOfferta(String lista, int indice) {
		return "Offerta all'indice " + indice;
	}
	
	public static String estraiIndirizzoOfferta(String offerta) {
		return "Indirizzo estatto da offerta";
	}
	
	public static String ottieniClasseAttrazione(String classiAttrazioniRichiesta, int indice) {
		return "Classe d'attrazione all'indice " + indice;
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
		double r = Math.random();
		if(r<=0.05)
		 return "";
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