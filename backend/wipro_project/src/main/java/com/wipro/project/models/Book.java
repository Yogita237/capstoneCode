package com.wipro.project.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Book {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	private String names;
	private String genre;
	private String category;
	private String author;

	private byte[] picture;
	private float price;
	private String edition;

	private String description;
	public Book() {}

	public Book(String name, Float price, String author,String genre,String category,byte[] picture) {
		super();

		this.names = name;
		this.price = price;
		this.author = author;
		this.genre = genre;
		this.category = category;
		this.picture = picture;


	}

	public byte[] getPicture() {
		return picture;
	}

	public void setPicture(byte[] picture) {
		this.picture = picture;
	}

	public String getNames() {
		return names;
	}

	public void setNames(String names) {
		this.names = names;
	}


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return names;
	}

	public void setName(String name) {
		this.names = name;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public String getEdition() {
		return edition;
	}

	public void setEdition(String edition) {
		this.edition = edition;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}
