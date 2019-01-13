
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

