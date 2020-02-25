<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html>
<html>

<head>
    <title>NOTEBOOK - Connect your world</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="resources/font-awesome/css/font-awesome.min.css">

    <link rel="stylesheet" href="resources/bootstrap/css/bootstrap.min.css">
    <script src="resources/js/jquery-2.2.4.min.js"></script>
    <script src="resources/bootstrap/js/bootstrap.min.js"></script>

    <link rel="stylesheet" href="resources/css/main.css">
</head>

<body>
    <nav class="container-fluid" id="main-nav-login">
        <div class="container">
            <div class="row">
                <div class="col-md-6">
                    <a href="/" id="logo-large">NOTEBOOK</a>
                </div>
            </div>
        </div>
    </nav>

    <section class="container-fluid" style="background-color: #e9ebee; margin-top:-30px;">
        <div class="container">
            <div class="row">
                <div class="col-md-12">
                    <form action="login" method="post" id="body-login-form">
                        <label>Login to NOTEBOOK</label>
                        <p style="color: red">${status}</p>
                        <input type="text" name="user" placeholder="Email address or phone number" />
                        <input type="password" name="pass" placeholder="Password" />
                        <button type="submit" id="btn-login">Login</button>
                        <a href="/">Forgotten password?</a>
                        <a href="/">Signup for NoteBook?</a>
                    </form>
                    
                    
                </div>
            </div>
        </div>
    </section>

    <footer class="container">
        <ul id="lans">
            <li>English (UK)</li>
            <li>
                <a href="#">Tiếng việt</a>
            </li>
            <li>
                <a href="#">中文(台灣)</a>
            </li>
            <li>
                <a href="#">한국어</a>
            </li>
            <li>
                <a href="#">日本語</a>
            </li>
            <li>
                <a href="#">Français (France)</a>
            </li>
            <li>
                <a href="#">ภาษาไทย</a>
            </li>
            <li>
                <a href="#">Español</a>
            </li>
            <li>
                <a href="#">Português (Brasil)</a>
            </li>
            <li>
                <a href="#">Deutsch</a>
            </li>
            <li>
                <a href="#">Italiano</a>
            </li>
            <li>+</li>
        </ul>
        <ul id="footer-tools">
            <li><a href="/">Sign Up</a></li>
            <li>
                <a href="#">Log In</a>
            </li>
            <li>
                <a href="#">Messenger</a>
            </li>
            <li>
                <a href="#">Facebook Lite</a>
            </li>
            <li>
                <a href="#">Mobile</a>
            </li>
            <li>
                <a href="#">Find Friends</a>
            </li>
            <li>
                <a href="#">Badges</a>
            </li>
            <li>
                <a href="#">People</a>
            </li>
            <li>
                <a href="#">Pages</a>
            </li>
            <li>
                <a href="#">Places</a>
            </li>
            <li>
                <a href="#">Games</a>
            </li>
            <li><a href="/">Locations</a></li>
            <li>
                <a href="#">Celebrities</a>
            </li>
            <li>
                <a href="#">Groups</a>
            </li>
            <li>
                <a href="#">Facebook Lite</a>
            </li>
            <li>
                <a href="#">Mobile</a>
            </li>
            <li>
                <a href="#">Find Friends</a>
            </li>
            <li>
                <a href="#">Badges</a>
            </li>
            <li>
                <a href="#">People</a>
            </li>
            <li>
                <a href="#">Pages</a>
            </li>
            <li>
                <a href="#">Places</a>
            </li>
            <li>
                <a href="#">Games</a>
            </li>
        </ul>
        NoteBook &copy; 2020
    </footer>
</body>

</html>
