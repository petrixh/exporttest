package org.vaadin.petri;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"/example"})
public class MainAppServlet extends HttpServlet {

    //private static String VAADIN_CONTEXT_PATH = "";

    //If the admin app (vaadin part) is on a different context path instead of root (see application.properties)...
    private static String VAADIN_CONTEXT_PATH = "/admin-app";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        //For this demo, will never be authenticated...
        Object authToken = req.getSession().getAttribute("auth_token");
        boolean isAuthenticated = authToken != null;



        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html><head>");
            out.println("<meta http-equiv='Content-Type' content='text/html; "
                    + "charset=UTF-8'>");

            if (!isAuthenticated) {
                out.println("<script type='text/javascript' "
                        + "src='"+VAADIN_CONTEXT_PATH+"/VAADIN/build/webcomponentsjs/"
                        + "webcomponents-loader.js'></script>");
                out.println("<script type='module' src='"+VAADIN_CONTEXT_PATH+"/web-component"
                        + "/export-form.js'></script>");
//                out.println("<script type='text/javascript' "
//                        + "src='/log-in.js' defer></script>");
            }
            out.println("</head><body>");
            if (isAuthenticated) {
                out.println("<h1>Welcome "
//                        + UserService.getInstance().getName(authToken)
                        + "</h1>");
            } else {
                out.println("<div>Exported form below: </div>");
                out.println("<export-form>"
                        + "</export-form>");
            }
            out.println("</body>");
            out.println("</html>");
        }
    }
}