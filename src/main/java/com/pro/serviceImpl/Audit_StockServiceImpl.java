package com.pro.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pro.dao.Audit_StockDao;
import com.pro.model.Audit_Stock;
import com.pro.service.Audit_StockService;

@Service
public class Audit_StockServiceImpl implements Audit_StockService{
@Autowired
private Audit_StockDao audit_StockDao;
	@Override
	public List<Audit_Stock> findAll() {
		return audit_StockDao.findAll();
	}

}
