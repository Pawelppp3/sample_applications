package pl.sda.model;

import org.springframework.context.annotation.Scope;

import javax.persistence.*;

@Entity
@Table(name = "user")
//@Scope("session")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String login;
	
	private String password;

	@Enumerated(EnumType.STRING)
	private UserRoleType userRoleType;

	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, targetEntity = Shopper.class)
	@JoinColumn(name = "shopper_id")
	private Shopper shopperS;
	
	public User() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public UserRoleType getUserRoleType() {
		return userRoleType;
	}

	public void setUserRoleType(UserRoleType userRoleType) {
		this.userRoleType = userRoleType;
	}

	public Shopper getShopperS() {
		return shopperS;
	}

	public void setShopperS(Shopper shopperS) {
		this.shopperS = shopperS;
	}
}
