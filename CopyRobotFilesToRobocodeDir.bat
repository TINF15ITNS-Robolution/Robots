#aus Robocode selber kann man externe Quellen für Roboter angeben (options->Preferences->DevelopmentOptions): So hab ich das Java-Projekt der Robots angegeben und kann meine Robots auswählen bei New->Battle
#wenn ich Robocode über die Control-API starte findet er die Robots aus der externen Quelle nicht
# die Doku sagt über die Methode, die die Robots finden soll, dass diese sich in dem Verzeichnis /robots befinden sollen (und sie werden durch die externe Quellenangabe nicht hierein kopiert)
#also dieses Skript hier, welches die Robot-Dateien in das Verzeichnis kopiert vor dem Start eines Battles



#target:robots\package-name\class-name
if not exist "C:\robocode\robots\TestRobot1" mkdir "C:\robocode\robots\TestRobot1"
COPY "C:\Users\Nikolai\Documents\DHBW\5.Semester\Robotik\Git Repo\Robots\bin\TestRobot1\TestRobot1Main.class" "C:\robocode\robots\TestRobot1"
COPY "C:\Users\Nikolai\Documents\DHBW\5.Semester\Robotik\Git Repo\Robots\src\TestRobot1\TestRobot1Main.java" "C:\robocode\robots\TestRobot1"