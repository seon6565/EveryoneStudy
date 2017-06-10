package comwow2778.naver.blog.everyonestudy;

/**
 * Created by seon on 2017-06-10.
 */

public class clear {
    private String name = "";
    private String clear = "0";
    public clear(String name, String clear){
        this.name = name;
        this.clear = clear;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getClear() {
        return clear;
    }

    public void setClear(String clear) {
        this.clear = clear;
    }
}
