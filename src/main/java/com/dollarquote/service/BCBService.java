package com.dollarquote.service;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.MediaType;

import com.dollarquote.entity.BCB;

@ApplicationScoped
public class BCBService {
	private Client client;

	public BCBService() {

	}

	public BCB getQuote(String date) {
		String url = "https://olinda.bcb.gov.br/olinda/servico/PTAX/versao/v1/odata/CotacaoDolarDia(dataCotacao=@dataCotacao)?@dataCotacao='"
				+ date + "'";

		client = ClientBuilder.newClient();

		return client.target(url).request(MediaType.APPLICATION_JSON).get(BCB.class);
	}
}