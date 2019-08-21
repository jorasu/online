/**
 * Created by jora on 2019/6/4.
 */
$(function () {
   LoadAjax(1);
})

/*初始加载数据*/
function LoadAjax(pNo) {
    $.ajax({
        type: "POST",
        url: "queryAllByPage.do",
        data: {"pNo":pNo},
        dataType:"json",
        success: function(msg){
            var strInfo="";
            $(".tr").remove();
            $(msg.list).each(function () {
                strInfo+=`<tr class="tr">
                     <td><a href="javascript:;">${this.id}</a></td>
                     <td><a href="javascript:;" onclick="queryQa(${this.id})">${this.title}</a></td>
                     <td><a href="javascript:;">${this.answerCount}</a></td>
                     <td><a href="javascript:;">${this.lastModified}</a></td>   
                     </tr>`;

            });
           var pageInfo=` <a href="javascript:;" onclick="transferPage(1);">首页</a>
            <a href="javascript:;" onclick="transferPage(${msg.prePage});">上一页</a>
            <a href="javascript:;" onclick="transferPage(${msg.nextPage});">下一页</a>
            <a href="javascript:;" onclick="transferPage(${msg.pages});">尾页</a>`;

            $("#tb").append(strInfo);
            $("#pageInfo").html(pageInfo);

        }
    });

}

//ajax分页
function transferPage(pNo) {
    if(pNo=='0'){
        alert("不能分页");
        return
    }else {
        LoadAjax(pNo);
    }
}

//问题和回答
function queryQa(qid) {
    alert(qid);
}