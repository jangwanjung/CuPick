<%@ include file="../layout/header.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<style>
    .contact-card {
        background-color: #ffeef4;
        border-radius: 10px;
        padding: 20px;
        margin: 10px;
        text-align: center;
    }
    .contact-card h5 {
        margin-bottom: 0;
    }
    .contact-card p {
        margin-bottom: 0;
        color: #ff69b4;
    }
    .add-contact-form {
        background-color: #fff;
        border-radius: 10px;
        padding: 20px;
        box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
    }
    .btn-custom {
        background-color: #ff69b4;
        border: none;
        color: white;
    }
    .container {
        display: flex;
        justify-content: space-between;
    }
    .card, .add-contact-form {
        width: 48%;
    }
    .contact-card {
        text-align: center;
        background: #f8f9fa;
        padding: 10px;
        border-radius: 5px;
        width: 30%;
    }
</style>

<body>
<div class="container mt-5">
    <input type="hidden" id="id" value="${principal.user.id}">
    <div class="card p-3 mb-6">
        <div class="d-flex justify-content-between align-items-center">
            <h3>기존에 등록한 사람</h3>
        </div>
        <div class="contact-card">
            <h5>${principal.user.likeName}</h5>
            <p>${principal.user.likeNumber}</p>
        </div>
        <button id="btn-reset" class="btn btn-custom btn-block">초기화</button>
    </div>
    <div class="add-contact-form p-4">
        <h3>새로 등록할 사람</h3>
        <form>
            <div class="form-group">
                <label for="likeName">이름</label>
                <input type="text" class="form-control" id="likeName" placeholder="Enter name">
            </div>
            <div class="form-group">
                <label for="likeNumber">휴대폰 번호</label>
                <input type="text" class="form-control" id="likeNumber" placeholder="Enter phone number">
            </div>
        </form>
        <button id="btn-register" class="btn btn-custom btn-block">등록하기</button>
    </div>
</div>
<script src="/js/user.js"></script>
</body>
</html>