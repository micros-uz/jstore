package uz.micros;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;

@WebServlet(value="/HelloWorld", name="HelloWorld")
public class HelloWorldServlet extends GenericServlet{
    private static final Long serialVersionUID = 1L;

    @Override
    public void service(ServletRequest servletRequest,
                        ServletResponse servletResponse) throws ServletException, IOException {

        servletResponse.getWriter().println("Hello Wrold!!");
    }
}