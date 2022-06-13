package com.in6backend.dto;

import java.io.Serializable;

import com.in6backend.entities.Vacancy;
import com.in6backend.enumerator.VacancyStatusEnum;

public class VacancyDTOOutput implements Serializable {
	private static final long serialVersionUID = 1L;

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
	private String description;
	private String benefits;
	private TypeJobDTO typeJobDTO;
	private TypeOfWorkloadDTO typeOfWorkloadDTO;
	private TypeOfPayDTO typeOfPayDTO;
	private CityDTO cityDTO;
	private CompanyDTOOutput companyDTOOutput;

	public VacancyDTOOutput() {
		super();
	}

	public VacancyDTOOutput(Long id, String name, boolean immediateHiring, boolean needExperience,
			boolean disabledPeople, boolean forStudents, VacancyStatusEnum vacancyStatus, String dateOfActivation,
			String workSchedule, String salary, boolean salaryToNegotiate, String description, String benefits,
			TypeJobDTO typeJobDTO, TypeOfWorkloadDTO typeOfWorkloadDTO, TypeOfPayDTO typeOfPayDTO, CityDTO cityDTO,
			CompanyDTOOutput companyDTOOutput) {
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
		this.typeJobDTO = typeJobDTO;
		this.typeOfWorkloadDTO = typeOfWorkloadDTO;
		this.typeOfPayDTO = typeOfPayDTO;
		this.cityDTO = cityDTO;
		this.companyDTOOutput = companyDTOOutput;
	}

	public VacancyDTOOutput(Vacancy vacancy) {
		id = vacancy.getId();
		name = vacancy.getName();
		immediateHiring = vacancy.isImmediateHiring();
		needExperience = vacancy.isNeedExperience();
		disabledPeople = vacancy.isDisabledPeople();
		forStudents = vacancy.isForStudents();
		vacancyStatus = vacancy.getVacancyStatus();
		dateOfActivation = vacancy.getDateOfActivation();
		workSchedule = vacancy.getWorkSchedule();
		salary = vacancy.getSalary();
		salaryToNegotiate = vacancy.isSalaryToNegotiate();
		description = vacancy.getDescription();
		benefits = vacancy.getBenefits();
		typeJobDTO = new TypeJobDTO(vacancy.getTypeJob());
		typeOfWorkloadDTO = new TypeOfWorkloadDTO(vacancy.getTypeOfWorkload());
		typeOfPayDTO = new TypeOfPayDTO(vacancy.getTypeOfPay());
		cityDTO = new CityDTO(vacancy.getCity());
		companyDTOOutput = new CompanyDTOOutput(vacancy.getCompany());
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

	public TypeJobDTO getTypeJobDTO() {
		return typeJobDTO;
	}

	public void setTypeJobDTO(TypeJobDTO typeJobDTO) {
		this.typeJobDTO = typeJobDTO;
	}

	public TypeOfWorkloadDTO getTypeOfWorkloadDTO() {
		return typeOfWorkloadDTO;
	}

	public void setTypeOfWorkloadDTO(TypeOfWorkloadDTO typeOfWorkloadDTO) {
		this.typeOfWorkloadDTO = typeOfWorkloadDTO;
	}

	public TypeOfPayDTO getTypeOfPayDTO() {
		return typeOfPayDTO;
	}

	public void setTypeOfPayDTO(TypeOfPayDTO typeOfPayDTO) {
		this.typeOfPayDTO = typeOfPayDTO;
	}

	public CityDTO getCityDTO() {
		return cityDTO;
	}

	public void setCityDTO(CityDTO cityDTO) {
		this.cityDTO = cityDTO;
	}

	public CompanyDTOOutput getCompanyDTOOutput() {
		return companyDTOOutput;
	}

	public void setCompanyDTOOutput(CompanyDTOOutput companyDTOOutput) {
		this.companyDTOOutput = companyDTOOutput;
	}
}