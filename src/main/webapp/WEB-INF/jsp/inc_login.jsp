
<div class="modal fade" id="loginModal" tabindex="-1" role="dialog" aria-labelledby="loginModalLabel" aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="loginModalLabel">Sign Up</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <form:form action="/j2c//auth" method="post" modelAttribute="usr">
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