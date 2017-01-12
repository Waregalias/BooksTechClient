package entities;

import java.io.Serializable;
import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Book implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private long id;
	private String title;
	private String summary;
	private int qty;
	private String isbn;
	private String picture;
	private Date datePublish;
	private Category category;
	private Author author;
	
//	@OneToOne
//	@JoinColumn(name="loan")
//	private Loan loan;

	public Book() {
		super();
	}
	
	public Book(long id, String title, String summary, int qty, String isbn, String picture, Date datePublish, Category category, Author author) {
		super();
		this.id = id;
		this.title = title;
		this.summary = summary;
		this.qty = qty;
		this.isbn = isbn;
		this.picture = picture;
		this.datePublish = datePublish;
		this.category = category;
		this.author = author;
	}

	public long getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	public int getQty() {
		return qty;
	}

	public void setQty(int qty) {
		this.qty = qty;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

	public Date getDatePublish() {
		return datePublish;
	}

	public void setDatePublish(Date datePublish) {
		this.datePublish = datePublish;
	}

	
	public Category getCategory() {
		return category;
	}

	
	public void setCategory(Category category) {
		this.category = category;
	}

	public Author getAuthor() {
		return author;
	}

	public void setAuthor(Author author) {
		this.author = author;
	}

}
