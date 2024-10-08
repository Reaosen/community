/**
 *  提交回复
 */

function comment2target(targetId, type, content) {

    if (!content) {
        alert("回复内容不能为空哦~");
        return;
    }
    $.ajax({
        type: "POST",
        url: "/comment",
        contentType: "application/json",
        data: JSON.stringify({
            "parentId": targetId,
            "content": content,
            "type": type
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
    location.reload();
}

function post() {
    var questionId = $("#question_id").val();
    var commentContent = $("#comment_content").val()

    comment2target(questionId, 1, commentContent);
}

function comment(e) {
    var commentId = e.getAttribute("data-id");
    var content = $('#input-' + commentId).val();
    comment2target(commentId, 2, content);
}


/**
 *  删除问题
 */
// todo 页面不进行跳转
function deleteQuestion() {
    let questionId = $("#delete_id").val();
    $.ajax({
        type: "DELETE",
        url: "/question/" + questionId + "/delete",
        success: function (response) {
            if (response.code === 200) {
                window.location.href = "/";
            }else {
                alert(response.message);
            }
        }
    });
}

/**
 *  展开二级评论
 */
function collapseComments(e) {
    let id = e.getAttribute("data-id");
    var comments = $("#comment-" + id);
    comments.toggleClass("show");
    if (comments.hasClass("show")) {
        e.classList.add("active");
        var subCommentContainer = $("#comment-" + id);
        if (subCommentContainer.children().length != 1) {
            return;
        }
        $.getJSON("/comment/" + id, function (data) {
            $.each(data.data.reverse(), function (index, comment) {

                var timeElement = $("<div/>", {
                    "class": "pull-left",
                    "html": moment(comment.gmtCreate).format("YYYY-MM-DD HH:mm:ss")
                });
                var menuElement = $("<div/>", {
                    "class": "menu"
                });
                var contentElement = $("<div/>", {
                    "html": comment.content
                });
                var userNameElement = $("<a/>", {
                    "class": "comment-userName",
                    "html": comment.user.name
                });
                var mediaElement = $("<div/>", {
                });
                var avatarElement = $("<img/>", {
                    "class": "comment-img flex-shrink-0 me-3 rounded float-start",
                    "src": comment.user.avatarUrl
                });
                var commentElement = $("<div/>", {
                    "class": "d-flex position-relative comments",
                });
                menuElement.append(timeElement);
                mediaElement.append(userNameElement)
                    .append(contentElement)
                    .append(menuElement);
                commentElement.append(avatarElement)
                    .append(mediaElement);
                subCommentContainer.prepend(commentElement);
            });
        });
    } else {
        e.classList.remove("active");
    }

}
function selectTag(e){
    let value = e.getAttribute("data-tag");
    var previous = $("#tag").val();
    //todo 用indexOf存在混淆问题：spring和springboot被判定为重复
    if (previous.indexOf(value) == -1){
        if (previous){
            $("#tag").val(previous + '，' + value);
        }else {
            $("#tag").val(value);
        }
    }
}
function showSelectTag(e){
    $("#select-tag").show();
}
/*
    发送邮箱验证
 */
function sentCode(event){
    event.preventDefault(); // 阻止表单默认提交行为
    var email = document.getElementById("emailInput").value;
    var button = document.getElementById("button");
    $.ajax({
        type: "POST",
        url: "/signUp",
        contentType: "application/json",
        data: JSON.stringify({
            "email": email
        }),
        success: function (response) {
            if (response.code === 200) {
                if (button.classList.contains("captcha-btn")) {
                    button.classList.remove("captcha-btn");
                    button.classList.add("captcha-btn-clicked");
                }
                alert(response.message);
            }else {
                if (response.code === 2007){
                    alert(response.message);
                }
            }
        },
        dataType: "json"
    });
}

function register(){
    var email = document.getElementById("emailInput").value;
    var captcha = document.getElementById("captchaInput").value;
    var password = document.getElementById("passwordInput").value;
    $.ajax({
        type: "POST",
        url: "/register",
        contentType: "application/json",
        data: JSON.stringify({
            "email": email,
            "code": captcha,
            "password": password
        }),
        success: function (response) {
            if (response.code === 200) {
                    window.location.href = "/login";
            }else {
                    alert(response.message);
            }
        },
        dataType: "json"
    });
}