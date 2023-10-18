package dio.desafiopadroesprojeto.service.impl;

import dio.desafiopadroesprojeto.handler.BusinessException;
import dio.desafiopadroesprojeto.model.Chamado;
import dio.desafiopadroesprojeto.model.Cliente;
import dio.desafiopadroesprojeto.model.Endereco;
import dio.desafiopadroesprojeto.repository.ClienteRepository;
import dio.desafiopadroesprojeto.repository.EnderecoRepository;
import dio.desafiopadroesprojeto.service.ClienteService;
import dio.desafiopadroesprojeto.service.ViaCepService;
import dio.desafiopadroesprojeto.service.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClienteServiceImpl implements ClienteService {
		@Autowired
		private ClienteRepository clienteRepository;
		@Autowired
		private EnderecoRepository enderecoRepository;
		@Autowired
		private ViaCepService viaCepService;

		@Override
		public Iterable<Cliente> buscarTodos() {
				return clienteRepository.findAll();
		}

		@Override
		public Cliente buscarPorId(Long id) {
				Optional<Cliente> cliente = clienteRepository.findById(id);
				if (!cliente.isPresent())
						throw new BusinessException("Cliente não localizado.");
				return cliente.get();
		}

		@Override
		public void inserir(Cliente cliente) {
				salvarClienteComCep(cliente);
		}

		@Override
		public void atualizar(Long id, Cliente cliente) {
				Optional<Cliente> clienteBd = clienteRepository.findById(id);
				if (clienteBd.isPresent()) {
						salvarClienteComCep(cliente);
				}
		}

		@Override
		public void deletar(Long id) {
				clienteRepository.deleteById(id);
		}

		private void salvarClienteComCep(Cliente cliente) {
				// Vai verificar se o endereco do Cliente já existe (pelo CEP).
				String cep = cliente.getEndereco().getCep();
				Endereco endereco = enderecoRepository.findById(cep).orElseGet(() -> {
						Endereco novoEndereco = viaCepService.consultarCep(cep);
						enderecoRepository.save(novoEndereco);
						return novoEndereco;
				});
				cliente.setEndereco(endereco);
				clienteRepository.save(cliente);
		}
}
