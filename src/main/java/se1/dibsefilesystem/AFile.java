package se1.dibsefilesystem;

/** Mutter aller Dateitypen */
abstract public class AFile {
    /** Dateiname */
    String name;


    /** unique id */
    long id;

    /** Eigentlicher Dateiinhalt. Der Einfachheit halber als String (statt Binärformat, z.B.  "byte[]") */
    private String payload;

    /** Erzeuge eine Datei
     * @param fileName Dateiname
     * @param payload Dateiinhalt
     */
    public AFile(String fileName, String payload) {
        this.name = fileName;
        this.payload= payload;
        this.id = IdGenerator.getInstance().createId();
        System.out.println(name + " \t\t" + getClass().getSimpleName()+ "\t\t"+ payload.length() + " bytes (id=" + id + ")" + " wurde erzeugt.");
    }

    /** @returns Name of file */
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    /** Liefert Informationen über diese Datei */  //  \t = Tabulatorzeichen
    public String getInfo() {
        return name + " \t\t" + getClass().getSimpleName()+ "\t\t"+ payload.length() + " bytes (id=" + id + ")";
    }


    /** toString() überschrieben */
    public String toString() {
        return getInfo();
    }


    /** @returns payload =eigentlicher Dateiinhalt, als String */
    public String getPayload() {
        return payload;
    }
}
