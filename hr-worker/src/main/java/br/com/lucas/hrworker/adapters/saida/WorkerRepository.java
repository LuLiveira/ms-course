package br.com.lucas.hrworker.adapters.saida;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.lucas.hrworker.entities.Worker;

public interface WorkerRepository extends JpaRepository<Worker, Long> {

}
