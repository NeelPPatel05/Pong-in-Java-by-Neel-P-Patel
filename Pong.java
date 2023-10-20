

public class Pong {

    
    private static String dirP1;
    private static String dirP2;
    private static int p1Points;
    private static int p2Points;
    private static double ballXVelo;
    private static double ballYVelo;
    private static double ballTotalSpeed;
    private static int ballXPos;
    private static int ballYPos;
    private static int p1YPos;
    private static int p2YPos;

    public Pong(){
        
        
        dirP1 = "";
        dirP2 = "";
        
        p1Points = 0;
        p2Points = 0;
        ballXVelo = -2.0;
        ballYVelo = 0.0;
        ballTotalSpeed = 2.0;   
        ballXPos = 215;
        ballYPos = 140;
        p1YPos = 120;
        p2YPos = 120;
    }
    
    
    
    //Getters for Painting
    public int getP1Points()
    {
        return p1Points;
    }
    
    public int getP2Points()
    {
        return p2Points;
    }
    public int getBallXPos(){
        return ballXPos;
    }
    
    public int getBallYPos()
    {
        return ballYPos;
    }
    
    public int getP1YPos()
    {
        return p1YPos;
    }
    
    public int getP2YPos()
    {
        return p2YPos;
    }
    
    //Getters and Setters for KeyPresses
    public String getDirP1()
    {
        return dirP1;
    }
    public String getDirP2(){
        return dirP2;
    }
    public void setP1YPos(int p1YPos){
        this.p1YPos = p1YPos;
    }
    public void setP2YPos(int p2YPos){
        this.p2YPos = p2YPos;
    }
    public void setDirP1 (String dir){
        dirP1 = dir;
    }
    public void setDirP2 (String dir){
        dirP2 = dir;
    }
    

    //runs 60 times per second to keep everything moving and checks for updates
    public void runGame(){
        this.moveBall();
        this.movePaddle();
        this.paddleCollision();
        this.wallCollision();
        this.getPoint();
    }
    //checks if either player has 5 points
    public void checkWin(){
        if(p1Points == 5){
            ballXVelo = 0;
            ballYVelo = 0;
            ballTotalSpeed = 0;
            ballYPos = 800;
            p1YPos = 800;
            p2YPos = 800;
        }
        if(p2Points == 5){
            ballXVelo = 0;
            ballYVelo = 0;
            ballTotalSpeed = 0;
            ballYPos = 800;
            p1YPos = 800;
            p2YPos = 800;
            
        }
    }

    
    //spawns ball in middle of the arena
    public void spawnBall(){
        ballXPos=215;
        ballYPos =140;
    }

    //updates the location of the ball
    public void moveBall()
    {
        ballXPos = ballXPos + (int)ballXVelo;
        ballYPos = ballYPos + (int)ballYVelo;
    }
    
    //updates location of the paddle based of direction input by player
    public void movePaddle(){
        if (dirP1.equals("up") && p1YPos>0)
        {
            p1YPos -= 4;
        }
        else if (dirP1.equals("down") && p1YPos < 240)
        {
            p1YPos += 4;
        }
        if (dirP2.equals("up") && p2YPos>0)
        {
            p2YPos -= 4;
        }
        else if (dirP2.equals("down") && p2YPos<240)
        {
            p2YPos += 4;
        }
    }
    
    
    //Changes direction of the ball based of where it hits the baddle
    //Uses trigonometry to calculate the distance from the center of the ball to the paddle, to determine what the x and y velocities should be
    //increments ball speed
    public void paddleCollision(){
        if (ballXPos < 30 && ballYPos+20 > p1YPos && ballYPos < p1YPos+60 && ballXVelo<0) //checks if the ball is within range of the paddle and if it has already been hit 
        {
            
            ballTotalSpeed++; //incrementing speed of ball
            ballXVelo = ballTotalSpeed*Math.cos(((ballYPos+10)-(p1YPos+30))/40.0); // Solves for xVelo
            ballYVelo = ballTotalSpeed*Math.sin(((ballYPos+10)-(p1YPos+30))/40.0); // Solves for yVelo

            
        }
        if (ballXPos > 400 && ballYPos+20 > p2YPos && ballYPos < p2YPos+60 && ballXVelo>0) //checks if the ball is within range of the paddle and if it has already been hit 
        {
            ballTotalSpeed++; //incrementing speed of ball
            ballXVelo = -1*ballTotalSpeed*Math.cos(((ballYPos+10)-(p2YPos+30))/30.0); //Solves for xVelo
            ballYVelo = ballTotalSpeed*Math.sin(((ballYPos+10)-(p2YPos+30))/30.0); // Solves for yVelo

        }
    }
    
    public void wallCollision(){ //changes direction of the ball from positive or negative in the y direction if it hits the wall
       if (ballYPos<0)
       {
           ballYVelo = -1*ballYVelo;
           ballYPos = 0; //Sets ball back to the edge of the borders
           
       }
       if (ballYPos> 280)
       {
           ballYVelo = -1*ballYVelo;
           ballYPos = 280; //Sets ball back to the edge of the borders
           
       }
    }
    

    //Checks if any player got a point, if so we have to reset the spawn a new ball, give the ball the approriate velocity, and check if anyone won
    public void getPoint(){
        if (ballXPos < 0)
        {
            p2Points++;
            this.spawnBall();

            ballXVelo = 2.0;
            ballYVelo = 0.0;
            ballTotalSpeed = 2.0;
            checkWin();
        }
        else if (ballXPos>430)
        {
            p1Points++;
            this.spawnBall();

            ballXVelo = -2.0;
            ballYVelo = 0.0;
            ballTotalSpeed = 2.0;
            checkWin();
        }
    }
    
    
}