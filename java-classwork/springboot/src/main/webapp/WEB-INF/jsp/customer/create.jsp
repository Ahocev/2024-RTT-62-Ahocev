<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="../include/header.jsp" />

<section style="background-color:gray">
    <div class="container">
        <div class="row pt-5 pb-5">
            <c:if test="${empty form.customerId}">
            <h1 class="text-center">Create Customer</h1>
            </c:if>
            <c:if test="${not empty form.customerId}">
                <h1 class="text-center">Edit Customer</h1>
            </c:if>
        </div>
    </div>
</section>

<section class="container">
    <div class="row justify-content-center pt-5">
        <div class="col-6">
            <form action="/customer/createSubmit">
                <input type="hidden" name="customerId" value="${form.customerId}">

                <div class="row g-3 align-items-center pb-3">
                    <div class="col-3">
                        <label for="customerName" class="col-form-label">Customer Name</label>
                    </div>
                    <div class="col-9">
                        <input type="text" id="customerName" name="customerName" class="form-control" value="${form.customerName}">
                    </div>
                </div>

                <div class="row g-3 align-items-center pb-3">
                    <div class="col-3">
                        <label for="contactFirstname" class="col-form-label">Contact First Name</label>
                    </div>
                    <div class="col-9">
                        <input type="text" id="contactFirstname" name="contactFirstname" class="form-control" value="${form.contactFirstname}">
                    </div>
                </div>

                <div class="row g-3 align-items-center pb-3">
                    <div class="col-3">
                        <label for="contactLastname" class="col-form-label">Contact Last Name</label>
                    </div>
                    <div class="col-9">
                        <input type="text" id="contactLastname" name="contactLastname" class="form-control" value="${form.contactLastname}">
                    </div>
                </div>

                <div class="row g-3 align-items-center pb-3">
                    <div class="col-3">
                        <label for="phone" class="col-form-label">Phone</label>
                    </div>
                    <div class="col-9">
                        <input type="text" id="phone" name="phone" class="form-control" value="${form.phone}">
                    </div>
                </div>

                <div class="row g-3 align-items-center pb-3">
                    <div class="col-3">
                        <label for="addressLine1" class="col-form-label">Address</label>
                    </div>
                    <div class="col-9">
                        <input type="text" id="addressLine1" name="addressLine1" class="form-control" value="${form.addressLine1}">
                    </div>
                </div>

                <div class="row g-3 align-items-center pb-3">
                    <div class="col-3">
                        <label for="city" class="col-form-label">City</label>
                    </div>
                    <div class="col-9">
                        <input type="text" id="city" name="city" class="form-control" value="${form.city}">
                    </div>
                </div>

                <div class="row g-3 align-items-center pb-3">
                    <div class="col-3">
                        <label for="state" class="col-form-label">State</label>
                    </div>
                    <div class="col-9">
                        <input type="text" id="state" name="state" class="form-control" value="${form.state}">
                    </div>
                </div>

                <div class="row g-3 align-items-center pb-3">
                    <div class="col-3">
                        <label for="country" class="col-form-label">Country</label>
                    </div>
                    <div class="col-9">
                        <input type="text" id="country" name="country" class="form-control" value="${form.country}">
                    </div>
                </div>

                <div class="row align-items-center pb-3">
                    <div class="col-3">
                        <label for="salesRepEmployeeId" class="col-form-label">Sales Rep Employee ID</label>
                    </div>
                    <div class="col-9">
                        <select id="salesRepEmployeeId" name="salesRepEmployeeId" class="form-control">
                            <c:forEach items="${employees}" var="employee">
                                <option value="${employee.id}"> ${employee.id}</option>
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