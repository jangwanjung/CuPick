<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<sec:authorize access="isAuthenticated()">
    <sec:authentication property="principal" var="principal"/>
</sec:authorize>
<html lang="en">
<head>

    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>CuPick</title>
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
    <link href="styles.css" rel="stylesheet">
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.4/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
    <style>
        body {
            background-color: #fff1f1;
        }

        .text-pink {
            color: #ff69b4;
        }

        .bg-light-pink {
            background-color: #fff1f1;
        }

        .btn-pink {
            background-color: #ff69b4;
            border-color: #ff69b4;
        }

        .btn-pink:hover {
            background-color: #ff4081;
            border-color: #ff4081;
        }

        .avatar {
            width: 32px;
            height: 32px;
            line-height: 32px;
            font-size: 14px;
        }
    </style>
    <header class="bg-white shadow-sm py-3">
        <div class="container d-flex justify-content-between align-items-center">
            <a class="d-flex align-items-center text-decoration-none" href="/">
                <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round" class="text-pink mr-2">
                    <path d="M19 14c1.49-1.46 3-3.21 3-5.5A5.5 5.5 0 0 0 16.5 3c-1.76 0-3 .5-4.5 2-1.5-1.5-2.74-2-4.5-2A5.5 5.5 0 0 0 2 8.5c0 2.3 1.5 4.05 3 5.5l7 7Z"></path>
                </svg>
                <span class="h4 font-weight-bold text-pink">CuPick</span>
            </a>
            <c:if test="${empty principal}">
                <div>
                    <a class="text-pink font-weight-medium mr-3" href="/login">Login</a>
                    <button type="button" class="btn" style="background: #ff69b4" onclick="location.href='/join'">Join Now</button>
                </div>
            </c:if>
            <c:if test="${not empty principal}">
                <div>
                    <button type="button" class="btn" style="background: #fff1f1" onclick="location.href='/user/update'">정보수정</button>
                    <button type="button" class="btn" style="background: #ff69b4" onclick="location.href='/logout'">Log Out</button>
                </div>
            </c:if>
        </div>
    </header>

</head>


