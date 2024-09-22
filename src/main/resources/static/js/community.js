function post() {
    var questionId = $("#question_id").val();
    var commentContent = $("#comment_content").val()
    $.ajax({
        type: "POST",
        url: "/comment",
        contentType: "application/json",
        data: JSON.stringify({
            "parentId": questionId,
            "content": commentContent,
            "type": 1
        }),
        success: function (response) {
            if (response.code === 200) {
                $("#comment_section").hide();
            } else {
                if (response.code === 2003) {
                    let isAccepted = confirm(response.message);
                    if (isAccepted) {
                        window.open("https://gitee.com/oauth/authorize?client_id=7e0df6b4bb3e4edc48e84259b8cd61a4780a8669cb002c149921c33a79f45530&redirect_uri=http://localhost:8080/giteeCallback&response_type=code");
                        window.localStorage.setItem("closable", true);
                    }
                } else {
                    alert(response.message);
                }
            }


        },
        dataType: "json"
    });
}

// todo 页面不进行跳转
function deleteQuestion() {
    let questionId = $("#delete_id").val();
    $.ajax({
        type: "DELETE",
        url: "/question/" + questionId + "/delete",
        success: function (response) {
            if (response.code !== 200) {
                alert(response.message);
            }
        }
    });
}