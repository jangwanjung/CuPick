let index = {
    init : function (){
        self = this;
        $("#btn-save").on("click", function(){
            self.save();
        })
    },

    save : function (){
        let data = {
            username: $("#username").val(),
            password: $("#password").val(),
            email: $("#email").val(),
            nickname: $("#nickname").val(),
            phoneNumber: $("#phoneNumber").val(),
        };
        $.ajax({
            type: "POST",
            url: "/joinProc",
            data: JSON.stringify(data),
            contentType: "application/json; charset=utf-8",
            dataType: "json",
        }).done(function (resp) {
            if(resp.status === 500){
                alert("회원가입을 실패하였습니다");
            }
            else{
                alert("회원가입을 성공하였습니다");
                location.href = "/";
            }
        }).fail(function (error) {
            alert(JSON.stringify(error));
        });
    },

}

index.init();