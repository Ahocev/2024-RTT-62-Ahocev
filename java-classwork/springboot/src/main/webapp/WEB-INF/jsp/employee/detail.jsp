<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="../include/header.jsp" />

<h1 class="page-title">This is an employee detail page</h1>

<section>
    <div class="row pt-5">
        <div class="col-12">
            <h2 class="text-center">Employee ${employee.firstName} ${employee.lastName}</h2>
        </div>
    </div>
    <div class="row justify-content-center">
        <table class="table table-success table-striped table-bordered table-responsive" style="width: 750pt">
            <tr>
                <td style="font-weight: bolder;">Employee ID:</td>
                <td><a href="employee/edit?employeeId=${employee.id}">${employee.id}</a></td>
            </tr>
            <tr>
                <td style="font-weight: bolder;">Office ID:</td>
                <td>${employee.officeId}</td>
            </tr>
            <tr>
                <td style="font-weight: bolder;">Office City:</td>
                <td>${employee.office.city}</td>
            </tr>
            <tr>
                <td style="font-weight: bolder;">Office Phone Number:</td>
                <td>${employee.office.phone}</td>
            </tr>
            <tr>
                <td style="font-weight: bolder;">Full Name:</td>
                <td>${employee.firstName} ${employee.lastName}</td>
            </tr>
            <tr>
                <td style="font-weight: bolder;">Extension:</td>
                <td>${employee.extension}</td>
            </tr>
            <tr>
                <td style="font-weight: bolder;">Email:</td>
                <td>${employee.email}</td>
            </tr>
            <tr>
                <td style="font-weight: bolder;">Job Title:</td>
                <td>${employee.jobTitle}</td>
            </tr>
            <tr>
                <td style="font-weight: bolder;">Vacation Hours:</td>
                <td>${employee.vacationHours}</td>
            </tr>
            <tr>
                <td style="font-weight: bolder;">Profile Image URL:</td>
                <td>${employee.profileImageUrl}</td>
            </tr>

        </table>
    </div>

</section>


<section>
    <div class="container">
        <div class="row pt-5">
            <div class="col-12">
                <h2 class="text-center">Customers Found (${customers.size()})</h2>
            </div>
        </div>
        <div class="row pt-3">
            <div class="col-12">
                <table class="table">
                    <tr>
                        <th>id</th>
                        <th>name</th>
                        <th>Contact Name</th>
                        <th>state</th>
                        <th>postal</th>
                        <th>country</th>
                    </tr>
                    <c:forEach items="${customers}" var="customer">
                        <tr>
                            <td>${customer.id}</td>
                            <td>${customer.customerName}</td>
                            <td>${customer.contactFirstname} ${customer.contactLastname}</td>
                            <td>${customer.state}</td>
                            <td>${customer.postalCode}</td>
                            <td>${customer.country}</td>
                        </tr>
                    </c:forEach>
                </table>
            </div>
        </div>
    </div>
</section>
<jsp:include page="../include/footer.jsp" />