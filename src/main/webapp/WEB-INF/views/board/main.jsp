<%@ include file="../layout/header.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<body>
<link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">

<style>
    body {
        background-color: #FDF1F1; /* 연한 핑크 배경색 */
    }
    .container {
        margin-top: 1px;
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
        padding: 1px;
        border-radius: 1px;
        box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        margin-bottom: 10px;
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
<div class="container" style="width: 1000px ; height: 800px">
    <div class="d-flex justify-content-between align-items-center mb-3" style="margin-top: 15px">
        <div>
            <button class="btn tab-button active">인기 게시물</button>
            <button class="btn tab-button">최신 게시물</button>
        </div>
        <div>
            <button class="btn tab-button" onclick="location.href='/board/write'">글쓰기</button>
        </div>
    </div>
    <c:forEach  var="board" items="${boards.content}">
        <div class="post-body">

            <div style="display: flex ; justify-content: space-between ;margin-top: 10px;margin-bottom: 10px">
                <a  href="/board/${board.id}" style="margin-left: 15px ; color: black">${board.title} </a>
                <div style="margin-right: 15px">
                    <span style="margin-right: 10px"><i class="material-icons" style="font-size: 20px">visibility</i> ${board.count}</span>
                    <span style="margin-right: 10px"><i class="material-icons" style="font-size: 20px">thumb_up</i> ${board.good}</span>
                    <span><i class="material-icons" style="font-size: 20px">comment</i> ${fn:length(board.replys)}</span>
                </div>
            </div>

        </div>
    </c:forEach>
    <div class="search-bar">
        <span class="material-icons">search</span>
        <input type="text" placeholder="검색">
    </div>
</div>
</body>
</html>
