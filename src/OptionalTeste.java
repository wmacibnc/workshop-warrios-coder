import java.util.Optional;

public class OptionalTeste {

	public static void main(String[] args) {
		Pessoa pessoa = new Pessoa();
		// Erro nullpointer
		// System.out.println(pessoa.getEndereco().getBairro().getLocalidade().getEstado().getNomeEstado());

		if (pessoa != null) {
			if (pessoa.getEndereco() != null) {
				if (pessoa.getEndereco().getBairro() != null) {
					if (pessoa.getEndereco().getBairro().getLocalidade() != null) {
						if (pessoa.getEndereco().getBairro().getLocalidade().getEstado() != null) {
							System.out.println(
									pessoa.getEndereco().getBairro().getLocalidade().getEstado().getNomeEstado());
						}
					}
				}
			}
		}

		Optional<Pessoa> pessoaOptional = Optional.of(new Pessoa());
		pessoaOptional.ifPresent(p -> {
			System.out.println(p.getEndereco());
		});

	}

	static class Pessoa {
		private String nome;
		private Endereco endereco;

		public String getNome() {
			return nome;
		}

		public void setNome(String nome) {
			this.nome = nome;
		}

		public Endereco getEndereco() {
			return endereco;
		}

		public void setEndereco(Endereco endereco) {
			this.endereco = endereco;
		}

	}

	static class Endereco {
		private String endereco;
		private Bairro bairro;

		public String getEndereco() {
			return endereco;
		}

		public void setEndereco(String endereco) {
			this.endereco = endereco;
		}

		public Bairro getBairro() {
			return bairro;
		}

		public void setBairro(Bairro bairro) {
			this.bairro = bairro;
		}

	}

	static class Estado {
		private String nomeEstado;

		public String getNomeEstado() {
			return nomeEstado;
		}

		public void setNomeEstado(String nomeEstado) {
			this.nomeEstado = nomeEstado;
		}

	}

	static class Localidade {
		private String nomeLocalidade;
		private Estado estado;

		public String getNomeLocalidade() {
			return nomeLocalidade;
		}

		public void setNomeLocalidade(String nomeLocalidade) {
			this.nomeLocalidade = nomeLocalidade;
		}

		public Estado getEstado() {
			return estado;
		}

		public void setEstado(Estado estado) {
			this.estado = estado;
		}

	}

	static class Bairro {
		private String nomeBairro;
		private Localidade localidade;

		public String getNomeBairro() {
			return nomeBairro;
		}

		public void setNomeBairro(String nomeBairro) {
			this.nomeBairro = nomeBairro;
		}

		public Localidade getLocalidade() {
			return localidade;
		}

		public void setLocalidade(Localidade localidade) {
			this.localidade = localidade;
		}

	}

}
