package com.pge.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pge.beans.Fichier;
import com.pge.forms.UploadForm;

@SuppressWarnings( "serial" )
public class Upload extends HttpServlet {
    private final static String VUE         = "/WEB-INF/upload.jsp";
    private final static String ATT_FORM    = "form";
    private final static String ATT_FICHIER = "fichier";

    public final static String  CHEMIN      = "chemin";

    // Méthode doGet pour l'affichage de la page
    public void doGet( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {
        this.getServletContext().getRequestDispatcher( VUE ).forward( request, response );
    }

    // Méthode doPost pour le traitement des données du formulaire
    public void doPost( HttpServletRequest request, HttpServletResponse response )
            throws ServletException, IOException {

        /* Récupération du chemin via le paramètre d'initialisation */
        String chemin = this.getServletConfig().getInitParameter( CHEMIN );

        /*
         * Initialisation du formulaire en lui passant la request
         */
        UploadForm form = new UploadForm();

        /*
         * Traitement de la requête et récupération du fichier
         */
        Fichier fichier = form.enregistrerFichier( request, chemin );

        /*
         * Stockage du formulaire et du fichier dans la requête
         */
        request.setAttribute( ATT_FORM, form );
        request.setAttribute( ATT_FICHIER, fichier );

        /*
         * Forward vers la vue formulaire
         */
        this.getServletContext().getRequestDispatcher( VUE ).forward( request, response );
    }
}
