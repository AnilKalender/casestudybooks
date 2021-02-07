package com.books.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Book {

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
	
    private String name;
    private String author;
    private String description;
    private String category;
    
    public Book() {
    }
    
	public Book(String name, String author, String description, String category) {
		super();
		this.name = name;
		this.author = author;
		this.description = description;
		this.category = category;
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

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	@Override
	public String toString() {
		return "Book [id=" + id + ", name=" + name + ", author=" + author + ", description=" + description
				+ ", category=" + category + "]";
	}
}
