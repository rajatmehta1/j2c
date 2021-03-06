<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="favicon.ico">

    <title>Health@India</title>

    <%@ include file = "inc_head.jsp" %>

    <style>
        .input-group.md-form.form-sm.form-1 input{
            border: 1px solid #bdbdbd;
            border-top-right-radius: 0.25rem;
            border-bottom-right-radius: 0.25rem;
        }
        .input-group.md-form.form-sm.form-2 input {
            border: 1px solid #bdbdbd;
            border-top-left-radius: 0.25rem;
            border-bottom-left-radius: 0.25rem;
        }
        .input-group.md-form.form-sm.form-2 input.red-border {
            border: 1px solid #ef9a9a;
        }
        .input-group.md-form.form-sm.form-2 input.lime-border {
            border: 1px solid #cddc39;
        }
        .input-group.md-form.form-sm.form-2 input.amber-border {
            border: 1px solid #ffca28;
        }

        @font-face {
            font-family: 'Glyphicons Halflings';
            src: url('glyphicons-halflings-regular.eot');
            src: url('glyphicons-halflings-regular.eot?#iefix') format('embedded-opentype'), url('glyphicons-halflings-regular.woff') format('woff'), url('glyphicons-halflings-regular.ttf') format('truetype'), url('glyphicons-halflings-regular.svg#glyphicons-halflingsregular') format('svg');
        }
    </style>

</head>

<body class="bg-light">

<div class="container">




    <header class="blog-header py-3">
        <div class="row flex-nowrap justify-content-between align-items-center">
            <div class="col-4 pt-1">
                 <a class="blog-post-title text-dark" href="#">Join2Cure</a>
                <!--<a class="blog-post-title text-dark" href="#">Sample</a> -->
            </div>
            <div class="col-4 text-center">

            </div>
            <div class="col-4 d-flex justify-content-end align-items-center">

                <table>

                    <tr><td>
                        <%--<form:form action="/j2c/m/srch" method="post" modelAttribute="srch">--%>
                            <%--<table>--%>
                                <%--<tr>--%>
                                    <%--<td>--%>
                                        <%--<form:input path="srchTxt" class="form-control" id="srchTxtId"/>--%>
                                    <%--</td>--%>
                                    <%--<td>--%>

                                        <%--<div class="input-group md-form form-sm form-2 pl-0">--%>
                                            <%--<input class="form-control my-0 py-1 lime-border" type="text"--%>
                                                   <%--placeholder="Search" aria-label="Search">--%>
                                            <%--<div class="input-group-append">--%>
                                                <%--<span class="input-group-text lime lighten-2" id="basic-text1">--%>
                                                    <%--<i class="fas fa-search text-grey" aria-hidden="true"></i>--%>
                                                <%--</span>--%>
                                            <%--</div>--%>
                                        <%--</div>--%>

                                    <%--</td>--%>
                                <%--</tr>--%>
                            <%--</table>--%>
                        <%--</form:form>--%>

                            <form:form action="/j2c/m/srch" method="post" modelAttribute="srch">
                                <div class="input-group md-form form-sm form-2 pl-0">
                                        <%--<input class="form-control my-0 py-1 lime-border" type="text" placeholder="Search" aria-label="Search">--%>
                                    <form:input path="srchTxt" class="form-control" id="srchTxtId"/>
                                    <div class="input-group-append">
                                <span class="input-group-text lime lighten-2" id="basic-text1">
                                                                        <button type="submit" image="">
                                        <svg xmlns="http://www.w3.org/2000/svg"
                                             width="20" height="20" viewBox="0 0 24 24" fill="none"
                                             stroke="currentColor" stroke-width="2" stroke-linecap="round"
                                             stroke-linejoin="round" class="mx-3"><circle cx="10.5" cy="10.5" r="7.5"></circle>
                                            <line x1="21" y1="21" x2="15.8" y2="15.8"></line>

                                        </svg></button>
                                </span>
                                    </div>
                                </div>
                            </form:form>

                    </td></tr>

                </table>

            </div>
        </div>
    </header>

    <%@ include file = "inc_nav_top.jsp" %>


    <!--
    <div class="jumbotron p-3 p-md-5 text-white rounded bg-dark">
        <div class="col-md-6 px-0">
            <h1 class="display-4 font-italic">Title of a longer featured blog post</h1>
            <p class="lead my-3">Multiple lines of text that form the lede, informing new readers quickly and efficiently about what's most interesting in this post's contents.</p>
            <p class="lead mb-0"><a href="#" class="text-white font-weight-bold">Continue reading...</a></p>
        </div>
    </div>


    <div class="row mb-2">
        <div class="col-md-6">
            <div class="card flex-md-row mb-4 box-shadow h-md-250">
                <div class="card-body d-flex flex-column align-items-start">
                    <strong class="d-inline-block mb-2 text-primary">World</strong>
                    <h3 class="mb-0">
                        <a class="text-dark" href="#">Featured post</a>
                    </h3>
                    <div class="mb-1 text-muted">Nov 12</div>
                    <p class="card-text mb-auto">This is a wider card with supporting text below as a natural lead-in to additional content.</p>
                    <a href="#">Continue reading</a>
                </div>
                <img class="card-img-right flex-auto d-none d-lg-block" data-src="holder.js/200x250?theme=thumb" alt="Card image cap">
            </div>
        </div>
        <div class="col-md-6">
            <div class="card flex-md-row mb-4 box-shadow h-md-250">
                <div class="card-body d-flex flex-column align-items-start">
                    <strong class="d-inline-block mb-2 text-success">Design</strong>
                    <h3 class="mb-0">
                        <a class="text-dark" href="#">Post title</a>
                    </h3>
                    <div class="mb-1 text-muted">Nov 11</div>
                    <p class="card-text mb-auto">This is a wider card with supporting text below as a natural lead-in to additional content.</p>
                    <a href="#">Continue reading</a>
                </div>
                <img class="card-img-right flex-auto d-none d-lg-block" data-src="holder.js/200x250?theme=thumb" alt="Card image cap">
            </div>
        </div>
    </div>
