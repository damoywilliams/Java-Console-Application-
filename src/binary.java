/**
 * 
 * This class have two methods
 * 
 * textToBinary  takes a text file and write it to a outfile as binary
 * 
 * index method  write a index file for the data file
 * 
 * 
 *
 * @author (Damoy Williams)
 * @version (a version 5)
 */

import java.io.*;

public class binary{
    String name;
    String isPrivate;
    String AcceptanceRate;
    String  GradRate;
    String Apps;
    String Enroll;
    int collegeName_size= 36;
    int isPrivate_size = 36;
    BufferedReader readerIndex= null; 
    BufferedReader reading= null;
    String outfile="generatedBinary.dat";
   
    pad ip = new pad();
  
    
    public void textToBinary ( String fn ) {
        BufferedReader reader = null; // required
        RandomAccessFile writer = null;
       
                  //To Read From a File
        try {
            reader = new BufferedReader(new FileReader(fn));
        } catch (Exception e) {
            System.err.println("Can't open what is going on?? "+fn);

        }
                  //To Write a Binary File 
        try {
            writer = new RandomAccessFile(outfile,"rw");
        } catch (Exception e) {
            System.err.println("Can't open "+outfile);
            return;
        }

        try {
                  
        	//Below We are Reading in from txt file and writing to Binary File
            String header = reader.readLine();
            String line = reader.readLine();

            while (line != null)  {

                String strings[]=line.split(",");

                name=strings[0];
                String updatedname =ip.writeFixedLengthString(name);
                writer.writeUTF(updatedname);

                isPrivate=strings[1];
                String updatedIsPrivate=ip.writeFixedLengthString(isPrivate);
                writer.writeUTF(updatedIsPrivate);

                Apps=strings[2];
                int ap=Integer.parseInt(Apps); //convert to a int

                writer.writeInt(ap);

                AcceptanceRate = strings[3];
                int AcceptRate=Integer.parseInt(AcceptanceRate); //convert to a int

                writer.writeInt(AcceptRate);

                Enroll = strings[4];
                int el =Integer.parseInt(Enroll); //convert to a int

                writer.writeInt(el);

                GradRate = strings[5];
                int Grad=Integer.parseInt(GradRate ); //convert to a int

                writer.writeInt(Grad);

                line = reader.readLine();
            }
            reader.close();

        } catch (Exception e) {

        }

        System.out.println("EOF");
    }
    
    
    
  //for writing the index binaryfile.
    public void index(){
       
        try{
            RandomAccessFile writeIndex = new RandomAccessFile("index.dat","rw");
            RandomAccessFile read = new RandomAccessFile(outfile,"r");
            for (int i =0; i<=read.length(); i+=92){      

                read.seek(i);
                String key= read.readUTF();
                writeIndex.writeUTF(key);

            }
            reading.close();
        }catch (Exception ex) {

        }}
}
