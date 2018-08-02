package pl.coderslab.model;

public class Raport1 {
    private String firstName;
    private String secondName;
    private Integer iloscRoboczogodzin;

    public Raport1(String firstName, String secondName, Integer iloscRoboczogodzin) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.iloscRoboczogodzin = iloscRoboczogodzin;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public Integer getIloscRoboczogodzin() {
        return iloscRoboczogodzin;
    }

    public void setIloscRoboczogodzin(Integer iloscRoboczogodzin) {
        this.iloscRoboczogodzin = iloscRoboczogodzin;
    }

    @Override
    public String toString() {
        return "Raport1{"
                + "firstName=" + firstName
                + ", secondName=" + secondName
                + ", iloscRoboczogodzin=" + iloscRoboczogodzin +
                "}";
    }
}
