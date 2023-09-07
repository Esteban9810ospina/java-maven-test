<%@page import="com.vaadin.server.VaadinSession"%>
<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="e" uri="https://www.owasp.org/index.php/OWASP_Java_Encoder_Project" %>
<%@page import="com.framework.common.web.security.MyCaptchaImpl" %>
<%@page import="com.framework.common.ui.util.security.VerificaFormulario" %>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Inicio de sesión | Sistema de Ofertas Publicas de Adquisición</title>
    <!--<link rel="stylesheet" type="text/css" href="/emisiones/VAADIN/themes/framework/styles.css">-->
  <link href="../VAADIN/themes/framework/styles.css" rel="stylesheet" type="text/css">
  <c:set var="context" value="${pageContext.request.contextPath}" />
  <script type="text/javascript" src="${context}/VAADIN/javascript/libs/jquery-3.6.1.min.js"></script>
  <script type="text/javascript" src="${context}/VAADIN/javascript/framework_login.js"></script>
  <script src='https://www.google.com/recaptcha/api.js' async defer></script>
  </head>
  <%
      if (request != null) {
          VerificaFormulario a = new VerificaFormulario(request);
          if (!(a.verificaCampos())) {
            if (!session.isNew()) {
                //session.invalidate();
            }
            out.println("<script>document.location.href='./SecurityError.jsp'</script>");
          }
       }
   %>
<body id="login_page">
  
<div id="main" class="clearfix">
  <div id="headbanner"></div>
  <div id="contenido">
    <div id="cajalo">
      <div id="login_box_wrapper">
    <div id="login_box">
      <form action="/opa/j_security_check" method="post">
        <div class="field-wrapper">
            <img src="../VAADIN/themes/framework/img/User.png" style="float:left"/>
          <input type="text" oninput="this.value = this.value.replace(/[^A-Za-z0-9]/g, '').replace(/(\..*?)\..*/g, '$1');" id="username" name="j_username" autocomplete="off" placeholder="Usuario" class="field-value" />
        </div>
        <div class="field-wrapper">
            <img src="../VAADIN/themes/framework/img/Pass.png" style="float:left"/>
          <input id="password" type="password" name="j_password" placeholder="Contraseña" autocomplete="off" class="field-value" />
        </div>
        <div class="field-wrapper captcha-wrapper">
          <% out.print(new MyCaptchaImpl().generateCaptchaHtml()); %>
        </div>  
          <c:if test="${not empty param.error}">
          <c:choose>
            <c:when test="${param['error'] eq 'wrong'}">
              <c:set var="message" value="Usuario o contraseña no válidos." />
            </c:when>
            <c:when test="${param['error'] eq 'status'}">
                <c:set var="message" value="Sistema no disponible." />
            </c:when>  
              <c:when test="${param['error'] eq 'inactivo'}">
                  <c:set var="message" value="Solo usuarios autorizados pueden acceder al sistema." />
              </c:when>  
            <c:when test="${param['error'] eq 'ip'}">
              <c:set var="message" value="Está intentando ingresar desde un equipo no registrado."/>
            </c:when>
            <c:when test="${param['error'] eq 'locked'}">
              <c:set var="message" value="El usuario se encuentra bloqueado." />
            </c:when>
            <c:when test="${param['error'] eq 'expired'}">
              <c:set var="message" value="La sesión expiró por inactividad, por favor volver a iniciar sesión." />
              <%
              session.setAttribute("entro", 0);
          //   session.invalidate();
              %>
            </c:when>
            <c:when test="${param['error'] eq 'closeSession'}">
              <c:set var="message" value="La sesión finalizó correctamente." />
            </c:when>
            <c:when test="${param['error'] eq 'technical'}">
              <c:set var="message" value="Ha ocurrido un error técnico, por favor contactar al administrador del sistema." />
            </c:when>
             <c:when test="${param['error'] eq 'captchavacio'}">
              <c:set var="message" value="Todos los campos en pantalla son requeridos." />
            </c:when>
              <c:when test="${param['error'] eq 'captchanotfound'}">
              <c:set var="message" value="El campo reCAPTCHA es obligatorio." />
              </c:when>
          </c:choose>
          <span class="${e:forHtml(param.error)} response-message field-wrapper">
            <c:out value="${message}" />
          </span>
        </c:if>
        <div class="form-buttons">  
            <input type="submit" onclick="" alt="Acceder" width="120" height="43" id="Acceder" value="Ingresar" class="btningresar"></input> 
        </div>
      </form>
    </div>
  </div>
</div>
  </div>
    <div class="version">
        Version 1.0
    </div>
</div>


</body>
</html>
