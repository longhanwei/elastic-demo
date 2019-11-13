package com.xiaoxiang.elasticdemo.entity;

import lombok.Data;
import org.springframework.data.elasticsearch.annotations.Document;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @author lhw<br>
 * @version 1.0<br>
 * @Description <Description> <br>
 * @taskId: <br>
 * @createDate 2019/11/13 14:54 <br>
 * @see com.xiaoxiang.elasticdemo.entity <br>
 */
@Entity(name ="book")
public class BookEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private String bookId;

	private String title;

	private String author;

	private String press;

	private Integer gradeId ;

	private Integer subjectId ;

	private Integer isbnCode;

	private Integer volume ;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getBookId() {
		return bookId;
	}

	public void setBookId(String bookId) {
		this.bookId = bookId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getPress() {
		return press;
	}

	public void setPress(String press) {
		this.press = press;
	}

	public Integer getGradeId() {
		return gradeId;
	}

	public void setGradeId(Integer gradeId) {
		this.gradeId = gradeId;
	}

	public Integer getSubjectId() {
		return subjectId;
	}

	public void setSubjectId(Integer subjectId) {
		this.subjectId = subjectId;
	}

	public Integer getIsbnCode() {
		return isbnCode;
	}

	public void setIsbnCode(Integer isbnCode) {
		this.isbnCode = isbnCode;
	}

	public Integer getVolume() {
		return volume;
	}

	public void setVolume(Integer volume) {
		this.volume = volume;
	}
}
