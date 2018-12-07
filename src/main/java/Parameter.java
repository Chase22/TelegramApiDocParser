import java.util.StringJoiner;

public class Parameter {
    private String name;
    private String type;
    private String description;

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(final String type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(final String description) {
        this.description = description;
    }

    public String toJavadoc() {
        StringJoiner joiner = new StringJoiner("\n*", "/**\n*", "\n**/");
        joiner.add(description);
        return joiner.toString();
    }
}
