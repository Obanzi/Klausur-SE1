package se1.dibsefilesystem;

public class AntivirusOne implements IVirusscanner{

    String name = "AntivirusOne";

    public String getName(){
        return name;
    }
    public AntivirusOne(){
    }
    /**
     * Scans a file for scams
     * @param file the file to be scanned
     * @return true if the file contains a scam, false otherwise
     */
    @Override
    public boolean scanFile(AFile file) {
        String myString = file.getPayload();
        if(myString.contains("scam")){
            //System.out.println(file.getName() +  " enthaelt Scam");
            return true;
        }
        return false;
    }
}
