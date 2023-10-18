package dio.desafiopadroesprojeto.service;

import dio.desafiopadroesprojeto.model.Chamado;

public interface ChamadoService {
		Iterable<Chamado> buscarTodos();

		Chamado buscarPorId(Long id);

		void inserir(Chamado chamado);

		void atualizar(Long id, Chamado chamado);

		void deletar(Long id);
}
