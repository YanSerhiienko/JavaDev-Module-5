package homework5.databaseContent;

public class MaxProjectCountClient {
    private String name;
    private int cnt;

    public MaxProjectCountClient(String name, int cnt) {
        this.name = name;
        this.cnt = cnt;
    }

    @Override
    public String toString() {
        return "maxProjectsCountClient{" +
                "name='" + name + '\'' +
                ", cnt=" + cnt +
                '}';
    }
}
