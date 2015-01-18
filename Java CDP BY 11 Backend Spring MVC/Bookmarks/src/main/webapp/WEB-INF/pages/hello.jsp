<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

    <html>
    <body>
        <h1>${message}</h1>

       <c:set var="contextPath" value="${pageContext.request.contextPath}" />
       <a href="${context}/example">Go to "HI" page</a>

        <table>
            <tr>
                <td>
                    <ul>
                        <li>
                            <form action="/add" method="post">
                                <p>
                                    <input type="submit" value="Add new bookmark" />
                                </p>
                            </form>
                        </li>
                    </ul>
                </td>
                <td>
                    <table>
                        <tr>
                            <th><br>id_bookmark</th>
                            <th><br>item</th>
                            <th><br>tag_id</th>
                            <th><br>url</th>
                        </tr>
                   <c:forEach var="item" items="${bookmarkList}">
                       <tr>
                           <td><c:out value="${item.id_bookmark}" /></td>
                           <td><c:out value="${item.title}" /></td>
                           <td><c:out value="${item.tag_id.tagname}" /></td>
                           <td><c:out value="${item.url}" /></td>
                           <td><c:out value="${item.user.last_name}" /></td>
                           <td>
                               <sf:form action="${pageContext.request.contextPath}/delete" modelAttribute="bookmark" method="post">
                                   <fieldset>
                                       <sf:hidden value="${item.id_bookmark}" path="id_bookmark" />
                                       <sf:hidden value="${item.title}" path="title" />
                                       <sf:hidden value="${item.url}" path="url" />
                                       <sf:hidden valule="${item.user}" path="user" />
                                       <sf:hidden value="${item.tag_id}" path="tag_id" />
                                       <input type="submit" value="Delete">
                                   </fieldset>
                               </sf:form>
                           </td>
                           <td>
                               <sf:form action="${pageContext.request.contextPath}/edit" modelAttribute="bookmark" method="post">
                                    <fieldset>
                                        <sf:hidden value="${item.id_bookmark}" path="id_bookmark" />
                                        <sf:hidden valule="${item.user}" path="user" />
                                        <sf:hidden value="${item.tag_id}" path="tag_id" />
                                        <sf:hidden value="${item.title}" path="title" />
                                        <sf:hidden value="${item.url}" path="url" />
                                        <input type="submit" value="Edit" />
                                    </fieldset>
                               </sf:form>
                           </td>

                       </tr>
                   </c:forEach>
                   </table>
                </td>
            </tr>

        </table>

    </body>
    </html>

