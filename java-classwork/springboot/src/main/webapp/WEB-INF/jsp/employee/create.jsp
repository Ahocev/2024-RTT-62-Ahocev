<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="../include/header.jsp" />

<section style="background-color:gray">
    <div class="container">
        <div class="row pt-5 pb-5">
            <h1 class="text-center">Create Employee</h1>
        </div>
    </div>
</section>

<section class="container">
    <div class="row justify-content-center pt-5">
        <div class="col-6">
            <form action="/employee/createSubmit">
                <div class="row g-3 align-items-center pb-3">
                    <div class="col-3">
                        <label for="emailId" class="col-form-label">Email</label>
                    </div>
                    <div class="col-9">
                        <input type="text" id="emailId" name="email" class="form-control">
                    </div>
                </div>
                <div class="row g-3 align-items-center pb-3">
                    <div class="col-3">
                        <label for="firstNameId" class="col-form-label">First Name</label>
                    </div>
                    <div class="col-9">
                        <input type="text" id="firstNameId" name="firstName" class="form-control">
                    </div>
                </div>
                <div class="row g-3 align-items-center pb-3">
                    <div class="col-3">
                        <label for="lastNameId" class="col-form-label">Last Name</label>
                    </div>
                    <div class="col-9">
                        <input type="text" id="lastNameId" name="lastName" class="form-control">
                    </div>
                </div>
                <div class="row align-items-center pb-3">
                    <div class="col-3">
                        <label for="reportsTo" class="col-form-label">Reports To</label>
                    </div>
                    <div class="col-9">
                        <select id="reportsTo" name="reportsTo" class="form-control">
                            <c:forEach items="${reportsToEmployees}" var="employee">
                                <option value="${employee.id}"> ${employee.firstName} ${employee.lastName} </option>
                            </c:forEach>
                        </select>
                    </div>
                </div>
                <div class="row justify-content-center">
                    <div class="col-auto text-center">
                        <button type="submit" class="btn btn-primary">Submit</button>
                    </div>
                </div>
            </form>
        </div>
    </div>
</section>

<jsp:include page="../include/footer.jsp" />