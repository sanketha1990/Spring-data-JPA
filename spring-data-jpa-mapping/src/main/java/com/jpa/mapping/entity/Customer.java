package com.jpa.mapping.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Customer {
	
	@Id
	@GeneratedValue
    private int id;
    private String name;
    private String gender;
    private String email;
    
    @OneToMany(targetEntity = Product.class,cascade = CascadeType.ALL)
	@JoinColumn(name="cp_fk",referencedColumnName = "id")
	private List<Product> products;

}
