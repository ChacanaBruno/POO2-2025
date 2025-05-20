package filtroWikipedia;

import java.util.Set;

public class FiltroPropiedadEnComun extends FiltroWikipedia {

    
    protected boolean esSimilar(WikipediaPage page1, WikipediaPage page2) {
        Set<String> props1 = page1.getInfobox().keySet();
        Set<String> props2 = page2.getInfobox().keySet();
        for (String prop : props1) {
            if (props2.contains(prop)) {
                return true;
            }
        }
        return false;
    }
}
