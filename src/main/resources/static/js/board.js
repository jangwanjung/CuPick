let index = {
    init: function (){
        self = this;
        $("#btn-save").on("click",()=>{
            self.save();
        })
        $("#btn-reply-save").on("click",()=>{
            self.replySave();
        })
        $("#btn-reply-delete").on("click",()=>{
            self.replyDelete();
        })
    },

    save: function (){
        let data = {
            title: $("#title").val(),
            content: $("#content").val(),
        };
        $.ajax({
            type: "POST",
            url: "/board/write",
            data: JSON.stringify(data),
            contentType: "application/json; charset=utf-8",
            dataType: "json"
        }).done(function (resp) {
            alert("글쓰기가 완료되었습니다");
            location.href = "/board"
        }).fail(function (error) {
            alert(JSON.stringify(error));
        });
    },
    replySave: function (){
        let data = {
            content: $("#content").val(),
        };
        let boardId = $("#boardId").val();
        console.log(data);
        console.log(boardId)
        $.ajax({
            type: "POST",
            url: `/board/${boardId}/reply/write`,
            data: JSON.stringify(data),
            contentType: "application/json; charset=utf-8",
            dataType: "json"
        }).done(function (resp) {
            alert("댓글쓰기가완료되었습니다");
            location.href = `/board/${boardId}`
        }).fail(function (error) {
            alert(JSON.stringify(error));
        });
    },
    replyDelete: function (boardId,replyId){
        $.ajax({
            type: "DELETE",
            url: `/board/${boardId}/reply/delete/${replyId}`,
            dataType: "json"
        }).done(function (resp) {
            alert("댓글삭제가 완료되었습니다");
            location.href = `/board/${boardId}`
        }).fail(function (error) {
            alert(JSON.stringify(error));
        })
    }

}
index.init();