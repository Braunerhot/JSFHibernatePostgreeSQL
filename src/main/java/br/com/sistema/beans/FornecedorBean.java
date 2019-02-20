package br.com.sistema.beans;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.sistema.dao.DaoGenerico;
import br.com.sistema.entidades.Fornecedor;

@ViewScoped
@ManagedBean(name = "fornecedorBean")
public class FornecedorBean {
	
	private Fornecedor fornecedor = new Fornecedor();
	private DaoGenerico<Fornecedor> daoGenerico = new DaoGenerico<Fornecedor>();
	private List<Fornecedor> Fornecedores = new ArrayList<Fornecedor>();
	
	public String salvar(){
		daoGenerico.salvar(fornecedor);
		fornecedor = new Fornecedor();
		return "";
	}
	
	public String novo() {
		fornecedor = new Fornecedor();
		return "";
	}

	public String remove() {
		daoGenerico.deletePorId(fornecedor);
		fornecedor = new Fornecedor();
		carregarFornecedor();
		return "";
	}

	@PostConstruct
	public void carregarFornecedor() {
		Fornecedores = daoGenerico.getListEntity(Fornecedor.class);
	}
		
	public Fornecedor getFornecedor() {
		return fornecedor;
	}
	public void setFornecedor(Fornecedor fornecedor) {
		this.fornecedor = fornecedor;
	}
	public DaoGenerico<Fornecedor> getDaoGenerico() {
		return daoGenerico;
	}
	public void setDaoGenerico(DaoGenerico<Fornecedor> daoGenerico) {
		this.daoGenerico = daoGenerico;
	}

	public List<Fornecedor> getFornecedores() {
		return Fornecedores;
	}

	public void setFornecedores(List<Fornecedor> fornecedores) {
		Fornecedores = fornecedores;
	}
	
	
}
