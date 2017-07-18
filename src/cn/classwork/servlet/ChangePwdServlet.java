package cn.classwork.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.classwork.base.BaseServlet;
import cn.classwork.entity.User;
import cn.classwork.util.JsonMsgUtils;
/**
 * 修改密码
 * @Title: ChangePwdServlet.java
 * @Package cn.classwork.servlet
 * @author lonecloud
 * @date 2017年7月18日 下午9:27:09
 * @version V1.0
 */
@WebServlet("/changePwd")
public class ChangePwdServlet extends BaseServlet{
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String oldPwd=req.getParameter("oldPwd");
		String repasswd=req.getParameter("repasswd");
		String confirm=req.getParameter("confirm");
		Object obj = req.getSession().getAttribute("user");
		if (obj!=null) {
			User user=(User)obj;
			if (!user.getPassword().equals(oldPwd)) {
				JsonMsgUtils.errorMsg("原密码错误", resp);
			}else{
				if (oldPwd!=null&&repasswd!=null&&repasswd.equals(confirm)) {
					userService.updatePwd(repasswd);
					JsonMsgUtils.successMsg("密码修改成功", resp);
				}
			}
		}

	}

}
