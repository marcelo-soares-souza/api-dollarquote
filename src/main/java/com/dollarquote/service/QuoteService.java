package com.dollarquote.service;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.core.Response;

import org.eclipse.microprofile.metrics.annotation.Counted;

import com.dollarquote.entity.BCB.Value;
import com.dollarquote.entity.Quote;

@ApplicationScoped
public class QuoteService {

	@Inject
	private BCBService bcbService;

	@Transactional
	@Counted(name = "requestQuote", description = "How many time Requested Quotes")
	public Response requestQuote(Date date) {
		Response response;
		Format formatter = new SimpleDateFormat("MM-dd-yyyy");
		List<Value> bcbQuote = bcbService.getQuote(formatter.format(date)).getValue();

		if (bcbQuote.size() > 0) {
			Double buyRate = bcbQuote.get(0).cotacaoCompra;
			Double sellRate = bcbQuote.get(0).cotacaoVenda;

			LocalDate localDate = Instant.ofEpochMilli(date.getTime()).atZone(ZoneId.systemDefault()).toLocalDate();
			LocalDateTime quoteDateTime = LocalDateTime.parse(bcbQuote.get(0).dataHoraCotacao,
					DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS"));
			LocalDateTime localDateTime = LocalDateTime.ofInstant(Instant.now(), ZoneOffset.UTC);

			Quote quote = new Quote(null, localDateTime, localDate, buyRate, sellRate, quoteDateTime);

			quote.persist();

			response = Response.ok(quote).status(200).build();

		} else {
			response = Response.ok("No Quote for this day.").status(200).build();

		}

		return response;
	}

}
