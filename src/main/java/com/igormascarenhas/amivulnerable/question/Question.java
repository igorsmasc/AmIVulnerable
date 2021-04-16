package com.igormascarenhas.amivulnerable.question;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@ToString
@Entity
@Table(name = "\"Question\"")
public class Question {

    @Id
    private Long id;
    private String title;
    private Boolean answer;
    private Long result;

    public Question(String title, Boolean answer, Long result) {
        this.title = title;
        this.answer = answer;
        this.result = result;
    }
}
