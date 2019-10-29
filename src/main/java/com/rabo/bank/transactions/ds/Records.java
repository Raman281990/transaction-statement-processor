//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2019.10.27 at 07:39:55 PM CET 
//


package com.rabo.bank.transactions.ds;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import com.opencsv.bean.CsvBindByName;


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
 *         &lt;element name="record" maxOccurs="unbounded">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="accountNumber" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="description" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="startBalance" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *                   &lt;element name="mutation" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *                   &lt;element name="endBalance" type="{http://www.w3.org/2001/XMLSchema}float"/>
 *                 &lt;/sequence>
 *                 &lt;attribute name="reference" use="required" type="{http://www.w3.org/2001/XMLSchema}unsignedInt" />
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
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
    "record"
})
@XmlRootElement(name = "records")
public class Records {

    @XmlElement(required = true)
    protected List<Records.Record> record;

    /**
     * Gets the value of the record property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the record property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getRecord().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Records.Record }
     * 
     * 
     */
    public List<Records.Record> getRecord() {
        if (record == null) {
            record = new ArrayList<Records.Record>();
        }
        return this.record;
    }


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
     *         &lt;element name="accountNumber" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="description" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="startBalance" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
     *         &lt;element name="mutation" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
     *         &lt;element name="endBalance" type="{http://www.w3.org/2001/XMLSchema}float"/>
     *       &lt;/sequence>
     *       &lt;attribute name="reference" use="required" type="{http://www.w3.org/2001/XMLSchema}unsignedInt" />
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "accountNumber",
        "description",
        "startBalance",
        "mutation",
        "endBalance"
    })
    public static class Record {

        @XmlElement(required = true)
        @CsvBindByName
        protected String accountNumber;
        @XmlElement(required = true)
        @CsvBindByName
        protected String description;
        @XmlElement(required = true)
        @CsvBindByName
        protected BigDecimal startBalance;
        @XmlElement(required = true)
        @CsvBindByName
        protected BigDecimal mutation;
        @CsvBindByName
        protected BigDecimal endBalance;
        @XmlAttribute(name = "reference", required = true)
        @XmlSchemaType(name = "unsignedInt")
        @CsvBindByName
        protected long reference;

        /**
         * Gets the value of the accountNumber property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getAccountNumber() {
            return accountNumber;
        }

        /**
         * Sets the value of the accountNumber property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setAccountNumber(String value) {
            this.accountNumber = value;
        }

        /**
         * Gets the value of the description property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getDescription() {
            return description;
        }

        /**
         * Sets the value of the description property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setDescription(String value) {
            this.description = value;
        }

        /**
         * Gets the value of the startBalance property.
         * 
         * @return
         *     possible object is
         *     {@link BigDecimal }
         *     
         */
        public BigDecimal getStartBalance() {
            return startBalance;
        }

        /**
         * Sets the value of the startBalance property.
         * 
         * @param value
         *     allowed object is
         *     {@link BigDecimal }
         *     
         */
        public void setStartBalance(BigDecimal value) {
            this.startBalance = value;
        }

        /**
         * Gets the value of the mutation property.
         * 
         * @return
         *     possible object is
         *     {@link BigDecimal }
         *     
         */
        public BigDecimal getMutation() {
            return mutation;
        }

        /**
         * Sets the value of the mutation property.
         * 
         * @param value
         *     allowed object is
         *     {@link BigDecimal }
         *     
         */
        public void setMutation(BigDecimal value) {
            this.mutation = value;
        }

        /**
         * Gets the value of the endBalance property.
         * 
         */
        public BigDecimal getEndBalance() {
            return endBalance;
        }

        /**
         * Sets the value of the endBalance property.
         * 
         */
        public void setEndBalance(BigDecimal value) {
            this.endBalance = value;
        }

        /**
         * Gets the value of the reference property.
         * 
         */
        public long getReference() {
            return reference;
        }

        /**
         * Sets the value of the reference property.
         * 
         */
        public void setReference(long value) {
            this.reference = value;
        }

    }

}
