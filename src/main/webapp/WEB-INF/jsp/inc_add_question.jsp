<script language="JavaScript">
    $()
</script>
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
                        <form:select class="form-control" id="exampleFormControlSelect2" path="topicId" >
                            <c:forEach var="tpc" items="${topics}">
                                <option value="${tpc.topicId}"><c:out value="${tpc.topicName}"/></option>
                            </c:forEach>
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