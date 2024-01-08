package com.demo.qrcode.simple.project.dto;

public class Customer {
	
	private String regnNumber;
	private String regdOwner;
	private String sDWf;
	private String purpose;
	
	private String regnDate;
	private String manufacturingDt;
	private String taxPAidUpTo;
	private String regdValidity;
	
	private String colour;
	private String fuel;
	private String vehicleClass;
	private String bodyType;
	
	private String manufacturar;
	private String chassisNo;
	private String engineNo;
	private String modelNo;
	
	private String hypothecatedTo;
	private int unladenWt;
	private double cubicCapacity;
	private int seatCapacity;
	private int standCapacity;
	
	private int noofcyc;
	private int ownerserial;
	private int wheelBase;
	private int rLW;
	
	private String address;
	private String issuing;
	
	private byte[] signature;
	
	
	public byte[] getSignature() {
		return signature;
	}
	public void setSignature(byte[] signature) {
		this.signature = signature;
	}
	public String getRegnNumber() {
		return regnNumber;
	}
	public void setRegnNumber(String regnNumber) {
		this.regnNumber = regnNumber;
	}
	public String getRegdOwner() {
		return regdOwner;
	}
	public void setRegdOwner(String regdOwner) {
		this.regdOwner = regdOwner;
	}
	public String getsDWf() {
		return sDWf;
	}
	public void setsDWf(String sDWf) {
		this.sDWf = sDWf;
	}
	public String getPurpose() {
		return purpose;
	}
	public void setPurpose(String purpose) {
		this.purpose = purpose;
	}
	public String getRegnDate() {
		return regnDate;
	}
	public void setRegnDate(String regnDate) {
		this.regnDate = regnDate;
	}
	public String getManufacturingDt() {
		return manufacturingDt;
	}
	public void setManufacturingDt(String manufacturingDt) {
		this.manufacturingDt = manufacturingDt;
	}
	public String getTaxPAidUpTo() {
		return taxPAidUpTo;
	}
	public void setTaxPAidUpTo(String taxPAidUpTo) {
		this.taxPAidUpTo = taxPAidUpTo;
	}
	public String getRegdValidity() {
		return regdValidity;
	}
	public void setRegdValidity(String regdValidity) {
		this.regdValidity = regdValidity;
	}
	public String getColour() {
		return colour;
	}
	public void setColour(String colour) {
		this.colour = colour;
	}
	public String getFuel() {
		return fuel;
	}
	public void setFuel(String fuel) {
		this.fuel = fuel;
	}
	public String getVehicleClass() {
		return vehicleClass;
	}
	public void setVehicleClass(String vehicleClass) {
		this.vehicleClass = vehicleClass;
	}
	public String getBodyType() {
		return bodyType;
	}
	public void setBodyType(String bodyType) {
		this.bodyType = bodyType;
	}
	public String getManufacturar() {
		return manufacturar;
	}
	public void setManufacturar(String manufacturar) {
		this.manufacturar = manufacturar;
	}
	public String getChassisNo() {
		return chassisNo;
	}
	public void setChassisNo(String chassisNo) {
		this.chassisNo = chassisNo;
	}
	public String getEngineNo() {
		return engineNo;
	}
	public void setEngineNo(String engineNo) {
		this.engineNo = engineNo;
	}
	public String getModelNo() {
		return modelNo;
	}
	public void setModelNo(String modelNo) {
		this.modelNo = modelNo;
	}
	public int getUnladenWt() {
		return unladenWt;
	}
	public void setUnladenWt(int unladenWt) {
		this.unladenWt = unladenWt;
	}
	public double getCubicCapacity() {
		return cubicCapacity;
	}
	public void setCubicCapacity(double e1) {
		this.cubicCapacity = e1;
	}
	public int getSeatCapacity() {
		return seatCapacity;
	}
	public void setSeatCapacity(int seatCapacity) {
		this.seatCapacity = seatCapacity;
	}
	public int getStandCapacity() {
		return standCapacity;
	}
	public void setStandCapacity(int standCapacity) {
		this.standCapacity = standCapacity;
	}
	public int getNoofcyc() {
		return noofcyc;
	}
	public void setNoofcyc(int noofcyc) {
		this.noofcyc = noofcyc;
	}
	public int getOwnerserial() {
		return ownerserial;
	}
	public void setOwnerserial(int ownerserial) {
		this.ownerserial = ownerserial;
	}
	public int getWheelBase() {
		return wheelBase;
	}
	public void setWheelBase(int wheelBase) {
		this.wheelBase = wheelBase;
	}
	public int getrLW() {
		return rLW;
	}
	public void setrLW(int rLW) {
		this.rLW = rLW;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getIssuing() {
		return issuing;
	}
	public void setIssuing(String issuing) {
		this.issuing = issuing;
	}
	
	public String getHypothecatedTo() {
		return hypothecatedTo;
	}
	public void setHypothecatedTo(String hypothecatedTo) {
		this.hypothecatedTo = hypothecatedTo;
	}
	public Customer(String regnNumber, String regdOwner, String sDWf, String purpose, String regnDate,
			String manufacturingDt, String taxPAidUpTo, String regdValidity, String colour, String fuel,
			String vehicleClass, String bodyType, String manufacturar, String chassisNo, String engineNo,
			String modelNo, String hypothecatedTo, int unladenWt, double cubicCapacity, int seatCapacity,
			int standCapacity, int noofcyc, int ownerserial, int wheelBase, int rLW, String address, String issuing) {
		super();
		this.regnNumber = regnNumber;
		this.regdOwner = regdOwner;
		this.sDWf = sDWf;
		this.purpose = purpose;
		this.regnDate = regnDate;
		this.manufacturingDt = manufacturingDt;
		this.taxPAidUpTo = taxPAidUpTo;
		this.regdValidity = regdValidity;
		this.colour = colour;
		this.fuel = fuel;
		this.vehicleClass = vehicleClass;
		this.bodyType = bodyType;
		this.manufacturar = manufacturar;
		this.chassisNo = chassisNo;
		this.engineNo = engineNo;
		this.modelNo = modelNo;
		this.hypothecatedTo = hypothecatedTo;
		this.unladenWt = unladenWt;
		this.cubicCapacity = cubicCapacity;
		this.seatCapacity = seatCapacity;
		this.standCapacity = standCapacity;
		this.noofcyc = noofcyc;
		this.ownerserial = ownerserial;
		this.wheelBase = wheelBase;
		this.rLW = rLW;
		this.address = address;
		this.issuing = issuing;
	}
	
	
	
	public Customer(String regnNumber, String regdOwner, String sDWf, String purpose, String regnDate,
			String manufacturingDt, String taxPAidUpTo, String regdValidity, String colour, String fuel,
			String vehicleClass, String bodyType, String manufacturar, String chassisNo, String engineNo,
			String modelNo, String hypothecatedTo, int unladenWt, double cubicCapacity, int seatCapacity,
			int standCapacity, int noofcyc, int ownerserial, int wheelBase, int rLW, String address, String issuing,
			byte[] signature) {
		super();
		this.regnNumber = regnNumber;
		this.regdOwner = regdOwner;
		this.sDWf = sDWf;
		this.purpose = purpose;
		this.regnDate = regnDate;
		this.manufacturingDt = manufacturingDt;
		this.taxPAidUpTo = taxPAidUpTo;
		this.regdValidity = regdValidity;
		this.colour = colour;
		this.fuel = fuel;
		this.vehicleClass = vehicleClass;
		this.bodyType = bodyType;
		this.manufacturar = manufacturar;
		this.chassisNo = chassisNo;
		this.engineNo = engineNo;
		this.modelNo = modelNo;
		this.hypothecatedTo = hypothecatedTo;
		this.unladenWt = unladenWt;
		this.cubicCapacity = cubicCapacity;
		this.seatCapacity = seatCapacity;
		this.standCapacity = standCapacity;
		this.noofcyc = noofcyc;
		this.ownerserial = ownerserial;
		this.wheelBase = wheelBase;
		this.rLW = rLW;
		this.address = address;
		this.issuing = issuing;
		this.signature = signature;
	}
	public Customer() {
		super();
	}
	
	@Override
	public String toString() {
		return "Customer [regnNumber=" + regnNumber + ", regdOwner=" + regdOwner + ", sDWf=" + sDWf + ", purpose="
				+ purpose + ", regnDate=" + regnDate + ", manufacturingDt=" + manufacturingDt + ", taxPAidUpTo="
				+ taxPAidUpTo + ", regdValidity=" + regdValidity + ", colour=" + colour + ", fuel=" + fuel
				+ ", vehicleClass=" + vehicleClass + ", bodyType=" + bodyType + ", manufacturar=" + manufacturar
				+ ", chassisNo=" + chassisNo + ", engineNo=" + engineNo + ", modelNo=" + modelNo + ", hypothecatedTo="
				+ hypothecatedTo + ", unladenWt=" + unladenWt + ", cubicCapacity=" + cubicCapacity + ", seatCapacity="
				+ seatCapacity + ", standCapacity=" + standCapacity + ", noofcyc=" + noofcyc + ", ownerserial="
				+ ownerserial + ", wheelBase=" + wheelBase + ", rLW=" + rLW + ", address=" + address + ", issuing="
				+ issuing + ", getRegnNumber()=" + getRegnNumber() + ", getRegdOwner()=" + getRegdOwner()
				+ ", getsDWf()=" + getsDWf() + ", getPurpose()=" + getPurpose() + ", getRegnDate()=" + getRegnDate()
				+ ", getManufacturingDt()=" + getManufacturingDt() + ", getTaxPAidUpTo()=" + getTaxPAidUpTo()
				+ ", getRegdValidity()=" + getRegdValidity() + ", getColour()=" + getColour() + ", getFuel()="
				+ getFuel() + ", getVehicleClass()=" + getVehicleClass() + ", getBodyType()=" + getBodyType()
				+ ", getManufacturar()=" + getManufacturar() + ", getChassisNo()=" + getChassisNo() + ", getEngineNo()="
				+ getEngineNo() + ", getModelNo()=" + getModelNo() + ", getUnladenWt()=" + getUnladenWt()
				+ ", getCubicCapacity()=" + getCubicCapacity() + ", getSeatCapacity()=" + getSeatCapacity()
				+ ", getStandCapacity()=" + getStandCapacity() + ", getNoofcyc()=" + getNoofcyc()
				+ ", getOwnerserial()=" + getOwnerserial() + ", getWheelBase()=" + getWheelBase() + ", getrLW()="
				+ getrLW() + ", getAddress()=" + getAddress() + ", getIssuing()=" + getIssuing()
				+ ", getHypothecatedTo()=" + getHypothecatedTo() + ", getClass()=" + getClass() + ", hashCode()="
				+ hashCode() + ", toString()=" + super.toString() + "]";
	}
	
	
	
	

}
