package br.gov.fazenda.mg.domain;

import com.fasterxml.jackson.annotation.JsonView;

import br.gov.fazenda.mg.jsonview.Views;

public class LoginResponseBody {
	
	@JsonView(Views.Public.class)
    Boolean authenticated;

    @JsonView(Views.Public.class)
    String token;

    @JsonView(Views.Public.class)
    String message;
    
    @JsonView(Views.Public.class)
    String flag;

    public LoginResponseBody() {
    }   

    public LoginResponseBody(Boolean authenticated, String token, String message, String flag) {
		super();
		this.authenticated = authenticated;
		this.token = token;
		this.message = message;
		this.flag = flag;
	}
    
	public LoginResponseBody(Boolean authenticated, String token, String message) {
        this.authenticated = authenticated;
        this.token = token;
        this.message = message;
    }

    public LoginResponseBody(Boolean authenticated, String token) {
        this.authenticated = authenticated;
        this.token = token;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Boolean getAuthenticated() {
        return authenticated;
    }

    public void setAuthenticated(Boolean authenticated) {
        this.authenticated = authenticated;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

	public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}

}
