/*
 * Generated by MyEclipse Struts
 * Template path: templates/java/JavaClass.vtl
 */
package com.yourcompany.struts.form;

import javax.servlet.http.HttpServletRequest;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;

/**
 * MyEclipse Struts
 * Creation date: 07-29-2008
 *
 * XDoclet definition:
 * @struts.form name="CustomerTransactionForm"
 */
public class CustomerTransactionForm extends ActionForm {
	/*
	 * Generated Methods
	 */
	private String name;
	private String accnumber;
	private String trannumber;
	private String amounthaving;
	private String amount;

	/**
	 * Method validate
	 * @param mapping
	 * @param request
	 * @return ActionErrors
	 */
	public ActionErrors validate(ActionMapping mapping,
			HttpServletRequest request) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Method reset
	 * @param mapping
	 * @param request
	 */
	public void reset(ActionMapping mapping, HttpServletRequest request) {
		// TODO Auto-generated method stub
	}

	public String getAccnumber() {
		return accnumber;
	}

	public void setAccnumber(String accnumber) {
		this.accnumber = accnumber;
	}

	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}

	public String getAmounthaving() {
		return amounthaving;
	}

	public void setAmounthaving(String amounthaving) {
		this.amounthaving = amounthaving;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTrannumber() {
		return trannumber;
	}

	public void setTrannumber(String trannumber) {
		this.trannumber = trannumber;
	}
}