package dio.desafiopadroesprojeto.service.impl;

import dio.desafiopadroesprojeto.handler.BusinessException;
import dio.desafiopadroesprojeto.model.Chamado;
import dio.desafiopadroesprojeto.model.Cliente;
import dio.desafiopadroesprojeto.repository.ChamadoRepository;
import dio.desafiopadroesprojeto.repository.ClienteRepository;
import dio.desafiopadroesprojeto.service.ChamadoService;
import dio.desafiopadroesprojeto.service.ClienteService;
import dio.desafiopadroesprojeto.service.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ChamadoServiceImpl implements ChamadoService {
		@Autowired
		private ChamadoRepository chamadoRepository;

		@Autowired
		private ClienteRepository clienteRepository;
		@Autowired
		private ClienteService clienteService;
		@Override
		public Iterable<Chamado> buscarTodos() {
				return chamadoRepository.findAll();
		}

		@Override
		public Chamado buscarPorId(Long id) {
				Optional<Chamado> chamado = chamadoRepository.findById(id);
				if (!chamado.isPresent())
						throw new BusinessException("Chamado não localizado.");
				return chamado.get();
		}

		@Override
		public void inserir(Chamado chamado) {
				Optional<Cliente> cliente = clienteRepository.findById(chamado.getCliente().getId());
				if (!cliente.isPresent())
						throw new BusinessException("Cliente não localizado.");

				chamado.setCliente(cliente.get());
				chamadoRepository.save(chamado);
		}

		@Override
		public void atualizar(Long id, Chamado chamado) {
				Optional<Chamado> chamadoUp = chamadoRepository.findById(id);
				if (chamadoUp.isPresent()){
						chamadoRepository.save(chamado);
				}
		}

		@Override
		public void deletar(Long id) {
				chamadoRepository.deleteById(id);
		}
}
