package controller.web;

import com.jfinal.core.Controller;

public class StudentController extends Controller{
	public void index() {
		this.renderText("StudentController.index()");
	}

}