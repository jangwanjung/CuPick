<!DOCTYPE html>
<%@ include file="../layout/header.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
<body>
<style>
    .post-info {
        display: flex;
        align-items: center;
        font-size: 0.9rem;
    }

    .post-info .text-muted {
        margin: 0 5px;
    }

    .post-info .btn {
        padding: 0.2rem 0.5rem;
        font-size: 0.8rem;
    }
    .post-title {
        font-size: 1.5rem;
        font-weight: bold;
    }

    .post-date {
        font-size: 0.9rem;
        color: gray;
    }

    .post-content {
        margin-top: 1rem;
    }

    .comments h3 {
        margin-top: 2rem;
        margin-bottom: 1rem;
    }

    .comment {
        border-bottom: solid #e9ecef;
    }

    footer {
        margin-top: 2rem;
    }

</style>

<div class="container my-4">
    <div class="row">
        <input type="hidden" id="boardId" value="${board.id}">
        <div class="col-md-9">
            <div class="post">
                <h2 class="post-title">${board.title}</h2>
                <div class="mt-3">
                    <div class="post-info">
                        <span class="author font-weight-bold">${board.user.nickname}</span>
                        <span class="text-muted">|</span>
                        <span class="text-muted">
                            <fmt:formatDate value="${board.creatDate}" pattern="yyyy.MM.dd HH:mm:ss"/>
                        </span>
                        <span class="text-muted">|</span>
                        <span class="text-muted">조회 ${board.count}</span>
                        <span class="text-muted">|</span>
                        <span class="text-muted">추천 ${board.good}</span>
                        <span class="text-muted">|</span>
                        <span class="text-muted">댓글 ${fn:length(board.replys)}</span>
                    </div>
                </div>
                <div class="post-content">
                    <p>${board.content}</p>
                </div>
            </div>
            <div class="comments mt-4">
                <h3>댓글</h3>
                <c:forEach var="reply" items="${board.replys}">
                    <div style="display: flex ; justify-content: space-between ;border-bottom: solid #e9ecef;">
                        <div style="margin: 3px ">
                            <strong>${reply.user.nickname} : </strong>${reply.content}
                        </div>
                        <div>
                            <c:if test="${principal.user == reply.user}">
                                <button onclick="index.replyDelete(${board.id},${reply.id})" style="background-color: white ; border: none">삭제 </button>
                            </c:if>
                        </div>
                    </div>
                </c:forEach>

            </div>
            <form class="mt-4">
                <div class="form-group">
                    <textarea class="form-control" id="content" rows="3"></textarea>
                </div>
            </form>
            <div style="display: flex ; justify-content: space-between" >
                <div>
                    <button class="btn btn-primary" id="btn-reply-save" style="background-color: #ff4081; border: #ff4081 ">댓글 작성</button>
                </div>
                <div>
                    <c:if test="${board.user==principal.user}">
                        <a href="/board/change/${board.id}" class="btn btn-primary" style="background-color: #6c757d; border: #ff4081 ">수정</a>
                        <button class="btn btn-primary" id="btn-board-delete" style="background-color: #6c757d; border: #ff4081 ">삭제</button>
                    </c:if>
                    <button class="btn btn-primary" id="#" style="background-color: #ff4081; border: #ff4081 ">글쓰기</button>
                </div>

            </div>
        </div>
        <div class="col-md-3">
            <h3>사이드바</h3>
            <ul class="list-group">
                <li class="list-group-item">항목 1</li>
                <li class="list-group-item">항목 2</li>
                <li class="list-group-item">항목 3</li>
            </ul>
        </div>
    </div>
</div>
</body>
<script src="/js/board.js"></script>
</html>
