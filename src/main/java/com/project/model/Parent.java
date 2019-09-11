package com.project.model;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.sun.istack.internal.NotNull;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@Document(collection = "parent")
public class Parent implements Serializable {
	  private static final long serialVersionUID = 1L;
	  @Id
	  @NotNull
	  private String idParent;
	  private String fullName;
	  private String gender;
	  private String birthdate;
	  private String TypeDocument;
	  private String NumberDocument;
	  private String id;
}
