//nazrawit tefera
//piece name- king
//It can move one square in any direction, 
// including diagonally, and can also perform a special move called castling, where it moves two squares towards a rook.

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
public class King extends Piece {

    
    public King(boolean isWhite, String img_file) {
        super(isWhite,img_file);

       // this.color = isWhite;
         
       // try {
           // if (this.img == null) {
               // this.img = ImageIO.read(new File(System.getProperty("user.dir")+img_file));
            //}
         // } catch (IOException e) {
          //  System.out.println("File not found: " + e.getMessage());
         // }
    }
    
    

    // Pre: b and start not null, start contains this piece, board is valid

    // Post: returns list of squares this piece could capture, inside board, board unchanged
    
    // TO BE IMPLEMENTED!
    //return a list of every square that is "controlled" by this piece. A square is controlled
    //if the piece capture into it legally.
    public ArrayList<Square> getControlledSquares(Board b, Square start) {
        //return getLegalMoves(b, start);
        ArrayList<Square>num= new ArrayList<Square>();
        Square[][]board=b.getSquareArray();
        int r=start.getRow();
        int c=start.getCol();
        for(int fr=-1;fr<=1;fr++){
            for(int fc=-1;fc<=1;fc++){
               int newR=r+fr;
               int newC=c+fc;
               if(fr==0&&fc==0){
                continue;
               }
               if(newR>=0&&newR<8&&newC>=0&&newC<8){
                Square tinySquare= board[newR][newC];
                num.add(tinySquare);
               }
            }
        }
        return getLegalMoves(b, start);


    }
// Pre: b and start not null, start contains this piece, board is valid
// Post: returns list of legal squares for this piece, inside board, no same-color pieces, board unchanged


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
        for(int fr=-1; fr<=1;fr++){
            for(int fc=-1; fc<= 1;fc++){
                if(fc==0&&fr==0){
                    continue;
                }
        int newR=r+ fr;
        int newC= c+fc;
        if(newR>=0&&newR<8&&newC>=0&&newC<8){
            Square tinySquare= board[newR][newC];
            if(tinySquare.isOccupied()){
                if(tinySquare.getOccupyingPiece().getColor()!=this.getColor()){
                    LegalMoves.add(tinySquare);
                }
            }else{
                                    LegalMoves.add(tinySquare);

            }
            }

        }
        }
        return LegalMoves;
    }
}


       