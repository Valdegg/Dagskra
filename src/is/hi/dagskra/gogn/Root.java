//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.5-2 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2017.03.15 at 10:18:06 AM GMT 
//


package is.hi.dagskra.gogn;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


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
 *         &lt;element name="results" maxOccurs="unbounded" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="title" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="originalTitle" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="duration" type="{http://www.w3.org/2001/XMLSchema}time"/>
 *                   &lt;element name="description" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="shortDescription" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="live" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="premier" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="startTime" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="aspectRatio" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="series">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="episode" type="{http://www.w3.org/2001/XMLSchema}byte"/>
 *                             &lt;element name="series" type="{http://www.w3.org/2001/XMLSchema}short"/>
 *                           &lt;/sequence>
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                 &lt;/sequence>
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
    "results"
})
@XmlRootElement(name = "root")
public class Root {

    protected List<Root.Results> results;

    /**
     * Gets the value of the results property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the results property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getResults().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Root.Results }
     * 
     * 
     */
    public List<Root.Results> getResults() {
        if (results == null) {
            results = new ArrayList<Root.Results>();
        }
        return this.results;
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
     *         &lt;element name="title" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="originalTitle" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="duration" type="{http://www.w3.org/2001/XMLSchema}time"/>
     *         &lt;element name="description" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="shortDescription" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="live" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="premier" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="startTime" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="aspectRatio" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="series">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;element name="episode" type="{http://www.w3.org/2001/XMLSchema}byte"/>
     *                   &lt;element name="series" type="{http://www.w3.org/2001/XMLSchema}short"/>
     *                 &lt;/sequence>
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
        "title",
        "originalTitle",
        "duration",
        "description",
        "shortDescription",
        "live",
        "premier",
        "startTime",
        "aspectRatio",
        "series"
    })
    public static class Results {

        @XmlElement(required = true)
        protected String title;
        @XmlElement(required = true)
        protected String originalTitle;
        @XmlElement(required = true)
        @XmlSchemaType(name = "time")
        protected XMLGregorianCalendar duration;
        @XmlElement(required = true)
        protected String description;
        @XmlElement(required = true)
        protected String shortDescription;
        @XmlElement(required = true)
        protected String live;
        @XmlElement(required = true)
        protected String premier;
        @XmlElement(required = true)
        protected String startTime;
        @XmlElement(required = true)
        protected String aspectRatio;
        @XmlElement(required = true)
        protected Root.Results.Series series;

        /**
         * Gets the value of the title property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getTitle() {
            return title;
        }

        /**
         * Sets the value of the title property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setTitle(String value) {
            this.title = value;
        }

        /**
         * Gets the value of the originalTitle property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getOriginalTitle() {
            return originalTitle;
        }

        /**
         * Sets the value of the originalTitle property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setOriginalTitle(String value) {
            this.originalTitle = value;
        }

        /**
         * Gets the value of the duration property.
         * 
         * @return
         *     possible object is
         *     {@link XMLGregorianCalendar }
         *     
         */
        public XMLGregorianCalendar getDuration() {
            return duration;
        }

        /**
         * Sets the value of the duration property.
         * 
         * @param value
         *     allowed object is
         *     {@link XMLGregorianCalendar }
         *     
         */
        public void setDuration(XMLGregorianCalendar value) {
            this.duration = value;
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
         * Gets the value of the shortDescription property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getShortDescription() {
            return shortDescription;
        }

        /**
         * Sets the value of the shortDescription property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setShortDescription(String value) {
            this.shortDescription = value;
        }

        /**
         * Gets the value of the live property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getLive() {
            return live;
        }

        /**
         * Sets the value of the live property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setLive(String value) {
            this.live = value;
        }

        /**
         * Gets the value of the premier property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getPremier() {
            return premier;
        }

        /**
         * Sets the value of the premier property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setPremier(String value) {
            this.premier = value;
        }

        /**
         * Gets the value of the startTime property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getStartTime() {
            return startTime;
        }

        /**
         * Sets the value of the startTime property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setStartTime(String value) {
            this.startTime = value;
        }

        /**
         * Gets the value of the aspectRatio property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getAspectRatio() {
            return aspectRatio;
        }

        /**
         * Sets the value of the aspectRatio property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setAspectRatio(String value) {
            this.aspectRatio = value;
        }

        /**
         * Gets the value of the series property.
         * 
         * @return
         *     possible object is
         *     {@link Root.Results.Series }
         *     
         */
        public Root.Results.Series getSeries() {
            return series;
        }

        /**
         * Sets the value of the series property.
         * 
         * @param value
         *     allowed object is
         *     {@link Root.Results.Series }
         *     
         */
        public void setSeries(Root.Results.Series value) {
            this.series = value;
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
         *         &lt;element name="episode" type="{http://www.w3.org/2001/XMLSchema}byte"/>
         *         &lt;element name="series" type="{http://www.w3.org/2001/XMLSchema}short"/>
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
            "episode",
            "series"
        })
        public static class Series {

            protected byte episode;
            protected short series;

            /**
             * Gets the value of the episode property.
             * 
             */
            public byte getEpisode() {
                return episode;
            }

            /**
             * Sets the value of the episode property.
             * 
             */
            public void setEpisode(byte value) {
                this.episode = value;
            }

            /**
             * Gets the value of the series property.
             * 
             */
            public short getSeries() {
                return series;
            }

            /**
             * Sets the value of the series property.
             * 
             */
            public void setSeries(short value) {
                this.series = value;
            }

        }

    }

}
