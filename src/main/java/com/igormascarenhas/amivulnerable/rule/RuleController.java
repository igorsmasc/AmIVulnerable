package com.igormascarenhas.amivulnerable.rule;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.*;
import org.springframework.web.bind.annotation.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/api")
@Api(value = "REST API - RULE")
@CrossOrigin(origins = "*") //All domains can access it
@AllArgsConstructor
public class RuleController {

    private final RuleService ruleService;

    @GetMapping("/rules")
    @ApiOperation(value = "GET ALL RULES")
    public List<Rule> getAllRules() {
        return ruleService.getAllRules();
    }

    @GetMapping("/rule/{ruleId}")
    @ApiOperation(value = "GET RULE BY ID")
    public Optional<Rule> getRule(@PathVariable("ruleId") Long ruleId) {
        return ruleService.getRule(ruleId);
    }

    @PostMapping("/rule")
    @ApiOperation(value = "REGISTER A NEW RULE")
    public void registerNewRule(@RequestBody Rule rule) {
        ruleService.addNewRule(rule);
    }


}
