package web.client;

import java.util.Scanner;

import web.controller.Controller;
import web.factory.ControllerFactory;

/*
 * 나중에 servlet 역할
 * FrontController가 된다.
 */
public class FrontController {

	public static void main(String[] args) {
		// 브라우저 폼에서 받은 값을
		Scanner sc = new Scanner(System.in);
		
		String command = sc.next();
		
		// 인자값(command)에 따라 다른 Controller 생성
		Controller controller = ControllerFactory.getInstance().createController(command);
		controller.handleRequest();
	}

}
