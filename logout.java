import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.*;

/**
 * Created By MrL on 14/11/2015.
 * In Project : Pronto-Auth
 */

class logout{

	public static final String url = "http://phc.prontonetworks.com/cgi-bin/authlogout";
	public static long start;
	
	public static void main(String argrs[]){
		try {
            Calendar cal = Calendar.getInstance();
            start = cal.getTimeInMillis();

			System.out.print("Trying to logout \n");

			Document doc = Jsoup.connect(url)
				    .userAgent("Mozilla/5.0 (X11; Ubuntu; Linux x86_64; rv:39.0) Gecko/20100101 Firefox/39.0")
				    .header("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,**;q=0.8")
				    .header("Accept-Encoding", "gzip, deflate")
				    .header("Accept-Language", "en-US,en;q=0.7,mr;q=0.3")
				    .header("Host", "phc.prontonetworks.com")
				    .header("Connection", "keep-alive")
				    .header("DNT", "1")
					.timeout(100000)
				    .method(Connection.Method.GET)
				    .execute().parse();
			
			String txt = doc.body().text(), message;
			Matcher matcher;
			matcher = Pattern.compile("\\bno active session\\b").matcher(txt);
			if (matcher.find()) {
			    message = " Already logged Out\t ᕕ( ᐛ )ᕗ";
			    end_program(message);
			}else{
				matcher = Pattern.compile("\\bsuccessfully\\b").matcher(txt);
		   	    if (matcher.find()) {
				    message = " Logged Out\t ┌(˘⌣˘)ʃ";
					end_program(message);
				}else{
                    message = " Probably error occurred\t (︶︹︺)";
					end_program(message);
				}
			}
		} catch (Exception e) {
		   	System.out.println("Error:  " + e);
		}
			
	}
	
	public static void end_program(String message){

		Calendar cal = Calendar.getInstance();
		long end = cal.getTimeInMillis();
		System.out.println("\n\nResult : " + message); 
		System.out.println("completed in " + (end - start)/1000 + "sec");

	}

}


