package com.kte.mvc.vo;

import java.util.List;

public class V3_FormVO {
	private String select= null; 
	private String checkbox = null;
	private String radio= null;
	
	private List<String> selectmulti = null;
	private List<String> checkboxmulti = null;
	
	public String getSelect() {
		return select;
	}
	public void setSelect(String select) {
		this.select = select;
	}
	public String getCheckbox() {
		return checkbox;
	}
	public void setCheckbox(String checkbox) {
		this.checkbox = checkbox;
	}
	public String getRadio() {
		return radio;
	}
	public void setRadio(String radio) {
		this.radio = radio;
	}
	public List<String> getSelectmulti() {
		return selectmulti;
	}
	public void setSelectmulti(List<String> selectmulti) {
		this.selectmulti = selectmulti;
	}
	public List<String> getCheckboxmulti() {
		return checkboxmulti;
	}
	public void setCheckboxmulti(List<String> checkboxmulti) {
		this.checkboxmulti = checkboxmulti;
	}

	
}
