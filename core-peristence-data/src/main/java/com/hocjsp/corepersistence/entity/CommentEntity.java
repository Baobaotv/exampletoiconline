package com.hocjsp.corepersistence.entity;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="comment")
public class CommentEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name="content")
	private String content;
	
	@Column(name="createddate")
	private Timestamp createdDate;
	
	@ManyToOne
	@JoinColumn(name="userid")
	private UserEntity user;
	
	@ManyToOne
	@JoinColumn(name="listenguidelineid")
	private ListenGuidelineEntity listenguideline;
	
	public UserEntity getUser() {
		return user;
	}

	public void setUser(UserEntity user) {
		this.user = user;
	}

	public ListenGuidelineEntity getListenguideline() {
		return listenguideline;
	}

	public void setListenguideline(ListenGuidelineEntity listenguideline) {
		this.listenguideline = listenguideline;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Timestamp getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Timestamp createdDate) {
		this.createdDate = createdDate;
	}
	

	
	
	
	
	
}
