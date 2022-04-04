package pl.byrka.uczelnia.model.Emuns;

public enum GradeStateEnum {
    Robocza("Robocza"),
    Wpisana("Wpisana"),
    Zatwierdzona("Zatwierdzona"),
    Anulowana("Anulowana");

    private String grade;

    private GradeStateEnum(String grade)
    {
        this.grade = grade;
    }
    public String getGradeStateEnum(){
        return grade;
    }
}
