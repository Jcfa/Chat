package entity;

import cn.itcast.chat.DDDDD;

/**
 * Created by User on 2017/1/13.
 */

public enum  MainTab {
    NEWS(1,"news","新闻", DDDDD.class),
    DISCOVER(2,"news","标题", DDDDD.class);
    private int id;
    private String tag;
    private String title;
    private Class clz;

   private  MainTab(int id, String tag,
                    String title, Class clz) {
        this.id = id;
        this.tag = tag;
        this.title = title;
        this.clz = clz;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Class getClz() {
        return clz;
    }

    public void setClz(Class clz) {
        this.clz = clz;
    }
}
