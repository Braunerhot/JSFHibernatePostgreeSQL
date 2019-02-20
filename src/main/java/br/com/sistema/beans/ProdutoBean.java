package br.com.sistema.beans;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.sistema.dao.DaoGenerico;
import br.com.sistema.entidades.Produto;

@ViewScoped
@ManagedBean(name = "produtoBean")
public class ProdutoBean {
	
	private Produto produto = new Produto();
	private DaoGenerico<Produto> daoGenerico = new DaoGenerico<Produto>();
	private List<Produto> produtos = new ArrayList<Produto>();
	
	public String salvar(){
		daoGenerico.salvar(produto);
		produto = new Produto();
		return "";
	}
	
	public String novo() {
		produto = new Produto();
		return "";
	}

	public String remove() {
		daoGenerico.deletePorId(produto);
		produto = new Produto();
		carregarProdutos();
		return "";
	}

	@PostConstruct
	public void carregarProdutos() {
		produtos = daoGenerico.getListEntity(Produto.class);
	}

	public Produto getProduto() {
		return produto;
	}
	public void setProduto(Produto produto) {
		this.produto = produto;
	}
	public DaoGenerico<Produto> getDaoGenerico() {
		return daoGenerico;
	}
	public void setDaoGenerico(DaoGenerico<Produto> daoGenerico) {
		this.daoGenerico = daoGenerico;
	}

	public List<Produto> getProdutos() {
		return produtos;
	}

	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}
	
}
