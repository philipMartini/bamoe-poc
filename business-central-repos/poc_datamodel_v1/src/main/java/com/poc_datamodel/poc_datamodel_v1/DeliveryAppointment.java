package com.poc_datamodel.poc_datamodel_v1;

/**
 * This class was automatically generated by the data modeler tool.
 */

@javax.persistence.Entity
public class DeliveryAppointment implements java.io.Serializable {

	static final long serialVersionUID = 1L;

	@javax.persistence.GeneratedValue(strategy = javax.persistence.GenerationType.AUTO, generator = "DELIVERYAPPOINTMENT_ID_GENERATOR")
	@javax.persistence.Id
	@javax.persistence.SequenceGenerator(name = "DELIVERYAPPOINTMENT_ID_GENERATOR", sequenceName = "DELIVERYAPPOINTMENT_ID_SEQ")
	private java.lang.Long id;

	private java.lang.String date;

	@javax.persistence.ManyToOne(cascade = {javax.persistence.CascadeType.ALL}, fetch = javax.persistence.FetchType.EAGER)
	private com.poc_datamodel.poc_datamodel_v1.AddressInfo address;

	public DeliveryAppointment() {
	}

	public java.lang.Long getId() {
		return this.id;
	}

	public void setId(java.lang.Long id) {
		this.id = id;
	}

	public java.lang.String getDate() {
		return this.date;
	}

	public void setDate(java.lang.String date) {
		this.date = date;
	}

	public com.poc_datamodel.poc_datamodel_v1.AddressInfo getAddress() {
		return this.address;
	}

	public void setAddress(
			com.poc_datamodel.poc_datamodel_v1.AddressInfo address) {
		this.address = address;
	}

	public DeliveryAppointment(java.lang.Long id, java.lang.String date,
			com.poc_datamodel.poc_datamodel_v1.AddressInfo address) {
		this.id = id;
		this.date = date;
		this.address = address;
	}

}