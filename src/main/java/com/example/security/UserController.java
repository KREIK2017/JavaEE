package com.example.security;

import jakarta.annotation.security.DeclareRoles;
import jakarta.annotation.security.RolesAllowed;
import jakarta.ejb.Stateless;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Named;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;

@Named
@Stateless
@DeclareRoles({"admin", "user"})
public class UserController {

    @RolesAllowed("admin")
    public String executeAdminAction() {
        return "Admin action performed!";
    }

    @RolesAllowed("user")
    public String executeUserAction() {
        return "User action performed!";
    }

    public String logout() {
        FacesContext context = FacesContext.getCurrentInstance();
        HttpServletRequest request = (HttpServletRequest) context.getExternalContext().getRequest();
        try {
            request.logout(); // Завершення сесії
            context.getExternalContext().invalidateSession();
            return "/login.xhtml?faces-redirect=true"; // Повернення до сторінки входу
        } catch (ServletException e) {
            e.printStackTrace();
            return null;
        }
    }
}
