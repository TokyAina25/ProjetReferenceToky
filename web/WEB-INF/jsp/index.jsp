<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html class="no-js" lang="en">

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>E-Project</title>
    <meta name="description" content="Sufee Admin - HTML5 Admin Template">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <link rel="apple-touch-icon" href="apple-icon.png">
    <link rel="shortcut icon" href="favicon.ico">

    <link rel="stylesheet" href="assets/vendors/bootstrap/dist/css/bootstrap.min.css">
    <link rel="stylesheet" href="assets/vendors/font-awesome/css/font-awesome.min.css">
    <link rel="stylesheet" href="assets/vendors/themify-icons/css/themify-icons.css">
    <link rel="stylesheet" href="assets/vendors/flag-icon-css/css/flag-icon.min.css">
    <link rel="stylesheet" href="assets/vendors/selectFX/css/cs-skin-elastic.css">

    <link rel="stylesheet" href="assets/css/style.css">

    <link href='https://fonts.googleapis.com/css?family=Open+Sans:400,600,700,800' rel='stylesheet' type='text/css'>



</head>

<body class="bg-dark">
    <div class="sufee-login d-flex align-content-center flex-wrap">
        <div class="container">
            <div class="login-content">
                <div class="login-logo">
                    <a href="index.html">
                        <img class="align-content" src="assets/images/logo.png" alt="">
                    </a>
                </div>
                <div class="login-form">
                    <form action="auth" method="post">
                            <div class="form-group">
                                <label>Utilisateur</label>
                                <input type="username" class="form-control" name="nom" placeholder="Utilisateur">
                            </div>
                            <div class="form-group">
                                <label>Mot de passe</label>
                                <input type="password" class="form-control" name="mdp" placeholder="Password">
                            </div>
                            <div class="form-group">
                                <select name="profil" class="form-control" type="text">
                                    <option value=1 >Administrateur</option>
                                    <option value=2 >Manager</option>
                                    <option value=3 >Developpeur</option>
                                    <option value=4 >Leader</option>
                                </select>
                            </div>    
                                <div class="checkbox">
                                    <label><input type="checkbox"> Remember Me</label>
                                    <label class="pull-right"><a href="#">Forgotten Password?</a></label>
                                </div>
                        
                                <button type="submit" class="btn btn-success btn-flat m-b-30 m-t-30">Sign in</button>
                                <div class="social-login-content">
                                    <div class="social-button">
                                        <button type="button" class="btn social facebook btn-flat btn-addon mb-3"><i class="ti-facebook"></i>Sign in with facebook</button>
                                        <button type="button" class="btn social twitter btn-flat btn-addon mt-2"><i class="ti-twitter"></i>Sign in with twitter</button>
                                    </div>
                                </div>
                                
                                <div class="register-link m-t-15 text-center">
                                    <p>Avez vous un compte ? <a href="#"> Inscrivez vous</a></p>
                                </div>
                    </form>
                </div>
            </div>
        </div>
    </div>


    <script src="assets/vendors/jquery/dist/jquery.min.js"></script>
    <script src="assets/vendors/popper.js/dist/umd/popper.min.js"></script>
    <script src="assets/vendors/bootstrap/dist/js/bootstrap.min.js"></script>
    <script src="assets/js/main.js"></script>


</body>

</html>

