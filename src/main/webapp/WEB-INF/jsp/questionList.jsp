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
        .change_cursor {
            cursor: pointer;
        }
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



        .has-search .form-control {
            padding-left: 2.375rem;
        }

        .has-search .form-control-feedback {
            position: absolute;
            z-index: 2;
            display: block;
            width: 2.375rem;
            height: 2.375rem;
            line-height: 2.375rem;
            text-align: center;
            pointer-events: none;
            color: #aaa;
        }

        .myNewDivHeight{
             height:250px;
             overflow: hidden;
        }

    </style>

    <script language="JavaScript">
        function redirectLang() {
            var langSelected = document.getElementById("selLangID").selectedIndex
            if(langSelected == 1) {
                window.location.href = "/j2c?lang=hi"
            } else {
                window.location.href = "/j2c?lang=en"
            }
        }

        function defaultLang() {
            if('en' == '<c:out value="${selLang}"/>')
            {
                document.getElementById("selLangID").selectedIndex = 0;
            } else {
                document.getElementById("selLangID").selectedIndex = 1
            }
        }

        function fetchQuestion(qid) {
            // alert('redirecting -->'+ qid)
            window.location.href = "/j2c/question/" + qid;
        }
    </script>

</head>

<body class="bg-light" onload="defaultLang()">

