
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class ParseDriver {
	
	public static void main(String[] args) throws FileNotFoundException, ParseException{
		Scanner scan = new Scanner( new File (args[0]));
        String line;
        boolean debug = false;
        if(args.length > 1)
        	debug = true;
        // loop through lines in input file
        while ( scan.hasNextLine()){
        	line = scan.nextLine();
        	System.out.println("next line: " + line);
        	TokenIter tokIt = new TokenIter(line);
    		ParseExpr parser = new ParseExpr(tokIt, debug);
    		parser.line();       
        }
	}
}

