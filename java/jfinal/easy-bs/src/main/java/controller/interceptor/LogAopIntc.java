package controller.interceptor;

import com.jfinal.aop.Interceptor;
import com.jfinal.aop.Invocation;
import com.jfinal.core.Controller;

import java.lang.reflect.Method;

/**记录后台请求数据
 * Created by dell on 2017/7/22.
 */
public class LogAopIntc implements Interceptor {
    @Override
    public void intercept(Invocation invocation) {
        invocation.invoke();
        // 记录各种数据
        Controller controller = invocation.getController();
        Method method = invocation.getMethod();
        System.err.print("访问信息： "+method.getName());
        System.err.println("  isAjax参数：" + controller.getPara("isAjax"));
    }
}
