<!doctype html>
<html>





<style>

@charset "utf-8";
@import url(http://weloveiconfonts.com/api/?family=fontawesome);

[class*="fontawesome-"]:before
{
  font-family: 'FontAwesome', sans-serif;
}

body 
{
	margin: 0;
	padding: 0;
	display: flex;
	justify-content: center;
	align-items: center;
	height: 100vh;
	background: #352b48;
	font-family: 'Poppins' , sans-serif;
}
	
.calendar
{
	position: relative;
	background: #fff;
	width: 800px;
	height: 450px;
	display: flex;
	justify-content: space-between;
	align-items: center;
	border: 15px solid #fff;
	box-shadow: 0 15px 35px rgba(0,0,0,.5);
}

.calendar .date
{
	width: 400px;
	padding: 30px;
	box-sizing: border-box;
}

.calendar .date h3
{
	margin: 0 0 20px;
	padding: 0;
	font-size: 0;
	font-weight: 500;
	text-align: center;
}

.calendar .date .days
{
	display: flex;
	flex-wrap: wrap;
}

.calendar .date .days .day,
.calendar .date .days .number
{
	width: 48px;
	height: 48px;
	display: flex;
	justify-content: center;
	align-items: center;
}

calendar .date .days .day:first-child,
calendar .date .days .number:nth-child(7n+1)
{
	color: #f44336;
	font-weight: 600;
}

calendar .date .days .number active
{
	background: #352b48;
	color: #fff;
	cursor: pointer;
	border-radius: 50%;
}
.calendar .image
{
	position:absolute;
	top: 0;
	right: 0;
	width: 400px;
	height: 100%;
	background: #000;
}

.calendar .image img
{
	position:absolute;
	top: 0;
	left: 0;
	width: 100%;
	height: 100%;
	object-fit: cover;
}
	
	
</style>	
	<head>
		<html lang="en-US">
 		<meta charset="utf-8">
    	<title>Login</title>
    
   		 <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Open+Sans:400,700">	
</head>

<body>
		<div class="calendar">
			<div class="date">
				<h3>July</h3>
				<div class="days">
					<div class="day">Lun</div>
					<div class="day">Mar</div>
					<div class="day">Mier</div>
					<div class="day">Jue</div>
					<div class="day">Vier</div>
					<div class="day">Sab</div>
					<div class="day">Dom</div>
					<div class="number">1</div>
					<div class="number">2</div>
					<div class="number">3</div>
					<div class="number">4</div>
					<div class="number">5</div>
					<div class="number">6</div>
					<div class="number">7</div>
					<div class="number">8</div>
					<div class="number">9</div>
					<div class="number">10</div>
					<div class="number">11</div>
					<div class="number">12</div>
					<div class="number">13</div>
					<div class="number">14</div>
					<div class="number">15</div>
					<div class="number">16</div>
					<div class="number">17</div>
					<div class="number">18</div>
					<div class="number">19</div>
					<div class="number">20</div>
					<div class="number">21</div>
					<div class="number">22</div>
					<div class="number">23</div>
					<div class="number">24</div>
					<div class="number">25</div>
					<div class="number">26</div>
					<div class="number">27</div>
					<div class="number">28</div>
					<div class="number">29</div>
					<div class="number">30</div>
					<div class="number">31</div>
				</div>
			</div>
			<div class="image">
				<img src="https://www.ahstatic.com/photos/9399_ho_00_p_1024x768.jpg">
			</div>
		</div>
	</body>
	

<htlm>