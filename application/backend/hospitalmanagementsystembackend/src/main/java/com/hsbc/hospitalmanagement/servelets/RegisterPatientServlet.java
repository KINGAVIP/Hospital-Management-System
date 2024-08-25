package com.hsbc.hospitalmanagement.servelets;

import com.hsbc.hospitalmanagement.dao.PatientDAOImpl;
import com.hsbc.hospitalmanagement.domain.Patient;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/registerPatient")
public class RegisterPatientServlet extends HttpServlet {
    private PatientDAOImpl patientDAO = new PatientDAOImpl();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String id = request.getParameter("patient-id");
        String name = request.getParameter("patient-name");
        String phoneNumber = request.getParameter("patient-phone");
        String address = request.getParameter("patient-address");
        String insurance = request.getParameter("patient-insurance");
        String username = request.getParameter("patient-username");
        String password = request.getParameter("patient-password");

        Patient patient = new Patient(id, name, phoneNumber, address, insurance, username, password);

        try {
            patientDAO.registerPatient(patient);
            response.sendRedirect("success.jsp");  // Redirect to a success page or handle accordingly
        } catch (SQLException e) {
            throw new ServletException("Database error when registering patient", e);
        }
    }
}
