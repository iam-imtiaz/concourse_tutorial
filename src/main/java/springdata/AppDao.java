package springdata;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class AppDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	@Autowired
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	
	public int saveDepartment(Department d) {
		return jdbcTemplate.update("insert into department values(?,?)",d.getDeptId(), d.getDeptName());
	}
	public int saveDepartmentUsingNamedParam(Department d) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("id",d.getDeptId());
		map.put("name", d.getDeptName());
		return namedParameterJdbcTemplate.update("insert into department values(:id,:name)",map);
	}
	
	public List<Map<String, Object>> getDepts() {
		
		List<Map<String, Object>> depts = jdbcTemplate.queryForList("select * from department");
		return depts;
	}
	
	@Transactional
	public Department getOneDepts(String id) {
	
		return jdbcTemplate.queryForObject("select * from department where id = '"+ id +"';",new RowMapper<Department>() {
			public Department mapRow(ResultSet rs, int rowNum) throws SQLException {
				Department d = new Department();
				d.setDeptId(rs.getString("id"));
				d.setDeptName(rs.getString("dname"));
				return d;
			}
		});
		
	}
	

	public void saveOrders(String oid, String desc, String cust_id, String prod_id) {
		 jdbcTemplate.update("insert into orders values(?,?,?,?)",oid,desc,cust_id,prod_id);
	}
	
	
	public void saveInvoice(String invoiceId, String orderId) {
		 jdbcTemplate.update("insert into invoices values(?,?)", invoiceId, orderId);
	}
	
	
	public void saveDept(hibernate.Department d) {
		SessionFactory sf = new Configuration().configure("hib.cfg.xml").addAnnotatedClass(hibernate.Department.class).buildSessionFactory();
		 Session session = sf.getCurrentSession();
		 session.beginTransaction().begin();
		 session.save(d);
		 session.getTransaction().commit();
	}
}