<div class="container">

    <header class="blog-header py-3">
        <div class="row flex-nowrap justify-content-between align-items-center">
            <div class="col-4 pt-1">
                <a class="blog-post-title text-dark" href="#">Join2Cure</a>
                <!--<a class="blog-post-title text-dark" href="#"> Sample </a> -->
            </div>
            <div class="col-4 text-center">
                <span class="p-2 text-dark">
                                <strong>Choose a Language :</strong>
                                <select  id="selLangID" onchange="redirectLang()">
                                    <option>English</option>
                                    <option>Hindi</option>
                                </select>
                            </span>


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
                        <%--<button type="submit" image="">--%>
                        <%--<svg xmlns="http://www.w3.org/2000/svg"--%>
                        <%--width="20" height="20" viewBox="0 0 24 24" fill="none"--%>
                        <%--stroke="currentColor" stroke-width="2" stroke-linecap="round"--%>
                        <%--stroke-linejoin="round" class="mx-3"><circle cx="10.5" cy="10.5" r="7.5"></circle>--%>
                        <%--<line x1="21" y1="21" x2="15.8" y2="15.8"></line>--%>

                        <%--</svg></button>--%>
                        <%--</td>--%>
                        <%--</tr>--%>
                        <%--</table>--%>
                        <%--</form:form>--%>

                        <div class="main">

                            <!-- Another variation with a button -->
                            <form:form action="/j2c/m/srch" method="post" modelAttribute="srch">
                                <div class="input-group">
                                        <%--<input type="text" class="form-control" placeholder="Search">--%>
                                    <form:input path="srchTxt" class="form-control" placeholder="Search" id="srchTxtId"/>
                                    <div class="input-group-append">
                                        <button class="btn btn-secondary" type="submit">
                                            <i class="fa fa-search"></i>
                                        </button>
                                    </div>
                                </div>
                            </form:form>

                        </div>


                        <!--
                    <%--<form:form action="/j2c/m/srch" method="post" modelAttribute="srch">--%>
                        <div class="input-group md-form form-sm form-2 pl-0">
                            <%--<input class="form-control my-0 py-1 lime-border" type="text" placeholder="Search" aria-label="Search">--%>
                            <%--<form:input path="srchTxt" class="form-control" id="srchTxtId"/>--%>
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
                    <%--</form:form>--%>
                    -->
                    </td></tr>


                    <%--<tr>--%>
                    <%--<td>--%>
                    <%--<a class="btn btn-sm btn-danger" href="#" data-toggle="modal" data-target="#exampleModal">Ask Question</a>--%>
                    <%--</td>--%>
                    <%--</tr>--%>

                </table>

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
            <%--<a class="p-2 text-success text-right" href="#" data-toggle="modal" data-target="#loginModal">Login</a>--%>
            <%--<a class="p-2 text-success text-right" href="#" data-toggle="modal" data-target="#userModal">Sign Up</a>--%>

            <div width="100%" class="w-100 text-right">
                <a class="btn btn-sm btn-danger" href="#" data-toggle="modal" data-target="#exampleModal">Ask Question</a>
            </div>
        </nav>
    </div>

    <div class="alert alert-secondary alert-dismissible fade show" role="alert">
        <strong>Join2Cure</strong> is an anonymous forum/community for all your health related queries.
        <button type="button" class="close" data-dismiss="alert" aria-label="Close">
            <span aria-hidden="true">&times;</span>
        </button>
    </div>

    <!--
    <div class="jumbotron p-3 p-md-5 text-white rounded bg-dark">
        <button type="button" class="close text-right" data-dismiss="modal" aria-label="Close">
            <span aria-hidden="true">&times;</span>
        </button>
        <div class="col-md-6 px-0">
            <p class="lead my-3">Multiple lines of text that form the lede, informing new readers quickly and efficiently about what's most interesting in this post's contents.</p>
            <p class="lead mb-0"><a href="#" class="text-white font-weight-bold">Continue reading...</a></p>
        </div>
    </div>
    -->

    <!--
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

            <aside class="col-md-3 blog-sidebar">

                <div class="p-3 bg-white">

                    <h6 class="border-bottom alert">Topics</h6>
                    <ol id="topicsListID" class="list-unstyled mb-0 scroll-bar">
                        <c:forEach items="${topics}" var="topic">
                            <c:if test = "${topic.topicId == 0}">
                                <li><a href="/j2c/topic/${topic.topicId}/questionsList" class="alert text-danger">${topic.topicName}</a></li>
                                <li>&nbsp;</li>
                            </c:if>
                            <c:if test = "${topic.topicId > 0}">
                                <li><a href="/j2c/topic/${topic.topicId}/questionsList" class="alert text-info">${topic.topicName}</a></li>
                                <li>&nbsp;</li>
                            </c:if>
                            <%--<c:if test = "${topic.topicId >= 10}">--%>
                            <%--<li class="d-none"><a href="/j2c/topic/${topic.topicId}/questionsList" class="text-dark">${topic.topicName}</a></li>--%>
                            <%--<li class="d-none">&nbsp;</li>--%>
                            <%--</c:if>--%>
                        </c:forEach>
                    </ol>
                    <%--<button id="moreTopics" onclick="showMoreTopics()">more...</button>--%>

                </div>

                <div class="p-3">
                    <%--<a class="btn btn-sm btn-success" href="#" data-toggle="modal" data-target="#exampleModal">+ Ask a Question</a>--%>
                </div>
            </aside><!-- /.blog-sidebar -->


            <div class="col-md-9 blog-main">

                <c:forEach items="${questions}" var="qs">
                    <div class="my-3 p-3 bg-white rounded box-shadow change_cursor" id="div_${qs.id}" onclick="fetchQuestion('${qs.id}')">
                        <h6 class="border-bottom border-gray pb-2 mb-0"><font color="black">
                            <a href="/j2c/question/${qs.id}" class="text-dark">${qs.qsTxt}</a></font></h6>
                        <div class="media text-muted pt-3">
                                <%--<textarea class="form-control rounded-0 text-left" contenteditable="false" rows="2">--%>
                            <c:out value="${qs.firstAnswer.ansTxt}" escapeXml="false"/>
                                <%--</textarea>--%>
                        </div>
                        <small class="d-block text-right mt-3">
                            <p class="media-body pb-3 mb-0 small lh-125 border-bottom border-gray">
                                <strong class="d-block text-gray-dark">${qs.createDate} by ${qs.displayName}</strong>
                            </p>
                        </small>
                        <small class="d-block text-right mt-3">
                            <a href="/j2c/question/${qs.id}">All Answers</a>
                        </small>
                    </div>
                </c:forEach>

            </div><!-- /.blog-main -->


        </div><!-- /.row -->
    </main><!-- /.container -->

    <footer class="blog-footer">
        <p>Built by SOL-Ventures</p>
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

    <div class="modal modal-lg" id="ansModal" tabindex="-1" role="dialog" aria-labelledby="ansModalLabel" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="ansModalLabel">${question.qsTxt}</h5>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <form:form action="/j2c/addAnswer" method="post" modelAttribute="ans">
                    <form:input path="questionId" type="hidden" name="questionId" value="${question.id}"/>
                    <div class="modal-body">


                        <div class="form-group">
                            <label for="qsTxt">Your Answer</label>
                            <form:textarea path="ansTxt" rows="7"></form:textarea>

                        </div>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                        <input type="submit" class="btn btn-primary" value="Submit" />
                    </div>
                </form:form>
            </div>
        </div>
    </div>


    <!-- End add answer modal -->
    <div class="modal fade" id="aboutModal" tabindex="-1" role="dialog" aria-labelledby="aboutModalLabel" aria-hidden="true">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="aboutModalLabel">About</h5>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <div class="modal-body">
                    <div class="bg-light rounded alert alert-dismissible">
                        <p class="mb-0">
                            Get answers to your health related queries.
                        </p>
                        <!-- <a class="btn btn-sm btn-warning" href="#">Login</a>
                        <a class="btn btn-sm btn-primary" href="#">Sign Up</a> -->
                    </div>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                </div>
            </div>
        </div>
    </div>

    <div class="modal fade bd-example-modal-lg" tabindex="-1" role="dialog" aria-labelledby="myLargeModalLabel" aria-hidden="true">
        <div class="modal-dialog modal-lg">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="ansModalLabel">${question.qsTxt}</h5>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <form:form action="/j2c/addAnswer" method="post" modelAttribute="ans">
                    <form:input path="questionId" type="hidden" name="questionId" value="${question.id}"/>
                    <div class="modal-body">


                        <div class="form-group">
                            <label for="qsTxt">Your Answer</label>
                            <form:textarea path="ansTxt" rows="15" id="summernote"></form:textarea>

                        </div>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                        <input type="submit" class="btn btn-primary" value="Submit" />
                    </div>
                </form:form>
                <script>
                    $('#summernote').summernote({
                        placeholder: 'Hello bootstrap 4',
                        tabsize: 2,
                        height: 100
                    });
                </script>
            </div>
        </div>
    </div>

    <%@ include file = "inc_tail.jsp" %>
    <script>
        function showMoreTopics() {
            alert('came here')

            $("ol li").removeClass("d-none").addClass("d-block");
            $('#moreTopics').hide();
            alert('done')

        }

    </script>

</body>
</html>