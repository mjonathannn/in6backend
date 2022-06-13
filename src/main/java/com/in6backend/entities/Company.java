package com.in6backend.entities;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.in6backend.dto.CompanyDTOInput;

@Entity
@Table(name = "tb_company")
public class Company implements UserDetails {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String name;
	private String password;
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

	@ManyToOne
	@JoinColumn(name = "id_city")
	private City city;

	@OneToOne
	@JoinColumn(name = "id_business_sector")
	private BusinessSector businessSector;

	@OneToMany(mappedBy = "company")
	private List<Vacancy> vacancies = new ArrayList<>();

	public Company() {
		super();
	}

	public Company(Long id, String name, String password, String cnpj, String email, String phone, String about,
			boolean activated, boolean activationEmailSended, boolean desktopNotification, boolean firstVacancy,
			boolean emailNotification, boolean whatsappNotification, City city, BusinessSector businessSector,
			List<Vacancy> vacancies) {
		super();
		this.id = id;
		this.name = name;
		this.password = password;
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
		this.city = city;
		this.businessSector = businessSector;
		this.vacancies = vacancies;
	}

	public Company(CompanyDTOInput companyDTOInput) {
		id = companyDTOInput.getId();
		name = companyDTOInput.getName();
		password = companyDTOInput.getPassword();
		cnpj = "";
		email = companyDTOInput.getEmail();
		phone = companyDTOInput.getPhone();
		about = "";
		activated = false;
		activationEmailSended = false;
		desktopNotification = false;
		firstVacancy = true;
		emailNotification = false;
		whatsappNotification = false;
		city = new City(companyDTOInput.getCityDTO());
		businessSector = new BusinessSector(companyDTOInput.getBusinessSectorDTO());
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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

	public City getCity() {
		return city;
	}

	public void setCity(City city) {
		this.city = city;
	}

	public BusinessSector getBusinessSector() {
		return businessSector;
	}

	public void setBusinessSector(BusinessSector businessSector) {
		this.businessSector = businessSector;
	}

	public List<Vacancy> getVacancies() {
		return vacancies;
	}

	public void setVacancies(List<Vacancy> vacancies) {
		this.vacancies = vacancies;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return false;
	}
}