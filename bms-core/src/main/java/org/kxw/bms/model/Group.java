package org.kxw.bms.model;

/**
 * 用户组对象，使用该对象来获取可以发布文章的栏目信息
 *
 * @author Administrator
 */
public class Group {
    /**
     * 组id
     */
    private int id;
    /**
     * 组名称
     */
    private String name;
    /**
     * 组描述信息
     */
    private String description;

    public Group() {
    }


    public Group(int id, String name) {
        super();
        this.id = id;
        this.name = name;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
