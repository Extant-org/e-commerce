package com.ecommerce.ecommerce.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.ecommerce.ecommerce.Util.AESUtil;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;
import org.springframework.beans.factory.annotation.Autowired;

import javax.crypto.SecretKey;

@Entity
@Table(name = "tb_user")
public class User implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	
	private String name;
	private String email;
	private String phone;
	private String password;
	private String CPF;
	
	@JsonIgnore
	@OneToMany(mappedBy = "client")
	private List<Order> orders = new ArrayList<>();

	private static final SecretKey key;

    static {
        try {
            key = AESUtil.getSecretKey();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public User () {
		
	}

	public User(Long id, String name, String email, String phone, String password, String CPF) {
		this.id = id;
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.password = password;
		this.CPF = CPF;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}


	@Transient
	public String getPhone() {
		try {
			return AESUtil.decrypt(this.phone, key);
		} catch (Exception e) {
			throw new RuntimeException("Error decrypting phone", e);
		}
	}

	public void setPhone(String phone) {
		try {
			this.phone = AESUtil.encrypt(phone, key);
		} catch (Exception e) {
			throw new RuntimeException("Error encrypting phone", e);
		}
	}


	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Transient
	public String getCPF() {
		try {
			return AESUtil.decrypt(this.CPF, key);
		} catch (Exception e) {
			throw new RuntimeException("Error decrypting CPF", e);
		}
	}

	public void setCPF(String CPF) {
		try {
			this.CPF = AESUtil.encrypt(CPF, key);
		} catch (Exception e) {
			throw new RuntimeException("Error encrypting CPF", e);
		}
	}

	public List<Order> getOrders() {
		return orders;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		return Objects.equals(id, other.id);
	}
	
}
