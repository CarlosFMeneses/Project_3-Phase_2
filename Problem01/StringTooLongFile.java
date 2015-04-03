import java.nio.file.*;
import java.io.*;
import java.nio.channels.FileChannel;
import java.nio.ByteBuffer;
import static java.nio.file.StandardOpenOption.*;
public class StringTooLongFile {
	
	public static void main(String[] args) {
		
		
		Path fileIn = Paths.get("C:\\Users\\alex\\Documents\\String.txt");//file input
		Path fileOut = Paths.get("C:\\Users\\alex\\Documents\\StringTooLongErrors.txt");//file output
		
		int count = 0;
		String newLine = "\n";
		InputStream input = null;
		OutputStream output = null;
		String line = "";
		String error;
		
		try{
			//Creates new file streams
			input = Files.newInputStream(fileIn);
			BufferedReader reader = new BufferedReader(new InputStreamReader(input));
			output = Files.newOutputStream(fileOut);

			while(line != null){
				line = reader.readLine();
				count += 1;
				//writes data to the file
				if(line.length() >= 20){
					error = line + "	Line: " + count + "\r\n";
					byte[] data = error.getBytes();
					output.write(data);
				}	
			}
			output.close();
		}
		catch(IOException e){
			System.out.println(e);
		}
		
	}

}
