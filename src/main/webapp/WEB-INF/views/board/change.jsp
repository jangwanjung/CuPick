<%@ include file="../layout/header.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<body>
<style>
    .form-control.summernote {
        background-color: #ffffff; /* 배경색을 흰색으로 변경 */
        color: #000000; /* 텍스트 색상을 검은색으로 설정 */
    }
</style>
<div class="container">
    <form>
        <div class="mb-3 mt-3">
            <input type="text" class="form-control" id="title" placeholder="Enter title"  name="title" value="${board.title}">
        </div>
        <div style="background: #f8f9fa">
            <div class="mb-3">
                <textarea class="form-control summernote" id="content"  placeholder="Enter content" name="content" style="background-color:#f8f9fa;">${board.content}</textarea>
            </div>
        </div>
    </form>
    <input type="hidden" id="boardId" value="${board.id}">
    <button id="btn-board-change" class="btn btn-primary" style="background: #ff69b4 ; border: #ff69b4  ">글수정완료</button>
</div>
<br>
</body>

<script>
    $('.summernote').summernote({
        placeholder: 'Hello Bootstrap 4',
        tabsize: 2,
        height: 400
    });
</script>
<script src="/js/board.js"></script>