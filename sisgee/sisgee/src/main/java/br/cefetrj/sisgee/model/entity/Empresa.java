package br.cefetrj.sisgee.model.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 * 
 * @author Paulo Cantuária
 * @since 1.0
 * 
 */
@Entity
public class Empresa {

	@Id
	@GeneratedValue
	private Integer idEmpresa;

	@Column(length = 14, nullable = false, unique = true)
	private String cnpjEmpresa;

	@Column(length = 100, nullable = false, unique = true)
	private String nomeEmpresa;

	@ManyToOne(fetch = FetchType.EAGER)
	private AgenteIntegracao agenteIntegracao;

	@OneToMany(mappedBy = "empresa")
	private List<Convenio> convenios;

	
	public Empresa(){}
	
	public Empresa(String cnpjEmpresa, String nomeEmpresa, AgenteIntegracao agenteIntegracao ){
		
		this.cnpjEmpresa = cnpjEmpresa;
		this.nomeEmpresa = nomeEmpresa;
		this.agenteIntegracao = agenteIntegracao;

	}
	
	public Empresa(Integer idEmpresa) {
		this.idEmpresa = idEmpresa;
	}
	
	public Integer getIdEmpresa() {
		return idEmpresa;
	}

	public void setIdEmpresa(Integer idEmpresa) {
		this.idEmpresa = idEmpresa;
	}

	public String getCnpjEmpresa() {
		return cnpjEmpresa;
	}

	public void setCnpjEmpresa(String cnpjEmpresa) {
		this.cnpjEmpresa = cnpjEmpresa;
	}

	public String getNomeEmpresa() {
		return nomeEmpresa;
	}

	public void setNomeEmpresa(String nomeEmpresa) {
		this.nomeEmpresa = nomeEmpresa;
	}

	public AgenteIntegracao getAgenteIntegracao() {
		return agenteIntegracao;
	}

	public void setAgenteIntegracao(AgenteIntegracao agenteIntegracao) {
		this.agenteIntegracao = agenteIntegracao;
	}

	public List<Convenio> getConvenios() {
		return convenios;
	}

	public void setConvenios(List<Convenio> convenios) {
		this.convenios = convenios;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idEmpresa == null) ? 0 : idEmpresa.hashCode());
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
		Empresa other = (Empresa) obj;
		if (idEmpresa == null) {
			if (other.idEmpresa != null)
				return false;
		} else if (!idEmpresa.equals(other.idEmpresa))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return nomeEmpresa;
	}

}