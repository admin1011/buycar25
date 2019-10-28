package com.newer.web.servlet;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.newer.domain.Buytable;
import com.newer.service.BuytableService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/buytables")
public class BuytableServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private BuytableService buytableService;
    @Override
    public void init() throws ServletException {
        buytableService=new BuytableService();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action=req.getParameter("action");
        PrintWriter out=resp.getWriter();
        if("findAll".equals(action)){
            List<Buytable> list=buytableService.findAllBuytable();
            Gson gson=new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
            out.print(gson.toJson(list));
            out.close();
        }
        out.close();
    }
}
