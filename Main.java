import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlButton;
import com.gargoylesoftware.htmlunit.html.HtmlForm;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import java.util.logging.Logger;

public static final string login_url = "https://www.appannie.com/account/login/?_ref=header";
public static final string base_url = "https://www.appannie.com/apps/google-play/app/"

public class Main {
	
	
	WebClient webClient = new WebClient(BrowserVersion.CHROME);
	
	public static void main(String[] args){ 
		
        
		// Turn off htmlunit warnings
    	getLogger("com.gargoylesoftware.htmlunit").setLevel(java.util.logging.Level.OFF);
    	getLogger("org.apache.http").setLevel(java.util.logging.Level.OFF);      
    	
    	// Setting webClient options
    	webClient.getOptions().setJavaScriptEnabled(true);
    	webClient.waitForBackgroundJavaScript(3000);
    	
    	HtmlPage page = login();
        
		get_app_details("org.telegram.messenger");
	} 
	
	
	public static HtmlPage login(){
		   
        HtmlPage login_page = (HtmlPage) webClient.getPage(login_url); 
        HtmlForm form = login_page.getFirstByXPath("//*[@id='login-form']");
        form.getInputByName("username").setValueAttribute("younesi@ce.sharif.edu");
        form.getInputByName("password").setValueAttribute("Une30316");
        
        HtmlButton button = form.getFirstByXPath("//*[@id='submit']");
        HtmlPage result_page = button.click();
        return result_page;
	}
	
	
	public static void get_app_details(string package_name){
		
		string detail_url = base_url + package_name + "/details/";
		HtmlPage detail_Page = webClient.getPage(detail_url);
        HtmlDivision div = (HtmlDivision) detail_Page.getFirstByXPath("//div[@class='desc']");
        System.out.println("Description");
        System.out.println(div.asText());
	}

}