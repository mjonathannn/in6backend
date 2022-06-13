package com.in6backend.services;

import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.in6backend.entities.Company;
import com.in6backend.repositories.CompanyRepository;

@Service
public class ActivationAccountService {

	@Autowired
	private JavaMailSender mailSender;

	@Autowired
	private CompanyRepository companyRepository;

	public void activate(Long id) {
		Company company = companyRepository.findById(id).orElse(null);
		company.setActivated(true);
		companyRepository.save(company);
	}

	public void activationEmailSended(Long id) {
		Company company = companyRepository.findById(id).orElse(null);
		company.setActivationEmailSended(true);
		companyRepository.save(company);
	}

	public boolean sendEmail(String to, Long companyId, String host) {
		String subject = "IN6 - Verificação de conta";
		String text;
		
		try {
			if (host.contains("localhost")) {
				text = "Este é o link para verificação da conta: <a href=\"http://" + host + "/activationPage/" + companyId
						+ "\"> VERIFICAR </a>";
			} else {
				text = "Este é o link para verificação da conta: <a href=\"https://" + host + "/activationPage/" + companyId
						+ "\"> VERIFICAR </a>";
			}

			MimeMessage mail = mailSender.createMimeMessage();
			MimeMessageHelper helper = new MimeMessageHelper(mail, true, "UTF-8");
			helper.setTo(to);
			helper.setSubject(subject);
			helper.setText(text, true);
			mailSender.send(mail);
			
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			
			return false;
		}
	}
}
