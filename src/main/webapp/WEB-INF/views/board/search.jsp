<%@ include file="../layout/header.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<body>
<link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">

<style>
    /*body {
        background-color: #FDF1F1; !* 연한 핑크 배경색 *!
    }*/
    .container {
        /*margin-top: 1px;*/
    }
    .post-header {
        display: flex;
        justify-content: space-between;
        align-items: center;
        background-color: #ffebef;
        padding: 10px;
        border-radius: 5px;
    }
    .post-body {
        background-color: white;
        /*padding: 0.1px;*/
        border-radius: 1px;
        box-shadow: 0 0 3px rgba(0, 0, 0, 0.1);
        /*margin-bottom: 10px;*/
    }
    .post-title {
        font-weight: bold;
        color: #ff1493;
    }
    .post-stats {
        display: flex;
        justify-content: space-between;
        margin-top: 10px;
    }
    .post-stats span {
        margin-right: 15px;
        color: grey;
    }
    .post-stats span:last-child {
        margin-right: 0;
    }
    .tab-button {
        background-color: #ff69b4;
        color: white;
    }
    .tab-button.active {
        background-color: white;
        color: #ff69b4;
    }
    .search-bar {
        background-color: #EFE0E3;
        padding: 5px 10px;
        border-radius: 20px;
        display: flex;
        align-items: center;

    }
    .search-bar input {
        border: none;
        background-color: transparent;
        outline: none;
        margin-left: 5px;
    }
</style>
<div class="container" style="width: 1000px ; height: 650px">
    <div class="d-flex justify-content-between align-items-center mb-3" style="margin-top: 15px">
        <div>
            <button class="btn tab-button active" style="background-color: #FDF1F1" >인기 게시물</button>
            <button class="btn tab-button">최신 게시물</button>
        </div>
        <div>
            <button class="btn tab-button" onclick="location.href='/board/write'">글쓰기</button>
        </div>
    </div>
    <div class="post-body" style="display: flex; justify-content: right">
        <span style="margin-right: 20px"><i class="material-icons" style="font-size: 20px">visibility</i></span>
        <span style="margin-right: 20px"><i class="material-icons" style="font-size: 20px">thumb_up</i> </span>
        <span><i class="material-icons" style=" margin-right:20px; font-size: 20px">comment</i> </span>
    </div>
    <c:forEach  var="board" items="${searchList}">
        <div class="post-body">
            <div style="display: flex ; justify-content: space-between ;margin-top: 2px;margin-bottom: 2px">
                <a  href="/board/${board.id}" style="margin-left: 15px ; color: black">${board.title} </a>
                <div style="margin-right: 15px">
                    <span style="margin-right: 26px;color: #6c757d;font-size: 13px"><i class="material-icons" style="font-size: 0px">visibility</i> ${board.count}</span>
                    <span style="margin-right: 25px;color: #6c757d;font-size: 13px"><i class="material-icons" style="font-size: 0px">thumb_up</i> ${board.good}</span>
                    <span style=" margin-right:10px;color: #6c757d;font-size: 13px"><i class="material-icons" style=" font-size: 0px">comment</i> ${fn:length(board.replys)}</span>
                </div>

            </div>
        </div>

    </c:forEach>
    <c:set var="page" value="${param.page}" />
    <ul class="pagination" style="margin-top: 5px;display: flex;justify-content: center">
        <li class="page-item"><a class="page-link" style="color: hotpink" href="?page=${page-10}">이전</a></li>
        <c:forEach var="i" begin="0" end="9">
            <li class="page-item"><a class="page-link" style="color: hotpink" href="?page=${i}">${i+1}</a></li>
        </c:forEach>
        <li class="page-item"><a class="page-link" style="color: hotpink" href="?page=${page+10}">다음</a></li>
    </ul>
    <form action="/board/search" method="GET" class="search-bar">
        <input size="117px" type="text" name="keyword" id="search" placeholder="검색">
        <button class="btn tab-button" ></button>
    </form>

</div>
</body>
</html>