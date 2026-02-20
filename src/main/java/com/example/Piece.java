package com.example;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import javax.imageio.ImageIO;

//you will need to implement two functions in this file.
public class Piece {
    private final boolean color;
    private BufferedImage img;
    
    public Piece(boolean isWhite, String img_file) {
        this.color = isWhite;
         
        try {
            if (this.img == null) {
                this.img = ImageIO.read(new File(System.getProperty("user.dir")+img_file));
            }
          } catch (IOException e) {
            System.out.println("File not found: " + e.getMessage());
          }
    }
    
    

    
    public boolean getColor() {
        return color;
    }
    
    public Image getImage() {
        return img;
    }
    
    public void draw(Graphics g, Square currentSquare) {
        int x = currentSquare.getX();
        int y = currentSquare.getY();
        
        g.drawImage(this.img, x, y, null);
    }
    
    
    // TO BE IMPLEMENTED!
    //return a list of every square that is "controlled" by this piece. A square is controlled
    //if the piece capture into it legally.
    public ArrayList<Square> getControlledSquares(Square[][] board, Square start) {
        ArrayList<Square>controlledSquares= new ArrayList<Square>();
        controlledSquares.add();
     return null;
    }
    

    //TO BE IMPLEMENTED!
    //implement the move function here
    //it's up to you how the piece moves, but at the very least the rules should be logical and it should never move off the board!
    //returns an arraylist of squares which are legal to move to
    //please note that your piece must have some sort of logic. Just being able to move to every square on the board is not
    //going to score any points.
    public ArrayList<Square> getLegalMoves(Board b, Square start){
        ArrayList<Square>LegalMoves= new ArrayList<Square>();
        Square[][]board=b.getSquareArray();
        int r=start.getRow();
        int c=start.getCol();
        int newR=r-1;
        int newC=c;
        if(newR>=0&&newR<8&&newC>=0&&newC<8){
            Square tinySquare= board[newR][newC];
            if(tinySquare.isOccupied()){
                if(tinySquare.getOccupyingPiece().getColor()!=this.getColor()){
                    LegalMoves.add(tinySquare);
                }
            }else{
                                    LegalMoves.add(tinySquare);

            }
        int newR2=r+1;
        int newC2=c;
        if(newR<8&&newR>=0&&newC>=0&&newC<8){
            Square tinySquare2=board[newR2][newC2];
            if(tinySquare2.isOccupied()){
                if(tinySquare2.getOccupyingPiece().getColor()!=this.getColor()){
                    LegalMoves.add(tinySquare2);
                }
            }else{
                LegalMoves.add(tinySquare2);
            }
        }
        int newR3=r-1;
        int newC3=c-1;
        if(newR3<8&&newR3>=0&&newC3>=0&&newC3<8){
            Square tinySquare3=board[newR3][newC3];
            if(tinySquare3.isOccupied()){
                if(tinySquare3.getOccupyingPiece().getColor()!=this.getColor()){
                    
                }
            }
        }
        }
    	return LegalMoves;
    }
}