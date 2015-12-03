import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.*;
import java.net.*;

/**
 * Created By MrL on 14/11/2015.
 * In Project : Pronto-Auth
 */

class pronto{

	private static final String username = "UrUsername";
	private static final String pass = "UrPassword";
	public static final String url = "http://phc.prontonetworks.com/cgi-bin/authlogin?URI=http://captive.apple.com/fEi7l7fzH/Art26D1hO/1D6QulJRI/jc91LbRjA.html";
	public static long start;

	public static void main(String argrs[]){

		String message = "";
		for (int i=0; i<3; i++){
			try {
				Calendar cal = Calendar.getInstance();
				start = cal.getTimeInMillis();
				
				Map<String, String> form_data = new HashMap<>();
				form_data.put("userId", username);
				form_data.put("password", pass);
				form_data.put("serviceName", "ProntoAuthentication");

				System.out.println("Trying for user :  " + username);

				Document doc = Jsoup.connect(url)
						.userAgent("Mozilla/5.0 (X11; Ubuntu; Linux x86_64; rv:39.0) Gecko/20100101 Firefox/39.0")
						.header("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,**;q=0.8")
						.header("Accept-Encoding", "gzip, deflate")
						.header("Accept-Language", "en-US,en;q=0.7,mr;q=0.3")
						.header("Host", "phc.prontonetworks.com")
						.header("Connection", "keep-alive")
						.header("DNT", "1")
						.timeout(100000)
						.data(form_data)
						.method(Connection.Method.POST)
						.execute().parse();
		
				String txt = doc.body().text();
				Matcher matcher;
				matcher = Pattern.compile("\\bSorry\\b").matcher(txt);
				if (matcher.find()) {
					matcher = Pattern.compile("\\bfree access quota\\b").matcher(txt);
			   	    if (matcher.find()) {
						message = " Free quota over for " + username + "\t  (︶︹︺)";
						end_program(message);
						break;
					}
					matcher = Pattern.compile("\\baccount does not exists\\b").matcher(txt);
			   	    if (matcher.find()) {
						message = " Wrong Username, No account exists with username : " + username + "\t ¯\\_(ツ)_/¯";
						end_program(message);
						break;
					}
					matcher = Pattern.compile("\\busername and password\\b").matcher(txt);
			   	    if (matcher.find()) {
						message = " Wrong Password \t (╯°□°)╯︵ ┻━┻ ";
						end_program(message);
						break;
					}
					matcher = Pattern.compile("\\bthere was an error\\b").matcher(txt);
			   	    if (matcher.find()) {
						message = " Probably already logged in somewhere else. Trying again - " + (i + 1) + "\t ┌П┐(►˛◄’!)";
						end_program(message);
					}
				}else{
					matcher = Pattern.compile("\\bCongratulations\\b").matcher(txt);
			   	    if (matcher.find()) {
						message = " Logged In.\t ┌(˘⌣˘)ʃ";
						end_program(message);
						break;
					}else{
				        message = " Already Logged In.\t ᕕ( ᐛ )ᕗ";				    
						end_program(message);
						break;
					}
				}
			
			} catch (UnknownHostException uhe){
				message = " Probably Not connected to VOLSBB\t  (」ﾟﾛﾟ)｣NOOOooooo━";
				end_program(message);		
				break;
			} catch (Exception e) {
			   	message = " Error Occured. Trying again - "+ (i + 1) +" (」ﾟﾛﾟ)｣NOOOooo━";  	
			   	end_program(message);
			   	System.out.println("Error:  " + e);
			}
		}	
	}
	
	public static void end_program(String message){

		Calendar cal = Calendar.getInstance();
		long end = cal.getTimeInMillis();
		System.out.println("\n\nResult : " + message); 
		System.out.println("completed in " + (end - start)/1000 + "sec");

	}
}


