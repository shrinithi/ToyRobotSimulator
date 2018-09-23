package RobotSimulator.ToyRobotSimulator;

import java.util.Scanner;



public class App 
{
    public static void main( String[] args )
    {
    	Robot robot = new Robot();
		Scanner scanner = new Scanner(System.in);
		
		String inputCommands = null;
		String[] place = null;
		String[] placeParams = null;

		int x,y;
		Boolean robotPlaced=false;
		System.out.println("Input commands");
		
		while(scanner.hasNext()) {
			inputCommands = scanner.nextLine();   //get line by line input
			//System.out.println(inputCommands);
		
		
			if(inputCommands.startsWith("Place")) {   /* Check if the command is Place */
				place =inputCommands.split(" ");
				placeParams = place[1].split(",");
				if(placeParams.length == 3) {
					x = Integer.parseInt(placeParams[0]);
					y= Integer.parseInt(placeParams[1]);
					if(robot.place(x,y,placeParams[2])) {  
					//If the robot is placed at valid points, it can accept other commands.
						robotPlaced = true;
						continue;
					} 	
				} else {
					continue;
				}
					
			} 
				
				
			if(!robotPlaced) {
				//ignore commands until robot is placed inside the square.
				continue;
			}
			if(inputCommands.equalsIgnoreCase("Move")) {
				robot.move();
			}
			if(inputCommands.equalsIgnoreCase("Right")) {
				robot.right();
			}
			if(inputCommands.equalsIgnoreCase("Left")) {
				robot.left();
			}
			if(inputCommands.equalsIgnoreCase("Report")) {
				System.out.println(robot.report());
			}
		}
		
		scanner.close();
	}
	
	
    }

