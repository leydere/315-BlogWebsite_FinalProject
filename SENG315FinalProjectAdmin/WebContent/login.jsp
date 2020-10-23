<!DOCTYPE html>
<html lang="en">

<head>

  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <meta name="description" content="">
  <meta name="author" content="">

  <title>Login</title>

  <!-- Custom fonts for this template-->
  <link href="./assets/vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">

  <!-- Custom styles for this template-->
  <link href="./assets/css/sb-admin.css" rel="stylesheet">

</head>

<body class="bg-dark">
  <div class="container">
    <div class="card card-login mx-auto mt-5">
      <div class="card-header">My CMS - Login</div>
      <div class="card-body">
        <form>
          <div class="form-group">
            <label for="username">Login Account</label>
            <input type="text" id="username" class="form-control" placeholder="Login Account" required  autofocus="autofocus" />
          </div>
          <div class="form-group">
            <label for="password">Password</label>
            <input type="password" id="password" class="form-control" placeholder="Password" required  />
          </div>
          <a id="loginButton" class="btn btn-primary btn-block" onclick="login()">Login</a>
        </form>
        <div id="message"></div>
      </div>
    </div>
  </div>

  <!-- Bootstrap core JavaScript-->
  <script src="./assets/vendor/jquery/jquery.min.js"></script>
  <script src="./assets/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

  <!-- Core plugin JavaScript-->
  <script src="./assets/vendor/jquery-easing/jquery.easing.min.js"></script>
  
  
  <!-- JavaScript-->
  <script src="./assets/js/login.js"></script>

</body>

</html>
