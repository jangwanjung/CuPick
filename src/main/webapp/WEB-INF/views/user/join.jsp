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
                <label for="instaId">인스타아이디</label>
                <input type="text" class="form-control" id="instaId" placeholder="insta_gram">
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
<script>
    document.addEventListener('DOMContentLoaded', function() {
        const form = document.getElementById('joinForm');
        const btnSave = document.getElementById('btn-save');

        const phoneNumberInput = document.getElementById('phoneNumber');
        const emailInput = document.getElementById('email');
        const passwordInput = document.getElementById('password');
        const confirmPasswordInput = document.getElementById('confirmPassword');

        const phoneNumberAlert = document.createElement('div');
        const emailAlert = document.createElement('div');
        const passwordAlert = document.createElement('div');
        const confirmPasswordAlert = document.createElement('div');

        phoneNumberAlert.style.color = 'red';
        emailAlert.style.color = 'red';
        passwordAlert.style.color = 'red';
        confirmPasswordAlert.style.color = 'red';

        phoneNumberInput.parentNode.appendChild(phoneNumberAlert);
        emailInput.parentNode.appendChild(emailAlert);
        passwordInput.parentNode.appendChild(passwordAlert);
        confirmPasswordInput.parentNode.appendChild(confirmPasswordAlert);

        // 초기 상태에서 버튼 비활성화
        btnSave.disabled = true;

        form.addEventListener('input', function() {
            const phoneNumber = phoneNumberInput.value;
            const email = emailInput.value;
            const password = passwordInput.value;
            const confirmPassword = confirmPasswordInput.value;

            const isPhoneNumberValid = /^(?:[0-9]{11})?$/.test(phoneNumber);
            const isEmailValid = emailInput.checkValidity();
            const isPasswordValid = password.length >= 8 ;
            const isPasswordMatch = password === confirmPassword;

            phoneNumberAlert.textContent = isPhoneNumberValid ? '' : '전화번호는 입력을하지않거나 11자리 숫자여야 합니다.';
            emailAlert.textContent = isEmailValid ? '' : '유효한 이메일 주소를 입력하세요.';
            passwordAlert.textContent = isPasswordValid ? '' : '비밀번호는 8자리 이상이어야 합니다.';
            confirmPasswordAlert.textContent = isPasswordMatch ? '' : '비밀번호가 일치하지 않습니다.';

            phoneNumberAlert.textContent = '';
            emailAlert.textContent = '';
            passwordAlert.textContent = '';
            confirmPasswordAlert.textContent = '';

            if (phoneNumber) {
                phoneNumberAlert.textContent = isPhoneNumberValid ? '' : '전화번호는 입력을하지않거나 11자리 숫자여야 합니다.';
            }
            if (email) {
                emailAlert.textContent = isEmailValid ? '' : '유효한 이메일 주소를 입력하세요.';
            }
            if (password) {
                passwordAlert.textContent = isPasswordValid ? '' : '비밀번호는 8자리 이상이어야 합니다.';
            }
            if (confirmPassword) {
                confirmPasswordAlert.textContent = isPasswordMatch ? '' : '비밀번호가 일치하지 않습니다.';
            }

            btnSave.disabled = !(isPhoneNumberValid && isEmailValid && isPasswordValid && isPasswordMatch);
        });
    });

</script>
</body>

<script src="/js/user.js"></script>

</html>