package dio.desafiopadroesprojeto.controller;

import dio.desafiopadroesprojeto.model.Chamado;
import dio.desafiopadroesprojeto.service.ChamadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("chamados")
public class ChamadoController {
		@Autowired
		private ChamadoService chamadoService;

		@GetMapping
		public ResponseEntity<Iterable<Chamado>> buscarTodos() {
				return ResponseEntity.ok(chamadoService.buscarTodos());
		}

		@GetMapping("/{id}")
		public ResponseEntity<Chamado> buscarPorId(@PathVariable Long id) {
				return ResponseEntity.ok(chamadoService.buscarPorId(id));
		}

		@PostMapping
		public ResponseEntity<Chamado> inserir(@RequestBody Chamado chamado) {
				chamadoService.inserir(chamado);
				return ResponseEntity.ok(chamado);
		}

		@PutMapping("/{id}")
		public ResponseEntity<Chamado> atualizar(@PathVariable Long id, @RequestBody Chamado chamado) {
				chamadoService.atualizar(id, chamado);
				return ResponseEntity.ok(chamado);
		}

		@DeleteMapping("/{id}")
		public ResponseEntity<Void> deletar(@PathVariable Long id) {
				chamadoService.deletar(id);
				return ResponseEntity.ok().build();
		}
}
