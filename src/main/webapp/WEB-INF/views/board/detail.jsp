<%@ include file="../layout/header.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>게시물 페이지</title>
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
    <style>
        body {
            background-color: #f8f9fa;
        }
        .post-header {
            padding: 20px;
            border-bottom: 1px solid #ddd;
            background-color: white;
        }
        .post-title {
            font-weight: bold;
            font-size: 18px;
            margin-bottom: 10px;
        }
        .post-meta {
            font-size: 14px;
            color: #666;
        }
        .post-meta span {
            margin-right: 10px;
        }
        .post-meta .author {
            font-weight: bold;
            color: #000;
        }
        .post-meta .badge {
            background-color: #eee;
            color: #666;
            padding: 5px 10px;
            border-radius: 20px;
        }
        .post-content {
            padding: 20px;
            background-color: white;
            border-bottom: 1px solid #ddd;
        }
        .reactions {
            margin: 20px 0;
            text-align: center;
        }
        .reaction-buttons {
            display: flex;
            justify-content: center;
            align-items: center;
        }
        .reaction-buttons span {
            margin: 0 10px;
            cursor: pointer;
        }
        .reaction-buttons .material-icons {
            font-size: 24px;
        }
        .comment-section {
            margin-top: 20px;
            background-color: white;
            padding: 20px;
            border-top: 1px solid #ddd;
        }
        .comment {
            padding: 10px 0;
            border-bottom: 1px solid #ddd;
        }
        .comment-meta {
            font-size: 14px;
            color: #666;
            margin-bottom: 5px;
        }
        .search-bar {
            display: flex;
            align-items: center;
            margin-top: 20px;
        }
        .search-bar input {
            flex-grow: 1;
            border: none;
            border-bottom: 1px solid #ddd;
            outline: none;
        }
        .search-bar span {
            margin-right: 10px;
            color: #999;
        }
    </style>
</head>
<body>
<div class="container">
    <div class="post-header">
        <div class="post-title">[질문/후기] 노트북 꺼놔도 배터리 닳는거 정상임?</div>
        <div class="post-meta">
            <span class="author">붕어</span>
            <span>(39.112)</span>
            <span>|</span>
            <span>2024.07.17 23:57:40</span>
            <span>|</span>
            <span>조회 90</span>
            <span>|</span>
            <span>추천 0</span>
            <span>|</span>
            <span class="badge">댓글 5</span>
        </div>
    </div>

    <div class="post-content">
        <p>usb 충전, 최대절전모드, 보관 모드 이외에 전력이 안 잡아먹으면 하루에 한 2%정도 빠지는거 같은데 ㅠㅠ</p>
        <p>배터리 대기전력만으로도 보관모드에 빠지게 되는건가요?</p>
        <p>광고로 배터리 활성을 보면 거의 0%로 생각할 수 있을 것 같은데...</p>
    </div>

    <div class="reactions">
        <div class="reaction-buttons">
            <span class="material-icons">star</span>
            <span>0</span>
            <span class="material-icons">thumb_down</span>
            <span>0</span>
        </div>
        <div class="mt-3">
            <button class="btn btn-secondary">실베추</button>
            <button class="btn btn-secondary">공유</button>
            <button class="btn btn-secondary">신고</button>
        </div>
    </div>

    <div class="comment-section">
        <h5>전체 댓글 5개</h5>
        <div class="comment">
            <div class="comment-meta">익명 (58.29) | 07.18 00:00:11</div>
            <p>당연히 완전히 차단된게 아니라 그럼 배터리 소모 ㅇㅇ 다 차단하면 전원 버튼으로 못킴</p>
        </div>
        <div class="comment">
            <div class="comment-meta">글쓴 노붕이 (39.112) | 07.18 00:02:03</div>
            <p>아 배터리로 어디 대기전력을 쓰고 있는거임? 난 또 불량인줄 ㅋ. 감사합니다</p>
        </div>
        <div class="comment">
            <div class="comment-meta">익명 (58.29) | 07.18 00:05:05</div>
            <p>장기 보관 모드나 배터리 비활성화 모드 이런거 있으면 보드에 아예 죽여서 대기 전력을 확 잡을 수 있는데 이럼 그냥 전원 버튼 눌러서는 안 켜지고 공장에서 출고한 새빨처럼 어댑터 꽂아야 배터리 활성화 되고 전원버튼으로 부팅 가능해짐</p>
        </div>
        <div class="comment">
            <div class="comment-meta">익명 (110.35) | 07.18 00:01:19</div>
            <p>메인보드가 어느정도 전력소모를 하니깐 어쩔수없지</p>
        </div>
        <div class="comment">
            <div class="comment-meta">글쓴 노붕이 (39.112) | 07.18 00:02:15</div>
            <p>정상이구나 ㅋㅋ</p>
        </div>
    </div>
</div>
</body>
</html>
