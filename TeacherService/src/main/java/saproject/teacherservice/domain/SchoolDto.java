package saproject.teacherservice.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * A DTO for the {@link School} entity
 */


public record SchoolDto(String name, String address, Contact contact) implements Serializable {
}