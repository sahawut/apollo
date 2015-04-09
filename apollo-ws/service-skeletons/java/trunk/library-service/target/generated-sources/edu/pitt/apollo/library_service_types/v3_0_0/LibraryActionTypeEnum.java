
package edu.pitt.apollo.library_service_types.v3_0_0;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for LibraryActionTypeEnum.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="LibraryActionTypeEnum">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="addedItem"/>
 *     &lt;enumeration value="updatedItem"/>
 *     &lt;enumeration value="addedReviewerComment"/>
 *     &lt;enumeration value="setAsReleaseVersion"/>
 *     &lt;enumeration value="removedAsReleaseVersion"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "LibraryActionTypeEnum")
@XmlEnum
public enum LibraryActionTypeEnum {

    @XmlEnumValue("addedItem")
    ADDED_ITEM("addedItem"),
    @XmlEnumValue("updatedItem")
    UPDATED_ITEM("updatedItem"),
    @XmlEnumValue("addedReviewerComment")
    ADDED_REVIEWER_COMMENT("addedReviewerComment"),
    @XmlEnumValue("setAsReleaseVersion")
    SET_AS_RELEASE_VERSION("setAsReleaseVersion"),
    @XmlEnumValue("removedAsReleaseVersion")
    REMOVED_AS_RELEASE_VERSION("removedAsReleaseVersion");
    private final String value;

    LibraryActionTypeEnum(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static LibraryActionTypeEnum fromValue(String v) {
        for (LibraryActionTypeEnum c: LibraryActionTypeEnum.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
