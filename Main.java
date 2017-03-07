import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlButton;
import com.gargoylesoftware.htmlunit.html.HtmlForm;
import com.gargoylesoftware.htmlunit.html.HtmlPage;

public class Main {

	public static void main(String[] args){  
		// turn off htmlunit warnings
    	java.util.logging.Logger.getLogger("com.gargoylesoftware.htmlunit").setLevel(java.util.logging.Level.OFF);
    	java.util.logging.Logger.getLogger("org.apache.http").setLevel(java.util.logging.Level.OFF);
        
    	
    	HtmlPage page = login();
        System.out.println(page.asText());
	} 
	
	public static HtmlPage login(){
		WebClient webClient = new WebClient(BrowserVersion.CHROME);

        HtmlPage page = (HtmlPage) webClient.getPage("https://www.appannie.com/account/login/?_ref=header"); 
        HtmlForm form = page.getFirstByXPath("//*[@id='login-form']");
        form.getInputByName("username").setValueAttribute("younesi@ce.sharif.edu");
        form.getInputByName("password").setValueAttribute("Une30316");
        
        HtmlButton button = form.getFirstByXPath("//*[@id='submit']");
        page = button.click();
        return page;
	}

}