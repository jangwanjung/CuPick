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

            <button type="submit" id="btn-save" class="btn btn-dark" style="background: #ff69b4">회원가입</button>
        </form>
    </div>
</div>
<script>
    document.addEventListener('DOMContentLoaded', function() {

        const form = document.getElementById('joinForm');
        const btnSave = document.getElementById('btn-save');

        const emailInput = document.getElementById('email');
        const passwordInput = document.getElementById('password');
        const confirmPasswordInput = document.getElementById('confirmPassword');

        const emailAlert = document.createElement('div');
        const passwordAlert = document.createElement('div');
        const confirmPasswordAlert = document.createElement('div');

        emailAlert.style.color = 'red';
        passwordAlert.style.color = 'red';
        confirmPasswordAlert.style.color = 'red';

        emailInput.parentNode.appendChild(emailAlert);
        passwordInput.parentNode.appendChild(passwordAlert);
        confirmPasswordInput.parentNode.appendChild(confirmPasswordAlert);

        // 초기 상태에서 버튼 비활성화
        btnSave.disabled = true;

        form.addEventListener('input', function () {
            const email = emailInput.value;
            const password = passwordInput.value;
            const confirmPassword = confirmPasswordInput.value;

            const isEmailValid = emailInput.checkValidity();
            const isPasswordValid = password.length >= 8 ;
            const isPasswordMatch = password === confirmPassword;

            emailAlert.textContent = isEmailValid ? '' : '유효한 이메일 주소를 입력하세요.';
            passwordAlert.textContent = isPasswordValid ? '' : '비밀번호는 8자리 이상이어야 합니다.';
            confirmPasswordAlert.textContent = isPasswordMatch ? '' : '비밀번호가 일치하지 않습니다.';

            emailAlert.textContent = '';
            passwordAlert.textContent = '';
            confirmPasswordAlert.textContent = '';

            if (email) {
                emailAlert.textContent = isEmailValid ? '' : '유효한 이메일 주소를 입력하세요.';
            }
            if (password) {
                passwordAlert.textContent = isPasswordValid ? '' : '비밀번호는 8자리 이상이어야 합니다.';
            }
            if (confirmPassword) {
                confirmPasswordAlert.textContent = isPasswordMatch ? '' : '비밀번호가 일치하지 않습니다.';
            }

            btnSave.disabled = !( isEmailValid && isPasswordValid && isPasswordMatch);
        });
    });
    $('#send').click(function (){
        const to = $('#phoneNumber').val();
        $.ajax({
            url: "/check/sendSms",
            type: "POST",
            data: {
                "to" : to
            },

            success: function (data) {
                const checkNum = data;
                alert('checkNum:' + checkNum);
                $('#check').click(function (){
                    const userNum = $('#userNum').val();
                    if(checkNum === userNum){
                        alert("인증 성공하였습니다");
                        phoneFlag=true;
                        $('#btn-save').prop('disabled', false);
                    }
                    else{
                        alert("인증 실패하였습니다 다시입력해주세요")
                    }
                })
            }

        })
    });




</script>
<script>


</script>
</body>

<script src="/js/user.js"></script>
</html>