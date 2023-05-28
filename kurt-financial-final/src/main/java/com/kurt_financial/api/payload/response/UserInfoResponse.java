	package com.kurt_financial.api.payload.response;

	import lombok.AllArgsConstructor;
	import lombok.Getter;
	import lombok.Setter;

	import java.util.List;
	@Getter @Setter @AllArgsConstructor
	public class UserInfoResponse {
		private Long id;
		private String username;
		private String sessionID;
	}
