package org.kxw.bms.model;

/**
 * 用户组对象，存储用户和组的关联
 *
 * @author Administrator
 */
public class UserGroup {

    private int id;
    private User user;
    private Group group;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

}
