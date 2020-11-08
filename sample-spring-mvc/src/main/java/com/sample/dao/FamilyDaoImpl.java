package com.sample.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.sample.model.Family_Members;

public class FamilyDaoImpl implements FamilyDao {
	
	JdbcTemplate template;

	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}

/*	@Override
	public List<Family_Members> getFamilyMembers() {
		return template.query("select * from family_members", new RowMapper<Family_Members>() {
			public Family_Members mapRow(ResultSet rs, int row) throws SQLException {
				Family_Members f = new Family_Members();
				f.setId(rs.getInt(1));
				f.setName(rs.getString(2));
				f.setWeight(rs.getString(3));
				f.setProfession(rs.getString(4));
				return f;
			}
		});
	}*/

	@Override
	public List<Family_Members> getListAllMembers() {
		return template.query("select * from family_members",new RowMapper<Family_Members>(){    
	        public Family_Members mapRow(ResultSet rs, int row) throws SQLException {    
	        	Family_Members f=new Family_Members();    
	            f.setF_id(rs.getInt(1));    
	            f.setF_name(rs.getString(2));    
	            f.setF_profession(rs.getString(3));    
	            f.setF_weight(rs.getString(4));   
	            System.out.println("HHH : " + f.getF_name());
	            return f;    
	        }    
	    });  
	}

	@Override
	public int save(Family_Members f) {
		String sql="insert into family_members(f_name,f_weight,f_profession) values('"+f.getF_name()+"',"+f.getF_weight()+",'"+f.getF_profession()+"')";    
	    return template.update(sql);
	}

	@Override
	public Family_Members getFamilyById(int id) {
		 String sql="select * from family_members where f_id=?";    
		    return template.queryForObject(sql, new Object[]{id},new BeanPropertyRowMapper<Family_Members>(Family_Members.class));  
	}

	@Override
	public int update(Family_Members f) {
		 String sql="update family_members set f_name='"+f.getF_name()+"', f_weight="+f.getF_weight()+",f_profession='"+f.getF_profession()+"' where f_id="+f.getF_id()+"";    
		    return template.update(sql);   
	}

	@Override
	public int delete(int id) { 
	    String sql="delete from family_members where f_id="+id+"";    
		    return template.update(sql);    
		}    
	
}
