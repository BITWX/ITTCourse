/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets.principal;

import app.utils.Constantes;
import dao.principal.Main_Principal_DAO;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import managedbean.principal.Curso_MB;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.util.JRLoader;

/**
 *
 * @author diego
 */
public class Main_Principal_Srv extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        List<Curso_MB> cursos = Main_Principal_DAO.getCursos();
        request.setAttribute(Constantes.ATTR_LISTA_CURSOS, cursos);
        RequestDispatcher dis = request.getRequestDispatcher(Constantes.PATH_MAIN);
        dis.forward(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        List<Curso_MB> cursos = Main_Principal_DAO.getData(request.getParameterNames());
        String pathReport = request.getServletContext().getRealPath("/WEB-INF/reports/report_cursos.jasper");
        File jasperFile = new File(pathReport);
        JRDataSource data = new JRBeanCollectionDataSource(cursos);
        JasperReport jasperObject;
        try {
            jasperObject = (JasperReport) JRLoader.loadObject(jasperFile);
            JasperPrint print = JasperFillManager.fillReport(jasperObject, null, data);
            response.setContentType("application/pdf");
            response.setHeader("Content-disposition", "inline;filename=\"archivo.pdf\"");
            JasperExportManager.exportReportToPdfStream(print, response.getOutputStream());
            response.getOutputStream().flush();
            response.getOutputStream().close();

        } catch (JRException ex) {

        }

    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
