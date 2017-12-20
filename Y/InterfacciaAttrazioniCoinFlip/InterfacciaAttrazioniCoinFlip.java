import java.util.regex.Pattern;
import java.util.Arrays;

public class InterfacciaAttrazioniCoinFlip {

	double disponibilita = 0.001;

	public String ottieniListaAttrazioni(String aIndirizzo) {
		if (aIndirizzo.equals(""))
			return "Indirizzo non specificato";
		double r = Math.random();
		if (r <= disponibilita)
			return "Servizio non disponibile";
		return "Lista di attrazioni ordinata per distanza";
	}

	public String suggerisciListaPropostaAttivita(String aInformazioni, String aClassiAttrazioni) {
		if (aInformazioni.equals("")) 
			return "Informazioni soggiorno non specificate";
		if (aClassiAttrazioni.equals(""))
			return "Classi d'attrazioni non specificate";
		double r = Math.random();
		if (r <= disponibilita)
			return "Servizio non disponibile";
		return "Riferimento alla lista proposta attivita generata";
	}

	public String visualizzaListaPropostaAttivita(String aPropostaID) {
		if (aPropostaID.equals("")) 
			return "ID non specificato";
		if (!Pattern.matches("[A-Z0-9]*", aPropostaID))
			return "ID non valido";
		double r = Math.random();
		if (r <= disponibilita)
			return "Servizio non disponibile";
		return "Lista proposta attivita";
	}

	public String aggiungiAlternative(String aListaPropostaAttivita, boolean[] aInQualiProposteAggiungere) {
		if (aListaPropostaAttivita.equals("")) 
			return "Lista proposta attivita non specificata";
		if (aInQualiProposteAggiungere.length==0)
			return "Dove aggiungere non specificato";
		double r = Math.random();
		if (r <= disponibilita)
			return "Servizio non disponibile";
		return "Lista proposta attivita modificata";
	}

	public String rimuoviAlternative(String aListaPropostaAttivita, boolean[] aAlternativeDaRimuovere) {
		if (aListaPropostaAttivita.equals("")) 
			return "Lista proposta attivita non specificata";
		if (aAlternativeDaRimuovere.length==0)
			return "Cosa rimuovere non specificato";
		double r = Math.random();
		if (r <= disponibilita)
			return "Servizio non disponibile";
		return "Lista proposta attivita modificata";
	}
}