</div>
-->

    <div class="control-group">
        &nbsp;
    </div>
<main role="main" class="container">
    <div class="row">
        <div class="col-md-8 blog-main">

            <h4 class="pb-3 mb-4 border-bottom">
                ${question.qsTxt}
            </h4>

                <c:forEach items="${question.ansList}" var="qAns">
                    <div>
                        <p class="blog-post-meta">${qs.createDate} by ${qs.displayName}</p>
                            <c:out value="${qAns.ansTxt}" escapeXml="false"/>
                        <hr>
                    </div>
                </c:forEach>

            <nav class="blog-pagination">
                <a class="btn btn-outline-primary" href="#">Older</a>
                <a class="btn btn-outline-secondary disabled" href="#">Newer</a>
            </nav>

        </div><!-- /.blog-main -->

        <aside class="col-md-4 blog-sidebar">
            <div>
                <button class="btn btn-sm btn-primary" href="#" data-toggle="modal" data-target="#ansModal">Answer</button>
            </div>

            <div>
                <span>&nbsp;</span>
            </div>

            <div class="p-3">

                <%--<h6 class="border-bottom">Related Questions</h6>--%>
                <%--<ol class="list-unstyled mb-0">--%>
                    <%--<li><a href="#">Has insulin some side defects ?</a></li>--%>
                    <%--<li>&nbsp;</li>--%>
                    <%--<li><a href="#">What is the effect of diabetes on teeth?</a></li>--%>
                    <%--<li>&nbsp;</li>--%>
                    <%--<li><a href="#">What affect does diabetes have for cataract operation ?</a></li>--%>
                    <%--<li>&nbsp;</li>--%>
                    <%--<li><a href="#">December 2013</a></li>--%>
                    <%--<li>&nbsp;</li>--%>
                    <%--<li><a href="#">November 2013</a></li>--%>
                    <%--<li>&nbsp;</li>--%>
                    <%--<li><a href="#">April 2013</a></li>--%>
                <%--</ol>--%>

                    <h6 class="border-bottom">Related Questions</h6>
                    <ol class="list-unstyled mb-0">
                        <c:forEach items="${rel_questions}" var="rq">
                            <li class="border-bottom"><a href="/j2c/question/${rq.id}">${rq.qsTxt}</a></li>
                        </c:forEach>
                    </ol>

            </div>

            <div class="p-3">
                <a class="btn btn-sm btn-success" href="#" data-toggle="modal" data-target="#exampleModal">+ Ask a Question</a>
            </div>
        </aside><!-- /.blog-sidebar -->

    </div><!-- /.row -->
</main><!-- /.container -->

<footer class="blog-footer">
    <p>
        <a href="#">Back to top</a>
    </p>
</footer>

    <!--  Add User Modal -->
    <%@ include file = "inc_add_user.jsp" %>
    <!-- End add user modal -->

    <!--  Add login Modal -->
    <%@ include file = "inc_login.jsp" %>
    <!-- End login modal -->

    <!--  Add Question Modal -->
    <%@ include file = "inc_add_question.jsp" %>
    <!-- End add question modal -->


    <!--  Add Answer Modal -->
    <%@ include file = "inc_add_answer.jsp" %>
    <!-- End add answer modal -->

    <%@ include file = "about.jsp" %>


    <%@ include file = "inc_tail.jsp" %>


</body>
</html>
