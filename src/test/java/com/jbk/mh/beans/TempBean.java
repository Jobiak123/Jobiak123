package com.jbk.mh.beans;

import java.io.Serializable;


public class TempBean implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String propertyName;
	private String beginDateRange;
	public String getPropertyName() {
		return propertyName;
	}
	public void setPropertyName(String propertyName) {
		this.propertyName = propertyName;
	}
	public String getBeginDateRange() {
		return beginDateRange;
	}
	
	public void setBeginDateRange(String beginDateRange) {
		if(beginDateRange!=null && beginDateRange.contains("-")){
			beginDateRange = beginDateRange.replace("-","").substring(0, 6);
		}
		this.beginDateRange = beginDateRange;
	}
	
	@Override
	public String toString() {
		return "TempBean [propertyName=" + propertyName + ", beginDateRange="
				+ beginDateRange + "]";
	}
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((beginDateRange == null) ? 0 : beginDateRange.hashCode());
		result = prime * result
				+ ((propertyName == null) ? 0 : propertyName.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TempBean other = (TempBean) obj;
		if (beginDateRange == null) {
			if (other.beginDateRange != null)
				return false;
		} else if (!beginDateRange.equals(other.beginDateRange))
			return false;
		if (propertyName == null) {
			if (other.propertyName != null)
				return false;
		} else if (!propertyName.equals(other.propertyName))
			return false;
		return true;
	}
	
	
}
