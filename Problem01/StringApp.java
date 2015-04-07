/*
Carlos F. Meneses
03/30/2015
Bergen Community College
Advanced Java Programming

Homework Project 3, Phase 2, Problem 1
*/
/**
StringApp.java: Modification of Project 3 Phase 2 Problem 1. App reads strings 
from pre-existing data file data.txt until "DONE" is read-in. Throws exception 
if a string is entered that is 20 or more characters long. The exception 
StringTooLongException catches and handles such exception. For every String that 
is read in error, the program logs that error (the string and the line number of 
the offending statement. Store the errors in a file called error.log (see also: 
StringTooLongException.java)
*/

import static java.nio.file.StandardOpenOption.*;
import java.nio.file.*;
import java.io.*;

public class StringApp 
{
	public static void main(String[] args) throws StringTooLongException
	{
		String inFileName = "data.txt";
		String outFileName = "error.log";
		boolean done = false;
		int maxLength = 20;
		String doneString = "done";
		Path inPath = Paths.get(inFileName);
      Path outPath = Paths.get(outFileName);
		String inString = "";
      String outString = "";
      int lineCount = 0;
		
      try
      {
   		InputStream input = new BufferedInputStream(Files.newInputStream(inPath));
   		BufferedReader reader = new BufferedReader(new InputStreamReader(input));
         
         OutputStream output = new BufferedOutputStream(Files.newOutputStream(outPath, CREATE));
         BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(output));
            
   		System.out.println("Reading from file " + inFileName + "...");
         
   		while (!done)
   		{
   			++lineCount;
            try
            {
               inString = reader.readLine();
               
      			if (doneString.equalsIgnoreCase(inString))
      			{
      				done = true;
      			}
               
               else if (inString.length() >= maxLength)
               {
                  outString = lineCount + " " + inString;
                  writer.write(outString, 0, outString.length());
                  throw(new StringTooLongException());
               }
            }
            catch(StringTooLongException e)
            {
               System.out.println(e);
            }
   		}
		   reader.close();
         writer.close();
      }
      catch(NullPointerException e)
      {
         System.out.println("Reached EOF before " + doneString);
      }
      
      catch(Exception e)
      {
         System.out.println(e);
      }
			
	}
}
