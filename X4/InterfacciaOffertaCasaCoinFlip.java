public class InterfacciaOffertaCasaCoinFlip {

	public String ricercaOfferte(String aIndirizzo, String aLimitazioni, String aTrasporto, String aDescrizioneComposizioneCasa) {
		if ((Math.random())<=0.001)
			return "Servizio non disponibile";
		
		if (aIndirizzo.equals(""))
			return "Parametri errati: indirizzo non specificato";
		if (aLimitazioni.equals(""))
			return "Parametri errati: limitazioni non specificate";
		if (aTrasporto.equals(""))
			return "Parametri errati: informazioni di trasporto non specificate";
		if (aDescrizioneComposizioneCasa.equals(""))
			return "Parametri errati: Descrizione della casa non specificata";
		
	
		return "Lista di offerte pertinenti con i parametri di ricerca.";
	}

	public String pubblicaPropostaScambio(String aOfferta, String aContattiRichiedente) {
		if ((Math.random()) <= 0.001)
			return "Servizio non disponibile";
		
		if (aContattiRichiedente.equals(""))
			return "Parametri errati: contatti del richiedente errati";
		
		if (aOfferta.equals(""))
			return "Parametri errati: errore nell'offerta";
		
		return "La proposta e' stata effettuata con successo.";
	}
}