package com.zx.servlet;


import com.zx.domain.FlowerSystem;
import com.zx.mapper.FlowerSystemMapper;
import com.zx.service.FlowerService;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/zx/flowerServlet")
public class FlowerServlet extends HttpServlet{
    private FlowerService flowerService;

    @Override
    public void init() throws ServletException {
        ApplicationContext app = WebApplicationContextUtils.getWebApplicationContext(getServletContext());
        // 这里为什么要用service而不是用impl？？
        flowerService = app.getBean("flowers", FlowerService.class);
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<FlowerSystem> list = flowerService.findAll();
        resp.getWriter().print(list);
    }

}
