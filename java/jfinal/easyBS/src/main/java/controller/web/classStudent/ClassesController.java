package controller.web.classStudent;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import model.Classes;

import com.jfinal.core.ActionKey;
import com.jfinal.core.Controller;
import com.jfinal.plugin.activerecord.Page;

public class ClassesController extends Controller {

	/**
	 * 数据分页，默认使用全页面刷新
	 */
	public void index() {
		boolean isAjaxReq = false;
		isAjaxReq = getParaToBoolean("isAjax") == null ? false : true;

		int pageNumber = 1;
		int pageSize = 2;
		int totalpage;
		int totalRow;
		if (getParaToInt("pageNumber") != null) {
			pageNumber = getParaToInt("pageNumber");
		}
		try {
			Classes.dao.find("select * from classes limit 1");
		} catch (Exception e) {
			renderText("数据表classes不存在，存在的时候才会进行页面展示。");
			return;
		}
		Page<Classes> classes = Classes.dao.paginate(pageNumber, pageSize, "select * ",
				"from classes where claPeople >?", 0);
		totalpage = classes.getTotalPage();
		totalRow = classes.getTotalRow();

		Classes list = classes.getList().get(0);
		System.out.println(classes.getList());
		System.out.println(classes.getList().get(0));

		setAttr("pageNumber", pageNumber);
		setAttr("pageSize", pageSize);
		setAttr("totalpage", totalpage);
		setAttr("totalRow", totalRow);
		setAttr("list", classes.getList());

		if (!isAjaxReq) {
			render("/WEB-INF/classes/classesPage.jsp");
		} else {
			render("/WEB-INF/classes/classesPageAjax.jsp");
		}
	}

	/**
	 * ajax获取分页数据
	 */
	public void pageAjax() {
		Map<String, List> map = new LinkedHashMap<String, List>();
		int pageNumber = 1;
		int pageSize = 2;
		if (getParaToInt("pageNumber") != null) {
			pageNumber = getParaToInt("pageNumber");
		}
		Page<Classes> classes = Classes.dao.paginate(pageNumber, pageSize, "select * ",
				"from classes where claPeople >?", 0);

		map.put("list", classes.getList());
		// json.add("list", classes.getList().toString());
		System.out.println(map);
		renderJson(map);
	}

	@ActionKey("/actionKey")
	public void lo() {
		this.renderText("通过@ActionKey访问此方法");
		forwardAction("/classes/query");
		/*
		 * forwardAction只会后台处理，前台的URL不变，但是返回的内容是跳转之后的返回内容；redirect前台后台都会变，即前台重新请求
		 */
	}

	public void query() {
		String sql = "select * from classes";
		try {
			Classes.dao.find("select * from classes limit 1");
		} catch (Exception e) {
			renderText("数据表classes不存在，存在的时候才会进行页面展示。");
			return;
		}
		List<Classes> list = Classes.dao.find(sql);
		System.out.println(list);
		setAttr("list", list);
		render("/WEB-INF/classes/home.jsp");
	}

	public void add() {
		renderText("add()");
	}

	public void doadd() {
		int claID = getParaToInt("claID");
		String claName = getPara("claName");
		String claCharger = getPara("claCharger");
		int claPeople = getParaToInt("claPeople");
		Classes newClasses = new Classes();
		newClasses.set("claID", claID).set("claName", claName).set("claCharger", claCharger).set("claPeople", claPeople)
				.save();
		/*
		 * new Classes().set("claID", claID).set("claName", claName)
		 * .set("claCharger", claCharger).save();
		 */
		redirect("/classes/query");
	}

	public void detail() {
		int id = getParaToInt("claID");
		String sql = "select * from classes where claID = '" + id + "'";
		/*
		 * 方式一：使用model类获取属性值 在jsp中直接使用classes.claCharger的方式获取属性值
		 */
		Classes classes = Classes.dao.findFirst(sql);
		setAttr("classes", classes);

		/* 方式二：使用getStr获取属性值 */
		String claCharger = classes.getStr("claCharger");
		int claPeople = classes.getInt("claPeople");
		setAttr("claCharger", claCharger);
		setAttr("claPeople", claPeople);

		/* 方式三：使用findByID获取属性值 */
		Classes classes3 = Classes.dao.findById(id, "claCharger,claPeople");
		setAttr("classes3", classes3);

		System.out.println(classes);
		// System.out.println(classes.get("claCharger"));
		System.out.println(classes3.getStr("claCharger"));
		// renderText("detail()");
		render("/WEB-INF/classes/detail.jsp");
	}

	public void edit() {
		int claID = getParaToInt("claID");
		String claName = getPara("claName");
		String claCharger = getPara("claCharger");
		int claPeople = getParaToInt("claPeople");
		/* 使用set不仅能添加，还能修改 */
		Classes classes = Classes.dao.findById(claID);
		classes.set("claName", claName).set("claCharger", claCharger).set("claPeople", claPeople);
		classes.update();

		redirect("/classes/query");
		// renderText("edit()");
	}

	public void delete() {
		int claID = getParaToInt("claID");
		Classes.dao.deleteById(claID);/* 必须在config中配置好数据库的主键 */
		redirect("/classes/query");
	}
}
