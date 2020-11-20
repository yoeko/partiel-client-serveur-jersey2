package com.ensup.partielwebservice.service;

import java.util.List;

import com.ensup.partielwebservice.dao.EtudiantDao;
import com.ensup.partielwebservice.dao.IEtudiantDao;
import com.ensup.partielwebservice.domaine.Etudiant;

public class EtudiantService implements IEtudiantService {
	
	IEtudiantDao etudiantDao = new EtudiantDao();
	
	
	/**
	 * Constructeur
	 * @param etudiantDao
	 */
	public EtudiantService(IEtudiantDao etudiantDao) {
		super();
		this.etudiantDao = etudiantDao;
	}

	
	/**
	 * createEtudiant
	 * @param etudiant
	 */
	public void createEtudiant(Etudiant etudiant) {
		etudiantDao.createEtudiant(etudiant);
	}
	
	/**
	 * getEtudiant
	 * @param id
	 */
	public Etudiant getEtudiant(Long id) {
		return etudiantDao.getEtudiant(id);
	}
	
	/**
	 * 
	 * @return
	 */
	public Etudiant getEtudiantByEmail(String email) {
		return etudiantDao.getEtudiantByEmail(email);
	}
	
	public List<Etudiant> getStudentByResearch(String firstNameR, String lastNameR) {
		return etudiantDao.getStudentByResearch(firstNameR, lastNameR);
	}
	
	/**
	 * updateEtudiant
	 * @param etudiant, nEtudiant
	 */
	public void updateStudent(Long id, Etudiant student) {
		etudiantDao.updateStudent(id, student);
	}
	
	/**
	 * getAllStudent
	 * 
	 */
	public List<Etudiant> getAllStudent() {
		return etudiantDao.getAllStudent();
	}
	
	/**
	 * deleteEtudiant
	 * @id
	 */
	public void deleteEtudiant(Long id) {
		etudiantDao.deleteEtudiant(id);
	}


}
