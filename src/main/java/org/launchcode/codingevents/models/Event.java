package org.launchcode.codingevents.models;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

/**
 * Represents an event in the system. Inherits common entity properties like ID from AbstractEntity.
 */
@Entity
public class Event extends AbstractEntity {

    @NotBlank(message = "Name is required")
    @Size(min = 3, max = 50, message = "Name must be between 3 and 50 characters")
    private String name;

    @Size(max = 500, message = "Description too long!")
    private String description;

    @NotBlank(message = "Email is required")
    @Email(message = "Invalid email. Try again.")
    private String contactEmail;

    @Enumerated(EnumType.STRING) // Assuming EventType is an enum. Adjust as necessary.
    private EventType type;

    /**
     * Default constructor required by JPA. Do not use to create instances.
     */
    public Event() {}

    /**
     * Creates a new Event with specified details.
     *
     * @param name the name of the event, must not be null or empty
     * @param description the description of the event, can be empty but not null
     * @param contactEmail the contact email for the event, must be a valid email format
     * @param type the type of the event, represented by the EventType enum
     */
    public Event(String name, String description, String contactEmail, EventType type) {
        this.name = name;
        this.description = description;
        this.contactEmail = contactEmail;
        this.type = type;
    }

    // Getters and setters

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getContactEmail() {
        return contactEmail;
    }

    public void setContactEmail(String contactEmail) {
        this.contactEmail = contactEmail;
    }

    public EventType getType() {
        return type;
    }

    public void setType(EventType type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Event{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", contactEmail='" + contactEmail + '\'' +
                ", type=" + type +
                '}';
    }
}