package com.avizva.model;

import javax.persistence.Entity;
import javax.validation.constraints.NotEmpty;

import org.springframework.stereotype.Component;
/**
 * @author Parul.Sharma
 * @Entity annotation for making table of that class above which it is applied
 * with default name
 * 
 *
 */
@Entity
/**
 * 
 * @author Parul.Sharma
 * makes the bean of class
 *
 */
@Component
/**
 * 
 * @author Parul.Sharma
 * suppliers class have parameters supplier_id that takes the id of supplier,
 * supplier_name that takes the name of supplier,
 * supplier_Description that takes the description about a supplier
 * This class is for getting the information of supplier
 *
 */
public class Suppliers {
	/**
	 * @NotEmpty annotation is validation that means that field should not be empty above which it is applied
	 */
	@NotEmpty
	/**
	 * supplier_id specifies supplier's id
	 */
	private String supplier_id;
	@NotEmpty
	/**
	 * supplier_name specifies supplier name
	 */
	private String supplier_name;
	@NotEmpty
	/**
	 * supplier_description specifies suppliers'description
	 */
	private String supplier_description;
	public String getSupplier_id() {
		return supplier_id;
	}
	public void setSupplier_id(String supplier_id) {
		this.supplier_id = supplier_id;
	}
	public String getSupplier_name() {
		return supplier_name;
	}
	public void setSupplier_name(String supplier_name) {
		this.supplier_name = supplier_name;
	}
	public String getSupplier_description() {
		return supplier_description;
	}
	public void setSupplier_description(String supplier_description) {
		this.supplier_description = supplier_description;
	}
	
	
	

}
