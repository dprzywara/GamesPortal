package com.project.inz.model;


import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "quiz",catalog="quizgame")
@Setter @Getter @NoArgsConstructor 
@AllArgsConstructor 
public class Quiz {
	
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "quizzName", nullable = false)
	private String name;
	
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "categoryId")
	private Category category;
	
	@Column(name = "level", nullable = false)
	private int level;
	
	@Column(name = "popularity", nullable = false)
	private int popularity;
	
	@OneToMany(mappedBy="quiz",fetch=FetchType.EAGER)
	@Fetch (FetchMode.SELECT)
	private Set<Question> questions= new HashSet<Question>();
	
	@OneToMany(mappedBy="quiz",fetch=FetchType.EAGER)
	@Fetch (FetchMode.SELECT)
	private Set<Comment> comments= new HashSet<Comment>();
	
	@OneToMany(mappedBy="quiz",fetch=FetchType.EAGER)
	@Fetch (FetchMode.SELECT)
	private Set<ScoreCard> scores= new HashSet<ScoreCard>();
	
}
