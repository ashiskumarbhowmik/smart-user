<%-- 
    Document   : organizationList
    Created on : Jul 22, 2010, 2:43:43 PM
    Author     : russel
--%>

<%@page import="java.util.Collection"%>
<%@page import="com.smartitengineering.user.domain.Organization"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
 

<html>
    <head>
       
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link type="text/css" rel="stylesheet" href="/css/organizationlist.css">
        <link type="text/javascript"  href="/script/js_1.js"/>
        <link type="text/javascript" href="/css/jquery-1.4.2.js"/>
        <title>            
            Organizations  
        </title>
        
                
       
        

    </head>
    <body>

        <div class="show" id="showList" style="width: 80%;position: relative;clear: left">
                    <div style="background-color: #77e445">
                        <h1 id="header" >Organization</h1>
                    </div>

                    <div style="text-decoration: underline;border-color: #13200d">

                    <div id="tableheadid">
                     <h4> ID</h4>
                    </div>

                     <div class="tableheadname">
                    <h4>Organization name</h4>
                    </div>

                    <div class="tableheadname">
                    <h4>Organization</h4>
                    </div>


                    <div class="tableheadlink">
                    <h4>Edit</h4>
                    </div>

                    <div class="tableheadlink">
                    <h4> Delete</h4>
                    </div>

                    </div>





                    <c:forEach var="organization" items="${it}">
                     <div>
                      <div id="teblecontentid">
                          <h4><c:out value="${organization.id}" /></h4>
                      </div>

                      <div class="teblecontentname">
                          <h4><c:out value="${organization.name}" /></h4>

                      </div>
                      <div class="teblecontentname">
                          <h4><c:out value="${organization.uniqueShortName}"/></h4>
                          <c:set value="${organization.uniqueShortName}" var="uniqueName"></c:set>

                      </div>

                      <div class="teblecontentlink">
                          <a href="orgs/shortname/${organization.uniqueShortName}" ><h4>Edit</h4></a>
                      </div>
                      <form method="POST" onclick="OnclickActive()">
                      <div class="teblecontentlink">
                          <h4><a href="#">Delete</a></h4>s

                      </div>
                      </form>
                      


                      </div>
                    </c:forEach>
           
        </div>


        
    </body>
</html>
