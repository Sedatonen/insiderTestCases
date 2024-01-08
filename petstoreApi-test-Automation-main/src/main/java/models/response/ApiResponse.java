package models.response;

import lombok.Data;

@Data
public class ApiResponse {

	private int code;

	private String type;

	private String message;
}