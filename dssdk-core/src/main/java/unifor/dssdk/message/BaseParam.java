package unifor.dssdk.message;

/**
 * @author Fernando Nogueira
 * @since 11/3/16 1:50 PM
 */
public class BaseParam {

    private String name;
    private String value;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    /**
     * Parses the param to String
     *
     * @return
     */
    public String string() {
        if (name != null) {
            String result = name;
            if (value != null) {
                result += ":" + value;
            }
        }
        return "";
    }


    @Override
    public String toString() {
        return "BaseParam{" +
                "name='" + name + '\'' +
                ", value='" + value + '\'' +
                '}';
    }
}
