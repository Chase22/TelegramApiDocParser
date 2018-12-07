import java.util.Arrays;
import java.util.List;

public class DocEntry {
    private String name;
    private String description;
    private String blockQuote;
    private List<Parameter> parameters;

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(final String description) {
        this.description = description;
    }

    public String getBlockQuote() {
        return blockQuote;
    }

    public void setBlockQuote(final String blockQuote) {
        this.blockQuote = blockQuote;
    }

    public List<Parameter> getParameters() {
        return parameters;
    }

    public void setParameters(final List<Parameter> parameters) {
        this.parameters = parameters;
    }

    public void addParameter(Parameter... parameter) {
        parameters.addAll(Arrays.asList(parameter));
    }
}
