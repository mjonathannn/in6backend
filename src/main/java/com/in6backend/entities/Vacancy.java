package com.in6backend.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.in6backend.dto.VacancyDTOInput;
import com.in6backend.enumerator.VacancyStatusEnum;

@Entity
@Table(name = "tb_vacancy")
public class Vacancy {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String name;
	private boolean immediateHiring;
	private boolean needExperience;
	private boolean disabledPeople;
	private boolean forStudents;
	private VacancyStatusEnum vacancyStatus;
	private String dateOfActivation;
	private String workSchedule;
	private String salary;
	private boolean salaryToNegotiate;

	@Column(length = 3000)
	private String description;

	@Column(length = 3000)
	private String benefits;

	@ManyToOne
	@JoinColumn(name = "id_type_job")
	private TypeJob typeJob;

	@ManyToOne
	@JoinColumn(name = "id_type_of_workload")
	private TypeOfWorkload typeOfWorkload;

	@ManyToOne
	@JoinColumn(name = "id_type_of_pay")
	private TypeOfPay typeOfPay;

	@ManyToOne
	@JoinColumn(name = "id_city")
	private City city;

	@ManyToOne
	@JoinColumn(name = "id_company")
	private Company company;

	public Vacancy() {
		super();
	}

	public Vacancy(Long id, String name, boolean immediateHiring, boolean needExperience, boolean disabledPeople,
			boolean forStudents, VacancyStatusEnum vacancyStatus, String dateOfActivation, String workSchedule,
			String salary, boolean salaryToNegotiate, String description, String benefits, TypeJob typeJob,
			TypeOfWorkload typeOfWorkload, TypeOfPay typeOfPay, City city, Company company) {
		super();
		this.id = id;
		this.name = name;
		this.immediateHiring = immediateHiring;
		this.needExperience = needExperience;
		this.disabledPeople = disabledPeople;
		this.forStudents = forStudents;
		this.vacancyStatus = vacancyStatus;
		this.dateOfActivation = dateOfActivation;
		this.workSchedule = workSchedule;
		this.salary = salary;
		this.salaryToNegotiate = salaryToNegotiate;
		this.description = description;
		this.benefits = benefits;
		this.typeJob = typeJob;
		this.typeOfWorkload = typeOfWorkload;
		this.typeOfPay = typeOfPay;
		this.city = city;
		this.company = company;
	}

	public Vacancy(VacancyDTOInput vacancyDTOInput) {
		name = vacancyDTOInput.getName();
		immediateHiring = vacancyDTOInput.isImmediateHiring();
		needExperience = vacancyDTOInput.isNeedExperience();
		disabledPeople = vacancyDTOInput.isDisabledPeople();
		forStudents = vacancyDTOInput.isForStudents();
		workSchedule = vacancyDTOInput.getWorkSchedule();
		salary = vacancyDTOInput.getSalary();
		salaryToNegotiate = vacancyDTOInput.isSalaryToNegotiate();
		description = vacancyDTOInput.getDescription();
		benefits = vacancyDTOInput.getBenefits();
		typeJob = new TypeJob(vacancyDTOInput.getTypeJobDTO());
		typeOfWorkload = new TypeOfWorkload(vacancyDTOInput.getTypeOfWorkloadDTO());
		typeOfPay = new TypeOfPay(vacancyDTOInput.getTypeOfPayDTO());
		city = new City(vacancyDTOInput.getCityDTO());
		company = new Company(vacancyDTOInput.getCompanyDTOInput());
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

	public boolean isImmediateHiring() {
		return immediateHiring;
	}

	public void setImmediateHiring(boolean immediateHiring) {
		this.immediateHiring = immediateHiring;
	}

	public boolean isNeedExperience() {
		return needExperience;
	}

	public void setNeedExperience(boolean needExperience) {
		this.needExperience = needExperience;
	}

	public boolean isDisabledPeople() {
		return disabledPeople;
	}

	public void setDisabledPeople(boolean disabledPeople) {
		this.disabledPeople = disabledPeople;
	}

	public boolean isForStudents() {
		return forStudents;
	}

	public void setForStudents(boolean forStudents) {
		this.forStudents = forStudents;
	}

	public VacancyStatusEnum getVacancyStatus() {
		return vacancyStatus;
	}

	public void setVacancyStatus(VacancyStatusEnum vacancyStatus) {
		this.vacancyStatus = vacancyStatus;
	}

	public String getDateOfActivation() {
		return dateOfActivation;
	}

	public void setDateOfActivation(String dateOfActivation) {
		this.dateOfActivation = dateOfActivation;
	}

	public String getWorkSchedule() {
		return workSchedule;
	}

	public void setWorkSchedule(String workSchedule) {
		this.workSchedule = workSchedule;
	}

	public String getSalary() {
		return salary;
	}

	public void setSalary(String salary) {
		this.salary = salary;
	}

	public boolean isSalaryToNegotiate() {
		return salaryToNegotiate;
	}

	public void setSalaryToNegotiate(boolean salaryToNegotiate) {
		this.salaryToNegotiate = salaryToNegotiate;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getBenefits() {
		return benefits;
	}

	public void setBenefits(String benefits) {
		this.benefits = benefits;
	}

	public TypeJob getTypeJob() {
		return typeJob;
	}

	public void setTypeJob(TypeJob typeJob) {
		this.typeJob = typeJob;
	}

	public TypeOfWorkload getTypeOfWorkload() {
		return typeOfWorkload;
	}

	public void setTypeOfWorkload(TypeOfWorkload typeOfWorkload) {
		this.typeOfWorkload = typeOfWorkload;
	}

	public TypeOfPay getTypeOfPay() {
		return typeOfPay;
	}

	public void setTypeOfPay(TypeOfPay typeOfPay) {
		this.typeOfPay = typeOfPay;
	}

	public City getCity() {
		return city;
	}

	public void setCity(City city) {
		this.city = city;
	}

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}
}