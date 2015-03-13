<?xml version="1.0" encoding="UTF-8"?>
<!-- 
    Document   : test-jsp
    Created on : Mar 9, 2015, 2:57:16 PM
    Author     : M6500
-->
<jsp:root xmlns:jsp="http://java.sun.com/JSP/Page"
          xmlns:c="http://java.sun.com/jsp/jstl/core" version="2.0">

    <jsp:directive.page contentType="text/html" pageEncoding="UTF-8"/>

    <!-- any content can be specified here, e.g.: -->
    <jsp:element name="text">
        <jsp:attribute name="lang">EN</jsp:attribute>
        <jsp:body>
            Login Compleat <br/>
            Username = ${sessionScope['username']}
        </jsp:body>
    </jsp:element>

</jsp:root>
