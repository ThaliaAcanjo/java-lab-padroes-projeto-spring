package dio.desafiopadroesprojeto.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import dio.desafiopadroesprojeto.enums.Prioridade;
import dio.desafiopadroesprojeto.enums.Status;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
public class Chamado implements Serializable {
		private static final long serialVersionUID = 1L;

		@Id
		@GeneratedValue(strategy = GenerationType.AUTO)
		private Long id;

		@JsonFormat(pattern = "dd/MM/yyyy")
		private LocalDate dataAbertura;

		@JsonFormat(pattern = "dd/MM/yyyy")
		private LocalDate dataFechamento;

		private Prioridade prioridade;
		private Status status;
		private String titulo;
		private String descricao;

		@ManyToOne
		@JoinColumn(name = "cliente_id")
		private Cliente cliente;

		public Chamado() {
				super();
				this.dataAbertura = LocalDate.now();
				this.prioridade = Prioridade.BAIXA;
				this.status = Status.ABERTO;
		}

		public Long getId() {
				return id;
		}

		public void setId(Long id) {
				this.id = id;
		}

		public LocalDate getDataAbertura() {
				return dataAbertura;
		}

		public void setDataAbertura(LocalDate dataAbertura) {
				this.dataAbertura = dataAbertura;
		}

		public LocalDate getDataFechamento() {
				return dataFechamento;
		}

		public void setDataFechamento(LocalDate dataFechamento) {
				this.dataFechamento = dataFechamento;
		}

		public Prioridade getPrioridade() {
				return prioridade;
		}

		public void setPrioridade(Prioridade prioridade) {
				this.prioridade = prioridade;
		}

		public Status getStatus() {
				return status;
		}

		public void setStatus(Status status) {
				this.status = status;
		}

		public String getTitulo() {
				return titulo;
		}

		public void setTitulo(String titulo) {
				this.titulo = titulo;
		}

		public String getDescricao() {
				return descricao;
		}

		public void setDescricao(String descricao) {
				this.descricao = descricao;
		}

		public Cliente getCliente() {
				return cliente;
		}

		public void setCliente(Cliente cliente) {
				this.cliente = cliente;
		}

		@Override
		public int hashCode() {
				final int prime = 31;
				int result = 1;
				result = prime * result + ((id == null) ? 0 : id.hashCode());
				return result;
		}

		@Override
		public boolean equals(Object obj) {
				if (this == obj)
						return true;
				if (obj == null)
						return false;
				if (getClass() != obj.getClass())
						return false;
				Chamado other = (Chamado) obj;
				if (id == null) {
						if (other.id != null)
								return false;
				} else if (!id.equals(other.id))
						return false;
				return true;
		}

}
