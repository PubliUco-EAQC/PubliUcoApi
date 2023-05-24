package co.edu.uco.publiuco.api.controller.response;

import java.util.ArrayList;

import java.util.List;

import co.edu.uco.publiuco.utils.UtilObject;

public class Response<T> {
	private List<T> data;
	private List<String> messages;
	
	public Response(List<T> data, List<String> messages) {
		super();
		setData(data);
		setMessages(messages);
	}
	
	public Response() {
		super();
		setData(new ArrayList<>());
		setMessages(new ArrayList<>());
	}
	
	public List<T> getData() {
		return data;
	}
	
	public void setData(List<T> data) {
		this.data = UtilObject.getDefault(data, new ArrayList<>());
	}
	
	public List<String> getMessages() {
		return messages;
	}
	
	public void setMessages(List<String> messages) {
		this.messages = UtilObject.getDefault(messages, new ArrayList<>());;
	}
}
