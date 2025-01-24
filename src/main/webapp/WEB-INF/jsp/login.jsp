<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login</title>
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
        .login-container {
            background-color: white;
            padding: 30px;
            border-radius: 8px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
            width: 100%;
            max-width: 400px;
        }
        h1 {
            text-align: center;
            color: #333;
        }
        label {
            display: block;
            margin-bottom: 5px;
            font-size: 14px;
            color: #555;
        }
        input[type="text"], input[type="password"] {
            width: 100%;
            padding: 10px;
            margin-bottom: 15px;
            border: 1px solid #ccc;
            border-radius: 5px;
            box-sizing: border-box;
            font-size: 14px;
        }
        .button {
            width: 100%;
            padding: 10px;
            background-color: #007bff;
            color: white;
            border: none;
            border-radius: 5px;
            font-size: 16px;
            cursor: pointer;
        }
        .button:hover {
            background-color: #0056b3;
        }
        .error-message {
            color: red;
            text-align: center;
            font-size: 14px;
            margin-bottom: 15px;
        }
        .password-container {
            position: relative;
            width: 100%;
        }
        .password-container button {
            position: absolute;
            right: 10px;
            top: 40%; /* Adjusted to move the button higher */
            transform: translateY(-50%);
            background-color: transparent;
            border: none;
            font-size: 14px;
            cursor: pointer;
        }
    </style>
</head>
<body>
    <div class="login-container">
        <h1>Login</h1>
        <div class="error-message">
            <font color="red">${errorMessage}</font>
        </div>
        <form action="/login" method="post">
            <label for="name">User Name</label>
            <input type="text" name="name" id="name" required>

            <label for="password">Password</label>
            <div class="password-container">
                <input type="password" name="password" id="password" required>
                <button type="button" onclick="toggleInputType(this, 'password')">show</button>
            </div>

            <button class="button" type="submit">Login</button>
        </form>
    </div>
</body>
<script>
    function toggleInputType(button, inputId) {
        const inputField = document.getElementById(inputId);

        if (inputField.type === 'password') {
            inputField.type = 'text'; // Show password
            button.textContent = 'hide'; // Change button text to 'hide'
        } else {
            inputField.type = 'password'; // Hide password
            button.textContent = 'show'; // Change button text to 'show'
        }
    }
</script>
</html>
