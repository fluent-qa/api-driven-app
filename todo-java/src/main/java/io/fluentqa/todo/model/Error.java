package io.fluentqa.todo.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;
import javax.validation.Valid;

import io.swagger.v3.oas.annotations.media.Schema;


import javax.annotation.Generated;

/**
 * Error
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2022-11-14T16:29:29.158062+08:00[Asia/Shanghai]")
public class Error {

  @JsonProperty("statusCode")
  private BigDecimal statusCode;

  @JsonProperty("error")
  private String error;

  @JsonProperty("message")
  private String message;

  public Error statusCode(BigDecimal statusCode) {
    this.statusCode = statusCode;
    return this;
  }

  /**
   * Status code of the response
   * @return statusCode
  */
  @Valid 
  @Schema(name = "statusCode", description = "Status code of the response", required = false)
  public BigDecimal getStatusCode() {
    return statusCode;
  }

  public void setStatusCode(BigDecimal statusCode) {
    this.statusCode = statusCode;
  }

  public Error error(String error) {
    this.error = error;
    return this;
  }

  /**
   * Name of the error
   * @return error
  */
  
  @Schema(name = "error", description = "Name of the error", required = false)
  public String getError() {
    return error;
  }

  public void setError(String error) {
    this.error = error;
  }

  public Error message(String message) {
    this.message = message;
    return this;
  }

  /**
   * Explanation of the error
   * @return message
  */
  
  @Schema(name = "message", description = "Explanation of the error", required = false)
  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Error error = (Error) o;
    return Objects.equals(this.statusCode, error.statusCode) &&
        Objects.equals(this.error, error.error) &&
        Objects.equals(this.message, error.message);
  }

  @Override
  public int hashCode() {
    return Objects.hash(statusCode, error, message);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Error {\n");
    sb.append("    statusCode: ").append(toIndentedString(statusCode)).append("\n");
    sb.append("    error: ").append(toIndentedString(error)).append("\n");
    sb.append("    message: ").append(toIndentedString(message)).append("\n");
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

