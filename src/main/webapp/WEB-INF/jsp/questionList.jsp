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

    <!-- Bootstrap core CSS -->
    <link href="/css/bootstrap.min.css" rel="stylesheet" />
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
    <!-- Custom styles for this template -->
    <link href="/css/f.css" rel="stylesheet" />
    <link href="/css/blog.css" rel="stylesheet" />



    <link href="https://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.9/summernote-bs4.css" rel="stylesheet">


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

    <div class="alert alert-secondary alert-dismissible fade show" role="alert">
        <strong>Join2Cure</strong> is your resource for all your health related queries @India.
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

                    <h6 class="border-bottom">Topics</h6>
                    <ol class="list-unstyled mb-0">
                        <c:forEach items="${topics}" var="topic">
                            <li><a href="/j2c/topic/${topic.topicId}/questionsList" class="text-dark">${topic.topicName}</a></li>
                            <li>&nbsp;</li>
                        </c:forEach>
                    </ol>

                </div>

                <div class="p-3">
                    <a class="btn btn-sm btn-success" href="#" data-toggle="modal" data-target="#exampleModal">+ Ask a Question</a>
                </div>
            </aside><!-- /.blog-sidebar -->


            <div class="col-md-9 blog-main">

                <c:forEach items="${questions}" var="qs">
                    <div class="my-3 p-3 bg-white rounded box-shadow">
                        <h6 class="border-bottom border-gray pb-2 mb-0"><font color="black"><a href="/j2c/question/${qs.id}" class="text-dark">${qs.qsTxt}</a></font></h6>
                        <div class="media text-muted pt-3">
                                <c:out value="${qs.firstAnswer.ansTxt}" escapeXml="false"/>
                        </div>
                        <small class="d-block text-right mt-3">
                            <p class="media-body pb-3 mb-0 small lh-125 border-bottom border-gray">
                                <strong class="d-block text-gray-dark">January 1, 2014 by @mark</strong>
                            </p>
                        </small>
                        <small class="d-block text-right mt-3">
                            <a href="/j2c/question/${qs.id}">All Answers</a>
                        </small>
                    </div>
                </c:forEach>

                <nav class="blog-pagination">
                    <a class="btn btn-outline-primary" href="#">Older</a>
                    <a class="btn btn-outline-secondary disabled" href="#">Newer</a>
                </nav>

            </div><!-- /.blog-main -->


        </div><!-- /.row -->o
    </main><!-- /.container -->

    <footer class="blog-footer">
        <p>Blog template built for <a href="https://getbootstrap.com/">Bootstrap</a> by <a href="https://twitter.com/mdo">@mdo</a>.</p>
        <p>
            <a href="#">Back to top</a>
        </p>
    </footer>

    <!--  Add User Modal -->

    <div class="modal fade" id="userModal" tabindex="-1" role="dialog" aria-labelledby="userModalLabel" aria-hidden="true">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="userModalLabel">Sign Up</h5>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <form:form action="/j2c/addUser" method="post" modelAttribute="usr">
                    <div class="modal-body">

                        <div class="form-group">
                            <label for="email">Email</label>
                            <form:input path="email" class="form-control" id="email"></form:input>
                        </div>
                        <div class="form-group">
                            <label for="pwd">Password</label>
                            <form:password path="pwd" class="form-control" id="pwd"></form:password>
                        </div>

                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                        <input type="submit" class="btn btn-secondary" value="Submit" />
                    </div>
                </form:form>
            </div>
        </div>
    </div>
    <!-- End add user modal -->

    <!--  Add login Modal -->

    <div class="modal fade" id="loginModal" tabindex="-1" role="dialog" aria-labelledby="loginModalLabel" aria-hidden="true">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="loginModalLabel">Sign Up</h5>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <form:form action="/j2c/auth" method="post" modelAttribute="usr">
                    <div class="modal-body">

                        <div class="form-group">
                            <label for="email2">Email</label>
                            <form:input path="email" class="form-control" id="email2"></form:input>
                        </div>
                        <div class="form-group">
                            <label for="pwd2">Password</label>
                            <form:password path="pwd" class="form-control" id="pwd2"></form:password>
                        </div>

                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                        <input type="submit" class="btn btn-secondary" value="Submit" />
                    </div>
                </form:form>
            </div>
        </div>
    </div>
    <!-- End login modal -->

    <!--  Add Question Modal -->

    <div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="exampleModalLabel">Ask a Question</h5>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <form:form action="/j2c/addQuestion" method="post" modelAttribute="qst">
                    <div class="modal-body">


                        <div class="form-group">
                            <label for="qsTxt">Question Text</label>
                            <form:textarea path="qsTxt" class="form-control" id="qsTxt" rows="3"></form:textarea>
                        </div>
                        <div class="form-group">
                            <label for="exampleFormControlSelect2">Topic</label>
                            <form:select class="form-control" id="exampleFormControlSelect2" path="topicId">
                                <option>Select</option>
                                <option>1</option>
                                <option>2</option>
                                <option>3</option>
                                <option>4</option>
                                <option>5</option>
                            </form:select>
                        </div>

                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                        <input type="submit" class="btn btn-secondary" value="Submit" />
                    </div>
                </form:form>
            </div>
        </div>
    </div>
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

    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script>window.jQuery || document.write('<script src="assets/js/vendor/jquery-slim.min.js"><\/script>')</script>
    <script src="/assets/js/vendor/popper.min.js"></script>
    <script src="/js/bootstrap.min.js"></script>
    <script src="/assets/js/vendor/holder.min.js"></script>

    <script src="https://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.9/summernote-bs4.js"></script>

    <script>
        Holder.addTheme('thumb', {
            bg: '#55595c',
            fg: '#eceeef',
            text: 'Thumbnail'
        });
    </script>
    <script>
        $(document).ready(function() {
            $('#summernote').summernote();
        });
    </script>


</body>
</html>