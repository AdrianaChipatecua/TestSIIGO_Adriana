package testSIIGO.exceptions;

public class NotFoundUserAbility extends RuntimeException {

    public NotFoundUserAbility() {
        super("The Actor doesn't have this skill");
    }
}