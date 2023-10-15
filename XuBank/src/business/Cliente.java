package business;

public abstract class Cliente {
	private String nome;
	private String cpf;
	private String senha;

	public Cliente(String nome, String cpf, String senha) {
		this.nome = nome;
		this.cpf = cpf;
		this.senha = senha;
	}

    public String getNome() {
   	return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public boolean autenticar(String senha) {
        return this.senha.equals(senha);
    } 
	
	public abstract String getTipoCliente(); // vai ser implementado em cada classe de cliente especifico

}
