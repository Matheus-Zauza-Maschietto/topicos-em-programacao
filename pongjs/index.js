function setup() {
    createCanvas(width, heigth);
}

document.addEventListener('keydown', function(event) {
    if(event.key === 'ArrowUp') {
        if(player2IsDown){
            player2IsDown = false
        }
        player2IsUp = true;
    } else if(event.key === 'ArrowDown') {
        if(player2IsDown){
            player2IsUp = false;
        }
        player2IsDown = true
        
    } else if(event.key === 'w') {
        if(player1IsDown){
            player1IsDown = false
        }
        player1IsUp = true;
    } else if(event.key === 's') {
        if(player1IsDown){
            player1IsUp = false;
        }
        player1IsDown = true 
    }
})

document.addEventListener('keyup', function(event) {
    if(event.key === 'ArrowUp') {
        player2IsUp = false;
    } else if(event.key === 'ArrowDown') {
        player2IsDown = false
    } else if(event.key === 'w') {
        player1IsUp = false; 
    } else if(event.key === 's') {
        player1IsDown = false;
    }
})

// screen variable
let heigth = 400;
let width = 600;

// Ball variables
let ballSize = 30
let ballRadio = ballSize/2
let ballX = 200
let ballY = 300
let ballVelocityX = 5;
let ballVelocityY = 5;

// Player variables
let player1Points = 0;
let player2Points = 0;
let player1X = 10;
let player1Y = 10;
let player1IsDown = false;
let player1IsUp = false;
let player2IsDown = false;
let player2IsUp = false;
let player2X = 580;
let player2Y = 10;
let playerHeigth = 70;
let playerWidth = 10;
let playerSpeed = 10


function getPlayer1Speed() { return playerSpeed + (player1Points*2) }
function getPlayer2Speed() { return playerSpeed + (player2Points*2) }


function draw() {
    background(0);
    circle(ballX, ballY, ballSize);
    rect(player1X, player1Y, playerWidth, playerHeigth)
    rect(player2X, player2Y, playerWidth, playerHeigth)
    moveBall()
    resetBall()
    movePlayer1()
    movePlayer2()
    incluiPlacar()
}

function incluiPlacar() {
    fill(255);
    text(player1Points, 278, 26);
    text(player2Points, 321, 26); 
}


function movePlayer1(){
    if(player1IsDown){
        if(player1Y+playerHeigth+playerSpeed < heigth)
            player1Y += getPlayer1Speed()
    }
    else if(player1IsUp){
        if(player1Y-playerSpeed > 0)
            player1Y -= getPlayer1Speed()
    }
}

function movePlayer2(){
    if(player2IsDown){
        if(player2Y+playerHeigth+playerSpeed < heigth)
            player2Y += getPlayer2Speed()
    }
    else if(player2IsUp){
        if(player2Y-playerSpeed > 0)
            player2Y -= getPlayer2Speed()
    }
}

function moveBall() {
    checkPlayer1BallColision()
    checkPlayer2BallColision()
    if(ballY+(ballRadio) > heigth || ballY-(ballRadio) < 0) {
        ballVelocityY *= -1
    }


    ballX += ballVelocityX
    ballY += ballVelocityY
}

function checkPlayer1BallColision(){
    if(ballX-(ballRadio) <= player1X && (ballY >= player1Y && ballY <= player1Y+playerHeigth))
    {
        ballVelocityX *= -1
    }
}

function checkPlayer2BallColision(){
    if(ballX+(ballRadio) >= player2X && (ballY >= player2Y && ballY <= player2Y+playerHeigth))
    {
        ballVelocityX *= -1
    }
}


function resetBall(){
    if(ballX+(ballRadio) > width){
        player1Points += 1;
        stopBall()
    }
    else if(ballX-(ballRadio) < 0){
        player2Points += 1;
        stopBall()
    }
}

function stopBall(){
    ballX = width/2
    ballY = heigth/2
    ballVelocityX = 0
    ballVelocityY = 0
    setTimeout(() => {
        ballVelocityX = 5
        ballVelocityY = 5
    }, 2000)
}
