<%@ page contentType="text/html;charset=UTF-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>

<html lang="en">
<head>
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
            crossorigin="anonymous"></script>
</head>
<body>
<jsp:useBean id="step" scope="request" type="ua.javarush.entity.Step"/>
<div class="card" style="width: 30rem; horiz-align: center; left: 35%;">
    <div class="card-body">
        <h1 style="font-family: 'Comic Sans MS',monospace " class="fw-normal">${step.currentQuestion}</h1>
        <c:if test="${step.answersForCurrentQuestion != null}">
            <form action="gameServlet">
                <c:forEach var="answer" items="${step.answersForCurrentQuestion}">
                    <div>
                        <input class="form-check-input" type="radio" id="actionChoice${answer.ledToStep}"
                               name="stepID" value="${answer.ledToStep}">
                        <label class="form-check-label" for="actionChoice${answer.ledToStep}">${answer.text}</label>
                    </div>
                </c:forEach>
                <div class="btn" style="margin-top: 5%">
                    <button type="submit" class="btn btn-outline-success">Submit</button>
                </div>
            </form>
        </c:if>
        <c:if test="${step.isWin}">
            <div>
                <h2 class="fw-bold" style="color: darkgreen">Win!</h2>
            </div>
            <form action="gameServlet?stepID=1" target="_blank">
                <button class="btn btn-outline-success">Play again!</button>
            </form>
        </c:if>
        <c:if test="${!step.hasNextStep && !step.isWin}">
            <div>
                <h2 class="fw-bold" style="color: indigo">Lose!</h2>
            </div>
            <form action="gameServlet?stepID=1" target="_blank">
                <button class="btn btn-outline-success">Play again!</button>
            </form>
        </c:if>
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
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js"
        integrity="sha384-IQsoLXl5PILFhosVNubq5LC7Qb9DXgDA9i+tQ8Zj3iwWAwPtgFTxbJ8NT4GN1R8p"
        crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.min.js"
        integrity="sha384-cVKIPhGWiC2Al4u+LWgxfKTRIcfu0JTxR+EQDz/bgldoEyl4H0zUF0QKbrJ0EcQF"
        crossorigin="anonymous"></script>
</body>
</html>
