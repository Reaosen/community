/**
 *  提交回复
 */

function comment2target(targetId, type, content){

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
}

function post() {
    var questionId = $("#question_id").val();
    var commentContent = $("#comment_content").val()

    comment2target(questionId, 1, commentContent);
}

function comment(e){
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
            if (response.code !== 200) {
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
        $.getJSON( "/comment/" + id, function( data ) {
            // var commentBody = $('comment-body-' + id);
            // var items = [];
            //
            // $.each( data.data, function(comment) {
            //     $("<div/>",{
            //         "class":"d-flex position-relative comments",
            //         "id":'comment-' + id,
            //         html: items.join("")
            //     }).appendTo(commentBody);
            //
            //     items.push( "<li id='" + key + "'>" + val + "</li>" );
            // });
            // $("<div/>",{
            //     "class":"col-lg-12 col-md-12 col-sm-12 col-xs-12 accordion-collapse sub-comments collapse",
            //     "id":'comment-' + id,
            //     html: items.join("")
            // }).appendTo(commentBody);
        });
    }else {
        e.classList.remove("active");
    }

}