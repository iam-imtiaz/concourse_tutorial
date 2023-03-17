package springdata;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@Transactional
public class OrderService {

	@Autowired
	public AppDao appDao;
	
	@Transactional
	public void saveOrders(String oid, String desc, String cust_id, String prod_id, String iid) {
		appDao.saveOrders(oid, desc, cust_id, prod_id);
		appDao.saveInvoice(iid, oid);
	}
}
