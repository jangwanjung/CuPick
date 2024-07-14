<%@ include file="../layout/header.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<body>
<style>
    body {
        /*display: flex;*/
        justify-content: center;
        align-items: baseline ;
        height: 100vh;
        background-color: #FDF1F1; /* 배경색을 흰색으로 설정 */
    }
    .form-container {
        max-width: 400px;
        width: 100%;
    }
    .form-container h1 {
        font-size: 24px;
        margin-bottom: 10px;
        font-weight: 700; /* 글씨체를 더 두껍게 설정 */
    }
    .form-container p {
        margin-bottom: 20px;
        color: #6c757d; /* 부트스트랩의 text-muted 색상 */
    }
    .form-container .form-group {
        margin-bottom: 15px;
    }
    .form-container .btn {
        width: 100%;
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
        <h1 class="text-center">Membership Form</h1>
        <p class="text-center">Join our community and enjoy exclusive benefits!</p>
        <form id="joinForm">
            <div class="form-group">
                <label for="username">Name</label>
                <input type="text" class="form-control" id="username" placeholder="John Doe">
            </div>
            <div class="form-group">
                <label for="nickname">Nickname</label>
                <input type="text" class="form-control" id="nickname" placeholder="Nickname">
            </div>
            <div class="form-group">
                <label for="email">Email</label>
                <input type="email" class="form-control" id="email" placeholder="johndoe@example.com">
            </div>
            <div class="form-group">
                <label for="password">Password</label>
                <input type="password" class="form-control" id="password" placeholder="Password">
            </div>
            <div class="form-group">
                <label for="confirmPassword">Confirm Password</label>
                <input type="password" class="form-control" id="confirmPassword" placeholder="Confirm Password">
            </div>
            <div class="form-group">
                <label for="phoneNumber">Phone Number</label>
                <input type="text" class="form-control" id="phoneNumber" placeholder="Phone Number">
            </div>
            <button type="submit" id="btn-save" class="btn btn-dark" style="background: #ff69b4">회원가입</button>
        </form>
    </div>
</div>
</body>
<script src="/js/user.js"></script>
</html>