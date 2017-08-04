/**
 * Created by smart on 2017/8/2.
 */
function check() {
    var account = document.getElementById("account").value;
    var password = document.getElementById("password").value;
    if (account !== "xubinbin" || password !== "1024") {
        alert("账号或密码错误!");
    } else {
        // top.location.href="HttpHelperWeb/login/login.jsp";
        document.getElementById("login_form").submit();//出发表单的提交操作
    }
}