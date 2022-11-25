package se1.dibsefilesystem;

/** Dateityp für Texte  */
public class TextFile extends AFile {

    /** Erzeige eine Textdatei
     * @param fileName Dateiname
     * @param text Textinhalt der Datei
     */
    public TextFile(String fileName, String text) {
        super(fileName, text);
    }

}
