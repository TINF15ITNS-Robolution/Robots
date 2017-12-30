package TestRobot1;

import robocode.*;

public class TestRobot1Main extends Robot {

	
	private int currentDNASequence = 0;
	private DNA dna;
	
	public void run() {
		
		
		//auf Schussposition bewegen
		//eig unnötig, weil ich den Robot in Cotrol immer in den mittelpunkt setze
		schussPosition();
		
		
		//DNA einlesen
		dna = new DNA();
		//PROBLEM//
		//robocode scheint die Robot-Threads zu staretn, bevor das RoundStartedEvent geworfen wird, also bevor die Datei DNA.txt erzeugt wird, sodass der Robot nicht starten kann und Robocode wiederrum nicht weiterstartet
		//-> erst auf Schussposition fahren (dann hat die Runde auch safe angefangen) und dann erst einlesen 
		
		
		
		//mit der DNA-Abarbeitung beginnen:
		//Dreht Radar um 360Grad
		//bei ScannedRobotEvent wird abhängig von der DNA geschossen oder nichts getan
		while (true) {
			this.turnRight(360d);
		}
	}

	
	@Override
	public void onBattleEnded(BattleEndedEvent e) {

	}
	
	@Override
	public void onBulletHit(BulletHitEvent e) {


	}
	
	@Override
	public void onBulletHitBullet(BulletHitBulletEvent e) {

	}
	
	@Override
	public void onBulletMissed(BulletMissedEvent e) {

	}
	
	@Override
	public void onDeath(DeathEvent e) {

	}
	
	@Override
	public void onHitByBullet(HitByBulletEvent e) {

	}
	@Override
	public void onHitRobot(HitRobotEvent e) {

	}
	
	@Override
	public void onHitWall(HitWallEvent e) {

	}
	
	@Override
	public void onRobotDeath(RobotDeathEvent e) {

	}
	
	@Override
	public void onRoundEnded(RoundEndedEvent e) {

	}
	
	@Override
	public void onScannedRobot(ScannedRobotEvent e) {

		switch(dna.getDNA()[currentDNASequence]) {
		case 0:
			this.doNothing();
			System.out.println("Scanned a Robot but doing Nothing cause: " + dna.getDNA()[currentDNASequence]);
			break;
		case 1:
			this.fire(2);
			System.out.println("Scanned a Robot and fireing at him cause: " + dna.getDNA()[currentDNASequence]);
			break;
		}
		
		currentDNASequence++;
		
		//wenn DNA einmal abgearbeitet, beginne von vorne
		if(currentDNASequence==dna.getDNA().length)currentDNASequence=0;
	}
	
	@Override
	public void onStatus(StatusEvent e) {

	}
	
	@Override
	public void onWin(WinEvent e) {

	}
	
	public void schussPosition() {
		double X0 = getX();
		double Y0 = getY();
		double fieldX = getBattleFieldWidth();
		double fieldY = getBattleFieldHeight();
		double heading = getHeading();

		if (0 <= heading && heading <= 90) {
			turnLeft(90 - heading);
		}
		if (270 <= heading && heading <= 360) {
			turnRight(90 - heading);
		}
		if (270 > heading && heading > 90) {
			turnRight(heading - 90);
		}

		ahead(fieldX / 2 - X0);
		turnRight(90);
		ahead(fieldY / 2 - Y0);
	}


}