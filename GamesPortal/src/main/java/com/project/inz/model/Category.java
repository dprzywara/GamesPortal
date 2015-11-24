package com.project.inz.model;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "category", catalog = "quizgame")
@Setter @Getter @NoArgsConstructor 
@AllArgsConstructor 
public class Category {
	
	@Id
	@Column(name = "categoryId")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "categoryName", nullable = false)
	private String name;

	@Override
	public String toString() {
		return name;
	}
	
	

	

}
