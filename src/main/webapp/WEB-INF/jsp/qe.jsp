<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="en">
<body class="bg-light">

    <form:form action="/j2c/addQuestionExternal" method="post" modelAttribute="qex">

        <div class="modal-body">
            <div class="form-group">
                Link for Extraction
                    <form:textarea path="questionUrl" rows="15" id="questionUrl"/>
            </div>
        </div>

        <div class="modal-footer">
            <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
            <input type="submit" class="btn btn-primary" value="Submit"/>
        </div>

    </form:form>


</body>
</html>
