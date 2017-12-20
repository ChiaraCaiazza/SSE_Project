
public class InterfacciaAttrazioni {

	public String ottieniListaAttrazioni(String aIndirizzo) {
		return "Lista di attrazioni ordinata per distanza";
	}

	public String suggerisciListaPropostaAttivita(String aInformazioni, String aClassiAttrazioni) {
		return "Riferimento alla lista proposta attivita generata";
	}

	public String visualizzaListaPropostaAttivita(String aPropostaID) {
		return "Lista proposta attivita";
	}

	public String aggiungiAlternative(String aListaPropostaAttivita, boolean[] aInQualiProposteAggiungere) {
		return "Lista proposta attivita modificata";
	}

	public String rimuoviAlternative(String aListaPropostaAttivita, boolean[] aAlternativeDaRimuovere) {
		return "Lista proposta attivita modificata";
	}
}