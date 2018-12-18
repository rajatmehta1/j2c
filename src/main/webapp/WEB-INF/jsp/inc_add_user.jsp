<div class="modal fade" id="userModal" tabindex="-1" role="dialog" aria-labelledby="userModalLabel" aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="userModalLabel">Sign Up</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <form:form action="/j2c/j2c/addUser" method="post" modelAttribute="usr">
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
