<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Quest game!</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
            crossorigin="anonymous"></script>
</head>
<body>
<div class="card" style="width: 18rem; horiz-align: center; left: 35%;">
    <div class="card-body">
        <label class="card-text" style="font-family: 'Comic Sans MS',monospace">
            Ти пішов до магазину і по дорозі тебе викрали інопланетяни.
            Ти прокинувся в білій каюті і побачив дивну істоту,
            яка представляється іменем Q. Q питає як тебе звати?
        </label>
        <form action="gameServlet">
            <p class="card-body">Введи своє ім'я:<label>
                <input type="text" name="userName">
            </label>
            </p>
            <button type="submit" class="btn btn-outline-success">Start</button>
        </form>
    </div>
</div>
<hr>
<p>
    <a class="btn btn-primary" data-bs-toggle="collapse" href="#collapse" role="button" aria-expanded="false"
       aria-controls="collapseExample">
        Session Info
    </a>
</p>
<div class="collapse" id="collapse">
    <div class="card card-body">
        <%@ include file="session_info.jsp" %>
    </div>
</div>

</body>
</html>
