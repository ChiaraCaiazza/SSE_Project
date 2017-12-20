import java.lang.Math;
import java.util.Date;

public class Test {
	public static void main(String[] args) 
	{
		try{
			String url = "http://localhost:8080/axis2/services/InterfacciaRichiestaCasaCoinFlip";
		
			String ottieniRichiesteGestite = "<?xml version=\"1.0\" encoding=\"utf-8\"?><soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:axis=\"http://ws.apache.org/axis2\"><soapenv:Header/><soapenv:Body><axis:ottieniRichiesteGestite/></soapenv:Body></soapenv:Envelope>";
			String ottieniRichiesteNonGestite = "<?xml version=\"1.0\" encoding=\"utf-8\" ?><soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:axis=\"http://ws.apache.org/axis2\"><soapenv:Header/><soapenv:Body><axis:ottieniRichiesteNonGestite></axis:ottieniRichiesteNonGestite></soapenv:Body></soapenv:Envelope>";
			String ottieniRichiesta = "<?xml version=\"1.0\" encoding=\"utf-8\"?><soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:axis=\"http://ws.apache.org/axis2\"><soapenv:Header/><soapenv:Body><axis:ottieniRichiesta><axis:args0>56rh83</axis:args0><axis:args1>Stoccolma</axis:args1><axis:args2>Svezia</axis:args2><axis:args3>2017-09-23</axis:args3><axis:args4>2018-11-02</axis:args4></axis:ottieniRichiesta></soapenv:Body></soapenv:Envelope>";
			String gestisciRichiesta = "<?xml version=\"1.0\" encoding=\"utf-8\" ?><soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:axis=\"http://ws.apache.org/axis2\"><soapenv:Header/><soapenv:Body><axis:gestisciRichiesta><axis:args0>richiesta</axis:args0></axis:gestisciRichiesta></soapenv:Body></soapenv:Envelope>";
			String creaProposta = "<?xml version=\"1.0\" encoding=\"utf-8\"?><soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:axis=\"http://ws.apache.org/axis2\"><soapenv:Header/><soapenv:Body><axis:creaProposta><axis:args0>uj37hd</axis:args0><axis:args1>indirizzo</axis:args1><axis:args2>2017-01-01</axis:args2><axis:args3>2018-01-01</axis:args3></axis:creaProposta></soapenv:Body></soapenv:Envelope>";
			String modificaProposta = "<?xml version=\"1.0\" encoding=\"utf-8\"?><soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:axis=\"http://ws.apache.org/axis2\"><soapenv:Header/><soapenv:Body><axis:modificaProposta><axis:args0>proposta</axis:args0></axis:modificaProposta></soapenv:Body></soapenv:Envelope>";
			String ottieniProposta = "<?xml version=\"1.0\" encoding=\"utf-8\"?><soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:axis=\"http://ws.apache.org/axis2\"><soapenv:Header/><soapenv:Body><axis:ottieniProposta><axis:args0>56rh83</axis:args0><axis:args1>indirizzo</axis:args1><axis:args2>2017-01-01</axis:args2><axis:args3>2018-01-01</axis:args3></axis:ottieniProposta></soapenv:Body></soapenv:Envelope>";
		
			int servizioNonDisp = 0;

			String risposta;
			CharSequence noDisp = "Servizio non disponibile";
			for (int i = 0; i < 500; i++)
			{
				
				risposta = SOAPClient.sendMess(url, ottieniRichiesteGestite);
				if(risposta.contains(noDisp)) servizioNonDisp++;
				risposta = SOAPClient.sendMess(url, ottieniRichiesteNonGestite);
				if(risposta.contains(noDisp)) servizioNonDisp++;
				risposta = SOAPClient.sendMess(url, ottieniRichiesta);
				if(risposta.contains(noDisp)) servizioNonDisp++;
				risposta = SOAPClient.sendMess(url, gestisciRichiesta);
				if(risposta.contains(noDisp)) servizioNonDisp++;
				risposta = SOAPClient.sendMess(url, creaProposta);
				if(risposta.contains(noDisp)) servizioNonDisp++;
				risposta = SOAPClient.sendMess(url, modificaProposta);
				if(risposta.contains(noDisp)) servizioNonDisp++;
				risposta = SOAPClient.sendMess(url, ottieniProposta);
				if(risposta.contains(noDisp)) servizioNonDisp++;
			}
			
			double disponibilita = (1.0 - ((double)servizioNonDisp / 3500.0)) * 100.0;
			System.out.println("La disponibilità complessiva e': " + disponibilita);
		}catch(Exception e){System.out.println("Eccezione\n");}
	}
}