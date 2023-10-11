<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.2/css/all.min.css" integrity="sha512-z3gLpd7yknf1YoNbCzqRKc4qyor8gaKU1qmn+CShxbuBusANI9QpRohGBreCFkKxLhei6S9CQXFEbbKuqLg0DA==" crossorigin="anonymous" referrerpolicy="no-referrer" />
    <title>Admin</title>
    <style>
        body{
            height: 100vh;
            width: 100vw;
            margin: 0px;
            flex-wrap: wrap;
            
        }
        .container{
            height: 100vh;
            width: 100vw;
            margin: 0px;
            border: .1px solid white;
            display: flex;
        }
        .item-box1{
            height: 100vh;
            width: 30vw;
            margin: 0px;
            border: .1px solid white;
        }
        .item-box2{
            height: 100vh;
            width: 70vw;
            margin: 0px;
            border: .1px solid white;
        }
        .items1{
            height: 10vh;
            width: 30vw;
            margin: 0px;
            border: .1px solid orange;
            color: white;
            background-color: orange;
        }
        .items2{
            height: 90vh;
            width: 30vw;
            border: .1px solid orange;
            background-color: orange;
            color: white;
        }
        .items3{
            height: 10vh;
            width: 70vw;
            margin: 0px;
            border: .1px solid black;
            display: flex;
            justify-content: space-around;
            align-items: center;
            align-content: space-around;
            background-color: black;
            color: white;
            text-decoration: transparent;
            
        }
        .items4{
            height: 90vh;
            width: 70vw;
            border: .1px solid black;
            background: url(./images/OIP.jpg);
            background-repeat: no-repeat;
            background-size: cover;
            backface-visibility: hidden;
            box-decoration-break: transparent;
            color: white;
            text-decoration: transparent;
        }
        .head{
            
            
    height: 10vh;
    width: 70vw;
    display: flex;
    justify-content: space-evenly;
    align-items: center;
    font-size: 20px;
    background-color: black;
    color: white;
    flex-direction: row;
    flex-wrap: wrap;
    align-content: space-around;
        }
        a{
            text-decoration: transparent;
            color: white;
        }

        .he{
            display: flex;
            align-items: center;
            align-content: center;
            /* width: 100px; */
            /* margin-left: -690px;
            margin-top: -180px; */
            margin-top: -270px;
            margin-left: 180px;
            font-size: 50px;
            /* border: 1px solid white; */
            font-family: Cambria, Cochin, Georgia, Times, 'Times New Roman', serif;
        }

        .he1{
            display: flex;
            align-items: center;
            align-content: center;
            /* margin-left: -225px;
            margin-top: -40px; */
            margin-left: 300px;
            font-size: 70px;
            color: orange;
        }
        .he2{
            display: flex;
            align-items: center;
            align-content: center;
            /* margin-left: -238px;
            margin-top: 50px; */
            margin-left: 380px;
            font-size: 30px;
            
        }
        .he331{
            margin-top: 70px;
           margin-left: 17%;
           text-decoration: transparent;
           color: white;
           font-size: 40px;
           font-family: cursive;
           font-style: oblique;
        }
        .footer{
            /* height: 4vh;
            width: 100vw; */
            /* border: 2px solid red; */
            /* background-color: orange; */
            display: flex;
            /* background-color: black; */
            margin: 0px;
            color: white;
        }

        .footer1{
            display: flex;
            width: 25%; 
            /* border: 2px solid red; */ 
          /* background-color: orange; */
        

        }

        .footer1 img{
            border-radius: 50%;
            height: 70px;
            width: 70px;
            /* margin-left: 7px;
            margin-top: -57px; */
            margin-top: 300px;
            margin-left: 12px;
        }

        .footer2 img{
            border-radius: 50%;
            height: 71px;
            width: 71px;
            /* margin-left: -220px;
            margin-top: -89px; */
            margin-left: 160px;
            margin-top: 300px;
        }

        .footer3 img{
            border-radius: 50%;
            height: 71px;
            width: 71px;
            /* margin-left: -130px;
            margin-top: -89px; */
            margin-top: 300px;
            margin-left: -180px;
        }
        

        .box4{
            width: 240px;
            height: 240px;
            border-radius: 50%;
            border: .5px solid;
            display: flex;
            justify-content: space-around;
            align-items: center;
            margin-left: -120px;
            margin-top: 100px;
            /* margin-top: 7%;
            margin-left: 192px; */
            /* background-color: green; */
            background: url(https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSB9hwFjVm9UfaQRKCLeGQKwScNpxSi2TZMUg&usqp=CAU);
        }

        .box3{
            width: 255px;
            height: 255px;
            border-radius: 50%;
            border: 5px solid white;
            display: flex;
            justify-content: space-around;
            align-items: center;
            /* margin-top: -81%;
            margin-left: 182px; */
            margin-top: -253px;
            margin-left: -130px;
        }

  

        .form{
margin-left: 280px;
margin-top: 100px;
height: 250px;
width: 250px;
/* color: white; */

position:absolute;
/* background-color: white; */

text-decoration: transparent;

}
fieldset{
border: 1px solid transparent;
height: 250px;
width: 250px;
border-radius: 4%;
text-shadow: 2px;
/* background-color: white; */
/* background: linear-gradient(orange,black); */
text-decoration: transparent;
}

