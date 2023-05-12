package co.edu.uco.publiuco.api.validator;

import java.util.ArrayList;
import java.util.List;

import co.edu.uco.publiuco.crosscutting.utils.UtilObject;
import co.edu.uco.publiuco.crosscutting.utils.UtilText;

public final class Result {
	private List<String> messages;
	
	public Result(final List<String> messages) {
		setMessages(messages);
	}
	
	public static Result createValid() {
		return new Result(new ArrayList<>());
	}
	
	public static Result createInValid(final List<String> messages) {
		return new Result(messages);
	}
	
	public void addMessage(String message) {
		if(!UtilText.getUtilText().isEmpty(messages))
		messages.add(UtilText.getUtilText().applyTrim(message));
	}

	public final void setMessages(List<String> messages) {
		this.messages = UtilObject.getDefault(messages, new ArrayList<>());
	}
	
}
