package pages;

public class MainPage extends BasePage{

    public Header getHeader(){
        return new Header();
    }

    public void accessPage(){
        super.accessPage("https://www.amazon.com.br/");
    }

}
