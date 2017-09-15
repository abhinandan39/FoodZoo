package com.avizva.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;

import org.springframework.stereotype.Component;
/**
 * @author Parul.Sharma
 * @Entity annotation for making table of that class above which it is applied
 * with default name
 * 
 *
 */

/**
 * 
 * @author Parul.Sharma
 * makes the bean of class
 *
 */

/**
 * 
 * @author Parul.Sharma
 * categories class have parameters category_id that takes the id of category,
 * category_name that takes the name of category,
 * category_Description that takes the description about a category
 * This class is for getting the information of category
 *
 */

@Entity
@Component
public class Categories {
	/**
	 * @NotEmpty annotation is validation that means that field should not be empty above which it is applied
	 */
	
	/**
	 * category_id specifies category's id
	 */
	@NotEmpty
	@Id
	private String category_id;
	
	/**
	 * category_name specifies category's name
	 */
	@NotEmpty
	private String category_name;
	
	/**
	 * category_description specifies category's description
	 */
	@NotEmpty
	private String category_description;
	public String getCategory_id() {
		return category_id;
	}
	public void setCategory_id(String category_id) {
		this.category_id = category_id;
	}
	public String getCategory_name() {
		return category_name;
	}
	public void setCategory_name(String category_name) {
		this.category_name = category_name;
	}
	public String getCategory_description() {
		return category_description;
	}
	public void setCategory_description(String category_description) {
		this.category_description = category_description;
	}
	
	

}
