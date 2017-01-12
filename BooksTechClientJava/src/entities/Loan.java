package entities;

import java.io.Serializable;
import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Loan implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private long id;
	private Date startDate;
	private int duration;
	
	private Book book;
	private User user;

	public Loan() {
		super();
	}
	
	public Loan(long id, Date startDate, int duration, Book book, User user) {
		super();
		this.id = id;
		this.startDate = startDate;
		this.duration = duration;
		this.book = book;
		this.user = user;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
}
