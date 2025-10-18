package com.project.hospital_management_system.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.hospital_management_system.dto.BranchHead;
import com.project.hospital_management_system.repo.BranchHeadRepo;
@Repository
public class BranchHeadDao {
	
	@Autowired
	BranchHeadRepo branchHeadrepo;
	
	public BranchHead saveBranchHead(BranchHead branchHead) {
//		BranchHead dbBranchHead = BranchHeadRepo.save(BranchHead);
//		return dbBranchHead;
		return branchHeadrepo.save(branchHead);
	}

	public BranchHead fetchBranchHeadById(int branchHeadId) {
		Optional<BranchHead> branchHead = branchHeadrepo.findById(branchHeadId);
		if (branchHead.isEmpty()) {
			return null;
		} else {
			return branchHead.get();
		}
//		if (branchHead.isPresent()) {
//			return branchHead.get();
//		} else {
//			return null;
//		}
	}

	public BranchHead deleteBranchHeadById(int branchHeadId) {
		// BranchHead branchHead = BranchHeadRepo.findById(branchHeadId).get();
		BranchHead branchHead = fetchBranchHeadById(branchHeadId);
		branchHeadrepo.delete(branchHead);
		return branchHead;
	}

	public BranchHead updateBranchHeadById(int oldBranchHeadId, BranchHead newBranchHead) {
		newBranchHead.setBranchHeadId(oldBranchHeadId);
		return branchHeadrepo.save(newBranchHead);
	}

	public List<BranchHead> fetchAllBranchHead() {
		return branchHeadrepo.findAll();
	}


}
