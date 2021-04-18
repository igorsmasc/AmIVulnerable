package com.igormascarenhas.amivulnerable.device;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;

@Setter
@Getter
@NoArgsConstructor
public class RuleVul {

    private ArrayList<Integer> vulnerabilitiesList = new ArrayList<Integer>();
    private ArrayList<Integer>  rulesList = new ArrayList<Integer>();

    public RuleVul(ArrayList<Integer> vulnerabilitiesList, ArrayList<Integer> rulesList) {
        this.vulnerabilitiesList = vulnerabilitiesList;
        this.rulesList = rulesList;
    }

    public boolean findVulnerability(Integer i) {
        return vulnerabilitiesList.contains(i);
    }

    public void addVulnerability(Integer vulnerability) {
        this.vulnerabilitiesList.add(vulnerability);
    }
    public void addRule(Integer rule) {
        this.rulesList.add(rule);
    }

}
