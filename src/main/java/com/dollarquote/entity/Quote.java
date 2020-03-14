package com.dollarquote.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

@Entity
@Table( name = "tb_quote" )
public class Quote extends PanacheEntityBase {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private LocalDateTime requisitiontimestamp;

    @Column
    private LocalDate quotedate;

    @Column
    private Double buyrate; 

    @Column
    private Double sellrate;

    @Column
    private LocalDateTime quotedatetime;
    
    public Quote() {
    	
    }

	public Quote(Long id, LocalDateTime requisitiontimestamp, LocalDate quotedate, Double buyrate, Double sellrate,
			LocalDateTime quotedatetime) {
		this.id = id;
		this.requisitiontimestamp = requisitiontimestamp;
		this.quotedate = quotedate;
		this.buyrate = buyrate;
		this.sellrate = sellrate;
		this.quotedatetime = quotedatetime;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDateTime getRequisitiontimestamp() {
		return requisitiontimestamp;
	}

	public void setRequisitiontimestamp(LocalDateTime requisitiontimestamp) {
		this.requisitiontimestamp = requisitiontimestamp;
	}

	public LocalDate getQuotedate() {
		return quotedate;
	}

	public void setQuotedate(LocalDate quotedate) {
		this.quotedate = quotedate;
	}

	public Double getBuyrate() {
		return buyrate;
	}

	public void setBuyrate(Double buyrate) {
		this.buyrate = buyrate;
	}

	public Double getSellrate() {
		return sellrate;
	}

	public void setSellrate(Double sellrate) {
		this.sellrate = sellrate;
	}

	public LocalDateTime getQuotedatetime() {
		return quotedatetime;
	}

	public void setQuotedatetime(LocalDateTime quotedatetime) {
		this.quotedatetime = quotedatetime;
	}
}
