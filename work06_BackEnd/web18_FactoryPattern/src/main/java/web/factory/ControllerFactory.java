package web.factory;
/*
 * Controller를 만드는 공장 ControllerFactory
 * 이곳에서 RegisterController, FindController, UpdateController, LoginController를 각각 생성한다.
 * ::
 *  4개의 Controller 생성 -> 하나의 Factory
 *  
 *  -> ControllerFactory 싱글톤 패턴으로 작성
 * 
 */


import web.controller.Controller;
import web.controller.FindController;
import web.controller.LoginController;
import web.controller.RegisterController;
import web.controller.UpdateController;

public class ControllerFactory {
	private static ControllerFactory factory = new ControllerFactory();
	private ControllerFactory() {
		System.out.println("Creating ControllerFactory");
	}
	public static ControllerFactory getInstance() {
		return factory;
	}
	
	// client의 요청에 따라서 서로 다른 Controller를 공장에서 생성해낸다
	public Controller createController(String command) {
		Controller controller = null;
		if(command.equals("register")) {
			controller = new RegisterController();
		}else if(command.equals("find")) {
			controller = new FindController();
		}else if(command.equals("update")) {
			controller = new UpdateController();
		}else if(command.equals("login")) {
			controller = new LoginController();
		}
		return controller;
	}
}
