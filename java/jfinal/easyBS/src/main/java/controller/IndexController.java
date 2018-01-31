package controller;

import com.jfinal.core.Controller;

public class IndexController extends Controller {

	public void index() {
		this.render("/index.jsp");
	}

	public void login() {
		renderText("来自IndexController.login()，并没有实现。");
	}

}
