package org.service;

import java.util.List;

import org.dao.LendDao;
import org.model.Lend;

public class LendService {
	private LendDao lendDao;
	
	public void setLendDao(LendDao lendDao) {
		this.lendDao = lendDao;
	}
	
	public List selectLend(String readerId,int pageNow,int pageSize){
		return lendDao.selectLend(readerId, pageNow, pageSize);
	}
	
	public int selectLendSize(String readerId){
		return lendDao.selectLendSize(readerId);
	}
	
	public boolean addLend(Lend lend){
		return lendDao.addLend(lend);
	}
	
	public Lend selectByBookISBN(String ISBN){
		return lendDao.selectByBookISBN(ISBN);
	}
	
	public Lend selectByBookISBN(String ISBN , String readerId){
		return lendDao.selectByBookISBN(ISBN, readerId);
	}
	
	public boolean deleteLend(String ISBN, String readerId){
		return lendDao.deleteLend(ISBN, readerId);
	}
}
