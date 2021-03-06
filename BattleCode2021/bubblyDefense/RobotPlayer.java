package bubblyDefense;
import battlecode.common.*;

public strictfp class RobotPlayer {
    static RobotController rc;

    //spawnable robots
    static final RobotType[] spawnableRobot = {
        RobotType.POLITICIAN,
        RobotType.SLANDERER,
        RobotType.MUCKRAKER,
    };

    static final Direction[] directions = {
        Direction.NORTH,
        Direction.NORTHEAST,
        Direction.EAST,
        Direction.SOUTHEAST,
        Direction.SOUTH,
        Direction.SOUTHWEST,
        Direction.WEST,
        Direction.NORTHWEST,
    };

    static int turnCount;

    /**
     * run() is the method that is called when a robot is instantiated in the Battlecode world.
     * If this method returns, the robot dies!
     **/
    @SuppressWarnings("unused")
    public static void run(RobotController rc) throws GameActionException {

        // This is the RobotController object. You use it to perform actions from this robot,
        // and to get information on its current status.
        RobotPlayer.rc = rc;

        turnCount = 0;

        //System.out.println("I'm a " + rc.getType() + " and I just got created!");
        while (true) {
            turnCount += 1;
            // Try/catch blocks stop unhandled exceptions, which cause your robot to freeze
            try {
                // Here, we've separated the controls into a different method for each RobotType.
                // You may rewrite this into your own control structure if you wish.
                //System.out.println("I'm a " + rc.getType() + "! Location " + rc.getLocation());
                switch (rc.getType()) {
                    case ENLIGHTENMENT_CENTER: runEnlightenmentCenter(); break;
                    case POLITICIAN:           runPolitician();          break;
                    case SLANDERER:            runSlanderer();           break;
                    case MUCKRAKER:            runMuckraker();           break;
                }

                // Clock.yield() makes the robot wait until the next turn, then it will perform this loop again
                Clock.yield();

            } catch (Exception e) {
                System.out.println(rc.getType() + " Exception");
                e.printStackTrace();
            }
        }
    }


    static void runEnlightenmentCenter() throws GameActionException {
        RobotType toBuild = randomSpawnableRobotType();

         /*  rc.getTeam().opponent();
           //Finish me:
            if ( Team.opponent() == false) {
                System.out.println("Hey! You serve the other side!");
               // RobotType toBuild = RobotType.MUCKRAKER;
            }*/

        int influence = 50;
        for (Direction dir : directions) {
            if (rc.canBuildRobot(toBuild, dir, influence)) {
                rc.buildRobot(toBuild, dir, influence);
            } else {
                break;
            }
        }
        //Vote Bidding
        int B = 5;
        int BiddingThreshold = 1000;
        if (rc.canBid(BiddingThreshold)) {
            try {
                rc.bid(B);
                System.out.println("BugTestmk2 is bidding: " + B );
            }
            catch (GameActionException CANT_DO_THAT){
                rc.bid(B*5);
                System.out.println("TIME TO BID HIGHER");

            }
            //Decrease the bid until it is at the original bidding number
            if (B <= 5) {
                rc.bid(B + 5);
            }  else if (B > 5) {
                rc.bid(B - 5);
            }
        }

    }

    static void runPolitician() throws GameActionException {
        Team enemy = rc.getTeam().opponent();
        int actionRadius = rc.getType().actionRadiusSquared;
        RobotInfo[] attackable = rc.senseNearbyRobots(actionRadius, enemy);
        if (attackable.length != 0 && rc.canEmpower(actionRadius)) {
            System.out.println("empowering...");
            rc.empower(actionRadius);
            System.out.println("empowered");
            return;
        }else if (attackable.length != 0 && rc.canEmpower(actionRadius)) {
            rc.empower(actionRadius);

        }

        if (tryMove(randomDirection()))
            System.out.println("I moved!");
    }

    static void runSlanderer() throws GameActionException {
        if (tryMove(randomDirection()))
            System.out.println("I moved!");
    }

    static void runMuckraker() throws GameActionException {
        Team enemy = rc.getTeam().opponent();
        int actionRadius = rc.getType().actionRadiusSquared;
        for (RobotInfo robot : rc.senseNearbyRobots(actionRadius, enemy)) {
            if (robot.type.canBeExposed()) {
                // It's a slanderer... go get them!
                if (rc.canExpose(robot.location)) {
                    //System.out.println("e x p o s e d");
                    rc.expose(robot.location);
                    return;
                }
            }
        }
        if (tryMove(randomDirection()))
            System.out.println("I moved!");
    }

    /**
     * Returns a random Direction.
     *
     * @return a random Direction
     */
    static Direction randomDirection() {
        return directions[(int) (Math.random() * directions.length)];
    }

    /**
     * Returns a random spawnable RobotType
     *
     * @return a random RobotType
     */
    static RobotType randomSpawnableRobotType() {
        return spawnableRobot[(int) (Math.random() * spawnableRobot.length)];
    }
    // Try to make it spawn a specific RobotType?
    static RobotType twst() {
        return spawnableRobot[(int) (Math.random() * spawnableRobot.length)];
    }

    /**
     * Attempts to move in a given direction.
     *
     * @param dir The intended direction of movement
     * @return true if a move was performed
     * @throws GameActionException
     */
    static boolean tryMove(Direction dir) throws GameActionException {
        //System.out.println("I am trying to move " + dir + "; " + rc.isReady() + " " + rc.getCooldownTurns() + " " + rc.canMove(dir));
        if (rc.canMove(dir)) {
            rc.move(dir);
            return true;
        } else return false;
    }
    //Bubble
    //Bubbles a layer of Muckrackers, Politicans, Muckrackers, Slanders in that order!

    static void bubbling_Defense(){

    }



    /*
    //BFS (Assume passablilty of 0/1
    Queue q = {Location}
    while q not empty:
        u = remove 1st from q;
        for each neighbor of u:
            if d[U] + 1 < d[n]
                then add n +q
                update d

    // Dijkstra's algorithm
    //java.util.PriorityQueue
    q = PriorityQueue
        while q not empty:
            u = remove closest from q
            for each neighbor of u:
                if d[U] + cooldown < d[n]
                    then add n to q
                    update d

     //Dial's algorithm
        // Assumes small whole number distances
        // PriorityQueue - Add a new location w/ some distance
        //               - Remove location with smallest d
        //                                                 Difference <= 10
        // To do this Create an Array!
        // Put array into q
        // Each cell holds a list of different distances and after all detectable squares are organized,
        // expand all around.

        // Larger strats

     */

}
