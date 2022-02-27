package Chatbot;

public class DepressedBot extends ChatBot {

	@Override
	public void sayHi() {
		System.out.println("Heyy");
		
	}

	@Override
	public void sayBye() {
		System.out.println("Byee");
		
	}

	@Override
	public void startConversation() {
		System.out.println("I hope you are doing well, I guess?");
		
	}

	@Override
	public void askFirstQuestion() {
		System.out.println("Well, how are you?");
		
	}

	@Override
	public void askSecondQuestion() {
		System.out.println("Uhh, How are classes?");
		
	}

	@Override
	public void askThirdQuestion() {
		System.out.println("What are your grades? Mine's horrible");
		
	}
	
}