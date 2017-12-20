import java.lang.Math;

public class Test {

	public static void main(String[] args) {
		try{
		
			int contatore = 0;
			String risultato;
		
			String url = "http://localhost:8080/axis2/services/InterfacciaServiziAccessoriCoinFlip";
			
			String[] messaggio = new String[2];
			
			messaggio[0] = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:axis=\"http://ws.apache.org/axis2\"><soapenv:Header/><soapenv:Body><axis:creaPianificazione><axis:args0>pianificazione</axis:args0></axis:creaPianificazione></soapenv:Body></soapenv:Envelope>";

			messaggio[1] = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:axis=\"http://ws.apache.org/axis2\"><soapenv:Header/><soapenv:Body><axis:ottieniRiferimentoServiziAccessori><axis:args0>cavour</axis:args0></axis:ottieniRiferimentoServiziAccessori></soapenv:Body></soapenv:Envelope>";
			
			
			
			for(int i=0; i<2; i++)
			{
				for(int j=0; j<1750; j++)
				{
					risultato = SOAPClient.sendMess(url,messaggio[i]);
					if (risultato.contains("Servizio non disponibile"))
						contatore++;
				}
			}
			System.out.println("Disponibilità:" +(double)((3500 - contatore)*100)/3500 + "% \n");
			
			
		} catch(Exception e) {System.out.println("Eccezione\n");}
	}
}