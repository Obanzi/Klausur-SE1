package se1.dibsefilesystem;



import java.util.ArrayList;
import java.util.List;

public class Directory  {

    String name;


    /** @return Name of file */
    public String getName() {
        return name;
    }

    /** Erzeuge benanntes Verzeichnis */
    public Directory(String name) {
        this.name= name;
    }

    // Dateien in diesem Verzeichnis
    List<AFile> files= new ArrayList<>();
    private final List<AntivirusOne> observersScam = new ArrayList<>();
    private final List<AntivirusTwo> observersVirus = new ArrayList<>();



    /**
     * Datei diesem Verzeichnis hinzufügen
     * @param file Hinzuzufügende Datei
     */

    public void addFile(AFile file) {
            if (notifyObserversScam(file)) {
                System.out.println("SCAMALARM: '" + file.getName() + "' enthaelt Scam!");
            } else if (notifyObserversVirus(file)) {
                System.out.println("VIRUSALARM: '" + file.getName() + "' enthaelt Virus!");
            } else {
                files.add(file);
                System.out.println("'" + file.getName() + "' dem Verzeichnis '" + getName() + "' hinzugefuegt.");
            }
    }


    public void addScamObserver(AntivirusOne observer) {
        observersScam.add(observer);
    }

    public void addVirusObserver(AntivirusTwo observer) {
        observersVirus.add(observer);
    }

    public boolean notifyObserversScam(AFile file) {
        for (AntivirusOne observer : observersScam) {
            return observer.scanFile(file);
        }
        return false;
    }

    public boolean notifyObserversVirus(AFile file) {
        for (AntivirusTwo observer : observersVirus) {
            return observer.scanFile(file);
        }
        return false;
    }

    /** Inhalt vom Verzeichnis ausgeben */
    public void dirCmd() {
        System.out.println("\nListing directory '"+ name+"':");
        for (AFile f: files) {
            System.out.println(f.getInfo());
        }
    }

}
