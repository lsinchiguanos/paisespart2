package uteq.student.project.paisespart2.entidad;

public class Pais2 {

    private String name;
    private String name_capital;

    private String iso2;

    public Pais2(String name, String name_capital, String iso2) {
        this.name = name;
        this.name_capital = name_capital;
        this.iso2 = iso2;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName_capital() {
        return name_capital;
    }

    public void setName_capital(String name_capital) {
        this.name_capital = name_capital;
    }

    public String getIso2() {
        return iso2;
    }

    public void setIso2(String iso2) {
        this.iso2 = iso2;
    }
}
