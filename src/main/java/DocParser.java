import org.jsoup.nodes.Element;
import org.jsoup.nodes.Node;
import org.jsoup.select.Elements;
import org.jsoup.select.NodeFilter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DocParser {

    private static List<String> tags = Arrays.asList("h4", "table", "p", "blockquote");

    public List<DocEntry> parseDoc(Elements doc) {
        TelegramDocFilter filter = new TelegramDocFilter();
        doc.filter(filter);
        return filter.docEntries;
    }

    private class TelegramDocFilter implements NodeFilter {
        private List<DocEntry> docEntries = new ArrayList<>();

        @Override
        public FilterResult head(final Node node, final int depth) {
            if (node instanceof Element) {
                Element elem = (Element) node;
                if (tags.contains(elem.tagName())) {
                    return FilterResult.SKIP_CHILDREN;
                } else {
                    return FilterResult.REMOVE;
                }
            } else {
                return FilterResult.REMOVE;
            }
        }

        @Override
        public FilterResult tail(final Node node, final int depth) {
            Element elem = (Element) node;
            if (isDocNode(elem)) {
                System.out.println(elem.text());
                DocEntry docEntry = new DocEntry();

                docEntry.setName(elem.text());

                elem = elem.nextElementSibling();
                docEntry.setDescription(elem.text());

                elem = elem.nextElementSibling();

                docEntry.setParameters(new TableParser().parse(elem));

                elem = elem.nextElementSibling();

                if(elem != null && elem.tagName() == "blockquote") {
                    docEntry.setBlockQuote(elem.text());
                }

                docEntries.add(docEntry);
            }
            return null;
        }

        private boolean isDocNode(final Element elem) {
            if (elem.nextElementSibling() == null || elem.nextElementSibling().nextElementSibling() == null) return false;
            return elem.tagName().equals("h4") &&
                    elem.nextElementSibling().tagName().equals("p") &&
                    elem.nextElementSibling().nextElementSibling().tagName().equals("table");
        }
    }
}
