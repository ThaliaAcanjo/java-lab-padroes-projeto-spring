package dio.desafiopadroesprojeto.repository;

import dio.desafiopadroesprojeto.model.Cliente;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends CrudRepository<Cliente, Long> {

}