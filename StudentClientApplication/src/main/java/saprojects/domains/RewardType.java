package saprojects.domains;

public enum RewardType {
    ELEMENT("ELEMENT"), INSCHOOL("INSCHOOL"), GIFT("GIFT");
    private String message;
    RewardType(String message){
        this.message = message;
    }
}
