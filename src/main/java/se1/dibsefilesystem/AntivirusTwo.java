package se1.dibsefilesystem;

public class AntivirusTwo implements IVirusscanner{

    String name = "AntivirusTwo";

    public String getName(){
        return name;
    }

    public AntivirusTwo(){
    }
    /**
     * Scans a file for viruses
     * @param file the file to be scanned
     * @return true if the file contains a virus, false otherwise
     */
    @Override
    public boolean scanFile(AFile file) {
        String myString = file.getPayload();
        if(myString.contains("virus")){
            //System.out.println(file.getName() +  " enthaelt Virus");
            return true;
        }
        return false;
    }
}
