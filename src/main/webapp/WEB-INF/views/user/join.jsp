<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Membership Form</title>
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
    <style>
        body {
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            background-color: #FDF1F1; /* 배경색을 흰색으로 설정 */
        }
        .form-container {
            max-width: 400px;
            width: 100%;
        }
        .form-container h1 {
            font-size: 24px;
            margin-bottom: 10px;
            font-weight: 700; /* 글씨체를 더 두껍게 설정 */
        }
        .form-container p {
            margin-bottom: 20px;
            color: #6c757d; /* 부트스트랩의 text-muted 색상 */
        }
        .form-container .form-group {
            margin-bottom: 15px;
        }
        .form-container .btn {
            width: 100%;
        }
    </style>
</head>
<body>
<div class="form-container">
    <h1 class="text-center">Membership Form</h1>
    <p class="text-center">Join our community and enjoy exclusive benefits!</p>
    <form>
        <div class="form-group">
            <label for="fullName">Full Name</label>
            <input type="text" class="form-control" id="fullName" placeholder="John Doe">
        </div>
        <div class="form-group">
            <label for="email">Email</label>
            <input type="email" class="form-control" id="email" placeholder="johndoe@example.com">
        </div>
        <div class="form-group">
            <label for="password">Password</label>
            <input type="password" class="form-control" id="password" placeholder="Password">
        </div>
        <div class="form-group">
            <label for="confirmPassword">Confirm Password</label>
            <input type="password" class="form-control" id="confirmPassword" placeholder="Confirm Password">
        </div>
        <div class="form-group">
            <label>Phone Number</label>
            <input type="text" class="form-control" id="phone-number" placeholder="Confirm Phone Number">
        </div>
        <button type="submit" class="btn btn-dark" style="background: #ff69b4">Register</button>
    </form>
</div>
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.4/dist/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>