package com.metademy.microservices.model;

public class DocumentUploaded {
	
	private String docemuntId;
	private String documentName;
	private String s3Url;

	public String getDocemuntId() {
		return docemuntId;
	}

	public void setDocemuntId(String docemuntId) {
		this.docemuntId = docemuntId;
	}

	public String getDocumentName() {
		return documentName;
	}

	public void setDocumentName(String documentName) {
		this.documentName = documentName;
	}

	public String getS3Url() {
		return s3Url;
	}

	public void setS3Url(String s3Url) {
		this.s3Url = s3Url;
	}

}
