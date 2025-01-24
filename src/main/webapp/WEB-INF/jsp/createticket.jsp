<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Raise a Ticket</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f7fa;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            margin: 0;
        }
        .ticket-container {
            background-color: white;
            padding: 30px;
            border-radius: 8px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
            width: 100%;
            max-width: 500px;
        }
        h1 {
            text-align: center;
            color: #333;
        }
        label {
            display: block;
            margin-bottom: 10px;
            font-size: 14px;
            color: #555;
        }
        select, textarea {
            width: 100%;
            padding: 10px;
            margin-bottom: 20px;
            border: 1px solid #ccc;
            border-radius: 5px;
            font-size: 14px;
        }
        button {
            width: 100%;
            padding: 10px;
            background-color: #007bff;
            color: white;
            border: none;
            border-radius: 5px;
            font-size: 16px;
            cursor: pointer;
            transition: background-color 0.3s ease;
        }
        button:hover {
            background-color: #0056b3;
        }
        .form-group {
            margin-bottom: 20px;
        }
    </style>
</head>
<body>
    <div class="ticket-container">
        <h1>Raise a Ticket</h1>
        <form action="/createTicket" method="post">
            <!-- Problem Type Dropdown -->
            <div class="form-group">
                <label for="problemType">Problem Type</label>
                <select id="problemType" name="problemType" required>
                    <option value="">Select Problem Type</option>
                    <option value="Hardware">Hardware</option>
                    <option value="Software">Software</option>
                </select>
            </div>

            <!-- Problem Description Textarea -->
            <div class="form-group">
                <label for="problemDescription">Problem Description</label>
                <textarea id="problemDescription" name="problemDescription" rows="5" placeholder="Describe your problem in detail..." required></textarea>
            </div>

            <!-- Submit Button -->
            <button type="submit">Submit Ticket</button>
        </form>
    </div>
</body>
</html>
