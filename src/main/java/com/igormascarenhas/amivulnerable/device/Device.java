package com.igormascarenhas.amivulnerable.device;

import com.igormascarenhas.amivulnerable.vulnerability.Vulnerability;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@ToString
@Entity
@Table(name = "\"Device\"")
public class Device {

    @Id
    @SequenceGenerator(
            name = "device_sequence",
            sequenceName = "device_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "device_sequence"
    )
    private Long id;
    private String os;
    private String os_version;
    private String model;

    @Access(AccessType.PROPERTY)
    @OneToMany(targetEntity = Vulnerability.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "dv_fk", referencedColumnName = "id")
    private List<Vulnerability> vulnerabilities;

    @Access(AccessType.PROPERTY)
    @OneToMany(targetEntity = Vulnerability.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "dv_fk", referencedColumnName = "id")
    private List<Vulnerability> questions;


    public Device(
            String os,
            String os_version,
            String model) {
        this.os = os;
        this.os_version = os_version;
        this.model = model;
    }

}