.name{
          
          text-decoration: transparent;
          position: absolute;
          display: flex;
          justify-content: space-between;
          align-content: space-between;
          /* height: 30px;
          width: 170px; */
          /* border: 1px solid black; */
          border: none;
          outline: none;
          margin-left: 30px;
          margin-top: 17px;
          /* position: absolute; */
          /* background: url(./images/user-solid.svg);
          background-repeat: no-repeat; */
         
      }
      .password{
          text-decoration: transparent;
          position: absolute;
          display: flex;
          justify-content: space-between;
          align-content: space-between;
          /* height: 30px;
          width: 156px; */
          /* border: 1px solid black; */
          border: none;
          outline: none;
          margin-left: 0px;
          margin-top: 15px;
         
      }

      hr{
          margin-left: -28px;
      }
     
      .m1 {
          /* height: 8px; */
          width: 50px;
          display: flex;
          justify-content: space-between;
          align-content:space-between ;
          /* border: 2px solid black; */
          height: 33px;
          width: 220px;
          border: none;
          outline: none;
          background-color: white;
          text-decoration: transparent;
      }
      .m2 {
          /* height: 8px; */
          width: 50px;
          display: flex;
          justify-content: space-between;
          align-content:space-between ;
          /* border: 2px solid black; */
          height: 33px;
          width: 220px;
          border: none;
          outline: none;
          background-color:white;
          text-decoration: transparent;
      }

    

      .pass{
          
          display: flex;
          /* border: 1px solid black; */
          border: none;
          outline: none;
          height: 33px;
          width: 36px;
          margin-left: 182px;
          text-decoration: transparent;
       
      }
      .user{
          
          display: flex;
          /* border: 1px solid black; */
          border: none;
          outline: none;
          height: 33px;
          width: 30px;
          /* background-color: black; */
          color: white;
          margin-left: 0px;
          text-decoration: transparent;
      }

    </style>
</head>
<body>
    <h1 style="color: green">${pos}</h1>
    <h1 style="color: red">${neg}</h1>
    <div class="container">
        <div class="item-box1">
            <div class="items1">
                <h1 class="logo">On-Wheel   <img src="./images/motorcycle-solid.svg" alt="" style="height: 60px;width: 30px;margin-left:3px;margin-top: -40px;"></h1>
            </div>
            <div class="items2">
                <div class="footer">
                    
                    <div class="footer1"><img src="/images/download.png" alt=""></div>
                    <div class="footer2"><img src="/images/download (12).png" alt=""></div>
                    <div class="footer3"><img src="/images/images1-removebg-preview.png" alt=""></div>
                </div>
            </div>
        </div>
        <div class="item-box2">
            <div class="items3">
               
                <div class="the" style="margin-left: 0px;">
                    <h1 style="color: white;margin-left: -100px;"><i>Welcome TO Hotel-Login</i></h1>
                </div>
               
            </div>
            <div class="items4">
               <div class="item-box">
                
                <form action="/hotel/login" method="post" class="form">
                    <fieldset>
                        <h1 class="Heading">Hotel Login</h1>
                        <div class="m1">
                            <div class="user">
                                <img src="./images/user-solid.svg" alt="" >
                            </div>
                                <input   type="email" name="email" class="name" required="required" placeholder="Enter the email" >
                        </div><br>
                        <div class="m2">
                            <div class="pass">
                                <img src="./images/eye-solid.svg" alt="">
                            </div>
                            <input type="password" name="password" class="password" required="required" placeholder="Enter the password"><br><br>
                        </div>
    
                        <hr>
                        <button style="margin: 0px,2px;" class="submit">Submit</button>
                        <button style="margin-left: 65px;" class="cancel" type="reset">Cancel</button><br><br>
                        <a href="/hotel/register" class="reg" style="color: yellow;">Register?If new User</a>

                       
                       
                    </fieldset>
                </form>
                <div class="box5" style="margin-top: 0px;margin-left: 300px;height: 30px;width: 30px;background-color:transparent;border: none;">
                    <a href="/" style="background-color:transparent;border: none;margin-left: 0px;"><button class="house" style="background-color: transparent;border: none;height: 100px;width: 150px;margin-left: 0px;color: white;font-size: 20px;">Back-to-Home <img src="./images/house-solid.svg" alt="" style="background-color:transparent;height: 50px;width: 50px;border: none;margin-top: 0px;margin-left: 0px;"></button></a>
                </div>
               </div>
            </div>
        </div>
    </div>
</body>
</html>