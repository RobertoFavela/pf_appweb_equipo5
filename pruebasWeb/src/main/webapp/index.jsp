<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="style.css">
    <title>Login & Register</title>
</head>
<body>

<div class="container" id="container">
    <!-- Formulario de registro -->
    <div class="form-container sign-up-container">
        <form action="RegisterControlador" method="post">
            <h1>Create Account</h1>
            <div class="social-container">
                <a href="#" class="social"><i class="fab fa-facebook-f"></i></a>
                <a href="#" class="social"><i class="fab fa-google-plus-g"></i></a>
                <a href="#" class="social"><i class="fab fa-linkedin-in"></i></a>
            </div>
            <span>or use your email for registration</span>
            <input type="text" placeholder="Name" name="name" required />
            <input type="email" placeholder="Email" name="email" required />
            <input type="password" placeholder="Password" name="password" required />
            <button type="submit">Sign Up</button>
        </form>
    </div>

    <!-- Formulario de inicio de sesión -->
    <div class="form-container sign-in-container">
        <form action="LoginControlador" method="post">
            <h1>Sign In</h1>
            <div class="social-container">
                <a href="#" class="social"><i class="fab fa-facebook-f"></i></a>
                <a href="#" class="social"><i class="fab fa-google-plus-g"></i></a>
                <a href="#" class="social"><i class="fab fa-linkedin-in"></i></a>
            </div>
            <span>or use your account</span>
            <input type="email" placeholder="Email" name="email" required />
            <input type="password" placeholder="Password" name="password" required />
            <a href="#" class="forgot">Forgot your password?</a>
            <button type="submit">Sign In</button>
        </form>
    </div>

    <!-- Contenedor de la superposición -->
    <div class="overlay-container">
        <div class="overlay">
            <div class="overlay-panel overlay-left">
                <h1>Welcome Back!</h1>
                <p>To keep connected with us please login with your personal info</p>
                <button class="ghost" id="signIn">Sign In</button>
            </div>
            <div class="overlay-panel overlay-right">
                <h1>Hello, Friend!</h1>
                <p>Enter your personal details and start journey with us</p>
                <button class="ghost" id="signUp">Sign Up</button>
            </div>
        </div>
    </div>
</div>

<script>
    const container = document.getElementById('container');
    const signInButton = document.getElementById('signIn');
    const signUpButton = document.getElementById('signUp');

    signInButton.addEventListener('click', () => {
        container.classList.remove('right-panel-active');
    });

    signUpButton.addEventListener('click', () => {
        container.classList.add('right-panel-active');
    });
</script>

</body>
</html>
