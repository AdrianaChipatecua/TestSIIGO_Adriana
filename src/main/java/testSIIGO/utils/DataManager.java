package testSIIGO.utils;

import testSIIGO.constants.Constants;
import testSIIGO.models.UserRegistrationData;

import java.util.Arrays;
import java.util.Optional;

import net.serenitybdd.screenplay.actors.OnStage;

public class DataManager {

    enum Users {
        API("Eve", "usuario para registro sin password en el api") {
            @Override
            public UserRegistrationData registrationData() {
                return new UserRegistrationData("Eve", "eve.holt@reqres.in", "", Optional.of("4"));
            }
        },
        DELETE("Emma", "usuario para eliminarse en el api") {
            @Override
            public UserRegistrationData registrationData() {
                return new UserRegistrationData("Emma", "emma.wong@reqres.in", "", Optional.of("15"));
            }
        },
        STG("Laura", "usuario STG con login valido") {
            @Override
            public UserRegistrationData registrationData() {
                return new UserRegistrationData("Laura", "retoautomationsiigo@yopmail.com", "T4b4ck0ff1c3P455w0rd658*", Optional.empty());
            }
        };


        public final String actorName;
        public final String description;

        private Users(String actorName, String description) {
            this.actorName = actorName;
            this.description = description;
        }

        public String getActorName() {
            return actorName;
        }

        public String getDescription() {
            return description;
        }

        public abstract UserRegistrationData registrationData();

        public static Users fromUserName(String actorName) {
            return Arrays.stream(values())
                    .filter(users -> users.actorName.equals(actorName))
                    .findFirst()
                    .orElse(STG);
        }
    }

    public static void initActorWithName(String actorName) {
        Users user = Users.fromUserName(actorName);
        OnStage.theActorCalled(actorName)
                .describedAs(user.description)
                .remember(Constants.REGISTER_DATA_KEY, user.registrationData());

    }
}
