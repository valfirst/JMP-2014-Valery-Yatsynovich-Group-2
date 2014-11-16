<html>
<head>
    <script src="http://ajax.googleapis.com/ajax/libs/angularjs/1.2.26/angular.min.js"></script>
</head>

<body>

<form ng-app="" name="myForm" method="GET" action="/over" novalidate>

    <b>Registration form:</b>
    <table>
        <tr>
            <td>
                FIO:
            </td>
            <td>
                <input type="text" name="user" ng-model="user" autofocus="autofocus" ng-controller="validateCtrl" required>
            <span style="color:red" ng-show="myForm.user.$dirty && myForm.user.$invalid">
                <span ng-show="myForm.user.$error.required">Username is required.</span>
            </span>
            </td>
        </tr>

        <tr>
            <td>
                Email:
            </td>
            <td>
                <input type="email" name="email" ng-model="email" ng-controller="validateCtrl" required>
                    <span style="color:red" ng-show="myForm.email.$dirty && myForm.email.$invalid">
                        <span ng-show="myForm.email.$error.required">Email is required.</span>
                        <span ng-show="myForm.email.$error.email">Invalid email address.</span>
                    </span>
            </td>
        </tr>


        <tr>
            <td>
                Phone number:
            </td>
            <td>
                <input type="text" name="phone" ng-model="phone" placeholder='xxx xxx-xx-xx' ng-pattern='/[0-9]{3} [0-9]{3}-[0-9]{2}-[0-9]{2}/' required>
                <span style="color:red" ng-show="myForm.phone.$dirty && myForm.phone.$invalid">Phone has invalid pattern</span>
                <span style="color:red" ng-show="myForm.phone.$dirty && myForm.phone.$required">Phone is required </span>
            </td>
        </tr>

        <tr>
            <td>
                Web-site:
            </td>
            <td>
                <input type="url" name="site" ng-model="site">
            </td>
        </tr>

        <tr>
            <td>
                Date Birth:
            </td>
            <td>
                <input type="date" name="date" ng-model="date">
            </td>
        </tr>
    </table>

    <b>Delivery options:</b>
    <table>
        <tr>
            <td>
                Country:
            </td>
            <td>
                    <select type="text" ng-model="country" name="country" ng-options="item in items">
                        <option value="?" selected="selected"></option>
                        <option value="0">Belarus</option>
                        <option value="1">Russia</option>
                        <option value="2">Litva</option>
                        <option value="3">Kazakhstan</option>
                    </select>
            </td>
        </tr>
        <tr>
            <td>
                Address:
            </td>
            <td>
                <textarea type="text" ng-model="address" required></textarea>
            </td>
        </tr>

        <tr>
            <td>
                Post code:
            </td>
            <td>
                <input type="text" ng-model="pochta" name="pochta" ng-pattern='/[0-9]{5}/' placeholder="000000" required>
                <span style="color:red" ng-show="myForm.pochta.$dirty && myForm.pochta.$invalid">Post code has invalid pattern</span>
                <span style="color:red" ng-show="myForm.pochta.$dirty && myForm.pochta.$required">post code is required </span>
            </td>
        </tr>
    </table>

    <b>Preferred way to get updates</b>
    <table>
        <tr>
            <td>
                <p><input type="radio" name="answer" value="a1">By email</p>
                <p><input type="radio" name="answer" value="a2">By phone</p>
                <p><input type="radio" name="answer" value="a3">Don't bother me</p>
            </td>
        </tr>

        <tr>
            <td>
                Notification per day:
                <input type="number" ng-model="size" name="size" ng-controller="sizeFunc"
                       min="7" max="21" integer />{{size}}
                <span ng-show="myForm.size.$isDirty && myForm.size.$error.integer">The value is not a valid integer!</span>
                <span style="color:red" ng-show="myForm.size.$isDirty && myForm.size.$error.min || myForm.size.$error.max">
                    The value must be in range 0 to 10!</span>
                </div>
            </td>
        </tr>
    </table>

    <p>
        <input type="submit" value="Send">
    </p>

</form>

<script>
    function sizeFunc($scope){
        $scope.size=7
    }

    function validateCtrl($scope) {
        $scope.submitForm = function () {
            alert("Here I should implement the logic to send a request to the server.");
        }
    }

    function InstantSearchController($scope){
        $scope.items = [
            {name:Belarus, value:Belarus},
            {name:Litva, value:Litva},
            {name:Russia, value:Russia}
        ];
    }


    app.directive('integer', function() {
        var INTEGER_REGEXP = /^\-?\d+$/;
        return {
            require: 'ngModel',
            link: function(scope, elm, attrs, ctrl) {
                ctrl.$validators.integer = function(modelValue, viewValue) {
                    if (ctrl.$isEmpty(modelValue)) {
                        // consider empty models to be valid
                        return true;
                    }

                    if (INTEGER_REGEXP.test(viewValue)) {
                        // it is valid
                        return true;
                    }

                    // it is invalid
                    return false;
                };
            }
        };
    });
</script>
</body>
</html>