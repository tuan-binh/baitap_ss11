package com.example.bai_3;

import com.example.bai_3.database.DBUtils;
import com.example.bai_3.model.Dept;

import java.io.*;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // Truy vấn dữ liệu từ DB (Mô phỏng).
        List<Dept> list = DBUtils.queryDepartments();

        // Lưu dữ liệu vào thuộc tính 'departments' của request.
        request.setAttribute("departments", list);

        // Tạo đối tượng RequestDispatcher
        // để Forward (chuyển tiếp) yêu cầu tới jstl_core_example01.jsp

        request.getRequestDispatcher("/jsps/jstl_example.jsp").forward(request, response);
        ;

        // Forward (Chuyển tiếp) yêu cầu, để hiển thị dữ liệu trên trang JSP.

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}