package com.lv.hims.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;

import com.lv.hims.entity.Patient;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Long>, QuerydslPredicateExecutor<Patient> {
}
