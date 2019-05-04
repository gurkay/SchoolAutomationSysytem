/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

/**
 *
 * @author gurkay
 */
public class FamilyInfoController extends AccountController {
	private String motherJob;
	private String motherName;
	private String fatherJob;
	private String fatherName;
	
	public String getMotherJob() {
		return motherJob;
	}
	public void setMotherJob(String motherJob) {
		this.motherJob = motherJob;
	}
	public String getMotherName() {
		return motherName;
	}
	public void setMotherName(String motherName) {
		this.motherName = motherName;
	}
	public String getFatherJob() {
		return fatherJob;
	}
	public void setFatherJob(String fatherJob) {
		this.fatherJob = fatherJob;
	}
	public String getFatherName() {
		return fatherName;
	}
	public void setFatherName(String fatherName) {
		this.fatherName = fatherName;
	}
	
	
}
