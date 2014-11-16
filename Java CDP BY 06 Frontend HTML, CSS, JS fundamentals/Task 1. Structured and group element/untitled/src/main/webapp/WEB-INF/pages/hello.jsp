<%--
  Created by IntelliJ IDEA.
  User: Julia
  Date: 11/16/14
  Time: 12:32 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8" >
    <title>HTML5</title>
    <style>

        body {
            background-color: white;
            font-family: Geneva, Arial, Helvetica, sans-serif;
            margin: 0px auto;
            max-width:990px;
            border:solid;
            border-color:#FFFFFF;
        }

        header {
            background-color: #44344A;
            display:block;
            color: #CCDAAA;
            text-align: center;
        }

        header h2 {
            font-size: 14px;
            margin: 0px;
            color: #CCDAAA;
        }

        h1 {
            font-size: 40px;
            margin: 0px;
        }

        h2 {
            font-size: 24px;
            margin: 0px;
            text-align: center;
            color: #CCDAAA;
        }

        h3 {
            font-size: 18px;
            margin: 0px;
            text-align: center;
            color: #CCDAAA;
        }

        h4 {
            color: #CCDAAA;
            background-color: #fff;
            -webkit-box-shadow: 2px 2px 20px #536345;
            -moz-box-shadow: 2px 2px 20px #536345;
            position: absolute;
            padding: 0px 150px;
            top: 50px;
            left: -120px;
            text-align: center;
        }

        nav {
            display: block;
            width: 25%;
            float: left;
            color: #CCDAAA;
        }

        nav a:link, nav a:visited {
            display: block;
            border-bottom: 3px solid #fff;
            padding: 10px;
            text-decoration: none;
            font-weight: bold;
            margin: 5px;
        }

        nav a:hover {
            color: white;
            background-color: #44344A;
        }

        nav h3 {
            margin: 15px;
            color: #CCDAAA;
        }

        #container {
            background-color: #536345;
        }

        section {
            display: block;
            width: 50%;
            float: left;
        }

        article {
            background-color: #eee;
            display: block;
            margin: 10px;
            padding: 10px;
            -webkit-border-radius: 10px;
            -moz-border-radius: 10px;
            border-radius: 10px;
            -webkit-box-shadow: 2px 2px 20px #888;
            -moz-box-shadow: 2px 2px 20px #888;
        }

        article header {
            -webkit-border-radius: 10px;
            -moz-border-radius: 10px;
            border-radius: 10px;
            padding: 10px;
        }

        article footer {
            -webkit-border-radius: 10px;
            -moz-border-radius: 10px;
            border-radius: 10px;
            padding: 5px;
        }

        article h1 {
            font-size: 18px;
        }

        aside {
            width: 25%;
            float: left;
            image-resolution: from-image;
        }

        footer {
            clear: both;
            display: block;
            background-color: #63454E;
            color: #ffffff;
            text-align: center;
            padding: 10px;
        }

        footer h2 {
            font-size: 14px;
            color: #CCDAAA;
            background-color: #63454E;
        }

        /* link */
        a {
            color: #4D2B34;
        }

        a:hover {
            text-decoration: underline;
        }

        figcaption {
            display: block;
            text-align: center;
        }

    </style>
</head>
<body>
<header>
    <h1>Page Header</h1>
    <h2>HTML5 Rocks!</h2>
</header>

<div id="container">
    <nav>
        <h3>Navigation Bar</h3>
        <a href="http://www.example.com">Link 1</a>
        <a href="http://www.example.com">Link 2</a>
        <a href="http://www.example.com">Link 3</a>
    </nav>

    <section>
        <article>
            <header>
                <h2>Article Header</h2>
            </header>
            <p>Lorem ipsum dolor HTML5 nunc aut nunquam sit amet, consectetur adipiscing
                elit. Vivamus at est eros, vel fringilla urna.</p>
            <p>Per inceptos himenaeos. Quisque feugiat, justo at vehicula
                pellentesque, turpis lorem dictum nunc.</p>
            <footer>
                <h2>Article Footer</h2>
            </footer>
        </article>

        <article>
            <header>
                <h2>Article Header</h2>
            </header>
            <p>Lorem dolor nunc aut nunquam sit amet, consectetur adipiscing
                elit. Vivamus at est eros, vel fringilla urna. Pellentesque odio</p>
            <footer>
                <h2>Article Footer</h2>
            </footer>
        </article>
    </section>

    <aside>
        <figure >
            <img src="http://categoriya.com/fotoArticle/MB4boDDKIbo5iS6yHSApA6IVU0rWbK.jpg" alt="HTML5 rocks" width="200" height="180">
            <figcaption style="color:white">figcaption</figcaption>
        </figure>
    </aside>

    <footer>
        <h2>Footer</h2>
    </footer>
</div>
</body>
</html>
