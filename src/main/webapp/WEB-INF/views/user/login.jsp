<%@ include file="../layout/header.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<body>
<style>
    body {
        /*display: flex;*/
        justify-content: center;
        align-items: baseline;
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
    .flex-container {
        display: flex;
        justify-content: center;
        align-items: center;
        min-height: 100vh;
    }
    .form-container {
        background: #fff;
        padding: 20px;
        border-radius: 8px;
        box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
    }
</style>
<div class="flex-container">
    <div class="form-container">
        <h1 class="text-center">Login</h1>
        <p class="text-center text-muted">Sign in to your account</p>
        <form method="POST" action="/loginProc">
            <div class="form-group">
                <label for="email">Email</label>
                <input type="email" class="form-control" id="email" placeholder="m@example.com" name="email" required>
            </div>
            <div class="form-group">
                <label for="password">Password</label>
                <input type="password" class="form-control" id="password" placeholder="Password" name="password" required>
            </div>
            <button type="submit" class="btn btn-primary" style="background: #ff69b4">Login</button>
            <a href="#" class="forgot-password" style="color: black">Forgot your password?</a>
        </form>

    </div>
</div>
</body>
</html>
