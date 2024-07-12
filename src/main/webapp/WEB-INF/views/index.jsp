<%@ include file="layout/header.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<body>
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
        <a class="d-flex align-items-center text-decoration-none" href="#">
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
                <button type="button" class="btn" style="background: #ff69b4" onclick="location.href='/logout'">Log Out</button>
            </div>
        </c:if>



    </div>
</header>
<main class="py-5 bg-light-pink">
    <div class="container">
        <div class="row align-items-center">
            <div class="col-md-6 mb-4 mb-md-0">
                <h1 class="display-4 font-weight-bold text-pink">Find Your Perfect Match</h1>
                <p class="lead text-muted">CuPick is the premier dating site for couples looking to connect and build lasting relationships.</p>
                <div>
                    <button type="button" class="btn" style="background: #ff69b4" onclick="location.href='/join'">Join Now</button>
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
