package com.igormascarenhas.amivulnerable.rule;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@ToString
@Entity
@Table(name = "\"Rule\"")
public class Rule {

    @Id
    private Long id;
    private String description;
    private String source;

    public Rule(Long id, String description, String source) {
        this.id = id;
        this.description = description;
        this.source = source;
    }
}
