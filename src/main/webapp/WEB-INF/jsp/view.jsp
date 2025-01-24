<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> <!-- For JSTL tags -->

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>View Tickets</title>
    <style>
        table {
            width: 100%;
            border-collapse: collapse;
            margin: 20px 0;
        }
        table, th, td {
            border: 1px solid black;
        }
        th, td {
            padding: 10px;
            text-align: left;
        }
    </style>
</head>
<body>
    <h1>Ticket List</h1>
    <table>
        <thead>
            <tr>
                <th>Ticket ID</th>
                <th>Raised By</th>
                <th>Problem Type</th>
                <th>Status</th>
                <th>Description</th>
            </tr>
        </thead>
        <tbody>
            <!-- Iterate over the ticketList and display each ticket -->
            <c:forEach var="ticket" items="${ticketList}">
                <tr>
                    <td>${ticket.id}</td>
                    <td>${ticket.raisedby}</td>
                    <td>${ticket.problemType}</td>
                    <td>${ticket.status}</td>
                    <td>${ticket.problemDescription}</td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</body>
</html>
