<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="../include/header.jsp" />

<h1 class="page-title">This is a customer detail page</h1>

<section>
    <div class="row pt-5">
        <div class="col-12">
            <h2 class="text-center">${customer.customerName}</h2>
        </div>
    </div>
    <div class="row justify-content-center">
        <table class="table table-success table-striped table-bordered table-responsive" style="width: 750pt">
            <tr>
                <td style="font-weight: bolder;">Customer ID:</td>
                <td>${customer.id}</td>
            </tr>
            <tr>
                <td style="font-weight: bolder;">Contact First Name:</td>
                <td>${customer.contactFirstname}</td>
            </tr>
            <tr>
                <td style="font-weight: bolder;">Contact Last Name:</td>
                <td>${customer.contactLastname}</td>
            </tr>
            <tr>
                <td style="font-weight: bolder;">Customer Phone Number:</td>
                <td>${customer.phone}</td>
            </tr>
            <tr>
                <td style="font-weight: bolder;">Address Line 1:</td>
                <td>${customer.addressLine1}</td>
            </tr>
            <tr>
                <td style="font-weight: bolder;">State:</td>
                <td>${customer.state}</td>
            </tr>
            <tr>
                <td style="font-weight: bolder;">Postal Code:</td>
                <td>${customer.postalCode}</td>
            </tr>
            <tr>
                <td style="font-weight: bolder;">Country:</td>
                <td>${customer.country}</td>
            </tr>
            <tr>
                <td style="font-weight: bolder;">Sales Rep Employee Id:</td>
                <td>${customer.salesRepEmployeeId}</td>
            </tr>
            <tr>
                <td style="font-weight: bolder;">Credit Limit:</td>
                <td>${customer.creditLimit}</td>
            </tr>

        </table>
    </div>

</section>


<section>
    <div class="container">
        <div class="row pt-5">
            <div class="col-12">
                <h2 class="text-center">Orders Found (${orders.size()})</h2>
            </div>
        </div>
        <div class="row pt-3">
            <div class="col-12">
                <table class="table">
                    <tr>
                        <th>id</th>
                        <th>order date</th>
                        <th>status</th>
                        <th>sales rep employee id</th>
                        <th>comment</th>
                    </tr>
                    <c:forEach items="${orders}" var="order">
                        <tr>
                            <td>${order.id}</td>
                            <td>${order.orderDate}</td>
                            <td>${order.status}</td>
                            <td>${customer.salesRepEmployeeId}</td>
                            <td>${order.comment}</td>
                        </tr>
                    </c:forEach>
                </table>
            </div>
        </div>
    </div>
</section>
<jsp:include page="../include/footer.jsp" />