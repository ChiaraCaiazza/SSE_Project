class Test {
	
	public static void main(String[] args) {
		int conta = 0;
		
		String url = "http://localhost:8080/axis2/services/InterfacciaAttrazioniCoinFlip";
	
		String[] mess = new String[5];
		mess[0] = "<?xml version=\"1.0\" encoding=\"utf-8\" ?><soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:axis=\"http://ws.apache.org/axis2\"><soapenv:Header/><soapenv:Body><axis:ottieniListaAttrazioni> <axis:args0>indirizzo offerta</axis:args0>  </axis:ottieniListaAttrazioni></soapenv:Body></soapenv:Envelope>";	
		mess[1] = "<?xml version=\"1.0\" encoding=\"utf-8\" ?><soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:axis=\"http://ws.apache.org/axis2\"><soapenv:Header/><soapenv:Body><axis:suggerisciListaPropostaAttivita><axis:args0>Informazioni soggiorno</axis:args0><axis:args1>Classi</axis:args1></axis:suggerisciListaPropostaAttivita></soapenv:Body></soapenv:Envelope>";
		mess[2] = "<?xml version=\"1.0\" encoding=\"utf-8\" ?><soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:axis=\"http://ws.apache.org/axis2\"><soapenv:Header/><soapenv:Body><axis:visualizzaListaPropostaAttivita><axis:args0>AKL32D11</axis:args0></axis:visualizzaListaPropostaAttivita></soapenv:Body></soapenv:Envelope>";
		mess[3] = "<?xml version=\"1.0\" encoding=\"utf-8\" ?><soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:axis=\"http://ws.apache.org/axis2\"><soapenv:Header/><soapenv:Body><axis:aggiungiAlternative><axis:args0>Lista proposta attivita</axis:args0> <axis:args1>false</axis:args1> <axis:args1>false</axis:args1> <axis:args1>true</axis:args1> <axis:args1>false</axis:args1> </axis:aggiungiAlternative></soapenv:Body></soapenv:Envelope>";
		mess[4] = "<?xml version=\"1.0\" encoding=\"utf-8\" ?><soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:axis=\"http://ws.apache.org/axis2\"><soapenv:Header/><soapenv:Body><axis:rimuoviAlternative> <axis:args0>Lista proposta attivita</axis:args0> <axis:args1>true</axis:args1> <axis:args1>false</axis:args1> <axis:args1>false</axis:args1> <axis:args1>false</axis:args1> <axis:args1>true</axis:args1> <axis:args1>false</axis:args1> <axis:args1>false</axis:args1> <axis:args1>false</axis:args1> </axis:rimuoviAlternative></soapenv:Body></soapenv:Envelope>";
		
		try {
			for (int i=0; i<700; i++) {
				for (String s : mess) {
					String ret = SOAPClient.sendMess(url, s);
					if (ret.contains("Servizio non disponibile"))
						conta++;
				}
			}
		} catch (Exception e){}
		System.out.println("Disponibilità "+(double)(3500-conta)/3500*100+"%");
	}
	
}