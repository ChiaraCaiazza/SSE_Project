import java.lang.Math;
import java.util.Date;

public class InterfacciaRichiestaCasa {

	public String ottieniRichiesteNonGestite() {
		return "Richieste non gestite";
	}

	public String ottieniRichiesteGestite() {
		return "Richieste gestite dall'agente";
	}

	public String ottieniRichiesta(String aRichiedenteID, String aCitta, String aStato, Date aInizio, Date aFine) {
		return "Richiesta";
	}

	public boolean gestisciRichiesta(String aRichiesta) {
		boolean result = (Math.random() < 0.05)? false : true;
		return result;
	}

	public String creaProposta(String aRichiedenteID, String aDestinazione, Date aInizio, Date aFine) {
		return "Nuova proposta";
	}

	public String ottieniProposta(String aRichiedenteID, String aDestinazione, Date aInizio, Date aFine) {
		return "Proposta";
	}

	public String modificaProposta(String aProposta) {
		return "Proposta modificata";
	}
}