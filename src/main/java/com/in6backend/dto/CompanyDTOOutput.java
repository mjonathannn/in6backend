package com.in6backend.dto;

import java.io.Serializable;

import com.in6backend.entities.Company;

public class CompanyDTOOutput implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long id;
	private String name;
	private String cnpj;
	private String email;
	private String phone;
	private String about;
	private boolean activated;
	private boolean activationEmailSended;
	private boolean desktopNotification;
	private boolean firstVacancy;
	private boolean emailNotification;
	private boolean whatsappNotification;
	private CityDTO cityDTO;
	private BusinessSectorDTO businessSectorDTO;

	public CompanyDTOOutput() {
		super();
	}

	public CompanyDTOOutput(Long id, String name, String cnpj, String email, String phone, String about,
			boolean activated, boolean activationEmailSended, boolean desktopNotification, boolean firstVacancy,
			boolean emailNotification, boolean whatsappNotification, CityDTO cityDTO,
			BusinessSectorDTO businessSectorDTO) {
		super();
		this.id = id;
		this.name = name;
		this.cnpj = cnpj;
		this.email = email;
		this.phone = phone;
		this.about = about;
		this.activated = activated;
		this.activationEmailSended = activationEmailSended;
		this.desktopNotification = desktopNotification;
		this.firstVacancy = firstVacancy;
		this.emailNotification = emailNotification;
		this.whatsappNotification = whatsappNotification;
		this.cityDTO = cityDTO;
		this.businessSectorDTO = businessSectorDTO;
	}

	public CompanyDTOOutput(Company company) {
		id = company.getId();
		name = company.getName();
		cnpj = company.getCnpj();
		email = company.getEmail();
		phone = company.getPhone();
		about = company.getAbout();
		activated = company.isActivated();
		activationEmailSended = company.isActivationEmailSended();
		desktopNotification = company.isDesktopNotification();
		firstVacancy = company.isFirstVacancy();
		emailNotification = company.isEmailNotification();
		whatsappNotification = company.isWhatsappNotification();
		cityDTO = new CityDTO(company.getCity());
		businessSectorDTO = new BusinessSectorDTO(company.getBusinessSector());
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAbout() {
		return about;
	}

	public void setAbout(String about) {
		this.about = about;
	}

	public boolean isActivated() {
		return activated;
	}

	public void setActivated(boolean activated) {
		this.activated = activated;
	}

	public boolean isActivationEmailSended() {
		return activationEmailSended;
	}

	public void setActivationEmailSended(boolean activationEmailSended) {
		this.activationEmailSended = activationEmailSended;
	}

	public boolean isDesktopNotification() {
		return desktopNotification;
	}

	public void setDesktopNotification(boolean desktopNotification) {
		this.desktopNotification = desktopNotification;
	}

	public boolean isFirstVacancy() {
		return firstVacancy;
	}

	public void setFirstVacancy(boolean firstVacancy) {
		this.firstVacancy = firstVacancy;
	}

	public boolean isEmailNotification() {
		return emailNotification;
	}

	public void setEmailNotification(boolean emailNotification) {
		this.emailNotification = emailNotification;
	}

	public boolean isWhatsappNotification() {
		return whatsappNotification;
	}

	public void setWhatsappNotification(boolean whatsappNotification) {
		this.whatsappNotification = whatsappNotification;
	}

	public CityDTO getCityDTO() {
		return cityDTO;
	}

	public void setCityDTO(CityDTO cityDTO) {
		this.cityDTO = cityDTO;
	}

	public BusinessSectorDTO getBusinessSectorDTO() {
		return businessSectorDTO;
	}

	public void setBusinessSectorDTO(BusinessSectorDTO businessSectorDTO) {
		this.businessSectorDTO = businessSectorDTO;
	}
}
