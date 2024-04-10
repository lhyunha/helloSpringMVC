package kr.ac.hansung.cse.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Getter
@Setter
@ToString
@NoArgsConstructor

public class Offer { //field 생성
    private int id;

    //조건을 만족하지 않았을 경우 아래의 메세지 출력
    @Size(min=2, max=100, message = "Name must be between 2 and 100 chars")
    private String name;

    @Email(message = "Please provide a valid email address")
    @NotEmpty(message = "The email address cannot be empty")
    private String email;

    @Size(min = 5, max = 100, message = "Text must be between 5 and 100 chars")
    private String text;
}
