package interview;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
/**
 * 
 * <p>Description:实现类 传入一组 SKUId(入参限定不能超过100个), 输出一组 item, 包含总库存和区间价</p>
 * @author wangjs
 * @date 2018年9月16日下午7:52:06
 */
public class ItemGroupServiceImpl implements ItemGroupService {

	 private SkuService skuService=ServiceBeanFactory.getInstance().getServiceBean(SkuService.class);
     private PriceService priceService=ServiceBeanFactory.getInstance().getServiceBean(PriceService.class);
     private InventoryService inventoryService=ServiceBeanFactory.getInstance().getServiceBean(InventoryService.class);
     
     @Override 
     public List<ItemInfo> itemGroup(List<String> skuIds) {
        Map<String, ItemInfo> entitys = skuService.querySkuEntity(skuIds);
        Map<String, BigDecimal> inventorys = inventoryService.querySkuInventory(skuIds);
        Map<String, BigDecimal> prices = priceService.querySkuPrice(skuIds);
        List<ItemInfo> itemInfoList = new ArrayList<>();
        if (null == entitys) return itemInfoList;
        entitys.forEach((id, itemInfo) -> {
            ItemInfo item = new ItemInfo();
            item.setId(id);
            item.setArtNo(itemInfo.getArtNo());
            item.setName(itemInfo.getName());
            item.setSpuId(itemInfo.getSpuId());
            item.setSkuType(itemInfo.getSkuType());
            item.setInventory(inventorys.containsKey(id) ? inventorys.get(id) : new BigDecimal(0));
            item.setPrice(prices.containsKey(id) ? prices.get(id) : new BigDecimal(0));
            itemInfoList.add(item);
        });
        System.out.println("Query ["+itemInfoList.size()+"] item.");
        List<ItemInfo> originItems =
                ItemGroupServiceFactory.getService(ItemType.ORIGIN).itemGroupByType(itemInfoList);
        System.out.println("Origin item: "+originItems.size());
        List<ItemInfo> digitalItems =
                ItemGroupServiceFactory.getService(ItemType.DIGITAL).itemGroupByType(itemInfoList);
        System.out.println("Origin item: "+digitalItems.size());
        List<ItemInfo> res = new ArrayList<>();
        res.addAll(originItems);
        res.addAll(digitalItems);
        return res;
    }
}
