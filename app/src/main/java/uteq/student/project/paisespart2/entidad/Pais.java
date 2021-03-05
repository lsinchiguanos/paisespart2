package uteq.student.project.paisespart2.entidad;

public class Pais {
    private String name;
    private double dlst;
    private double td;
    private int flg;
    private String name_capital;
    private double[] geoptCapital;
    private double west;
    private double east;
    private double north;
    private double south;
    private int seqid;
    private double[] geopt;
    private String telpref;
    private String tld;
    private String iso3;
    private String iso2;
    private String fips;
    private int ison;
    private String countryinfo;
    private String paisCustom;

    public Pais(String name, String iso2) {
        this.name = name;
        this.iso2 = iso2;
    }

    public Pais(String name, String name_capital, String iso2) {
        this.name = name;
        this.name_capital = name_capital;
        this.iso2 = iso2;
    }

    public Pais(String name, double dlst, double td, int flg, String name_capital, double[] geoptCapital, double west, double east, double north, double south, int seqid, double[] geopt, String telpref, String tld, String iso3, String iso2, String fips, int ison, String countryinfo) {
        this.name = name;
        this.dlst = dlst;
        this.td = td;
        this.flg = flg;
        this.name_capital = name_capital;
        this.geoptCapital = geoptCapital;
        this.west = west;
        this.east = east;
        this.north = north;
        this.south = south;
        this.seqid = seqid;
        this.geopt = geopt;
        this.telpref = telpref;
        this.tld = tld;
        this.iso3 = iso3;
        this.iso2 = iso2;
        this.fips = fips;
        this.ison = ison;
        this.countryinfo = countryinfo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getDlst() {
        return dlst;
    }

    public void setDlst(double dlst) {
        this.dlst = dlst;
    }

    public double getTd() {
        return td;
    }

    public void setTd(double td) {
        this.td = td;
    }

    public int getFlg() {
        return flg;
    }

    public void setFlg(int flg) {
        this.flg = flg;
    }

    public String getName_capital() {
        return name_capital;
    }

    public void setName_capital(String name_capital) {
        this.name_capital = name_capital;
    }

    public double[] getGeoptCapital() {
        return geoptCapital;
    }

    public void setGeoptCapital(double[] geoptCapital) {
        this.geoptCapital = geoptCapital;
    }

    public double getWest() {
        return west;
    }

    public void setWest(double west) {
        this.west = west;
    }

    public double getEast() {
        return east;
    }

    public void setEast(double east) {
        this.east = east;
    }

    public double getNorth() {
        return north;
    }

    public void setNorth(double north) {
        this.north = north;
    }

    public double getSouth() {
        return south;
    }

    public void setSouth(double south) {
        this.south = south;
    }

    public int getSeqid() {
        return seqid;
    }

    public void setSeqid(int seqid) {
        this.seqid = seqid;
    }

    public double[] getGeopt() {
        return geopt;
    }

    public void setGeopt(double[] geopt) {
        this.geopt = geopt;
    }

    public String getTelpref() {
        return telpref;
    }

    public void setTelpref(String telpref) {
        this.telpref = telpref;
    }

    public String getTld() {
        return tld;
    }

    public void setTld(String tld) {
        this.tld = tld;
    }

    public String getIso3() {
        return iso3;
    }

    public void setIso3(String iso3) {
        this.iso3 = iso3;
    }

    public String getIso2() {
        return iso2;
    }

    public void setIso2(String iso2) {
        this.iso2 = iso2;
    }

    public String getFips() {
        return fips;
    }

    public void setFips(String fips) {
        this.fips = fips;
    }

    public int getIson() {
        return ison;
    }

    public void setIson(int ison) {
        this.ison = ison;
    }

    public String getCountryinfo() {
        return countryinfo;
    }

    public void setCountryinfo(String countryinfo) {
        this.countryinfo = countryinfo;
    }

    @Override
    public String toString() {
        this.paisCustom = this.name;
        return paisCustom;
    }

}
