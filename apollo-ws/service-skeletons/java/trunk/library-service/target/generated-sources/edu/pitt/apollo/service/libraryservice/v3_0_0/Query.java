
package edu.pitt.apollo.service.libraryservice.v3_0_0;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import edu.pitt.apollo.library_service_types.v3_0_0.QueryMessage;


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
 *         &lt;element name="queryMessage" type="{http://library-service-types.apollo.pitt.edu/v3_0_0/}QueryMessage"/>
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
    "queryMessage"
})
@XmlRootElement(name = "query")
public class Query {

    @XmlElement(required = true)
    protected QueryMessage queryMessage;

    /**
     * Gets the value of the queryMessage property.
     * 
     * @return
     *     possible object is
     *     {@link QueryMessage }
     *     
     */
    public QueryMessage getQueryMessage() {
        return queryMessage;
    }

    /**
     * Sets the value of the queryMessage property.
     * 
     * @param value
     *     allowed object is
     *     {@link QueryMessage }
     *     
     */
    public void setQueryMessage(QueryMessage value) {
        this.queryMessage = value;
    }

}
