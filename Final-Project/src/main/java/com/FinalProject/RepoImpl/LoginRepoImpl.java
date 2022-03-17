package com.FinalProject.RepoImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.FinalProject.Entity.foodie;
import com.FinalProject.Entity.vendor;
import com.FinalProject.Repo.LoginRepo;

@Component
public class LoginRepoImpl implements LoginRepo {
	
	@Autowired
	JdbcTemplate jt;

	@Override
	public boolean validateAdmin(String username, String password) {
		if(username.equals("Admin")&&password.equals("123"))
		{
			return true;
		}
		return false;
	}

	@Override
	public vendor validatevendor(String vendorid, String password) {
		String str="select*from vendor where vendorid=? and password=?;";
		try
		{
			vendor x=(vendor) jt.queryForObject(str, new Object[] {vendorid,password}, new BeanPropertyRowMapper(vendor.class));
			return x;
		}
		catch(Exception ex)
		{
			System.out.println(ex.getMessage());
		}
		return null;
	}

	@Override
	public foodie validatefoodie(String foodieid, String password) {
		String str="select*from foodie where foodieid=? and password=?;";
		try
		{
			foodie x=(foodie) jt.queryForObject(str, new Object[] {foodieid,password}, new BeanPropertyRowMapper(foodie.class));
			return x;
		}
		catch(Exception ex)
		{
			System.out.println(ex.getMessage());
		}

		return null;
	}

	@Override
	public boolean addvendor(vendor ven) {
		String str = "insert into vendor(vendorname,email,location,websiteid,vendortype,cusinetype,uploadmenucard,uploadphoto,password) values(?,?,?,?,?,?,?,?,?);";
		try 
		{
			int r = jt.update(str, new Object[] {ven.getVendorname(),ven.getEmail(),ven.getLocation(),ven.getWebsiteid(),ven.getVendortype(),ven.getCusinetype(),ven.getUploadmenucard(),ven.getUploadphoto(),ven.getPassword()});
			if(r>=1)
			{
				return true;
			}
		
		else
		 	return false;
		}
			catch(Exception ex)
			{
				System.out.println(ex.getMessage());
			}
			
		return false;
		}

	@Override
	public boolean addfoodie(foodie fod) {
		String str = "insert into foodie(firstname,lastname,password,confirmpassword,emailid,dob,gender,mobile,address) values(?,?,?,?,?,?,?,?,?);";
		try
		{
			int r=jt.update(str, new Object[] {fod.getFirstname(),fod.getLastname(),fod.getPassword(),fod.getConfirmpassword(),fod.getEmailid(),fod.getDob(),fod.getGender(),fod.getMobile(),fod.getAddress()});
			if(r>=1)
			{
				return true;
			}
			else
		       return false;
		}
		catch(Exception ex)
		{
			System.out.println(ex.getMessage());
		}
		
	return false;
	}
		
	}