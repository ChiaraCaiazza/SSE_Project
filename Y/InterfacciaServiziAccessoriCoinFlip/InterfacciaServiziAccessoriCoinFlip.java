import java.lang.Math;

public class InterfacciaServiziAccessoriCoinFlip {

	double disponibilita = 0.001;				//disponibilità 99.9%

	public String ottieniRiferimentoServiziAccessori(String aIndirizzo) 
	{
		
		if (aIndirizzo.equals(""))
			return "Indirizzo sbagliato";
	
		double r = Math.random();
		
		if( r <= disponibilita) 
			return "Servizio non disponibile";	
		
		
		
		return "Riferimento ai servizi accessori";
	}

	public String creaPianificazione(String aFasceOrarie) 
	{
	
		if (aFasceOrarie.equals(""))
			return "Fascia oraria non inserita";
	
		double r = Math.random();
		if( r <= disponibilita) 
			return "Servizio non disponibile";
		
		
	
		return "Pianificazione";
	} 

}
