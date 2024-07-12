<%@ include file="../layout/header.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<body>
<style>
    body {
        display: flex;
        justify-content: center;
        align-items: center;
        height: 100vh;
        background-color: #FDF1F1; /* 배경색을 흰색으로 설정 */
    }
    .form-container {
        max-width: 400px;
        width: 100%;
    }
    .form-container h1 {
        font-size: 24px;
        margin-bottom: 20px;
        font-weight: 700; /* 글씨체를 더 두껍게 설정 */
    }
    .form-container .form-group {
        margin-bottom: 15px;
    }
    .form-container .btn {
        width: 100%;
    }
    .form-container .forgot-password {
        display: block;
        text-align: center;
        margin-top: 10px;
    }
</style>
<div class="form-container">
    <h1 class="text-center">CuPick</h1>
    <p class="text-center text-muted">Sign in to your account</p>
    <form>
        <div class="form-group">
            <label for="email">Email</label>
            <input type="email" class="form-control" id="email" placeholder="m@example.com">
        </div>
        <div class="form-group">
            <label for="password">Password</label>
            <input type="password" class="form-control" id="password" placeholder="Password">
        </div>
        <button type="submit" class="btn btn-dark" style="background: #ff69b4">Login</button>
        <a href="#" class="forgot-password" style="color: black">Forgot your password?</a>
    </form>
</div>
</body>
</html>
