package org.launchcode.codingevents.models;

import jakarta.persistence.Entity;
import jakarta.validation.constraints.Size;

/**
 * Represents a category for events in the system. Inherits ID and common entity behavior from AbstractEntity.
 */
@Entity
public class EventCategory extends AbstractEntity {

    @Size(min = 3, message = "Name must be at least 3 characters long")
    private String name;

    /**
     * Default constructor required by JPA. Do not use to create instances.
     */
    public EventCategory() {}

    /**
     * Creates a new EventCategory with the specified name.
     *
     * @param name the name of the category, must be at least 3 characters long
     */
    public EventCategory(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "EventCategory{" +
                "name='" + name + '\'' +
                '}';
    }
}
