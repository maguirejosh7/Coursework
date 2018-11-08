using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Diagnostics; //for stopwatch

namespace Mankalah
{
    /*****************************************************************
         * A Mankalah player, by Joshua Maguire for cs 212. Uses minimax, a timer, a depth
         * limiter(line 29 (for some reason, 5 works best), and a lack of an evaluate funciton
         * override to pick the best next move. beats bonzo! WOOP WOOP!
     *****************************************************************/

    public class jlm54Player : Player
    {
        private String name;
        private Position position;
        private int timePerMove;	// time allowed per move in msec
        private String[] resultString;
        private Stopwatch myWatch = new Stopwatch();

        public jlm54Player(Position pos, int timeLimit) : base(pos, "G Man", timeLimit) { timePerMove = timeLimit; }

        public override int chooseMove(Board b)
        {
            myWatch.Restart();
            moveResult myMove = miniMax(b, 5); // 5 beats bonzo by the most. can be put up to like 100 as long as the timer is set to a few seconds
            return myMove.move;
        }


        /// <summary>
        /// MiniMax algorithm for mankalah. Uses the moveResult class, probably doesn't need to and 
        /// could use it much more efficiently, but for times sake...
        /// This method finds returns the best move based on its rating.
        /// </summary>
        /// <param name="b"></param> which mankalah board
        /// <param name="d"></param> depth of which algotithm will recurse
        /// <returns></returns>
        private moveResult miniMax(Board b, int d)
        {
            moveResult moveVal = new moveResult(0, 0);      //uses result class at bottom
            moveResult bestMoveVal = new moveResult(0, 0);  // ^^
            if (b.gameOver() || d == 0) return new moveResult(0, evaluate(b));//evaluate function is simple. Bad thing?
            if (b.whoseMove() == Position.Bottom)
            {
                bestMoveVal.val = 999;
                for (int move = 0; move <= 5; move++)   //for all possible moves,
                {
                    if (b.legalMove(move) && myWatch.ElapsedMilliseconds < timePerMove) /*and time not expired*/
                    {
                        Board b1 = new Board(b); //dup board b
                        b1.makeMove(move, false);//make move
                        moveVal = miniMax(b1, d - 1); //recurse and return value
                        if (moveVal.val < bestMoveVal.val) { bestMoveVal = moveVal; bestMoveVal.move = move; }//overwrite if better move
                    }
                }
                return bestMoveVal;//return best move found.
            }
            else       //similar comments as above...
            {
                bestMoveVal.val = -999;
                for (int move = 7; move <= 12; move++)
                {
                    if (b.legalMove(move) && myWatch.ElapsedMilliseconds < timePerMove) /*and time not expired*/
                    {
                        Board b1 = new Board(b); //dup board b
                        b1.makeMove(move, false);
                        moveVal = miniMax(b1, d - 1);
                        if (moveVal.val > bestMoveVal.val) { bestMoveVal = moveVal; bestMoveVal.move = move; }

                    }
                }
                return bestMoveVal;
            }
        }


        public override String gloat() { return " The right piece in the wrong place can make all the difference in the world."; }
        public override String getImage() { return "http://static3.wikia.nocookie.net/__cb20100621095821/half-life/en/images/2/27/G-man_heart_to_heart_headshot.jpg"; }



    }
}
/// <summary>
/// Basically an object that holds two ints. Used so we can return two things at once.
/// </summary>
public class moveResult
{
    public int val;
    public int move;
    public moveResult(int m, int v){ move = m; val = v; }

}