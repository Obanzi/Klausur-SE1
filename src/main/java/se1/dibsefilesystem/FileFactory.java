package se1.dibsefilesystem;

public class FileFactory {

    public FileFactory() {
    }

    /**
     * Erzeuge eine Datei
     * @param type Dateityp welcher erzeugt werden soll
     * @param name Dateiname der erzeugt werden soll
     * @return die Datei
     * @throws IllegalArgumentException wenn der Dateityp nicht existiert
     */
    public AFile createFile(String type, String name) throws IllegalArgumentException {
        if(name.length() >=1){
            switch (type) {
                case "text":
                    return new TextFile(name, "TextFile");
                case "image":
                    return new ImageFile(name, "ImageFile");
                default:
                    throw new IllegalArgumentException("File name not supported");
            }
        }else{
            throw new IllegalArgumentException("File name is too short");
        }
}
}
