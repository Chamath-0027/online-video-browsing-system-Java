<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>CloudClip</title>
  <link rel="stylesheet" href="https://unpkg.com/boxicons@2.1.4/css/boxicons.min.css">
  <style>
    *{
      margin: 0;
      padding: 0;
      box-sizing: border-box;
      font-family: "Poppins", sans-serif;
    }
    body{
      background: url(bg.jpg) no-repeat;
      background-size: cover;
      background-position: center;
      background-color: black;
    }
    .navbar {
      display: flex;
      justify-content: space-between;
      align-items: center;
      background-color: rgba(255, 255, 255, 0.2);
      padding: 10px 20px;
      position: fixed;
      top: 0;
      left: 0;
      right: 0;
      z-index: 1000;
    }
    .logo img {
      max-width: 100px;
    }
    .navbar ul {
      display: flex;
      list-style-type: none;
    }
    .navbar li {
      margin-right: 20px;
    }
    .navbar a {
      text-decoration: none;
      color: #fff;
      padding: 10px;
      border-radius: 5px;
      transition: background-color 0.3s ease;
    }
    .navbar a:hover {
      background-color: rgba(255, 255, 255, 0.3);
    }
    .wrapper{
      width: 100%;
      height: 100vh;
      display: flex;
      justify-content: center;
      align-items: center;
      flex-direction: column;
      padding-top: 80px;
      color: #fff;
    }
    .wrapper h1{
      font-size: 36px;
      text-align: center;
      margin-bottom: 30px;
    }
    .register-link p a{
      color: #fff;
      text-decoration: none;
      font-weight: 600;
    }
    .register-link p a:hover{
      text-decoration: underline;
    }
    .video-container {
      display: flex;
      justify-content: space-around;
      width: 100%;
      margin-top: 20px;
    }
    .video-container iframe {
      width: 640px;
      height: 360px;
      margin-bottom: 20px;
    }
  </style>
</head>
<body>
  <div class="navbar">
    <div class="logo">
      <img src="logo.jpg" alt="Logo">
    </div>
    <ul>
      <li><a href="user.jsp">Dashboard</a></li>
    </ul>
  </div>a

  <div class="wrapper">
    <h1>Welcome to CloudClip</h1>
    <div class="register-link">
      <p>Don't have an account? <a href="addUser.jsp">Register</a></p>
    </div>
    <div class="video-container">
      <iframe src="https://www.youtube.com/embed/lTxn2BuqyzU?si=8JP_noUO2eVPJmj0"></iframe>
      <iframe src="https://www.youtube.com/embed/jOUPAMyOPl0?si=wZ2CupIvqfJS7k3Z"></iframe>
      <iframe src="https://www.youtube.com/embed/7V5-q_WFTcs?si=fu0_ZP9Ys7yaYC2o"></iframe>
    </div>
  </div>

  <script src="https://www.youtube.com/player_api"></script>
  <script>
    var players = []; // Array to hold all players

    function onYouTubeIframeAPIReady() {
      var iframes = document.getElementsByTagName('iframe');
      for (var i = 0; i < iframes.length; i++) {
        var iframeID = iframes[i].id;
        players[i] = new YT.Player(iframeID);
      }
    }
  </script>
</body>
</html>