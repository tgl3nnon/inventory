
package com.glennon.inventory.model;

public class Beer {

	private int id;
	private String name;
	private String style;
	private int vol;
	private int quantity;
	private int bottleDate;
	private String brewery;
	private String location;

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

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	@Override
	public String toString() {
		return "Beer [id=" + id + ", name=" + name + ", style=" + style + ", vol=" + vol + ", quantity=" + quantity
				+ ", bottleDate=" + bottleDate + ", brewery=" + brewery + ", location=" + location + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + bottleDate;
		result = prime * result + ((brewery == null) ? 0 : brewery.hashCode());
		result = prime * result + id;
		result = prime * result + ((location == null) ? 0 : location.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + quantity;
		result = prime * result + ((style == null) ? 0 : style.hashCode());
		result = prime * result + vol;
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
		Beer other = (Beer) obj;
		if (bottleDate != other.bottleDate)
			return false;
		if (brewery == null) {
			if (other.brewery != null)
				return false;
		} else if (!brewery.equals(other.brewery))
			return false;
		if (id != other.id)
			return false;
		if (location == null) {
			if (other.location != null)
				return false;
		} else if (!location.equals(other.location))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (quantity != other.quantity)
			return false;
		if (style == null) {
			if (other.style != null)
				return false;
		} else if (!style.equals(other.style))
			return false;
		if (vol != other.vol)
			return false;
		return true;
	}

}
