package com.newer.web.servlet;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.newer.domain.Motorcycle;
import com.newer.service.MotorService;
import com.newer.util.JsonTypeAdapter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.List;

@WebServlet("/motorcycles")
public class MotorServlet extends HttpServlet {
    private MotorService motorService;

    @Override
    public void init() throws ServletException {
        motorService=new MotorService();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
      String action=req.getParameter("action");
        PrintWriter out=resp.getWriter();

      if(action==null){
          List<Motorcycle> motorcycles=motorService.findAll();
          Gson gson=new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
          out.print(gson.toJson(motorcycles));
          out.close();
      }
      out.close();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req,resp);
    }
}
