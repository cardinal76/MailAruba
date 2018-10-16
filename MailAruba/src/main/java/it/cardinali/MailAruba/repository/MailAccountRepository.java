package it.cardinali.MailAruba.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import it.cardinali.MailAruba.entity.Mailaccount;

public interface MailAccountRepository extends JpaRepository<Mailaccount, Long>{

}
