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

</head>

<body class="bg-light">

<div class="container">




    <header class="blog-header py-3">
        <div class="row flex-nowrap justify-content-between align-items-center">
            <div class="col-4 pt-1">
                <a class="blog-post-title text-dark" href="#">Join2Cure</a>
            </div>
            <div class="col-4 text-center">

            </div>
            <div class="col-4 d-flex justify-content-end align-items-center">
                <a class="text-muted" href="#">
                    <svg xmlns="http://www.w3.org/2000/svg" width="20" height="20" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round" class="mx-3"><circle cx="10.5" cy="10.5" r="7.5"></circle><line x1="21" y1="21" x2="15.8" y2="15.8"></line></svg>
                </a>
                <a class="btn btn-sm btn-danger" href="#" data-toggle="modal" data-target="#exampleModal">Ask Question</a>
            </div>
        </div>
    </header>

    <div class="nav-scroller py-1 mb-2">
        <nav class="nav d-flex">
            <a class="p-2 text-dark" href="#">Home</a>
            <a class="p-2 text-dark" href="#" data-toggle="modal" data-target="#aboutModal">About</a>
            <!--<a class="p-2 text-muted" href="#">Answer</a>
            <a class="p-2 text-muted" href="#">Login</a>
            <a class="p-2 text-muted" href="#">Sign Up</a> -->
            <!--<a class="p-2 text-muted" href="#">Technology</a>
            <a class="p-2 text-muted" href="#">Design</a>
            <a class="p-2 text-muted" href="#">Culture</a>
            <a class="p-2 text-muted" href="#">Business</a>
            <a class="p-2 text-muted" href="#">Politics</a>
            <a class="p-2 text-muted" href="#">Opinion</a>
            <a class="p-2 text-muted" href="#">Science</a>
            <a class="p-2 text-muted" href="#">Health</a>
            <a class="p-2 text-muted" href="#">Style</a>
            <a class="p-2 text-muted" href="#">Travel</a> -->
            <a class="p-2 text-success text-right" href="#" data-toggle="modal" data-target="#loginModal">Login</a>
            <a class="p-2 text-success text-right" href="#" data-toggle="modal" data-target="#userModal">Sign Up</a>
        </nav>
    </div>



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
                        <p class="blog-post-meta">January 1, 2014 by <a href="#">Mark</a></p>
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
                <button class="btn btn-sm btn-primary" href="#" data-toggle="modal" data-target=".bd-example-modal-lg">Answer</button>
            </div>

            <div>
                <span>&nbsp;</span>
            </div>

            <div class="p-3">

                <h6 class="border-bottom">Related Questions</h6>
                <ol class="list-unstyled mb-0">
                    <li><a href="#">Has insulin some side defects ?</a></li>
                    <li>&nbsp;</li>
                    <li><a href="#">What is the effect of diabetes on teeth?</a></li>
                    <li>&nbsp;</li>
                    <li><a href="#">What affect does diabetes have for cataract operation ?</a></li>
                    <li>&nbsp;</li>
                    <li><a href="#">December 2013</a></li>
                    <li>&nbsp;</li>
                    <li><a href="#">November 2013</a></li>
                    <li>&nbsp;</li>
                    <li><a href="#">April 2013</a></li>
                </ol>

            </div>

            <div class="p-3">
                <a class="btn btn-sm btn-success" href="#" data-toggle="modal" data-target="#exampleModal">+ Ask a Question</a>
            </div>
        </aside><!-- /.blog-sidebar -->

    </div><!-- /.row -->o
</main><!-- /.container -->

<footer class="blog-footer">
    <p>Blog template built for <a href="https://getbootstrap.com/">Bootstrap</a> by <a href="https://twitter.com/mdo">@mdo</a>.</p>
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
