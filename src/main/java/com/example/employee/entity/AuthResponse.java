package com.example.employee.entity;

public class AuthResponse {
    private String token;
    public AuthResponse(String token) { this.setToken(token); }
    
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
}
