package com.newer.web.servlet;

import com.google.gson.JsonObject;
import com.newer.domain.User;
import com.newer.service.UserService;
import com.newer.util.MD5;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/users")
public class UserServlet extends HttpServlet {
    private UserService userService;

    @Override
    public void init() throws ServletException {
        userService=new UserService();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action == null) {
            //登录验证
            login(req, resp);
        } else if ("changePwd".equals(action)) {
            //修改密码
            updatePwd(req, resp);
        }
    }

    private void updatePwd(HttpServletRequest req, HttpServletResponse resp) throws IOException{
        //密码转码
        String pwd = MD5.getInstance().getMD5ofStr(req.getParameter("password"));
        String pwd1 = MD5.getInstance().getMD5ofStr(req.getParameter("password1"));

        HttpSession session = req.getSession();
        JsonObject jo = new JsonObject();
        PrintWriter out = resp.getWriter();

        //获取session里的用户
        User user = (User) session.getAttribute("loginer");

        //如果输入的原始密码正确，则根据用户ID修改密码
        if (user.getPwd().equals(pwd)) {
            int count = userService.updatePwd(user.getUid(), pwd1);
            if (count > 0) {
                jo.addProperty("changed", true);

                // 更新session中的保存的用户密码
                user.setPwd(pwd1);
            } else {
                jo.addProperty("msg", "密码修改失败！");
            }

        } else {
            jo.addProperty("msg", "原密码错误！");
        }
        out.print(jo);
        out.close();
    }

    private void login(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String uname = req.getParameter("username");
        // 密码转码
        String password = MD5.getInstance().getMD5ofStr(req.getParameter("password"));
        String code = req.getParameter("code");

        JsonObject jo = new JsonObject();
        PrintWriter out = resp.getWriter();
        HttpSession session = req.getSession();
        String co = (String) session.getAttribute("code");
        User user = userService.findByUname(uname);

        //用户登录验证
        if (user == null) {
            jo.addProperty("msg", "用户名不存在！");
        } else if (!user.getPwd().equals(password)) {
            jo.addProperty("msg", "密码错误！");
        } else if (!co.equals(code)) {
            jo.addProperty("msg", "验证码错误！");
        }  else {
            session.setAttribute("loginer", user);
            jo.addProperty("suc", true);
        }
        out.print(jo);
        out.close();
    }
}
