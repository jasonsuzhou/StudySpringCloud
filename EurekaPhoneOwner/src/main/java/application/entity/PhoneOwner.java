package application.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

/**
 * https://blog.csdn.net/xufei_0320/article/details/78707661
 * @author Jason Yao
 *
 */
@Entity
@Table(name="owner")
public class PhoneOwner implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 374399195843143792L;
	private String section;
	private String vendor;
	private String province;
	private String city;
	private String zipCode;
	private String areaCode;
	private String cardType;

	@Id
	@GenericGenerator(name = "sectionStrategy", strategy = "assigned")
	@GeneratedValue(generator = "sectionStrategy")
	@Column(length=7)
	public String getSection() {
		return section;
	}

	public void setSection(String section) {
		this.section = section;
	}

	@Column(length=16)
	public String getVendor() {
		return vendor;
	}

	public void setVendor(String vendor) {
		this.vendor = vendor;
	}

	@Column(length=16)
	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	@Column(length=16)
	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	@Column(name="zip_code",length=6)
	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	@Column(name="area_code",length=4)
	public String getAreaCode() {
		return areaCode;
	}

	public void setAreaCode(String areaCode) {
		this.areaCode = areaCode;
	}

	@Column(name="card_type",length=32)
	public String getCardType() {
		return cardType;
	}

	public void setCardType(String cardType) {
		this.cardType = cardType;
	}

}
