package zk.ent;

import java.util.ArrayList;
import java.util.List;

public class Company {

    private int id;
    private String name;
    private CompanyType type;
    private Address address;
    private List<Filial> filials;

    public Company() {
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

    public CompanyType getType() {
        return type;
    }

    public void setType(CompanyType type) {
        this.type = type;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public List<Filial> getFilials() {
        if (filials == null) {
            filials = new ArrayList<>();
        }
        return filials;
    }

    public void setFilials(List<Filial> filials) {
        this.filials = filials;
    }
}
/*
* . "Компания", поля:
- "Название компании*"
- "Правовая форма" (ООО, ИП, АО)
- "Адрес компании*", выбирается из таблицы п.1.2.
- "Филиалы компании", список, выбарается из таблицы п.1.3.

* "Название компании", "Адрес компании" - обязательные поля
* */