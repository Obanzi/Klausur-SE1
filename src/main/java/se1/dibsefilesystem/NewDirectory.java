package se1.dibsefilesystem;



import java.util.ArrayList;
import java.util.List;

public class NewDirectory {

    String name;

    List<NewDirectory> children = new ArrayList<>();

    /** @return Name of file */
    public String getName() {
        return name;
    }

    /** Erzeuge benanntes Verzeichnis */
    public NewDirectory(String name) {
        this.name= name;
    }

    // Dateien in diesem Verzeichnis
    List<AFile> files= new ArrayList<>();
    private final List<AntivirusOne> observersScam = new ArrayList<>();
    private final List<AntivirusTwo> observersVirus = new ArrayList<>();

    /**
     * @param child NewDirectory, das hinzugefuegt werden soll
     * @return Dateien in diesem Verzeichnis */
    public void addChild(NewDirectory child){

        children.add(child);
        System.out.println("'" + child.getName() + "' dem Verzeichnis '" + getName() + "' hinzugefuegt.");
    }



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

    /**
     *
     * @param file Datei, die gescannt werden soll
     * @return true, wenn Datei ein Scam enthaelt
     */
    public boolean notifyObserversScam(AFile file) {
        for (AntivirusOne observer : observersScam) {
            return observer.scanFile(file);
        }
        return false;
    }

    /**
     *
     * @param file Datei, die auf Viren geprüft werden soll
     * @return true, wenn Datei Viren enthält
     */
    public boolean notifyObserversVirus(AFile file) {
        for (AntivirusTwo observer : observersVirus) {
            return observer.scanFile(file);
        }
        return false;
    }

    /** Inhalt vom Verzeichnis ausgeben */
    public void dirCmd() {
            for (AFile f: files) {
                System.out.println(f.getName() +"\t "+ f.getPayload());
        }
            for(NewDirectory d: children){
                System.out.println(d.getName() + "\t " + "DirectoryNew");
                d.dirCmd();
            }
    }

}
