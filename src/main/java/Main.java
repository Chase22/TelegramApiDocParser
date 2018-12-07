import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static List<DocEntry> docEntries = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        Document doc = Jsoup.connect("https://core.telegram.org/bots/api").get();

       List<DocEntry> entries = new DocParser().parseDoc(doc.body().getAllElements());
    }
}
