package com.amplifyframework.datastore.generated.model;

import com.amplifyframework.core.model.annotations.HasMany;

import java.util.List;
import java.util.UUID;
import java.util.Objects;

import androidx.core.util.ObjectsCompat;

import com.amplifyframework.core.model.AuthStrategy;
import com.amplifyframework.core.model.Model;
import com.amplifyframework.core.model.ModelOperation;
import com.amplifyframework.core.model.annotations.AuthRule;
import com.amplifyframework.core.model.annotations.Index;
import com.amplifyframework.core.model.annotations.ModelConfig;
import com.amplifyframework.core.model.annotations.ModelField;
import com.amplifyframework.core.model.query.predicate.QueryField;

import static com.amplifyframework.core.model.query.predicate.QueryField.field;

/** This is an auto generated class representing the User type in your schema. */
@SuppressWarnings("all")
@ModelConfig(pluralName = "Users", authRules = {
        @AuthRule(allow = AuthStrategy.OWNER, ownerField = "owner", identityClaim = "cognito:username", operations = { ModelOperation.CREATE, ModelOperation.DELETE, ModelOperation.UPDATE })
})
public final class User implements Model {
    public static final QueryField ID = field("id");
    public static final QueryField NAME = field("name");
    private final @ModelField(targetType="ID", isRequired = true) String id;
    private final @ModelField(targetType="String") String name;
    private final @ModelField(targetType="Message") @HasMany(associatedWith = "user", type = Message.class) List<Message> message = null;
    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<Message> getMessage() {
        return message;
    }

    private User(String id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        } else if(obj == null || getClass() != obj.getClass()) {
            return false;
        } else {
            User user = (User) obj;
            return ObjectsCompat.equals(getId(), user.getId()) &&
                    ObjectsCompat.equals(getName(), user.getName());
        }
    }

    @Override
    public int hashCode() {
        return new StringBuilder()
                .append(getId())
                .append(getName())
                .toString()
                .hashCode();
    }

    @Override
    public String toString() {
        return new StringBuilder()
                .append("User {")
                .append("id=" + String.valueOf(getId()) + ", ")
                .append("name=" + String.valueOf(getName()))
                .append("}")
                .toString();
    }

    public static BuildStep builder() {
        return new Builder();
    }

    /**
     * WARNING: This method should not be used to build an instance of this object for a CREATE mutation.
     * This is a convenience method to return an instance of the object with only its ID populated
     * to be used in the context of a parameter in a delete mutation or referencing a foreign key
     * in a relationship.
     * @param id the id of the existing item this instance will represent
     * @return an instance of this model with only ID populated
     * @throws IllegalArgumentException Checks that ID is in the proper format
     */
    public static User justId(String id) {
        try {
            UUID.fromString(id); // Check that ID is in the UUID format - if not an exception is thrown
        } catch (Exception exception) {
            throw new IllegalArgumentException(
                    "Model IDs must be unique in the format of UUID. This method is for creating instances " +
                            "of an existing object with only its ID field for sending as a mutation parameter. When " +
                            "creating a new object, use the standard builder method and leave the ID field blank."
            );
        }
        return new User(
                id,
                null
        );
    }

    public CopyOfBuilder copyOfBuilder() {
        return new CopyOfBuilder(id,
                name);
    }
    public interface BuildStep {
        User build();
        BuildStep id(String id) throws IllegalArgumentException;
        BuildStep name(String name);
    }


    public static class Builder implements BuildStep {
        private String id;
        private String name;
        @Override
        public User build() {
            String id = this.id != null ? this.id : UUID.randomUUID().toString();

            return new User(
                    id,
                    name);
        }

        @Override
        public BuildStep name(String name) {
            this.name = name;
            return this;
        }

        /**
         * WARNING: Do not set ID when creating a new object. Leave this blank and one will be auto generated for you.
         * This should only be set when referring to an already existing object.
         * @param id id
         * @return Current Builder instance, for fluent method chaining
         * @throws IllegalArgumentException Checks that ID is in the proper format
         */
        public BuildStep id(String id) throws IllegalArgumentException {
            this.id = id;

            try {
                UUID.fromString(id); // Check that ID is in the UUID format - if not an exception is thrown
            } catch (Exception exception) {
                throw new IllegalArgumentException("Model IDs must be unique in the format of UUID.",
                        exception);
            }

            return this;
        }
    }


    public final class CopyOfBuilder extends Builder {
        private CopyOfBuilder(String id, String name) {
            super.id(id);
            super.name(name);
        }

        @Override
        public CopyOfBuilder name(String name) {
            return (CopyOfBuilder) super.name(name);
        }
    }

}
