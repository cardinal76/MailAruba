package it.cardinali.MailAruba.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import it.cardinali.MailAruba.entity.Mail;

public interface MailRepository extends JpaRepository<Mail, Long>{

}
