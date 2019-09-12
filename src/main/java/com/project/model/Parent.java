package com.project.model;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@Document(collection = "parent")
public class Parent implements Serializable {
  private static final long serialVersionUID = 1L;
  @Id
  private String idParent;
  private String fullName;
  private String gender;
  private String birthdate;
  private String typeDocument;
  private String numberDocument;
  private String id;
}
