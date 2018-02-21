package com.revature.hibernate.dao;

import java.util.List;

import com.revature.hibernate.model.Batch;

public interface BatchDao {

	void createBatch(Batch b); 
	void editBatch(Batch b);
	void cloneBatch(Batch b);
	void deleteBatch(Batch b);
	Batch selectBatchByName(String name);
	List<Batch> selectAllBatches();
}
