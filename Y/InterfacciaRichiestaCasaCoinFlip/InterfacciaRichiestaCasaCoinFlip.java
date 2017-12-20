import java.util.Date;
import java.util.regex.Pattern;
import java.lang.Math;

public class InterfacciaRichiestaCasaCoinFlip {

	public String ottieniRichiesteNonGestite() {
		if(Math.random() <= 0.001) return "Servizio non disponibile";
		
		return "Richieste non gestite";
	}

	public String ottieniRichiesteGestite() {
		double coin = Math.random();
		if(coin <= 0.001) return "Servizio non disponibile";
		
		return "Richieste gestite dall'agente";
	}

	public String ottieniRichiesta(String aRichiedenteID, String aCitta, String aStato, Date aInizio, Date aFine) {
		if(Math.random() <= 0.001) return "Servizio non disponibile";
		
		if(aRichiedenteID.length() == 0) return "Richiedente non specificato";
		if(aCitta.length() == 0) return "Città non specificata";
		if(aStato.length() == 0) return "Stato non specificato";
		if(aInizio == null) return "Data d'inizio non specificata";
		if(aFine == null) return "Data di fine non specificata";
		
		
		if(!Pattern.matches("[0-9A-Za-z]{6}", aRichiedenteID)) return "L'ID richiedente non è di 6 caratteri alfanumerici";
		if(aInizio.after(aFine)) return "Il periodo di condivisione è errato.";
		return "Richiesta";
	}

	public String gestisciRichiesta(String aRichiesta) {
		if(Math.random() <= 0.001) return "Servizio non disponibile";
		
		if(aRichiesta.length() == 0) return "Richiesta non specificata";
		if(Math.random() < 0.05) return "false";
		return "true";
	}

	public String creaProposta(String aRichiedenteID, String aDestinazione, Date aInizio, Date aFine) {
		if(Math.random() <= 0.001) return "Servizio non disponibile";
		
		if(aRichiedenteID.length() == 0) return "Richiedente non specificato";
		if(aDestinazione.length() == 0) return "Destinazione non specificata";
		if(aInizio == null) return "Data d'inizio non specificata";
		if(aFine == null) return "Data di fine non specificata";
		
		if(!Pattern.matches("[0-9A-Za-z]{6}", aRichiedenteID)) return "L'ID richiedente non è di 6 caratteri alfanumerici";
		if(aInizio.after(aFine)) return "Il periodo di condivisione è errato.";
		return "Nuova proposta";
	}

	public String ottieniProposta(String aRichiedenteID, String aDestinazione, Date aInizio, Date aFine) {
		if(Math.random() <= 0.001) return "Servizio non disponibile";
		
		if(aRichiedenteID.length() == 0) return "Richiedente non specificato";
		if(aDestinazione.length() == 0) return "Destinazione non specificata";
		if(aInizio == null) return "Data d'inizio non specificata";
		if(aFine == null) return "Data di fine non specificata";
		
		if(!Pattern.matches("[0-9A-Za-z]{6}", aRichiedenteID)) return "L'ID richiedente non è di 6 caratteri alfanumerici";
		if(aInizio.after(aFine)) return "Il periodo di condivisione è errato.";
		return "Proposta";
	}

	public String modificaProposta(String aProposta) {
		if(Math.random() <= 0.001) return "Servizio non disponibile";
		
		if(aProposta.length() == 0) return "Proposta non specificata";
		return "Proposta modificata";
	}
}