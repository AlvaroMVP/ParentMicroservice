package com.project.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;

import java.util.Date;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

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

//Employee POJO class to represent entity Parent
public class Parent {
  //public field
  @Id
  @NotNull
  public String idParent;
  @NotEmpty(message = "name cannot be empty")
  public String fullName;
  @NotEmpty(message = "gender cannot be empty")
  public String gender;
  @JsonFormat(pattern = "yyyy-MM-dd", shape = Shape.STRING)
  public Date birthdate;
  @NotEmpty(message = "Document type cannot be empty")
  public String typeDocument;
  @NotEmpty(message = "number document cannot be empty")
  @Size(min = 8, max = 8, message = "document number can only have 8 characters")
  public String numberDocument;
  @NotEmpty(message = "can't be empty")
  @Max(2)
  public String idFamily;
}
