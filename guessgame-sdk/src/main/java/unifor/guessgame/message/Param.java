package unifor.guessgame.message;

/**
 * @author Fernando Nogueira
 * @since 11/3/16 1:50 PM
 */
public class Param {

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
        String result = "";
        if (name != null) {
            result = name;
            if (value != null) {
                result += ":" + value;
            }
        }
        return result;
    }

    @Override
    public String toString() {
        return "BaseParam{" +
                "name='" + name + '\'' +
                ", value='" + value + '\'' +
                '}';
    }

    public static Param parseParam(String param) {
        if (param != null) {
            String[] split = param.split(":");
            Param p = new Param();
            if (split.length == 2) {
                p.setName(split[0]);
                p.setValue(split[1]);
            }
            return p;
        }
        return null;
    }
}
