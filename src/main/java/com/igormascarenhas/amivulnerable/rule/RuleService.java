package com.igormascarenhas.amivulnerable.rule;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class RuleService {

    private final RuleRepository ruleRepository;

    public List<Rule> getAllRules() {
        return  ruleRepository.findAll();
    }

    public Optional<Rule> getRule(Long ruleId) {

        boolean exists = ruleRepository.existsById(ruleId);
        if(!exists) {
            throw new IllegalStateException("Rule with id " + ruleId + " does not exists.");
        }

        return ruleRepository.findById(ruleId);
    }

    public void addNewRule(Rule rule) {
        ruleRepository.save(rule);
    }

    public void deleteDevice(Long deviceId) {
        boolean exists = ruleRepository.existsById(deviceId);
        if(!exists) {
            throw new IllegalStateException("Rule with id " + deviceId + " does not exists.");
        }
        ruleRepository.deleteById(deviceId);
    }

}
