
package com.glennon.inventory.model;

public class Beer {

	private int id;
	private String name;
	private String style;
	private int vol;
	private int quantity;
	private int bottleDate;
	private String brewery;

	/**
	 * @param id
	 * @param name
	 * @param style
	 */

	public Beer() {

	}

	public Beer(int id, String name, String style) {
		super();
		this.id = id;
		this.name = name;
		this.style = style;
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the style
	 */
	public String getStyle() {
		return style;
	}

	/**
	 * @param style
	 *            the style to set
	 */
	public void setStyle(String style) {
		this.style = style;
	}

	/**
	 * @return the vol
	 */
	public int getVol() {
		return vol;
	}

	/**
	 * @param vol
	 *            the vol to set
	 */
	public void setVol(int vol) {
		this.vol = vol;
	}

	/**
	 * @return the quantity
	 */
	public int getQuantity() {
		return quantity;
	}

	/**
	 * @param quantity
	 *            the quantity to set
	 */
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	/**
	 * @return the bottleDate
	 */

	/**
	 * @return the brewery
	 */
	public String getBrewery() {
		return brewery;
	}

	public int getBottleDate() {
		return bottleDate;
	}

	public void setBottleDate(int bottleDate) {
		this.bottleDate = bottleDate;
	}

	/**
	 * @param brewery
	 *            the brewery to set
	 */
	public void setBrewery(String brewery) {
		this.brewery = brewery;
	}
	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */

	@Override
	public String toString() {
		return "Beer [id=" + id + ", name=" + name + ", style=" + style + ", vol=" + vol + ", quantity=" + quantity
				+ ", bottleDate=" + bottleDate + ", brewery=" + brewery + "]";
	}



}
