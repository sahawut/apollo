
package edu.pitt.apollo.service.libraryservice.v3_0_0;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import edu.pitt.apollo.library_service_types.v3_0_0.AddReviewerCommentMessage;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="addReviewerCommentToLibraryItemMessage" type="{http://library-service-types.apollo.pitt.edu/v3_0_0/}AddReviewerCommentMessage"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "addReviewerCommentToLibraryItemMessage"
})
@XmlRootElement(name = "addReviewerCommentToLibraryItem")
public class AddReviewerCommentToLibraryItem {

    @XmlElement(required = true)
    protected AddReviewerCommentMessage addReviewerCommentToLibraryItemMessage;

    /**
     * Gets the value of the addReviewerCommentToLibraryItemMessage property.
     * 
     * @return
     *     possible object is
     *     {@link AddReviewerCommentMessage }
     *     
     */
    public AddReviewerCommentMessage getAddReviewerCommentToLibraryItemMessage() {
        return addReviewerCommentToLibraryItemMessage;
    }

    /**
     * Sets the value of the addReviewerCommentToLibraryItemMessage property.
     * 
     * @param value
     *     allowed object is
     *     {@link AddReviewerCommentMessage }
     *     
     */
    public void setAddReviewerCommentToLibraryItemMessage(AddReviewerCommentMessage value) {
        this.addReviewerCommentToLibraryItemMessage = value;
    }

}
