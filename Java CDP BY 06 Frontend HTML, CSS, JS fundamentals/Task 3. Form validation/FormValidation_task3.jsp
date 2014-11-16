<html>
<head>
    <script>
function check(){
            var username = document.getElementById("user").value;
            var bad = "";
            var result;
            if(username.length <= 3){
                bad += "The field name can not be less than 3 characters";
                result = false;
            }
            if(bad != ""){
                alert(bad);
                return result;
            }
        }

</script>
</head>

<body>

<form name="myForm" onsubmit="return check()">

 Registration form<br>
                FIO:
                <input type="text" name="user" id="user"><br>

                Email:
                <input type="email" name="email" ><br>
                Phone number:<br>
                <input type="text" name="phone">


    <p>
        <input type="submit" value="submit">
    </p>

</form>


</body>
</html>