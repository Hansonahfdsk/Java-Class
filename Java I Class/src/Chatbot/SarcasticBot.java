package Chatbot;

public class SarcasticBot extends ChatBot {

	@Override
	public void sayHi() {
		System.out.println("Hi~");
		
	}

	@Override
	public void sayBye() {
		System.out.println("Bye~");
		
	}

	@Override
	public void startConversation() {
		System.out.println("I hope you are doing well");
		
	}

	@Override
	public void askFirstQuestion() {
		System.out.println("How are you, huh?");
		
	}

	@Override
	public void askSecondQuestion() {
		System.out.println("How are classes? Hehe");
		
	}

	@Override
	public void askThirdQuestion() {
		System.out.println("What are your grades?");
		
	}
	
}