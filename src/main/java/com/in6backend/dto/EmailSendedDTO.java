package com.in6backend.dto;

import java.io.Serializable;

import com.in6backend.entities.Company;

public class EmailSendedDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long id;
	private boolean emailSended;

	public EmailSendedDTO() {
		super();
	}

	public EmailSendedDTO(Long id, boolean emailSended) {
		super();
		this.id = id;
		this.emailSended = emailSended;
	}
	
	public EmailSendedDTO(Company company) {
		super();
		this.id = company.getId();
		this.emailSended = company.isActivationEmailSended();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public boolean isEmailSended() {
		return emailSended;
	}

	public void setEmailSended(boolean emailSended) {
		this.emailSended = emailSended;
	}
}
