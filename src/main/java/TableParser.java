import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.List;

import static java.util.stream.Collectors.toList;

public class TableParser {

    public List<Parameter> parse(final Element elem) {

        Elements rows = elem.getElementsByTag("tbody").first().getElementsByTag("tr");

        return rows.stream().map(row -> {
            Elements cols = row.getElementsByTag("td");
            Parameter param = new Parameter();

            param.setName(cols.get(0).text());
            param.setType(cols.get(1).text());
            param.setDescription(cols.last().text());

            return param;
        }).collect(toList());
    }
}
