package pl.byrka.uczelnia.model.Emuns;

public enum GradeStateEnum {
    ROBOCZA("Robocza"),
    WPISANA("Wpisana"),
    ZATWIERDZONA("Zatwierdzona"),
    ANULOWANA("Anulowana");

    private String grade;

    private GradeStateEnum(String grade)
    {
        this.grade = grade;
    }
    public String getGradeStateEnum(){
        return grade;
    }
}
