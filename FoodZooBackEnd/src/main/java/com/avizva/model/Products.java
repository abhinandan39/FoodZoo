package com.avizva.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

/**
 * 
 * @author Abhinandan.Gupta
 * @Entity makes the table of this class in the database
 * @Component makes the bean for this class
 *	This is a modal class for Products.
 */
@Component
@Entity
public class Products {

	/**
	 * product_id stores the unique ID of a product
	 */
	
	@NotEmpty
	@Id
	private String product_id;
	
	/**
	 * product_name stores the name of the unique product
	 */
	@NotEmpty
	private String product_name;
	
	/**
	 * price should be stored as floating  a float value
	 */
    @NotNull
	private Float price;
	
	/**
	 * Description provides extra information about the product
	 */
	@NotEmpty
	private String description;
	
	/**
	 * Quantity tells the remaining number of items present
	 */
	@NotNull
	private int quantity;
	
	/**
	 * category name tells which category a product belongs to
	 */
	@NotEmpty
	private String category_name;
	
	/**
	 * Supplier name tells which Supplier provides that product
	 */
	@NotEmpty
	private String supplier_name;
	
	/**
	 * Image File is stored as a miltp_part file
	 */
//	@Transient
//	private MultipartFile image_file;
//	
	
	public String getProduct_id() {
		return product_id;
	}
	public void setProduct_id(String product_id) {
		this.product_id = product_id;
	}
	public String getProduct_name() {
		return product_name;
	}
	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}
	public Float getPrice() {
		return price;
	}
	public void setPrice(Float price) {
		this.price = price;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public String getCategory_name() {
		return category_name;
	}
	public void setCategory_name(String category_name) {
		this.category_name = category_name;
	}
	public String getSupplier_name() {
		return supplier_name;
	}
	public void setSupplier_name(String supplier_name) {
		this.supplier_name = supplier_name;
	}
//	public MultipartFile getImage_file() {
//		return image_file;
//	}
//	public void setImage_file(MultipartFile image_file) {
//		this.image_file = image_file;
//	}
	@Override
	public String toString() {
		return "Products [product_id=" + product_id + ", product_name=" + product_name + ", price=" + price
				+ ", description=" + description + ", quantity=" + quantity + ", category_name=" + category_name
				+ ", supplier_name=" + supplier_name + "]";
	} 
	
	
	
	
	
	
}
