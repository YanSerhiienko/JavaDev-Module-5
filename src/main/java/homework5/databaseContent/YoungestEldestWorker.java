package homework5.databaseContent;

import java.sql.Date;

public class YoungestEldestWorker {
    private String type;
    private String name;
    private Date birthday;

    public YoungestEldestWorker(String type, String name, Date birthday) {
        this.type = type;
        this.name = name;
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return "YoungestEldestWorker{" +
                "type='" + type + '\'' +
                ", name='" + name + '\'' +
                ", birthday=" + birthday +
                '}';
    }
}
