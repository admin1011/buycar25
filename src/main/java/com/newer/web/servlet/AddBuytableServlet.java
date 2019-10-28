package com.newer.web.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.newer.domain.Buytable;
import com.newer.service.BuytableService;
import org.apache.commons.beanutils.BeanUtils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.newer.domain.User;

import com.newer.util.JsonTypeAdapter;
import com.newer.util.MD5;

@WebServlet("/addbuytable")
public class AddBuytableServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private BuytableService buytableService;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddBuytableServlet() {
        super();
        buytableService=new BuytableService();
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String action=request.getParameter("action");
        System.out.print("111");
        if(action==null) {
            add(request,response);
        }

    }

    private void add(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Buytable buytable=new Buytable();
        System.out.print("123");
        try {
            //参数自动映射(这里不能自动映射）
            BeanUtils.populate(buytable, request.getParameterMap());
            int rows=buytableService.addBuytable(buytable);
            PrintWriter out=response.getWriter();
            out.print(rows);
            out.close();
        } catch (IllegalAccessException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        doGet(request, response);
    }

}