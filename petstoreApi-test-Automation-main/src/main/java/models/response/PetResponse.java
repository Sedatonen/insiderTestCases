package models.response;

import java.util.List;
import lombok.Data;

public @Data class PetResponse {

	private List<String> photoUrls;
	private String name;
	private Long id;
	private Category category;
	private List<Tags> tags;
	private String status;



}