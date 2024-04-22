package zk.ent;

public enum CompanyType {
    OOO("ООО"),
    IP("ИП"),
    AO("АО");

    private String id;

    CompanyType(String value) {
        this.id = value;
    }

    public String getId() {
        return id;
    }

    public static CompanyType fromId(String id) {
        for (CompanyType at : CompanyType.values()) {
            if (at.getId().equals(id)) {
                return at;
            }
        }
        return null;
    }
}