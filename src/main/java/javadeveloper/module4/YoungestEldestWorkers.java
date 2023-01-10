package javadeveloper.module4;

public class YoungestEldestWorkers {
    private String type;
    private String name;
    private String birthday;

    public YoungestEldestWorkers(String type, String name, String birthday) {
        this.type = type;
        this.name = name;
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return "YoungestEldestWorkers{" +
                "type='" + type + '\'' +
                ", name='" + name + '\'' +
                ", birthday='" + birthday + '\'' +
                '}';
    }
}
