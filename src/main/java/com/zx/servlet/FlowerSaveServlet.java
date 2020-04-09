package com.zx.servlet;

import com.zx.domain.FlowerSystem;
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

@WebServlet("/zx/flowerSaveServlet")
public class FlowerSaveServlet extends HttpServlet {
    private FlowerService flowerService;

    @Override
    public void init() throws ServletException {
        ApplicationContext app = WebApplicationContextUtils.getWebApplicationContext(getServletContext());
        flowerService = app.getBean("flowers", FlowerService.class);
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 接受来自jsp的数据，构成flowerSystem对象
        String name = req.getParameter("name");
        double price = Double.parseDouble(req.getParameter("price"));
        String production = req.getParameter("production");

        FlowerSystem record = new FlowerSystem(0, name, price, production);

        int save = flowerService.save(record);

        if(save>1){
            resp.sendRedirect(req.getContextPath()+"/zx/flowerServlet");
        }else{
            req.setAttribute("msg", "failed");
            req.getRequestDispatcher("/save.jsp").forward(req,resp);
        }
    }
}
