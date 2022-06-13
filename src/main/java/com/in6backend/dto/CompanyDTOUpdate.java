package com.in6backend.dto;

import java.io.Serializable;

public class CompanyDTOUpdate implements Serializable {
	private static final long serialVersionUID = 1L;

	private String name;
	private String cnpj;
	private String email;
	private String phone;
	private String about;
	private boolean desktopNotifications;
	private boolean emailNotifications;
	private boolean whatsappNotifications;
	private CityDTO cityDTO;
	private BusinessSectorDTO businessSectorDTO;

	public CompanyDTOUpdate() {
		super();
	}

	public CompanyDTOUpdate(String name, String cnpj, String email, String phone, String about,
			boolean desktopNotifications, boolean emailNotifications, boolean whatsappNotifications, CityDTO cityDTO,
			BusinessSectorDTO businessSectorDTO) {
		super();
		this.name = name;
		this.cnpj = cnpj;
		this.email = email;
		this.phone = phone;
		this.about = about;
		this.desktopNotifications = desktopNotifications;
		this.emailNotifications = emailNotifications;
		this.whatsappNotifications = whatsappNotifications;
		this.cityDTO = cityDTO;
		this.businessSectorDTO = businessSectorDTO;
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

	public boolean isDesktopNotifications() {
		return desktopNotifications;
	}

	public void setDesktopNotifications(boolean desktopNotifications) {
		this.desktopNotifications = desktopNotifications;
	}

	public boolean isEmailNotifications() {
		return emailNotifications;
	}

	public void setEmailNotifications(boolean emailNotifications) {
		this.emailNotifications = emailNotifications;
	}

	public boolean isWhatsappNotifications() {
		return whatsappNotifications;
	}

	public void setWhatsappNotifications(boolean whatsappNotifications) {
		this.whatsappNotifications = whatsappNotifications;
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
