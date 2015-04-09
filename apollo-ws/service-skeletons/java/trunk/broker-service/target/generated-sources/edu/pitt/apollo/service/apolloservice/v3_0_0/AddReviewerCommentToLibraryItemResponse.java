
package edu.pitt.apollo.service.apolloservice.v3_0_0;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import edu.pitt.apollo.library_service_types.v3_0_0.AddReviewerCommentResult;


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
 *         &lt;element name="addReviewerCommentToLibraryItemResult" type="{http://library-service-types.apollo.pitt.edu/v3_0_0/}AddReviewerCommentResult"/>
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
    "addReviewerCommentToLibraryItemResult"
})
@XmlRootElement(name = "addReviewerCommentToLibraryItemResponse")
public class AddReviewerCommentToLibraryItemResponse {

    @XmlElement(required = true)
    protected AddReviewerCommentResult addReviewerCommentToLibraryItemResult;

    /**
     * Gets the value of the addReviewerCommentToLibraryItemResult property.
     * 
     * @return
     *     possible object is
     *     {@link AddReviewerCommentResult }
     *     
     */
    public AddReviewerCommentResult getAddReviewerCommentToLibraryItemResult() {
        return addReviewerCommentToLibraryItemResult;
    }

    /**
     * Sets the value of the addReviewerCommentToLibraryItemResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link AddReviewerCommentResult }
     *     
     */
    public void setAddReviewerCommentToLibraryItemResult(AddReviewerCommentResult value) {
        this.addReviewerCommentToLibraryItemResult = value;
    }

}
