package entity;

import cn.itcast.chat.DDDDD;

/**
 * Created by User on 2017/1/13.
 */

public enum MainTab {
    NEWS(1, "news", "新闻", DDDDD.class),
    DISCOVER(2, "news", "标题", DDDDD.class);
    /*ADAS(3, "news", "活动", DDDDD.class),
    DERCOM(4, "news", "发现", DDDDD.class),
    REFRE(5, "news", "我的", DDDDD.class),
    FIND(6, "news", "他的", DDDDD.class);*/
    private int id;
    private String tag;
    private String title;
    private Class clz;

    private MainTab(int id, String tag,
                    String title, Class clz) {
        this.id = id;
        this.tag = tag;
        this.title = title;
        this.clz = clz;
    }

    public int getId() {
        return id;
    }

    public Class getClz() {
        return clz;
    }

    public String getTitle() {
        return title;
    }

    public String getTag() {
        return tag;
    }
}
