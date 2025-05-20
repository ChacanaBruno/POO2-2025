package filtroWikipedia;

import java.util.HashSet;
import java.util.Set;

public class FiltroLinkEnComun extends FiltroWikipedia {

    protected boolean esSimilar(WikipediaPage page1, WikipediaPage page2) {
        Set<WikipediaPage> links1 = new HashSet<>(page1.getLinks());
        Set<WikipediaPage> links2 = new HashSet<>(page2.getLinks());
        links1.retainAll(links2); // intersección
        return !links1.isEmpty();
    }
}
