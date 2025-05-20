package filtroWikipedia;

import java.util.ArrayList;
import java.util.List;

public abstract class FiltroWikipedia {

    public List<WikipediaPage> getSimilarPages(WikipediaPage page, List<WikipediaPage> wikipedia) {
        List<WikipediaPage> similares = new ArrayList<>();
        for (WikipediaPage otraPagina : wikipedia) {
            if (!otraPagina.equals(page) && esSimilar(page, otraPagina)) {
                similares.add(otraPagina);
            }
        }
        return similares;
    }

    protected abstract boolean esSimilar(WikipediaPage page1, WikipediaPage page2);
}
