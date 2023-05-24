package co.edu.uco.publiuco.api.validator;

import java.util.ArrayList;

import java.util.List;

import co.edu.uco.publiuco.utils.UtilObject;
import co.edu.uco.publiuco.utils.UtilText;

public final class Result {
	private List<String> messages;
	
	private Result(final List<String> messages) {
		setMessages(messages);
	}
	
	public static Result create() {
		return new Result(new ArrayList<>());
	}
	
	public static Result create(final List<String> messages) {
		return new Result(messages);
	}
	
	public final boolean isValid() {
		return messages.isEmpty();
	}
	
	private final void setMessages(List<String> messages) {
		this.messages = UtilObject.getDefault(messages, new ArrayList<>());
	}
	
	public void addMessage(String message) {
		if(!UtilText.isEmpty(message)) {
			messages.add(UtilText.applyTrim(message));
		}
	}
	
	public void addMessages(List<String> message) {
		getMessages().addAll(UtilObject.getDefault(message, new ArrayList<>()));
	}
	
	public List<String> getMessages() {
		return messages;
	}
}
