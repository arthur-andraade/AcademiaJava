package br.atos.petshop.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.security.core.GrantedAuthority;

import br.atos.petshop.enums.RoleEnum;

@Entity
public class Permissao implements GrantedAuthority {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long permissaoId;
	
	@Enumerated(EnumType.STRING)
	@Column(nullable = false, unique = true)
	private RoleEnum permissao;
		
	@Override
	public String getAuthority() {
		return this.permissao.name();
	}

	public Long getRoleId() {
		return permissaoId;
	}

	public void setRoleId(Long roleId) {
		this.permissaoId = roleId;
	}

	public RoleEnum getRoleName() {
		return permissao;
	}

	public void setRoleName(RoleEnum roleName) {
		this.permissao = roleName;
	}
	
	

}
