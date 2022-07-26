/**
 * Breadth First Search to win
 *
 * @author Haodong Li (hadenlee)
 * @version 0.1
 */
public class BFS {

    // field
    private String start;
    private int target;
    /**
     * constructor
     * 
     * @param start
     *            starting board
     */
    public BFS(String start) {
        this.start = start;
        this.target = 200 + ChessFaker.getFitness(start);
        
    }


    /**
     * output
     */
    public void print() {
        // field
        Queue board = new Queue();
        int fitness = 0;
        Queue move = new Queue();
        int nodesVisited = 0;

        // store the initial data
        board.enqueue(start);
        move.enqueue("");

        // output the lines
        System.out.println("Playing to win from: " + start);
        System.out.println("Starting fitness: " + ChessFaker.getFitness(start));

        // record starting time
        long timeStart = System.currentTimeMillis();

        String currBoard = "";
        String movesOutput = "";

        // find 200 more fitness than the start Board
        while (fitness < target) {
            

            // get current data
            currBoard = board.dequeue();
            movesOutput = move.dequeue();
            
            // get fitness
            fitness = ChessFaker.getFitness(currBoard);

            // get next moves
            String[] moves = ChessFaker.getNextMoves(currBoard);

            for (int i = 0; i < moves.length; i++) {

                // get next board and store
                board.enqueue(ChessFaker.getNextBoard(currBoard, moves[i]));

                // get move and add

                move.enqueue(movesOutput + " + " + moves[i]);
                

            }

            nodesVisited++;
        }

        long timeUsed = System.currentTimeMillis() - timeStart;
        // output the rest lines
        System.out.println("Moves to target: " + movesOutput.substring(3));
        System.out.println("Win state: " + currBoard);
        System.out.println("Target fitness: " + fitness);
        System.out.println("Nodes Visited: " + nodesVisited);
        System.out.println("Duration: " + timeUsed);

    }
}
