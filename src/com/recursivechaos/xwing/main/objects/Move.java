package com.recursivechaos.xwing.main.objects;

public enum Move {
	// All possible move combinations
	NONE(0, 0,0,  Dir.STRAIGHT,TurnType.STRAIGHT),
	// Straight
	S1  (2, 0,0,  Dir.STRAIGHT,TurnType.STRAIGHT),
	S2  (4, 0,0,  Dir.STRAIGHT,TurnType.STRAIGHT),
	S3  (6, 0,0,  Dir.STRAIGHT,TurnType.STRAIGHT),
	S4  (8, 0,0,  Dir.STRAIGHT,TurnType.STRAIGHT),
	S5  (10,0,0,  Dir.STRAIGHT,TurnType.STRAIGHT),
	// Turn Left
	TL1 (2, 2,-90,Dir.LEFT,    TurnType.TURN),
	TL2 (4, 4,-90,Dir.LEFT,    TurnType.TURN),
	TL3 (6, 6,-90,Dir.LEFT,    TurnType.TURN),
	// Turn Right
	TR1 (2, 2,90, Dir.RIGHT,   TurnType.TURN),
	TR2 (4, 4,90, Dir.RIGHT,   TurnType.TURN),
	TR3 (6, 6,90, Dir.RIGHT,   TurnType.TURN),
	// Bank Left
	BL1 (2, 1,-45,Dir.LEFT,    TurnType.BANK),
	BL2 (4, 2,-45,Dir.LEFT,    TurnType.BANK),
	BL3 (6, 3,-45,Dir.LEFT,    TurnType.BANK),
	// Bank Right
	BR1 (2, 1,45, Dir.RIGHT,   TurnType.BANK),
	BR2 (4, 2,45, Dir.RIGHT,   TurnType.BANK),
	BR3 (6, 3,45, Dir.RIGHT,   TurnType.BANK),
	// K-Turn
	K2  (4, 0,180,Dir.STRAIGHT,TurnType.KTURN),
	K3  (6, 0,180,Dir.STRAIGHT,TurnType.KTURN),
	K4  (8, 0,180,Dir.STRAIGHT,TurnType.KTURN),
	K5  (10,0,180,Dir.STRAIGHT,TurnType.KTURN);
	
	// move options
	public enum Dir{LEFT,RIGHT,STRAIGHT};
	
	// Also hold the angle the turn takes
	public enum TurnType{
		TURN(45),
		BANK(30),
		STRAIGHT(0),
		KTURN(0),
		BROLL(0);
	
	int turnRadius;
	
	private TurnType(int turnRadius){
		this.turnRadius = turnRadius;
	}

	public int getTurnRadius() {
		return turnRadius;
	}

	
	};
	
	// fields
	private int forward;
	private int shift;
	private int turnClicks;
	private Dir dir;
	private TurnType turnType;
	
	private Move(int forward, int shift, int turnClicks, Dir dir, TurnType turnType){
		this.forward = forward;
		this.shift = shift;
		this.turnClicks = turnClicks;
		this.dir = dir;
		this.turnType = turnType;
	}

	public int getForward() {
		return forward;
	}

	public int getShift() {
		return shift;
	}


	/**
	 * Return, in degrees, heading to turn to. Positive for right, Negative for left.
	 * @return degrees turn
	 */
	public int getTurnClicks() {
		return turnClicks;
	}

	public Dir getDir() {
		return dir;
	}

	public TurnType getTurnType() {
		return turnType;
	}

}
