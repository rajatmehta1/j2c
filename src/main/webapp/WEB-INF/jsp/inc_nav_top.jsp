<div class="nav-scroller py-1 mb-2">
    <nav class="nav d-flex">
        <a class="p-2 text-dark" href="/j2c?lang=en">Home</a>
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
            <a class="btn btn-sm btn-danger"
               href="#" data-toggle="modal" data-target="#exampleModal">Ask Question</a>
        </div>

    </nav>
</div>


<!--  Add User Modal -->
<%@ include file = "inc_add_user.jsp" %>
<!-- End add user modal -->

<!--  Add login Modal -->
<%@ include file = "inc_login.jsp" %>
<!-- End login modal -->
