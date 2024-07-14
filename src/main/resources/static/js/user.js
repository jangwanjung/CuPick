let index = {
    init : function (){
        self = this;
        $("#btn-save").on("click", function(){
            self.save();
        })
        $("#btn-register").on("click", function(){
            self.register();
        })
        $("#btn-reset").on("click", function(){
            self.reset();
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

    register : function (){
        let data = {
            id: $("#id").val(),
            likeName: $("#likeName").val(),
            likeNumber: $("#likeNumber").val(),
        };
        $.ajax({
            type: "PUT",
            url: "/register",
            data: JSON.stringify(data),
            contentType: "application/json; charset=utf-8",
            dataType: "json",
        }).done(function (resp) {
            if(resp.status === 500){
                alert("등록을 실패하였습니다");
            }
            else{
                alert("등록을 성공하였습니다");
                location.href = "/register";
            }
        }).fail(function (error) {
            alert(JSON.stringify(error));
        });
    },

    reset : function (){
        let data = {
            id: $("#id").val(),
        };
        $.ajax({
            type: "PUT",
            url: "/reset",
            data: JSON.stringify(data),
            contentType: "application/json; charset=utf-8",
            dataType: "json",
        }).done(function (resp) {
            if(resp.status === 500){
                alert("초기화를 실패하였습니다");
            }
            else{
                alert("초기화를 성공하였습니다");
                location.href = "/register";
            }
        }).fail(function (error) {
            alert(JSON.stringify(error));
        });
    },

}

index.init();