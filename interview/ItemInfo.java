package interview;

import java.math.BigDecimal;

public class ItemInfo {
	private String id;
    private String name;
    private String artNo;
    private String spuId;
    private BigDecimal inventory;
    private BigDecimal minPrice;
    private BigDecimal maxPrice;
    private BigDecimal price;
    private String skuType;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getArtNo() {
		return artNo;
	}
	public void setArtNo(String artNo) {
		this.artNo = artNo;
	}
	public String getSpuId() {
		return spuId;
	}
	public void setSpuId(String spuId) {
		this.spuId = spuId;
	}
	public BigDecimal getInventory() {
		return inventory;
	}
	public void setInventory(BigDecimal inventory) {
		this.inventory = inventory;
	}
	public BigDecimal getMinPrice() {
		return minPrice;
	}
	public void setMinPrice(BigDecimal minPrice) {
		this.minPrice = minPrice;
	}
	public BigDecimal getMaxPrice() {
		return maxPrice;
	}
	public void setMaxPrice(BigDecimal maxPrice) {
		this.maxPrice = maxPrice;
	}
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	public String getSkuType() {
		return skuType;
	}
	public void setSkuType(String skuType) {
		this.skuType = skuType;
	}
    
}
