package se1.dibsefilesystem;


public class App {

	/**
	 * Gibt einen Banner mit Aufgabennummer aus, um zu verdeutlichen, auf welche Aufgabe sich
	 * weitere Bildschirmausgaben beziehen.
	 * @param beginAufgabe Nummer der hier beginnenden Aufgabe
	 */
	static final void aufgabenabgrenzer(int beginAufgabe) {
		System.out.println("\n#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#");
		System.out.println("# Aufgabe: " + beginAufgabe + ":\n");
	}

	// M A I N
	public static void main(String[] args) {

		/////////////////////////////////////////////////////////////////////////
		// Beginn Aufgabe 1: Singleton
		// Hier zu Aufgabe 1 soll nichts mehr geändert werden, implementieren Sie bitte lediglich die Factory-Klasse lt. Aufgabenstellung
		aufgabenabgrenzer(1);

		// Einige Dateien erzeugen
		AFile textFile= new TextFile("duck.txt", "A yellow duck swims on its lake until it flies away.");
		AFile mouseFile= new ImageFile("flower.jpg", "Mouse_image_binary__data__" );

		// Verzeichnis erzeugen und Dateien hinzufügen
		Directory myDir= new Directory("myDir");
		myDir.addFile(textFile);
		myDir.addFile(mouseFile);

		// Dateien im Verzeichnis am Bildschirm auflisten
		myDir.dirCmd();

		/////////////////////////////////////////////////////////////////////////
		// Beginn Aufgabe 2: Factory
		aufgabenabgrenzer(2);

		// HIER Ihr Code

		FileFactory fileFactory = new FileFactory();


		AFile file1 = fileFactory.createFile("image", "cat.jpg");
		AFile file2 = fileFactory.createFile("text", "dog.txt");
		AFile file3 = fileFactory.createFile("text", "stick.txt");
		file1.setName("cat.jpg");
		file2.setName("dog.txt");
		file3.setName("stick.txt");
		try {
			AFile file4 = fileFactory.createFile("audio", "Audiofile");
		} catch (IllegalArgumentException e) {
			System.out.println("File name not supported -> " + e);
		}

		//myDir.dirCmd();



		/////////////////////////////////////////////////////////////////////////
		// Aufgabe 3: Unit Tests --> Testklasse im üblichen Testverzeichnis, nicht hier!
		/////////////////////////////////////////////////////////////////////////
		// Beginn Aufgabe 4: Observer
		aufgabenabgrenzer(4);

		//
		//  --> HIER Ihre AntivirusOne und AntivirusTwo für das Directory "myDir" herstellen

		AntivirusOne antivirusOne = new AntivirusOne();
		AntivirusTwo antivirusTwo = new AntivirusTwo();

		myDir.addScamObserver(antivirusOne);
		myDir.addVirusObserver(antivirusTwo);

		//  Ihre zwei IVirusscanner wachen jetzt über "myDir":
		//  Die folgenden zwei gefährlichen Dateien können "myDir" nicht hinzugefügt werden.
		//  Ihre Virusscanner sollen dies mit "VIRUSALARM" und weiteren Infos verdeutlichen.
		AFile virus1= new ImageFile("danger.exe","*******virus*****");
		AFile virus2= new ImageFile("boom.exe","**scam**virus*********");
		myDir.addFile(virus1);
		myDir.addFile(virus2);

		// Die zwei Virusfiles dürfen in Auflistung NICHT enthalten sein:
		myDir.dirCmd();



		/////////////////////////////////////////////////////////////////////////
		// Beginn Aufgabe 5: Composite
		aufgabenabgrenzer(5);

		NewDirectory newDir = new NewDirectory("root");
		NewDirectory newDir2 = new NewDirectory("Verzeichnis2");
		NewDirectory newDir3 = new NewDirectory("songs");

		AFile file4 = fileFactory.createFile("text", "datei1.txt");
		AFile file5 = fileFactory.createFile("image", "image1.jpg");
		AFile file6 = fileFactory.createFile("text", "robots.txt");
		AFile file7 = fileFactory.createFile("text", "justinbiber.txt");
		System.out.println();

		newDir.addFile(file4);
		newDir.addFile(file5);
		newDir.addChild(newDir2);
		newDir2.addFile(file6);
		newDir2.addChild(newDir3);
		newDir3.addFile(file7);
		System.out.println();

		newDir.dirCmd();





	}
}