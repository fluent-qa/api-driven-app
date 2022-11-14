package io.fluentqa.todo.entity;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.v3.oas.annotations.media.Schema;

import javax.annotation.Generated;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.util.Objects;

/**
 * Todo
 */

@Entity
@Table(name = "todos")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2022-11-14T16:29:29.158062+08:00[Asia/Shanghai]")
public class ToDoEntity {
  @Id
  @GeneratedValue
  private Long id;
  @JsonProperty("uuid")
  private String uuid;

  @JsonProperty("ownerUuid")
  private String ownerUuid;

  @JsonProperty("title")
  private String title;

  /**
   * State of the todo
   */
  public enum StateEnum {
    ACTIVE("ACTIVE"),
    
    COMPLETED("COMPLETED"),
    
    DELETED("DELETED");

    private String value;

    StateEnum(String value) {
      this.value = value;
    }

    @JsonValue
    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static StateEnum fromValue(String value) {
      for (StateEnum b : StateEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }
  }

  @JsonProperty("state")
  private StateEnum state;

  @JsonProperty("description")
  private String description;

  public ToDoEntity uuid(String uuid) {
    this.uuid = uuid;
    return this;
  }

  /**
   * Unique identifier of the todo
   * @return uuid
  */
  @NotNull 
  @Schema(name = "uuid", description = "Unique identifier of the todo", required = true)
  public String getUuid() {
    return uuid;
  }

  public void setUuid(String uuid) {
    this.uuid = uuid;
  }

  public ToDoEntity ownerUuid(String ownerUuid) {
    this.ownerUuid = ownerUuid;
    return this;
  }

  /**
   * Unique identifier of the owner of the todo
   * @return ownerUuid
  */
  public String getOwnerUuid() {
    return ownerUuid;
  }

  public void setOwnerUuid(String ownerUuid) {
    this.ownerUuid = ownerUuid;
  }

  public ToDoEntity title(String title) {
    this.title = title;
    return this;
  }

  /**
   * Title/short summary of the todo
   * @return title
  */
  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public ToDoEntity state(StateEnum state) {
    this.state = state;
    return this;
  }

  /**
   * State of the todo
   * @return state
  */
  public StateEnum getState() {
    return state;
  }

  public void setState(StateEnum state) {
    this.state = state;
  }

  public ToDoEntity description(String description) {
    this.description = description;
    return this;
  }

  /**
   * The lengthy description of this todo
   * @return description
  */
  
  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ToDoEntity todo = (ToDoEntity) o;
    return Objects.equals(this.uuid, todo.uuid) &&
        Objects.equals(this.ownerUuid, todo.ownerUuid) &&
        Objects.equals(this.title, todo.title) &&
        Objects.equals(this.state, todo.state) &&
        Objects.equals(this.description, todo.description);
  }

  @Override
  public int hashCode() {
    return Objects.hash(uuid, ownerUuid, title, state, description);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Todo {\n");
    sb.append("    uuid: ").append(toIndentedString(uuid)).append("\n");
    sb.append("    ownerUuid: ").append(toIndentedString(ownerUuid)).append("\n");
    sb.append("    title: ").append(toIndentedString(title)).append("\n");
    sb.append("    state: ").append(toIndentedString(state)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

