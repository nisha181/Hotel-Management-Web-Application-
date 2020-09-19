package com.project.roombill.resources;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.roombill.model.Bill;

@Repository
public interface BillRepository extends JpaRepository<Bill, Integer> {

}
