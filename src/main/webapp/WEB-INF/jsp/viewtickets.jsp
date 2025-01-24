
<!DOCTYPE html>
<html lang="en">

<body>
    <h1>Ticket List</h1>
    <ul>
        <!-- Loop through the dataList -->
        <c:forEach var="ticket" items="${ticketList}">
            <li>${ticket}</li>
        </c:forEach>
    </ul>
</body>
</html>
