let index = {
    init: function (){
        self = this;
        $("#btn-save").on("click",()=>{
            self.save();
            console.log(111111);
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
    }
}
index.init();