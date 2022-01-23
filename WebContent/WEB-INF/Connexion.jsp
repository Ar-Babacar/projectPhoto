 <html>

            <head>
                <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
                <title>Role Based Access Control in Java Web Application Example</title>
                <link href="bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css">
                <script src="js/jquery-1.12.4-jquery.min.js" type="text/javascript"></script>
                <script src="bootstrap/js/bootstrap.min.js" type="text/javascript"></script>

                <!--valiadtion css & js start here-->
                <style type="text/css">
                    label.error {
                        color: red;
                        font-family: Times New Roman;
                        font-size: 17px;
                    }
                </style>

                <script src="js/validate.js" type="text/javascript"></script>
                <script type="text/javascript">
                    $(document).ready(function () {
                        $('#loginForm').validate({
                            rules:
                            {
                                txt_email:
                                {
                                    required: true,
                                    email: true
                                },
                                txt_password:
                                {
                                    required: true
                                },
                                txt_role:
                                {
                                    required: true
                                }
                            },
                            messages:
                            {
                                txt_email:
                                {
                                    required: "enter proper email address"
                                },
                                txt_password:
                                {
                                    required: "enter password"
                                },
                                txt_role:
                                {
                                    required: "please select role"
                                }
                            }
                        });
                    });
                </script>

                <!--valiadtion css & js end here-->

            </head>

            <body>
                <nav class="navbar navbar-default navbar-static-top">
                    <div class="container">
                        <div class="navbar-header">
                            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse"
                                data-target="#navbar" aria-expanded="false" aria-controls="navbar">
                                <span class="sr-only">Toggle navigation</span>
                                <span class="icon-bar"></span>
                                <span class="icon-bar"></span>
                                <span class="icon-bar"></span>
                            </button>
                        </div>
                        <div id="navbar" class="navbar-collapse collapse">
                            <ul class="nav navbar-nav">
                            </ul>
                        </div>
                        <!--/.nav-collapse -->
                    </div>
                </nav>

                <div class="wrapper">
                    <div class="container">

                        <div class="col-lg-12">
                            <% if(request.getAttribute("errorMsg")!=null) { %>
                                <div class="alert alert-danger">
                                    <strong>WRONG! <% out.println(request.getAttribute("errorMsg")); %></strong>
                                </div>
                                <% } %>
                                  
                                        <h2>Login Page</h2>
                                  
                                    <form method="post" id="loginForm" class="form-horizontal">

                                        <div class="form-group">
                                            <label class="col-sm-3 control-label">Email</label>
                                            <div class="col-sm-6">
                                                <input type="text" name="login" class="form-control"
                                                    placeholder="enter email" />
                                            </div>
                                        </div>

                                        <div class="form-group">
                                            <label class="col-sm-3 control-label">Password</label>
                                            <div class="col-sm-6">
                                                <input type="password" name="password" class="form-control"
                                                    placeholder="enter passowrd" />
                                            </div>
                                        </div>

                                        <div class="form-group">
                                            <div class="col-sm-offset-3 col-sm-9 m-t-15">
                                                <input type="submit" name="btn_login" class="btn btn-success"
                                                    value="Login">
                                            </div>
                                        </div>

                                        <div class="form-group">
                                            <div class="col-sm-offset-3 col-sm-9 m-t-15">
                                                You don't have a account register here? <a href="register.jsp">
                                                    <span class="text-info">Register Account</span>
                                                </a>
                                            </div>
                                        </div>

                                    </form>
                        </div>
                    </div>
                </div>

            </body>

            </html>