package RobotSimulator.ToyRobotSimulator;
import java.util.HashMap;

public class Robot {

Points points;
String facing;

static HashMap<String,Points> moveMap = new HashMap<String,Points>();
static {
	moveMap.put("North", new Points(0,1));
	moveMap.put("South", new Points(0,-1));
	moveMap.put("East", new Points(1,0));
	moveMap.put("West", new Points(-1,0));
}

public Boolean place(int x, int y,String facing) {
		
	if(isValid(x,y)) {
		this.points = new Points(x,y);
		this.facing = facing;
	return true;
	} else {
		System.out.println("Invalid Points");
	}
	
return false;
}

public Boolean isValid(int x, int y) {
		
	if(x>=0 && y>=0 && x<5 && y<5) {
		return true;
	}
	
return false;
}

public String report() {
	return this.points.x + ","+this.points.y + "," +this.facing;
}

public void move() {
	Points temp = moveMap.get(this.facing);
	int i = this.points.x+temp.x;
	int j = this.points.y+temp.y;
	if(isValid(i,j)) {
		this.points = new Points(i,j);
	}
}
public void left() {
	switch(this.facing) {
	case "North" :
		this.facing = "West";
		break;
	case "West" :
		this.facing = "South";
		break;
	case "South" :
		this.facing ="East";
		break;
	case "East" :
		this.facing = "North";
		break;
		
	}
}
public void right() {

  switch(this.facing) {
	case "North" :
		this.facing = "East";
		break;
	case "West" :
		this.facing = "North";
		break;
	case "South" :
		this.facing ="West";
		break;
	case "East" :
		this.facing = "South";
		break;
		
  }
}
}
