<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ include file="layout/header.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<body>
<main class="py-5 bg-light-pink">
    <div class="container">
        <div class="row align-items-center">
            <div class="col-md-6 mb-4 mb-md-0">
                <h1 class="display-6 font-weight-bold text-pink">당신과 마음이 맞는 운명의 짝을 찾아보세요</h1>

                <p class="lead text-muted">상대방의 이름과 전화번호를 등록하세요</p>
                <div>
                    <c:if test="${empty principal}">
                        <button type="button" class="btn" style="background: #ff69b4" onclick="location.href='/join'">Join Now</button>
                    </c:if>
                    <c:if test="${not empty principal}">

                        <button type="button" class="btn" style="background: #ff69b4" onclick="location.href='/register'" >등록하기</button>
                    </c:if>
                    <a class="text-pink font-weight-medium" href="#">Learn More</a>
                </div>
            </div>
            <div class="col-md-6">
                <img src="https://via.placeholder.com/400" alt="Couple" class="img-fluid rounded">
            </div>
        </div>
    </div>
</main>
<section class="py-5 bg-white">
    <div class="container">
        <h2 class="h3 font-weight-bold text-pink mb-4">Popular Posts</h2>
        <div class="row">
            <div class="col-md-4 mb-4">
                <div class="card border-0 shadow-sm">
                    <div class="card-body bg-light-pink">
                        <h3 class="h5 font-weight-bold text-pink">제목1</h3>
                        <p class="text-muted">내용1</p>
                        <div class="d-flex justify-content-between align-items-center">
                            <div class="d-flex align-items-center">
                                <span class="text-muted">닉네임1</span>
                            </div>
                            <a class="text-pink font-weight-medium" href="#">Read More</a>
                        </div>
                    </div>
                </div>
            </div>
            <div class="col-md-4 mb-4">
                <div class="card border-0 shadow-sm">
                    <div class="card-body bg-light-pink">
                        <h3 class="h5 font-weight-bold text-pink">제목2</h3>
                        <p class="text-muted">내용2</p>
                        <div class="d-flex justify-content-between align-items-center">
                            <div class="d-flex align-items-center">
                                <span class="text-muted">닉네임2</span>
                            </div>
                            <a class="text-pink font-weight-medium" href="#">Read More</a>
                        </div>
                    </div>
                </div>
            </div>
            <div class="col-md-4 mb-4">
                <div class="card border-0 shadow-sm">
                    <div class="card-body bg-light-pink">
                        <h3 class="h5 font-weight-bold text-pink">제목3</h3>
                        <p class="text-muted">내용3</p>
                        <div class="d-flex justify-content-between align-items-center">
                            <div class="d-flex align-items-center">
                                <span class="text-muted">닉네임3</span>
                            </div>
                            <a class="text-pink font-weight-medium" href="#">Read More</a>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>

</body>
</html>
```
