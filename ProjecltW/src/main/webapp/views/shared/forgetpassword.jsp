<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Quên mật khẩu</title>
</head>
<body>
	<div class="container-fluid px-2 px-md-4 py-5 mx-auto">
    <div class="card card0 border-0">
        <div class="row d-flex">
            <div class="col-lg-5">
                <div class="card1 pb-5">
                    <div class="row px-3">
                        <h5 class="logo"><u>izylearning</u></h5>
                    </div>
                    <div class="row px-3 justify-content-center mt-4 mb-5"> 
                        <div id="carouselExampleIndicators" class="carousel slide" data-ride="carousel">
                            <ol class="carousel-indicators">
                                <li data-target="#carouselExampleIndicators" data-slide-to="0" id="li1"></li>
                                <li data-target="#carouselExampleIndicators" data-slide-to="1" id="li2"></li>
                                <li data-target="#carouselExampleIndicators" data-slide-to="2" id="li3" class="active"></li>
                                <li data-target="#carouselExampleIndicators" data-slide-to="3" id="li4"></li>
                                <li data-target="#carouselExampleIndicators" data-slide-to="4" id="li5"></li>
                            </ol>
                            <div class="carousel-inner">
                                <div class="carousel-item card border-0 card-0">
                                    <div class="text-center">
                                        <img src="https://i.imgur.com/IjkibdE.jpg" class="img-fluid profile-pic">
                                    </div>
                                    <h6 class="font-weight-bold mt-5">John Paul</h6> <small class="mb-2">UI/UX Designer</small>
                                    <hr width="50%">
                                    <p class="content mt-2 mb-0">Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod incididunt ut labore et dolore magna aliqua.<br>Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur.</p>
                                </div>
                                <div class="carousel-item card border-0 card-0">
                                    <div class="text-center">
                                        <img src="https://i.imgur.com/oW8Wpwi.jpg" class="img-fluid profile-pic">
                                    </div>
                                    <h6 class="font-weight-bold mt-5">Ximena Vegara</h6> <small class="mb-2">UI/UX Designer</small>
                                    <hr width="50%">
                                    <p class="content mt-2 mb-0">Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod incididunt ut labore et dolore magna aliqua.<br>Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur.</p>
                                </div>
                                <div class="carousel-item active card border-0 card-0">
                                    <div class="text-center">
                                        <img src="https://i.imgur.com/EUYNvE1.jpg" class="img-fluid profile-pic">
                                    </div>
                                    <h6 class="font-weight-bold mt-5">Lena Maria</h6> <small class="mb-2">Backend Developer</small>
                                    <hr width="50%">
                                    <p class="content mt-2 mb-0">Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod incididunt ut labore et dolore magna aliqua.<br>Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur.</p>
                                </div>
                                <div class="carousel-item card border-0 card-0">
                                    <div class="text-center">
                                        <img src="https://i.imgur.com/ndQx2Rg.jpg" class="img-fluid profile-pic">
                                    </div>
                                    <h6 class="font-weight-bold mt-5">Richard Finch</h6> <small class="mb-2">UI/UX Designer</small>
                                    <hr width="50%">
                                    <p class="content mt-2 mb-0">Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod incididunt ut labore et dolore magna aliqua.<br>Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur.</p>
                                </div>
                                <div class="carousel-item card border-0 card-0">
                                    <div class="text-center">
                                        <img src="https://i.imgur.com/gazoShk.jpg" class="img-fluid profile-pic">
                                    </div>
                                    <h6 class="font-weight-bold mt-5">Marielle Haag</h6> <small class="mb-2">Backend Developer</small>
                                    <hr width="50%">
                                    <p class="content mt-2 mb-0">Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod incididunt ut labore et dolore magna aliqua.<br>Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur.</p>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="row px-3 text-center justify-content-center mb-0 social">
                        <span class="fa fa-facebook-square mx-2"></span>
                        <span class="fa fa-twitter mx-2"></span>
                        <span class="fa fa-instagram mx-2"></span>
                        <span class="fa fa-youtube-play mx-2"></span>
                    </div>
                </div>
            </div>
            <div class="col-lg-7">
                <div class="card2 card border-0 px-4 px-sm-5 py-5">
                    <small class="text-right mb-3"><a href=""><u>I already have an account</u></a></small>
                    <h3 class="mb-1">Sign up to izylearning</h3>
                    <p class="mb-4 text-sm">Create our account and start learning with thousands of courses</p>
                    
                    
                    <div class="row mt-3">
                        <div class="col-md-6">
                            <label class="mb-0"><h6 class="mb-0 text-sm">Full Name</h6></label>
                            <input type="text" name="fname" placeholder="John Doe">
                        </div>
                        <div class="col-md-6">
                            <label class="mb-0"><h6 class="mb-0 text-sm">Username</h6></label>
                            <input type="text" name="uname" placeholder="johndoe123">
                        </div>
                    </div>
                    <div class="row px-3">
                        <label class="mb-0"><h6 class="mb-0 text-sm">Email Address</h6></label>
                        <input type="text" name="email" placeholder="john.doe@email.com">
                    </div>
                    <div class="row px-3">
                        <label class="mb-0"><h6 class="mb-0 text-sm">Password</h6></label>
                        <input type="password" name="password" placeholder="&#9679;&#9679;&#9679;&#9679;&#9679;&#9679;&#9679;&#9679;&#9679;&#9679;">
                    </div>

                    <div class="row px-3 mb-3">
                        <small class="text-muted">By signing up, you agree our <a href="" class="text-primary">Terms of services</a> and <a href="" class="text-primary">Privacy Policy</a></small>
                    </div>

                    <div class="row mb-4">
                        <div class="col-md-6">
                            <button class="btn btn-blue text-center mb-1 py-2">Create Account</button>
                        </div>
                    </div>

                    <div class="row px-3 mb-4">
                        <div class="line"></div>
                        <small class="text-muted or text-center">OR</small>
                        <div class="line"></div>
                    </div>

                    <div class="row text-center">
                        <div class="col-sm-6">
                            <p class="social-connect"><span class="fa fa-facebook-square"></span><small class="pl-3 pr-1">Sign up with facebook</small></p>
                        </div>
                        <div class="col-sm-6">
                            <p class="social-connect"><span class="fa fa-google-plus"></span><small class="pl-3 pr-1">Sign up with google+</small></p>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>