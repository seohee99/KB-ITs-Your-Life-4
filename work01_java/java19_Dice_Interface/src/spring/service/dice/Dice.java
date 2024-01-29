package spring.service.dice;
// Dice A, Dice B, Dice C 클래스가 가지고 있는 핵심기능의 template
public interface Dice {
	void selectedNumber(); // public을 안붙이는 이유는 알아서 붙기 때문?
	int getValue();
}
