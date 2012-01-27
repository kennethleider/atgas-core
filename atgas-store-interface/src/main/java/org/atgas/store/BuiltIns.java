package org.atgas.store;

import org.atgas.store.StandardUtils.Multiplicity;
import org.atgas.store.StandardUtils.Requirement;
import org.atgas.store.StandardUtils.Type;

public class BuiltIns {

    public static final String BUILT_IN_SOURCE = "905a07a2-531e-4aa3-b90d-094f9f981050";
    public static final String STANDARD_STANDARD = "848b326c-c80a-4bd3-baac-d371b1857385";
    public static final String REPOSITORY_STANDARD = "2579d75f-fbd3-44e3-9474-7946b999b066";
    public static final String ORGANIZATIONAL_SOURCE_STANDARD = "40ad9ea3-6443-47d3-a065-4af6373ff021";

    public static Thing[] getBuiltInThings() {
        return new Thing[]{createStandardStandard()};
    }

    private static Thing createStandardStandard() {
        Thing retval = new Thing(STANDARD_STANDARD, STANDARD_STANDARD, BUILT_IN_SOURCE);
        retval.setProperty("name", "standard standard");
        retval.setProperty("version", "1");
        retval.setProperty("description", "The standard that describes standard things");
        String fields = StandardUtils.joinFields(
                StandardUtils.formatField("name", Type.String, Requirement.Required, Multiplicity.Single),
                StandardUtils.formatField("version", Type.Integer, Requirement.Required, Multiplicity.Single),
                StandardUtils.formatField("description", Type.String, Requirement.Optional, Multiplicity.Single),
                StandardUtils.formatField("fields", Type.String, Requirement.Optional, Multiplicity.Multiple));
        retval.setProperty("fields", fields);

        return retval;
    }
}
