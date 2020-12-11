package com.ensup.partielwebservice.service;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.ensup.partielwebservice.dao.EtudiantDao;
import com.ensup.partielwebservice.dao.IEtudiantDao;
import com.ensup.partielwebservice.domaine.Etudiant;

public class EtudiantService implements IEtudiantService {
	
	private static final Logger serviceLogger = LogManager.getLogger(EtudiantService.class);
	
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
		serviceLogger.info("Module Service, Méthode create Student");
		etudiantDao.createEtudiant(etudiant);
	}
	
	/**
	 * getEtudiant
	 * @param id
	 */
	public Etudiant getEtudiant(Long id) {
		serviceLogger.info("Module Service, Méthode get Etudiant");
		return etudiantDao.getEtudiant(id);
	}
	
	/**
	 * 
	 * @return
	 */
	public Etudiant getEtudiantByEmail(String email) {
		serviceLogger.info("Module Service, Méthode get Etudiant By Email");
		return etudiantDao.getEtudiantByEmail(email);
	}
	
	public List<Etudiant> getStudentByResearch(String firstNameR, String lastNameR) {
		serviceLogger.info("Module Service, Méthode get Student By Research");
		return etudiantDao.getStudentByResearch(firstNameR, lastNameR);
	}
	
	/**
	 * updateEtudiant
	 * @param etudiant, nEtudiant
	 */
	public void updateStudent(Long id, Etudiant student) {
		serviceLogger.info("Module Service, Méthode update Student");
		etudiantDao.updateStudent(id, student);
	}
	
	/**
	 * getAllStudent
	 * 
	 */
	public List<Etudiant> getAllStudent() {
		serviceLogger.info("Module Service, Méthode get All Student");
		return etudiantDao.getAllStudent();
	}
	
	/**
	 * deleteEtudiant
	 * @id
	 */
	public void deleteEtudiant(Long id) {
		serviceLogger.info("Module Service, Méthode get All Student");
		etudiantDao.deleteEtudiant(id);
	}


}
