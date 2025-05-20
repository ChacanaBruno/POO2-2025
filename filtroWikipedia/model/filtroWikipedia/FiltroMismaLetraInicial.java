package filtroWikipedia;

public class FiltroMismaLetraInicial extends FiltroWikipedia {

    
    protected boolean esSimilar(WikipediaPage page1, WikipediaPage page2) {
        return page1.getTitle().charAt(0) == page2.getTitle().charAt(0);
    }
}
