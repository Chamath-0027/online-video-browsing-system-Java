v<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Home Page</title>
    <style>
        body {
            margin: 0;
            padding: 0;
            font-family: 'Poppins', sans-serif;
            background-image:url('C:\Users\Chamath Arthanayake\Pictures\8_31_2023 2_40_43 AM.png'); /* Replace the URL with your actual image URL */
            background-size: cover;
            background-position: center;
            background-repeat: no-repeat;
           
        }

        header {
            background-color: #555c64;
            color: #fff;
            padding: 20px;
            text-align: center;
            position: fixed;
            top: 0;
            left: 0;
            width: 100%;
            z-index: 999;
        }

        .ClipCove {
            margin: 0;
            font-size: 24px;
            font-style: calc();
        }

        .navigation {
            display: inline-block;
            margin-top: 10px;
            margin-left: 100px;
        }

        .navigation a {
            color: #fff;
            text-decoration: none;
            margin: 0 15px;
            font-size: 18px;
            font-weight: bold;
        }

        .featured-videos {
            margin-top: 80px; /* Adjust according to the header height */
            display: flex;
            flex-wrap: wrap;
            justify-content: center;
            align-items: center;
        }

        .video {
            margin: 20px;
            max-width: 100%;
            flex: 1 1 300px; /* Adjust as needed */
            position: relative;
            padding-bottom: 56.25%; /* 16:9 aspect ratio */
            overflow: hidden;
        }

        .video iframe {
            position: absolute;
            top: 0;
            left: 0;
            width: 100%;
            height: 50%;
            border: none;
        }
       
        .login,
        .register {
            width: 130px;
            height: 40px;
            color: #fff;
            border-radius: 5px;
            padding: 10px 25px;
            font-family: 'Lato', sans-serif;
            font-weight: 500;
            background: transparent;
            cursor: pointer;
            transition: all 0.3s ease;
            position: relative;
            display: inline-block;
            box-shadow: inset 2px 2px 2px 0px rgba(255,255,255,.5),
             7px 7px 20px 0px rgba(0,0,0,.1),
             4px 4px 5px 0px rgba(0,0,0,.1);
            outline: none;
            font-size: 15px;
        }

        .login {
            margin-left: 400px;
            background: #004dff;
            background: linear-gradient(0deg, #004dff 0%, #004dff 100%);
            border: none;
        }

        .register {
            background: #004dff;
            background: linear-gradient(0deg, #004dff 0%, #004dff 100%);
            border: none;
        }

        .login:before,
        .register:before {
            height: 0%;
            width: 2px;
        }

        .login:hover,
        .register:hover {
            box-shadow: 4px 4px 6px 0 rgba(255,255,255,.5),
                        -4px -4px 6px 0 rgba(116, 125, 136, .5), 
            inset -4px -4px 6px 0 rgba(255,255,255,.2),
            inset 4px 4px 6px 0 rgba(0, 0, 0, .4);
        }

    </style>
</head>

<body>
    <header>
        <h2 class="ClipCove">PlayMe</h2>
        <nav class="navigation">
            <a href="#">Home</a>
            <a href="#">About</a>
            <a href="#">Services</a>
            <a href="#">Contact Us</a>
            <a href="user.jsp">Your Dashboard</a> 
        </nav>
        <div>
            <button class="login">Login</button>
            <button class="register">Register</button>
        </div>
    </header>

    <section class="featured-videos">
        <div class="video">
            <iframe src="https://www.youtube.com/embed/lTxn2BuqyzU?si=8JP_noUO2eVPJmj0"></iframe>
        </div>
        <div class="video">
            <iframe src="https://www.youtube.com/embed/jOUPAMyOPl0?si=wZ2CupIvqfJS7k3Z"></iframe>
        </div>
        <div class="video">
            <iframe src="https://www.youtube.com/embed/7V5-q_WFTcs?si=fu0_ZP9Ys7yaYC2o"></iframe>
        </div>
        <!-- Add more video iframes here -->
    </section>
	
    <script src="https://www.youtube.com/player_api"></script>
    <script>
        var players = [];
        function onYouTubePlayerAPIReady(){
            var videos = document.querySelectorAll('.video iframe');
            videos.forEach(function(video, index) {
                var player = new YT.Player(video, {
                    height: '100%',
                    width: '100%',
                    videoId: video.getAttribute('src').split('/')[4].split('?')[0]
                });
                players.push(player);
            });
        }
    </script>
</body>
</html>
