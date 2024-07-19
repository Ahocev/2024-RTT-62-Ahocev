<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="../include/header.jsp" />

<section style="background-color:gray">
    <div class="container">
        <div class="row pt-5 pb-5">
            <c:if test="${empty form.employeeId}">
                <h1 class="text-center">Create Employee</h1>
            </c:if>
            <c:if test="${not empty form.employeeId}">
                <h1 class="text-center">Edit Employee</h1>
            </c:if>
        </div>
    </div>
</section>

<section class="container">
    <div class="row justify-content-center pt-5">
        <div class="col-6">
            <form action="/employee/createSubmit">
                <input type="hidden" name="employeeId" value="${form.employeeId}">

                <div class="row g-3 align-items-center">
                    <div class="col-3">
                        <label for="emailId" class="col-form-label">Email</label>
                    </div>
                    <div class="col-9">
                        <input type="text" id="emailId" name="email" class="form-control <c:if test="${bindingResult.hasFieldErrors('email')}">is-invalid</c:if>" value="${form.email}">
                    </div>
                </div>
                <c:if test="${bindingResult.hasFieldErrors('email')}">
                    <div class="row align-items-center justify-content-center">
                        <div class="offset-6">
                            <div class="text-danger">
                                <c:forEach items="${bindingResult.getFieldErrors('email')}" var="error">
                                    ${error.defaultMessage}<br>
                                </c:forEach>
                            </div>
                        </div>
                    </div>
                </c:if>
                <div class="row g-3 align-items-center pt-3">
                    <div class="col-3">
                        <label for="firstNameId" class="col-form-label">First Name</label>
                    </div>
                    <div class="col-9">
                        <input type="text" id="firstNameId" name="firstName" class="form-control" value="${form.firstName}">
                    </div>
                </div>
                <div class="row g-3 align-items-center pt-3">
                    <div class="col-3">
                        <label for="lastNameId" class="col-form-label">Last Name</label>
                    </div>
                    <div class="col-9">
                        <input type="text" id="lastNameId" name="lastName" class="form-control" value="${form.lastName}">
                    </div>
                </div>
                <div class="row g-3 align-items-center pt-3">
                    <div class="col-3">
                        <label for="extension" class="col-form-label">Extension</label>
                    </div>
                    <div class="col-9">
                        <input type="text" id="extension" name="extension" class="form-control" value="${form.extension}">
                    </div>
                </div>
                <div class="row g-3 align-items-center pt-3">
                    <div class="col-3">
                        <label for="jobTitle" class="col-form-label">Job Title</label>
                    </div>
                    <div class="col-9">
                        <input type="text" id="jobTitle" name="jobTitle" class="form-control" value="${form.jobTitle}">
                    </div>
                </div>
                <div class="row g-3 align-items-center pt-3">
                    <div class="col-3">
                        <label for="vacationHours" class="col-form-label">Vacation Hours</label>
                    </div>
                    <div class="col-9">
                        <input type="text" id="vacationHours" name="vacationHours" class="form-control" value="${form.vacationHours}">
                    </div>
                </div>
                <div class="row g-3 align-items-center pt-3">
                    <div class="col-3">
                        <label for="profileImageUrl" class="col-form-label">Profile Image URL</label>
                    </div>
                    <div class="col-9">
                        <input type="text" id="profileImageUrl" name="profileImageUrl" class="form-control" value="${form.profileImageUrl}">
                    </div>
                </div>
                <div class="row align-items-center pt-3">
                    <div class="col-3">
                        <label for="reportsTo" class="col-form-label">Reports To</label>
                    </div>
                    <div class="col-9">
                        <select id="reportsTo" name="reportsTo" class="form-control">
                            <c:forEach items="${reportsToEmployees}" var="employee">
                                <option value="${employee.id}"
                                <c:if test="${employee.id == form.reportsTo}"> selected </c:if> > ${employee.firstName} ${employee.lastName} </option>
                            </c:forEach>
                        </select>
                    </div>
                </div>
                <div class="row align-items-center pt-3">
                    <div class="col-3">
                        <label for="officeId" class="col-form-label">Office</label>
                    </div>
                    <div class="col-9">
                        <select id="officeId" name="officeId" class="form-control">
                            <c:forEach items="${offices}" var="office">
                                <option value="${office.id}" <c:if test="${office.id == form.officeId}"> selected </c:if> > ${office.city} </option>
                            </c:forEach>
                        </select>
                    </div>
                </div>
                <div class="row justify-content-center pt-3">
                    <div class="col-auto text-center">
                        <button type="submit" class="btn btn-primary">Submit</button>
                    </div>
                </div>
            </form>
        </div>
    </div>
</section>

<jsp:include page="../include/footer.jsp" />