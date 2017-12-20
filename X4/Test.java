import java.lang.Math;

public class Test {
	public static void main(String[] args) {
		String listaOfferte, esitoPropostaScambio;
		double k = 0.00;
		double totale = 0.00;
		double availability = 0.00;
		
		try {
			
			String url = "http://localhost:8080/axis2/services/InterfacciaOffertaCasaCoinFlip";
			
			String ricercaOfferte = "<?xml version=\"1.0\" encoding=\"utf-8\" ?><soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:axis=\"http://ws.apache.org/axis2\"><soapenv:Header/><soapenv:Body><axis:ricercaOfferte> <axis:args0>indirizzo richiesta </axis:args0> <axis:args1>limitazioni richiesta </axis:args1> <axis:args2>trasporto richiesta </axis:args2> <axis:args3>descrizione richiesta </axis:args3> </axis:ricercaOfferte></soapenv:Body></soapenv:Envelope>";
			
			String pubblicaPropostaScambio = "<?xml version=\"1.0\" encoding=\"utf-8\"?><soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:axis=\"http://ws.apache.org/axis2\"><soapenv:Header/><soapenv:Body><axis:pubblicaPropostaScambio><axis:args0>offerta</axis:args0><axis:args1>contattiRichiedente</axis:args1></axis:pubblicaPropostaScambio></soapenv:Body></soapenv:Envelope>";
			
			for (int i = 0; i<1750; i++){
				listaOfferte = SOAPClient.sendMess(url, ricercaOfferte);
				if (listaOfferte.contains("Servizio non disponibile"))
					k++;
			}
			
			availability = (double)(1-(k/1750))*100.0;
			System.out.println("Availability ricercaOfferte():\t" + availability + "%\n");
			
			totale += k;
			k = 0.00;
			for (int i = 0; i<1750; i++){
				esitoPropostaScambio = SOAPClient.sendMess(url, pubblicaPropostaScambio);
			
				if (esitoPropostaScambio.contains("Servizio non disponibile"))
					k++;
			}
			
			availability = (double)(1-(k/1750))*100.0;
			System.out.println("Availability pubblicaPropostaScambio():\t" + availability + "%\n");
			
			totale += k;
			availability = (double)(1-(totale/3500))*100.0;
			System.out.println("Availability di OffertaCasa:\t" + availability + "%\n");
		
		} catch(Exception e) {System.out.println("Eccezione\n");}
	}
}