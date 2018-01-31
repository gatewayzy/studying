package controller.web.useless;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.jfinal.core.Controller;
import com.jfinal.plugin.activerecord.Db;
import com.jfinal.plugin.activerecord.Record;

/**疾病分类标注
 * @author dell
 *
 */
public class DisLabel20161209 extends Controller {

	public void index() {
		String sql1 = "SELECT id,category_1 cate1,category_2 cate2 FROM `qa_dis_dic_code` where id<26";
		String sql2 = "SELECT id,category_1 cate1,category_2 cate2 FROM `qa_dis_dic_code` where id>=26";
		List<Record> cates1 = Db.find(sql1);
		setAttr("cates1", cates1);
		List<Record> cates2 = Db.find(sql2);
		setAttr("cates2", cates2);

		int tagId = 0;
		String sql = "SELECT tag_id tagId,tag_name tagName FROM `qa_tag` where tag_id > ? and tag_dic_id1 is null limit 1";
		Record tag = Db.findFirst(sql, tagId);
		setAttr("tag", tag);

		render("/WEB-INF/views/disLabel/label.jsp");
	}

	public void login() {
		renderText("IndexController.login()");
	}

	/**
	 * 标注
	 */
	public void saveLabel() {
		int tagId = getParaToInt("tagId");
		int cateId = getParaToInt("cateId");
		if (cateId > 0) {
			String sql1 = "update qa_tag set tag_dic_id1 = ? where tag_id=?";
			Db.update(sql1, cateId, tagId);
		}
		String sql2 = "SELECT tag_id tagId,tag_name tagName FROM `qa_tag` where tag_id > ? limit 1";
		if (cateId == 0) {
			tagId = tagId > 2 ? tagId - 1 : 1;
			sql2 = "SELECT tag_id tagId,tag_name tagName FROM `qa_tag` where tag_id >= ? limit 1";
		}
		Record tag = Db.findFirst(sql2, tagId);
		Map<String, Object> ret = new HashMap<>();
		ret.put("ret", tag);
		renderJson(ret);
	}

}
