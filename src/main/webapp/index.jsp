<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<script type="text/javascript" src="/js/jquery-1.10.2.min.js"></script>
<body>

<h2>Hello World!</h2>
<button id="btn" type="button">Change Content</button>
<input type="text" id="jsonmsg"/>
<script type="text/javascript">
    $(document).ready(function () {
        $("#btn").click(function () {
            $.ajax({
                url: "/user/jsonobj.do",
                success: function (data) {
                    $("#jsonmsg").val(data.username);
                },
                error: function () {
                    alert("error");
                }
            });
        });
    });

</script>
</body>
</html>
