package com.quasar.frameq.util;

// Copyright © 2001 by Apple Computer, Inc., All Rights Reserved.
//
// You may incorporate this Apple sample code into your own code
// without restriction. This Apple sample code has been provided "AS IS"
// and the responsibility for its operation is yours. You may redistribute
// this code, but you are not permitted to redistribute it as
// "Apple sample code" after having made changes.

import java.io.IOException;
import java.io.PrintWriter;
import java.net.UnknownHostException;
import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class mail extends HttpServlet {

    public void doPost(HttpServletRequest request,
                       HttpServletResponse response)
        throws   UnknownHostException
    {   
        PrintWriter writer = null;
        try {
        writer = response.getWriter();
        response.setContentType("text/html");
        writer.println("<html><head><title>Mail Example</title></head>");
        writer.println("<body bgcolor=\"white\">");
        writer.println("<h1>Mail Example</h1>");

       
        } catch (UnknownHostException uhex) {
            
        }catch(Exception e){
            
        }
         ///////// set this variable to be your SMTP host


        ///////// set this variable to be your desired email recipient

        // these variables come from the mail form

        String from = request.getParameter("from");
        String subject = request.getParameter("subject");
        String body = request.getParameter("body");

        if ((from != null) && ("" != null) && (subject != null)  && (body != null)) // we have mail to send
        {

        try {

            //Get system properties
            Properties props = System.getProperties();

            //Specify the desired SMTP server
            props.put("mail.smtp.host", "");

            // create a new Session object
            Session session = Session.getInstance(props,null);

            // create a new MimeMessage object (using the Session created above)
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(from));
            message.setRecipients(Message.RecipientType.TO, new InternetAddress[] { new InternetAddress("") });
            message.setSubject(subject);
            message.setContent(body, "text/html");

            Transport.send(message);

            // it worked!
            writer.println("<b>Thank you.  Your message to " + "" + " was successfully sent.</b>");

        } catch (Throwable t) {

            writer.println("<b>Unable to send message: <br><pre>");
            t.printStackTrace(writer);
            writer.println("</pre></b>");
        }


        }
        else
        {
            // no mail to send. print a blank mail form
            writer.println("<form action=\"\" method=\"POST\">");
            writer.println("<table border=\"0\">");
            writer.println("<tr><td>Message From: </td><td><input type=\"text\" name=\"from\"></td></tr>");
            writer.println("<tr><td>Subject: </td><td><input type=\"text\" name=\"subject\"></td></tr>");
            writer.println("<tr><td valign=\"top\">Message: </td><td><textarea name=\"body\" rows=\"10\" cols\"40\"></textarea></td></tr>");
            writer.println("<tr><td colspan=\"2\" align=\"center\"><input type=\"submit\" value=\"Send\"></td></tr>");
            writer.println("</table>");
            writer.println("</form>");
        }


        writer.println("</body>");
        writer.println("</html>");

    }

    public void doGet(HttpServletRequest request,
                       HttpServletResponse response)
        throws   UnknownHostException
    {       
        try{
            doPost(request, response);
        }catch(UnknownHostException ex){
            
        }
    }
}
