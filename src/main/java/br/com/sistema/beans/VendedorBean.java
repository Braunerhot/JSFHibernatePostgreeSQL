package br.com.sistema.beans;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.sistema.dao.DaoGenerico;
import br.com.sistema.entidades.Vendedor;

@ViewScoped
@ManagedBean(name = "vendedorBean")
public class VendedorBean {
	
	private Vendedor vendedor = new Vendedor();
	private DaoGenerico<Vendedor> daoGenerico = new DaoGenerico<Vendedor>();
	private List<Vendedor> vendedores = new ArrayList<Vendedor>();
	
	public String salvar(){
		daoGenerico.salvar(vendedor);
		vendedor = new Vendedor();
		return "";
	}
	
	public String novo() {
		vendedor = new Vendedor();
		return "";
	}

	public String remove() {
		daoGenerico.deletePorId(vendedor);
		vendedor = new Vendedor();
		carregarVendedores();
		return "";
	}

	@PostConstruct
	public void carregarVendedores() {
		setVendedores(daoGenerico.getListEntity(Vendedor.class));
	}

	public List<Vendedor> getVendedores() {
		return vendedores;
	}

	public void setVendedores(List<Vendedor> vendedores) {
		this.vendedores = vendedores;
	}
	
	public Vendedor getVendedor() {
		return vendedor;
	}

	public void setVendedor(Vendedor vendedor) {
		this.vendedor = vendedor;
	}

	public DaoGenerico<Vendedor> getDaoGenerico() {
		return daoGenerico;
	}

	public void setDaoGenerico(DaoGenerico<Vendedor> daoGenerico) {
		this.daoGenerico = daoGenerico;
	}
	

}
